package com.cobo.custody.api.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WithdrawConfirmation {

    private String id;
    private String coin;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private String address;
    @JsonProperty(value = "source_address")
    private String sourceAddress;
    private String side;
    private String amount;
    private int decimal;
    @JsonProperty(value = "abs_amount")
    private String absAmount;
    @JsonProperty(value = "txid")
    private String txId;
    @JsonProperty(value = "vout_n")
    private int voutN;
    @JsonProperty(value = "request_id")
    private String requestId;
    private String status;
    @JsonProperty(value = "created_time")
    private long createdTime;
    @JsonProperty(value = "last_time")
    private long lastTime;
    private String memo;
    @JsonProperty(value = "confirming_threshold")
    private int confirmingThreshold;
    @JsonProperty(value = "confirmed_num")
    private int confirmedNum;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getDisplayCode() {
        return displayCode;
    }

    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public String getAbsAmount() {
        return absAmount;
    }

    public void setAbsAmount(String absAmount) {
        this.absAmount = absAmount;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public int getVoutN() {
        return voutN;
    }

    public void setVoutN(int voutN) {
        this.voutN = voutN;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getConfirmingThreshold() {
        return confirmingThreshold;
    }

    public void setConfirmingThreshold(int confirmingThreshold) {
        this.confirmingThreshold = confirmingThreshold;
    }

    public int getConfirmedNum() {
        return confirmedNum;
    }

    public void setConfirmedNum(int confirmedNum) {
        this.confirmedNum = confirmedNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
