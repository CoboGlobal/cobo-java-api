package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCCoin {
    private String coin;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private int decimal;
    @JsonProperty(value = "can_deposit")
    private boolean canDeposit;
    @JsonProperty(value = "can_withdraw")
    private boolean canWithdraw;
    @JsonProperty(value = "confirming_threshold")
    private String confirmingThreshold;

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

    public String getConfirmingThreshold() {
        return confirmingThreshold;
    }

    public void setConfirmingThreshold(String confirmingThreshold) {
        this.confirmingThreshold = confirmingThreshold;
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
                ", confirmingThreshold='" + confirmingThreshold + '\'' +
                '}';
    }
}
