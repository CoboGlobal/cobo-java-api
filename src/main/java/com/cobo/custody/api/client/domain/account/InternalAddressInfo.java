package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InternalAddressInfo {
    private String coin;
    private String address;
    @JsonProperty(value = "is_internal_address")
    private boolean isInternalAddress;
    @JsonProperty(value = "internal_org")
    private String internalOrg;
    @JsonProperty(value = "internal_wallet")
    private String internalWallet;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isInternalAddress() {
        return isInternalAddress;
    }

    public void setInternalAddress(boolean internalAddress) {
        this.isInternalAddress = internalAddress;
    }

    public String getInternalOrg() {
        return internalOrg;
    }

    public void setInternalOrg(String internalOrg) {
        this.internalOrg = internalOrg;
    }

    public String getInternalWallet() {
        return internalWallet;
    }

    public void setInternalWallet(String internalWallet) {
        this.internalWallet = internalWallet;
    }

    @Override
    public String toString() {
        return "InternalAddressInfo{" +
                "coin='" + coin + '\'' +
                ", address='" + address + '\'' +
                ", isInternalAddress=" + isInternalAddress +
                ", internalOrg='" + internalOrg + '\'' +
                ", internalWallet='" + internalWallet + '\'' +
                '}';
    }
}
