package com.cobo.api.client.domain;

public class WithdrawConfirmation {

    private String id;
    private String coin;
    private String display_code;
    private String description;
    private String address;
    private String source_address;
    private String side;
    private String amount;
    private int decimal;
    private String abs_amount;
    private String txid;
    private int vout_n;
    private String request_id;
    private String status;
    private long created_time;
    private long last_time;
    private String memo;
    private int confirming_threshold;
    private int confirmed_num;
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

    public String getDisplay_code() {
        return display_code;
    }

    public void setDisplay_code(String display_code) {
        this.display_code = display_code;
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

    public String getSource_address() {
        return source_address;
    }

    public void setSource_address(String source_address) {
        this.source_address = source_address;
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

    public String getAbs_amount() {
        return abs_amount;
    }

    public void setAbs_amount(String abs_amount) {
        this.abs_amount = abs_amount;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public int getVout_n() {
        return vout_n;
    }

    public void setVout_n(int vout_n) {
        this.vout_n = vout_n;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCreated_time() {
        return created_time;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public long getLast_time() {
        return last_time;
    }

    public void setLast_time(long last_time) {
        this.last_time = last_time;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getConfirming_threshold() {
        return confirming_threshold;
    }

    public void setConfirming_threshold(int confirming_threshold) {
        this.confirming_threshold = confirming_threshold;
    }

    public int getConfirmed_num() {
        return confirmed_num;
    }

    public void setConfirmed_num(int confirmed_num) {
        this.confirmed_num = confirmed_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
