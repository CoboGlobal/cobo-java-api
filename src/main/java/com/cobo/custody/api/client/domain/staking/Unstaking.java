package com.cobo.custody.api.client.domain.staking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Unstaking {

    private String coin;
    @JsonProperty(value = "coin_decimal")
    private int coinDecimal;
    private long amount;
    @JsonProperty(value = "unstake_time")
    private long unstakeTime;
    @JsonProperty(value = "liquidate_time")
    private long liquidateTime;

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

    public long getUnstakeTime() {
        return unstakeTime;
    }

    public void setUnstakeTime(long unstakeTime) {
        this.unstakeTime = unstakeTime;
    }

    public long getLiquidateTime() {
        return liquidateTime;
    }

    public void setLiquidateTime(long liquidateTime) {
        this.liquidateTime = liquidateTime;
    }

    @Override
    public String toString() {
        return "Unstaking{" +
                "coin='" + coin + '\'' +
                ", coinDecimal=" + coinDecimal +
                ", amount=" + amount +
                ", unstakeTime=" + unstakeTime +
                ", liquidateTime=" + liquidateTime +
                '}';
    }
}
