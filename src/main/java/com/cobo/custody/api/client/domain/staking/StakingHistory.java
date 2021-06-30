package com.cobo.custody.api.client.domain.staking;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StakingHistory {

    @JsonProperty(value = "activity_id")
    private String activityId;
    private String coin;
    private String amount;
    private String type;
    private long time;
    private StakingProduct product;
    @JsonProperty(value = "raw_type")
    private String rawType;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public StakingProduct getProduct() {
        return product;
    }

    public void setProduct(StakingProduct product) {
        this.product = product;
    }

    public String getRawType() {
        return rawType;
    }

    public void setRawType(String rawType) {
        this.rawType = rawType;
    }

    @Override
    public String toString() {
        return "StakingHistory{" +
                "activityId='" + activityId + '\'' +
                ", coin='" + coin + '\'' +
                ", amount='" + amount + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", product=" + product +
                ", rawType='" + rawType + '\'' +
                '}';
    }
}
