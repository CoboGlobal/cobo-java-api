package com.cobo.custody.api.client.domain.staking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StakingProduct {

    @JsonProperty(value = "product_id")
    private int productId;
    private String name;
    private String description;
    @JsonProperty(value = "doc_src")
    private String docSrc;
    private String coin;
    @JsonProperty(value = "coin_decimal")
    private int coinDecimal;
    @JsonProperty(value = "reward_coin")
    private String rewardCoin;
    @JsonProperty(value = "reward_coin_decimal")
    private int rewardCoinDecimal;
    @JsonProperty(value = "unstake_fee")
    private String unstakeFee;
    @JsonProperty(value = "min_amount")
    private String minAmount;
    private String rate;
    @JsonProperty(value = "rate_type")
    private int rateType;
    private int days;
    @JsonProperty(value = "stake_type")
    private String stakeType;
    private boolean lockup;
    @JsonProperty(value = "start_stake_time")
    private long startStakeTime;
    @JsonProperty(value = "stop_stake_time")
    private long stopStakeTime;
    @JsonProperty(value = "start_staking_time")
    private long startStakingTime;
    @JsonProperty(value = "stop_staking_time")
    private long stopStakingTime;
    @JsonProperty(value = "liquidate_time")
    private long liquidateTime;
    @JsonProperty(value = "reward_liquidate_time")
    private long rewardLiquidateTime;
    @JsonProperty(value = "product_group")
    private String productGroup;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getDocSrc() {
        return docSrc;
    }

    public void setDocSrc(String docSrc) {
        this.docSrc = docSrc;
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

    public String getUnstakeFee() {
        return unstakeFee;
    }

    public void setUnstakeFee(String unstakeFee) {
        this.unstakeFee = unstakeFee;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getRateType() {
        return rateType;
    }

    public void setRateType(int rateType) {
        this.rateType = rateType;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getStakeType() {
        return stakeType;
    }

    public void setStakeType(String stakeType) {
        this.stakeType = stakeType;
    }

    public boolean isLockup() {
        return lockup;
    }

    public void setLockup(boolean lockup) {
        this.lockup = lockup;
    }

    public long getStartStakeTime() {
        return startStakeTime;
    }

    public void setStartStakeTime(long startStakeTime) {
        this.startStakeTime = startStakeTime;
    }

    public long getStopStakeTime() {
        return stopStakeTime;
    }

    public void setStopStakeTime(long stopStakeTime) {
        this.stopStakeTime = stopStakeTime;
    }

    public long getStartStakingTime() {
        return startStakingTime;
    }

    public void setStartStakingTime(long startStakingTime) {
        this.startStakingTime = startStakingTime;
    }

    public long getStopStakingTime() {
        return stopStakingTime;
    }

    public void setStopStakingTime(long stopStakingTime) {
        this.stopStakingTime = stopStakingTime;
    }

    public long getLiquidateTime() {
        return liquidateTime;
    }

    public void setLiquidateTime(long liquidateTime) {
        this.liquidateTime = liquidateTime;
    }

    public long getRewardLiquidateTime() {
        return rewardLiquidateTime;
    }

    public void setRewardLiquidateTime(long rewardLiquidateTime) {
        this.rewardLiquidateTime = rewardLiquidateTime;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    @Override
    public String toString() {
        return "StakingProduct{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", docSrc='" + docSrc + '\'' +
                ", coin='" + coin + '\'' +
                ", coinDecimal=" + coinDecimal +
                ", rewardCoin='" + rewardCoin + '\'' +
                ", rewardCoinDecimal=" + rewardCoinDecimal +
                ", unstakeDee='" + unstakeFee + '\'' +
                ", minAmount='" + minAmount + '\'' +
                ", rate='" + rate + '\'' +
                ", rateType=" + rateType +
                ", days=" + days +
                ", stakeType='" + stakeType + '\'' +
                ", lockup=" + lockup +
                ", startStakeTime=" + startStakeTime +
                ", stopStakeTime=" + stopStakeTime +
                ", startStakingTime=" + startStakingTime +
                ", stopStakingTime=" + stopStakingTime +
                ", liquidateTime=" + liquidateTime +
                ", rewardLiquidateTime=" + rewardLiquidateTime +
                ", productGroup='" + productGroup + '\'' +
                '}';
    }
}
