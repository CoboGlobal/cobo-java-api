package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinInfo {
    private String coin;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private int decimal;
    @JsonProperty(value = "can_deposit")
    private boolean canDeposit;
    @JsonProperty(value = "can_withdraw")
    private boolean canWithdraw;
    @JsonProperty(value = "require_memo")
    private boolean requireMemo;
    @JsonProperty(value = "minimum_deposit_threshold")
    private String minimumDepositThreshold;
    private String balance;
    @JsonProperty(value = "abs_balance")
    private String absBalance;
    @JsonProperty(value = "fee_coin")
    private String feeCoin;
    @JsonProperty(value = "abs_estimate_fee")
    private String absEstimateFee;
    @JsonProperty(value = "confirming_threshold")
    private long confirmingThreshold;
    @JsonProperty(value = "dust_threshold")
    private long dustThreshold;
    @JsonProperty(value = "token_address")
    private String tokenAddress;

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

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public boolean isCanDeposit() {
        return canDeposit;
    }

    public void setCanDeposit(boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    public boolean isCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public boolean isRequireMemo() {
        return requireMemo;
    }

    public void setRequireMemo(boolean requireMemo) {
        this.requireMemo = requireMemo;
    }

    public String getMinimumDepositThreshold() {
        return minimumDepositThreshold;
    }

    public void setMinimumDepositThreshold(String minimumDepositThreshold) {
        this.minimumDepositThreshold = minimumDepositThreshold;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAbsBalance() {
        return absBalance;
    }

    public void setAbsBalance(String absBalance) {
        this.absBalance = absBalance;
    }

    public String getFeeCoin() {
        return feeCoin;
    }

    public void setFeeCoin(String feeCoin) {
        this.feeCoin = feeCoin;
    }

    public String getAbsEstimateFee() {
        return absEstimateFee;
    }

    public void setAbsEstimateFee(String absEstimateFee) {
        this.absEstimateFee = absEstimateFee;
    }

    public long getConfirmingThreshold() {
        return confirmingThreshold;
    }

    public void setConfirmingThreshold(long confirmingThreshold) {
        this.confirmingThreshold = confirmingThreshold;
    }

    public long getDustThreshold() {
        return dustThreshold;
    }

    public void setDustThreshold(int dustThreshold) {
        this.dustThreshold = dustThreshold;
    }

    public String getTokenAddress() {
        return tokenAddress;
    }

    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

    @Override
    public String toString() {
        return "CoinInfo{" +
                "coin='" + coin + '\'' +
                ", displayCode='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", decimal=" + decimal +
                ", canDeposit=" + canDeposit +
                ", canWithdraw=" + canWithdraw +
                ", requireMemo=" + requireMemo +
                ", minimumDepositThreshold='" + minimumDepositThreshold + '\'' +
                ", balance='" + balance + '\'' +
                ", absBalance='" + absBalance + '\'' +
                ", feeCoin='" + feeCoin + '\'' +
                ", absEstimateFee='" + absEstimateFee + '\'' +
                ", confirmingThreshold=" + confirmingThreshold +
                ", dustThreshold=" + dustThreshold +
                ", tokenAddress='" + tokenAddress + '\'' +
                '}';
    }
}
