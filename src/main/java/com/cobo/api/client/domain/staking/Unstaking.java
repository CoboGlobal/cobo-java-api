package com.cobo.api.client.domain.staking;

public class Unstaking {

    private String coin;
    private int coin_decimal;
    private long amount;
    private long unstake_time;
    private long liquidate_time;

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

    public long getUnstake_time() {
        return unstake_time;
    }

    public void setUnstake_time(long unstake_time) {
        this.unstake_time = unstake_time;
    }

    public long getLiquidate_time() {
        return liquidate_time;
    }

    public void setLiquidate_time(long liquidate_time) {
        this.liquidate_time = liquidate_time;
    }

    @Override
    public String toString() {
        return "Unstaking{" +
                "coin='" + coin + '\'' +
                ", coin_decimal=" + coin_decimal +
                ", amount=" + amount +
                ", unstake_time=" + unstake_time +
                ", liquidate_time=" + liquidate_time +
                '}';
    }
}
