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
}
