package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCCoin {
    private String coin;

    @JsonProperty(value = "chain_code")
    private String chainCode;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private Integer decimal;
    @JsonProperty(value = "can_deposit")
    private Boolean canDeposit;
    @JsonProperty(value = "can_withdraw")
    private Boolean canWithdraw;
    @JsonProperty(value = "confirming_threshold")
    private Integer confirmingThreshold;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
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

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    public Boolean getCanDeposit() {
        return canDeposit;
    }

    public void setCanDeposit(Boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public Integer getConfirmingThreshold() {
        return confirmingThreshold;
    }

    public void setConfirmingThreshold(Integer confirmingThreshold) {
        this.confirmingThreshold = confirmingThreshold;
    }

    @Override
    public String toString() {
        return "{" +
                "coin='" + coin + '\'' +
                ", chainCode='" + chainCode + '\'' +
                ", displayCode='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", decimal=" + decimal +
                ", canDeposit=" + canDeposit +
                ", canWithdraw=" + canWithdraw +
                ", confirmingThreshold=" + confirmingThreshold +
                '}';
    }
}
