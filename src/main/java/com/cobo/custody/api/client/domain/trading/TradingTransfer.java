package com.cobo.custody.api.client.domain.trading;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradingTransfer {

    @JsonProperty(value = "request_id")
    private String requestId;
    private String coin;
    private String amount;
    @JsonProperty(value = "abs_amount")
    private String absAmount;
    private String status;
    private String fee;
    @JsonProperty(value = "abs_fee")
    private String absFee;
    @JsonProperty(value = "estimated_amount_received")
    private String estimatedAmountReceived;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public String getAbsAmount() {
        return absAmount;
    }

    public void setAbsAmount(String absAmount) {
        this.absAmount = absAmount;
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

    public String getAbsFee() {
        return absFee;
    }

    public void setAbsFee(String absFee) {
        this.absFee = absFee;
    }

    public String getEstimatedAmountReceived() {
        return estimatedAmountReceived;
    }

    public void setEstimatedAmountReceived(String estimatedAmountReceived) {
        this.estimatedAmountReceived = estimatedAmountReceived;
    }
}
