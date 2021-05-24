package com.cobo.api.client.domain.staking;

public class StakingData {

    private int staking_id;
    private String coin;
    private int coin_decimal;
    private long amount;
    private String reward_coin;
    private int reward_coin_decimal;
    private int reward_amount;
    private StakingProduct product;

    public int getStaking_id() {
        return staking_id;
    }

    public void setStaking_id(int staking_id) {
        this.staking_id = staking_id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public int getCoin_decimal() {
        return coin_decimal;
    }

    public void setCoin_decimal(int coin_decimal) {
        this.coin_decimal = coin_decimal;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getReward_coin() {
        return reward_coin;
    }

    public void setReward_coin(String reward_coin) {
        this.reward_coin = reward_coin;
    }

    public int getReward_coin_decimal() {
        return reward_coin_decimal;
    }

    public void setReward_coin_decimal(int reward_coin_decimal) {
        this.reward_coin_decimal = reward_coin_decimal;
    }

    public int getReward_amount() {
        return reward_amount;
    }

    public void setReward_amount(int reward_amount) {
        this.reward_amount = reward_amount;
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
                "staking_id=" + staking_id +
                ", coin='" + coin + '\'' +
                ", coin_decimal=" + coin_decimal +
                ", amount=" + amount +
                ", reward_coin='" + reward_coin + '\'' +
                ", reward_coin_decimal=" + reward_coin_decimal +
                ", reward_amount=" + reward_amount +
                ", product=" + product +
                '}';
    }
}
