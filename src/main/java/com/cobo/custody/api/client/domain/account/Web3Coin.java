package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Web3Coin {
    private String coin;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private int decimal;
    @JsonProperty(value = "can_deposit")
    private boolean canDeposit;
    @JsonProperty(value = "can_withdraw")
    private boolean canWithdraw;
    @JsonProperty(value = "minimum_deposit_threshold")
    private String minimumDepositThreshold;

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

    public String getMinimumDepositThreshold() {
        return minimumDepositThreshold;
    }

    public void setMinimumDepositThreshold(String minimumDepositThreshold) {
        this.minimumDepositThreshold = minimumDepositThreshold;
    }

    @Override
    public String toString() {
        return "{" +
                "coin='" + coin + '\'' +
                ", displayCode='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", decimal=" + decimal +
                ", canDeposit=" + canDeposit +
                ", canWithdraw=" + canWithdraw +
                ", minimumDepositThreshold='" + minimumDepositThreshold + '\'' +
                '}';
    }
}
