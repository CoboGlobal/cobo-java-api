package com.cobo.custody.api.client.domain.staking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StakingData {

    @JsonProperty(value = "staking_id")
    private int stakingId;
    private String coin;
    @JsonProperty(value = "coin_decimal")
    private int coinDecimal;
    private long amount;
    @JsonProperty(value = "reward_coin")
    private String rewardCoin;
    @JsonProperty(value = "reward_coin_decimal")
    private int rewardCoinDecimal;
    @JsonProperty(value = "reward_amount")
    private long rewardAmount;
    private StakingProduct product;

    public int getStakingId() {
        return stakingId;
    }

    public void setStakingId(int stakingId) {
        this.stakingId = stakingId;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public int getCoinDecimal() {
        return coinDecimal;
    }

    public void setCoinDecimal(int coinDecimal) {
        this.coinDecimal = coinDecimal;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getRewardCoin() {
        return rewardCoin;
    }

    public void setRewardCoin(String rewardCoin) {
        this.rewardCoin = rewardCoin;
    }

    public int getRewardCoinDecimal() {
        return rewardCoinDecimal;
    }

    public void setRewardCoinDecimal(int rewardCoinDecimal) {
        this.rewardCoinDecimal = rewardCoinDecimal;
    }

    public long getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(long rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public StakingProduct getProduct() {
        return product;
    }

    public void setProduct(StakingProduct product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "StakingData{" +
                "stakingId=" + stakingId +
                ", coin='" + coin + '\'' +
                ", coinDecimal=" + coinDecimal +
                ", amount=" + amount +
                ", rewardCoin='" + rewardCoin + '\'' +
                ", rewardCoinDecimal=" + rewardCoinDecimal +
                ", rewardAmount=" + rewardAmount +
                ", product=" + product +
                '}';
    }
}
