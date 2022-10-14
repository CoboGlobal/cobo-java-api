package com.cobo.custody.api.client.domain.asset;

import java.util.List;

public class Web3WalletNfts {
    private List<Web3WalletNftInfo> nfts;

    public List<Web3WalletNftInfo> getNfts() {
        return nfts;
    }

    public void setNfts(List<Web3WalletNftInfo> nfts) {
        this.nfts = nfts;
    }

    @Override
    public String toString() {
        return "{" +
                "nfts='" + nfts + '\'' +
                '}';
    }
}
