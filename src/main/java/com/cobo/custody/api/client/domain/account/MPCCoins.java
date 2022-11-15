package com.cobo.custody.api.client.domain.account;

import java.util.List;

public class MPCCoins {
    private List<MPCCoin> coins;

    public List<MPCCoin> getCoins() {
        return coins;
    }

    public void setCoins(List<MPCCoin> coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "{" +
                "coins='" + coins + '\'' +
                '}';
    }
}
