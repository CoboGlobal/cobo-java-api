package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GasStationBalance {
    private List<Asset> assets;

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "GasStationBalance{" +
                "assets=" + assets +
                '}';
    }

    public static class Asset {
        private String coin;
        private String description;
        private String decimal;
        private String balance;
        @JsonProperty(value = "abs_balance")
        private String absBalance;
        private String address;

        public String getCoin() {
            return coin;
        }

        public void setCoin(String coin) {
            this.coin = coin;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDecimal() {
            return decimal;
        }

        public void setDecimal(String decimal) {
            this.decimal = decimal;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Assets{" +
                    "coin='" + coin + '\'' +
                    ", description='" + description + '\'' +
                    ", decimal=" + decimal +
                    ", balance='" + balance + '\'' +
                    ", absBalance='" + absBalance + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}

