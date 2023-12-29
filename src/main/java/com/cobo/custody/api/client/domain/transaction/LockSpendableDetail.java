package com.cobo.custody.api.client.domain.transaction;

public class LockSpendableDetail {
    private String coin;
    private String txHash;
    private Integer voutN;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public Integer getVoutN() {
        return voutN;
    }

    public void setVoutN(Integer voutN) {
        this.voutN = voutN;
    }

    @Override
    public String toString() {
        return "LockSpendableDetail{" +
                "coin='" + coin + '\'' +
                ",txHash='" + txHash + '\'' +
                ",voutN='" + voutN + '\'' +
                '}';
    }
}
