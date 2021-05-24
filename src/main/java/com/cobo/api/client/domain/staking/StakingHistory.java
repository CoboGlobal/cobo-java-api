package com.cobo.api.client.domain.staking;

public class StakingHistory {

    private String activity_id;
    private String coin;
    private String amount;
    private String type;
    private long time;
    private StakingProduct product;
    private String raw_type;

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
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

    public String getRaw_type() {
        return raw_type;
    }

    public void setRaw_type(String raw_type) {
        this.raw_type = raw_type;
    }

    @Override
    public String toString() {
        return "StakingHistory{" +
                "activity_id='" + activity_id + '\'' +
                ", coin='" + coin + '\'' +
                ", amount='" + amount + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", product=" + product +
                ", raw_type='" + raw_type + '\'' +
                '}';
    }
}
