package com.cobo.custody.api.client;

/***
 *
 */
public interface ApiSigner {
    String sign(byte[] message);

    String getPublicKey();
}
