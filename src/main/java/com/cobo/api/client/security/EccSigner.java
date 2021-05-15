package com.cobo.api.client.security;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;
import org.bouncycastle.util.encoders.Hex;

public class EccSigner {
    public static String generateEccSignature(String content, String key) {
        ECKey eckey = ECKey.fromPrivate(Hex.decode(key));
        return Hex.toHexString(eckey.sign(Sha256Hash.wrap(doubleSha256(content))).encodeToDER());
    }
    public static byte[] doubleSha256(String content) {
        return Sha256Hash.hashTwice(content.getBytes());
    }
}
