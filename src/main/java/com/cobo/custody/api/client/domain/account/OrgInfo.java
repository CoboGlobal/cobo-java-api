package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrgInfo {

    private String name;
    private List<Assets> assets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Assets> getAssets() {
        return assets;
    }

    public void setAssets(List<Assets> assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "OrgInfo{" +
                "name='" + name + '\'' +
                ", assets=" + assets +
                '}';
    }

    public static class Assets {
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
        private String balance;
        @JsonProperty(value = "abs_balance")
        private String absBalance;
        @JsonProperty(value = "fee_coin")
        private String feeCoin;
        @JsonProperty(value = "abs_estimate_fee")
        private String absEstimateFee;
        @JsonProperty(value = "confirming_threshold")
        private int confirmingThreshold;
        @JsonProperty(value = "dust_threshold")
        private long dustThreshold;
        @JsonProperty(value = "token_address")
        private String tokenAddress;
        @JsonProperty(value = "require_memo")
        private boolean requireMemo;

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

        public int getConfirmingThreshold() {
            return confirmingThreshold;
        }

        public void setConfirmingThreshold(int confirmingThreshold) {
            this.confirmingThreshold = confirmingThreshold;
        }

        public long getDustThreshold() {
            return dustThreshold;
        }

        public void setDustThreshold(long dustThreshold) {
            this.dustThreshold = dustThreshold;
        }

        public String getTokenAddress() {
            return tokenAddress;
        }

        public void setTokenAddress(String tokenAddress) {
            this.tokenAddress = tokenAddress;
        }

        public boolean isRequireMemo() {
            return requireMemo;
        }

        public void setRequireMemo(boolean requireMemo) {
            this.requireMemo = requireMemo;
        }

        @Override
        public String toString() {
            return "Assets{" +
                    "coin='" + coin + '\'' +
                    ", displayCode='" + displayCode + '\'' +
                    ", description='" + description + '\'' +
                    ", decimal=" + decimal +
                    ", canDeposit=" + canDeposit +
                    ", canWithdraw=" + canWithdraw +
                    ", minimumDepositThreshold='" + minimumDepositThreshold + '\'' +
                    ", balance='" + balance + '\'' +
                    ", absBalance='" + absBalance + '\'' +
                    ", feeCoin='" + feeCoin + '\'' +
                    ", absEstimateFee='" + absEstimateFee + '\'' +
                    ", confirmingThreshold=" + confirmingThreshold +
                    ", dustThreshold=" + dustThreshold +
                    ", tokenAddress='" + tokenAddress + '\'' +
                    ", requireMemo=" + requireMemo +
                    '}';
        }
    }
}
