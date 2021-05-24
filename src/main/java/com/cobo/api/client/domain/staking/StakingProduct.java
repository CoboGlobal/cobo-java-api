package com.cobo.api.client.domain.staking;

public class StakingProduct {

    private int product_id;
    private String name;
    private String description;
    private String doc_src;
    private String coin;
    private int coin_decimal;
    private String reward_coin;
    private int reward_coin_decimal;
    private String unstake_fee;
    private String min_amount;
    private String rate;
    private int rate_type;
    private int days;
    private String stake_type;
    private boolean lockup;
    private long start_stake_time;
    private long stop_stake_time;
    private long start_staking_time;
    private long stop_staking_time;
    private long liquidate_time;
    private long reward_liquidate_time;
    private String product_group;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoc_src() {
        return doc_src;
    }

    public void setDoc_src(String doc_src) {
        this.doc_src = doc_src;
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

    public String getUnstake_fee() {
        return unstake_fee;
    }

    public void setUnstake_fee(String unstake_fee) {
        this.unstake_fee = unstake_fee;
    }

    public String getMin_amount() {
        return min_amount;
    }

    public void setMin_amount(String min_amount) {
        this.min_amount = min_amount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getRate_type() {
        return rate_type;
    }

    public void setRate_type(int rate_type) {
        this.rate_type = rate_type;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getStake_type() {
        return stake_type;
    }

    public void setStake_type(String stake_type) {
        this.stake_type = stake_type;
    }

    public boolean isLockup() {
        return lockup;
    }

    public void setLockup(boolean lockup) {
        this.lockup = lockup;
    }

    public long getStart_stake_time() {
        return start_stake_time;
    }

    public void setStart_stake_time(long start_stake_time) {
        this.start_stake_time = start_stake_time;
    }

    public long getStop_stake_time() {
        return stop_stake_time;
    }

    public void setStop_stake_time(long stop_stake_time) {
        this.stop_stake_time = stop_stake_time;
    }

    public long getStart_staking_time() {
        return start_staking_time;
    }

    public void setStart_staking_time(long start_staking_time) {
        this.start_staking_time = start_staking_time;
    }

    public long getStop_staking_time() {
        return stop_staking_time;
    }

    public void setStop_staking_time(long stop_staking_time) {
        this.stop_staking_time = stop_staking_time;
    }

    public long getLiquidate_time() {
        return liquidate_time;
    }

    public void setLiquidate_time(long liquidate_time) {
        this.liquidate_time = liquidate_time;
    }

    public long getReward_liquidate_time() {
        return reward_liquidate_time;
    }

    public void setReward_liquidate_time(long reward_liquidate_time) {
        this.reward_liquidate_time = reward_liquidate_time;
    }

    public String getProduct_group() {
        return product_group;
    }

    public void setProduct_group(String product_group) {
        this.product_group = product_group;
    }

    @Override
    public String toString() {
        return "StakingProduct{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", doc_src='" + doc_src + '\'' +
                ", coin='" + coin + '\'' +
                ", coin_decimal=" + coin_decimal +
                ", reward_coin='" + reward_coin + '\'' +
                ", reward_coin_decimal=" + reward_coin_decimal +
                ", unstake_fee='" + unstake_fee + '\'' +
                ", min_amount='" + min_amount + '\'' +
                ", rate='" + rate + '\'' +
                ", rate_type=" + rate_type +
                ", days=" + days +
                ", stake_type='" + stake_type + '\'' +
                ", lockup=" + lockup +
                ", start_stake_time=" + start_stake_time +
                ", stop_stake_time=" + stop_stake_time +
                ", start_staking_time=" + start_staking_time +
                ", stop_staking_time=" + stop_staking_time +
                ", liquidate_time=" + liquidate_time +
                ", reward_liquidate_time=" + reward_liquidate_time +
                ", product_group='" + product_group + '\'' +
                '}';
    }
}
