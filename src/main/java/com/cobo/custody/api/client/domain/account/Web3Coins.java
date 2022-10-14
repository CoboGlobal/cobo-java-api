package com.cobo.custody.api.client.domain.account;

import java.util.List;

public class Web3Coins {
    private List<Web3Coin> coins;

    public List<Web3Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Web3Coin> coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "{" +
                "coins='" + coins + '\'' +
                '}';
    }
}
