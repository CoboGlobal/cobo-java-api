package com.cobo.api.client.impl;

import com.cobo.api.client.ApiSigner;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;
import org.bouncycastle.util.encoders.Hex;

public class LocalSigner implements ApiSigner {
    private final ECKey eckey;

    LocalSigner(String privKey) {
        eckey = ECKey.fromPrivate(Hex.decode(privKey));
    }

    @Override
    public String sign(byte[] message) {
        return Hex.toHexString(eckey.sign(Sha256Hash.wrap(message)).encodeToDER());
    }

    /***
     * generate key pair
     * @return res[0]--private key
     *         res[1]--public key
     */
    public static String[] generateKeyPair() {
        ECKey key = new ECKey();
        String privHex = Hex.toHexString(key.getPrivKeyBytes());
        String pubHex = Hex.toHexString(key.getPubKey());
        return new String[]{privHex, pubHex};
    }

}
