package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.ApiSigner;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.util.Properties;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.InvalidKeySpecException;

import static com.cobo.custody.api.client.impl.Utils.*;


public class LocalSigner implements ApiSigner {
    private static final X9ECParameters CURVE_PARAMS = CustomNamedCurves.getByName("secp256k1");
    public static final ECDomainParameters CURVE = new ECDomainParameters(CURVE_PARAMS.getCurve(),
            CURVE_PARAMS.getG(), CURVE_PARAMS.getN(), CURVE_PARAMS.getH());
    private final ECPrivateKey eckey;
    private final String secret;

    public LocalSigner(String privKey) {
        try {
            eckey = generatePrivateKey(hexToBytes(privKey));
            secret = privKey;
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /***
     * generate key pair
     * @return res[0]--private key
     *         res[1]--public key
     */
    public static String[] generateKeyPair() {
        ECKeyPairGenerator generator = new ECKeyPairGenerator();
        ECKeyGenerationParameters keygenParams = new ECKeyGenerationParameters(CURVE, new SecureRandom());
        generator.init(keygenParams);
        AsymmetricCipherKeyPair keypair = generator.generateKeyPair();
        ECPrivateKeyParameters privParams = (ECPrivateKeyParameters) keypair.getPrivate();
        ECPublicKeyParameters pubParams = (ECPublicKeyParameters) keypair.getPublic();
        BigInteger priv = privParams.getD();
        String privHex = bytesToHex(bigIntegerToBytes(priv, 32));
        String pubHex = bytesToHex(pubParams.getQ().getEncoded(true));
        return new String[]{privHex, pubHex};
    }

    public static boolean verifyEcdsaSignature(String content, String signature, String pub) {
        ECDSASigner signer = new ECDSASigner();
        ECPublicKeyParameters params = new ECPublicKeyParameters(CURVE.getCurve().decodePoint(hexToBytes(pub)), CURVE);
        signer.init(false, params);
        BigInteger[] rs = decodeFromDER(hexToBytes(signature));
        return signer.verifySignature(sha256(sha256(content.getBytes(StandardCharsets.UTF_8))), rs[0], rs[1]);
    }

    public static BigInteger[] decodeFromDER(byte[] bytes) {
        ASN1InputStream decoder = null;
        try {
            Properties.setThreadOverride("org.bouncycastle.asn1.allow_unsafe_integer", true);
            decoder = new ASN1InputStream(bytes);
            final ASN1Primitive seqObj = decoder.readObject();
            final DLSequence seq = (DLSequence) seqObj;
            ASN1Integer r, s;
            try {
                r = (ASN1Integer) seq.getObjectAt(0);
                s = (ASN1Integer) seq.getObjectAt(1);
                return new BigInteger[]{r.getPositiveValue(),
                        s.getPositiveValue()};
            } catch (ClassCastException e) {
                throw new RuntimeException(e);
            }
            // OpenSSL deviates from the DER spec by interpreting these values as unsigned, though they should not be
            // Thus, we always use the positive versions. See: http://r6.ca/blog/20111119T211504Z.html
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (decoder != null)
                try {
                    decoder.close();
                } catch (IOException ignored) {
                }
            Properties.removeThreadOverride("org.bouncycastle.asn1.allow_unsafe_integer");
        }
    }

    public ECPrivateKey generatePrivateKey(byte[] keyBin) throws InvalidKeySpecException, NoSuchAlgorithmException {
        ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256k1");
        KeyFactory kf = KeyFactory.getInstance("EC", new BouncyCastleProvider());
        ECNamedCurveSpec params = new ECNamedCurveSpec("secp256k1", spec.getCurve(), spec.getG(), spec.getN());
        ECPrivateKeySpec privKeySpec = new ECPrivateKeySpec(new BigInteger(keyBin), params);
        return (ECPrivateKey) kf.generatePrivate(privKeySpec);
    }

    @Override
    public String sign(byte[] message) {
        try {
            Signature dsa = Signature.getInstance("SHA256withECDSA");
            dsa.initSign(eckey);
            dsa.update(Utils.sha256(message));
            return bytesToHex(dsa.sign());
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getPublicKey() {
        ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256k1");
        org.bouncycastle.math.ec.ECPoint pointQ = spec.getG().multiply(new BigInteger(secret, 16));
        byte[] publickKeyByte = pointQ.getEncoded(true);
        return bytesToHex(publickKeyByte);
    }

}
