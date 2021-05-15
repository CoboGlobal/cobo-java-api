package com.cobo.api.client.domain;

public class CoinInfo {
    private String coin;
    private String display_code;
    private String description;
    private int decimal;
    private boolean can_deposit;
    private boolean can_withdraw;
    private boolean require_memo;
    private String balance;
    private String abs_balance;
    private String fee_coin;
    private String abs_estimate_fee;
    private long confirming_threshold;
    private long dust_threshold;
    private String token_address;

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

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public boolean isCan_deposit() {
        return can_deposit;
    }

    public void setCan_deposit(boolean can_deposit) {
        this.can_deposit = can_deposit;
    }

    public boolean isCan_withdraw() {
        return can_withdraw;
    }

    public void setCan_withdraw(boolean can_withdraw) {
        this.can_withdraw = can_withdraw;
    }

    public boolean isRequire_memo() {
        return require_memo;
    }

    public void setRequire_memo(boolean require_memo) {
        this.require_memo = require_memo;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAbs_balance() {
        return abs_balance;
    }

    public void setAbs_balance(String abs_balance) {
        this.abs_balance = abs_balance;
    }

    public String getFee_coin() {
        return fee_coin;
    }

    public void setFee_coin(String fee_coin) {
        this.fee_coin = fee_coin;
    }

    public String getAbs_estimate_fee() {
        return abs_estimate_fee;
    }

    public void setAbs_estimate_fee(String abs_estimate_fee) {
        this.abs_estimate_fee = abs_estimate_fee;
    }

    public long getConfirming_threshold() {
        return confirming_threshold;
    }

    public void setConfirming_threshold(long confirming_threshold) {
        this.confirming_threshold = confirming_threshold;
    }

    public long getDust_threshold() {
        return dust_threshold;
    }

    public void setDust_threshold(int dust_threshold) {
        this.dust_threshold = dust_threshold;
    }

    public String getToken_address() {
        return token_address;
    }

    public void setToken_address(String token_address) {
        this.token_address = token_address;
    }

    @Override
    public String toString() {
        return "CoinInfo{" +
                "coin='" + coin + '\'' +
                ", display_code='" + display_code + '\'' +
                ", description='" + description + '\'' +
                ", decimal=" + decimal +
                ", can_deposit=" + can_deposit +
                ", can_withdraw=" + can_withdraw +
                ", require_memo=" + require_memo +
                ", balance='" + balance + '\'' +
                ", abs_balance='" + abs_balance + '\'' +
                ", fee_coin='" + fee_coin + '\'' +
                ", abs_estimate_fee='" + abs_estimate_fee + '\'' +
                ", confirming_threshold=" + confirming_threshold +
                ", dust_threshold=" + dust_threshold +
                ", token_address='" + token_address + '\'' +
                '}';
    }
}
