package com.cobo.api.client;

/***
 *
 */
public interface ApiSigner {
    String sign(byte[] message);
    String getPublicKey();
}
