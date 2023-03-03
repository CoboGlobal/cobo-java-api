package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCWalletCoins {
    @JsonProperty(value = "wallet_name")
    private String walletName;
    private List<MPCCoin> coins;

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public List<MPCCoin> getCoins() {
        return coins;
    }

    public void setCoins(List<MPCCoin> coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "{" +
                "walletName='" + walletName + '\'' +
                ", coins='" + coins + '\'' +
                '}';
    }
}
