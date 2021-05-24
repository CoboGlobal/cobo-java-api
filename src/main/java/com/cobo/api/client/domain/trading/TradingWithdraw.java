package com.cobo.api.client.domain.trading;

public class TradingWithdraw {

    private String request_id;
    private String coin;
    private String amount;
    private String abs_amount;
    private String status;
    private String fee;
    private String abs_fee;
    private String estimated_amount_received;

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
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

    public String getAbs_amount() {
        return abs_amount;
    }

    public void setAbs_amount(String abs_amount) {
        this.abs_amount = abs_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getAbs_fee() {
        return abs_fee;
    }

    public void setAbs_fee(String abs_fee) {
        this.abs_fee = abs_fee;
    }

    public String getEstimated_amount_received() {
        return estimated_amount_received;
    }

    public void setEstimated_amount_received(String estimated_amount_received) {
        this.estimated_amount_received = estimated_amount_received;
    }
}
