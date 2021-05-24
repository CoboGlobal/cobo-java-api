package com.cobo.api.client.domain.account;

public class InternalAddressInfo {
    private String coin;
    private String address;
    private boolean is_internal_address;
    private String internal_org;
    private String internal_wallet;

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

    public boolean isIs_internal_address() {
        return is_internal_address;
    }

    public void setIs_internal_address(boolean is_internal_address) {
        this.is_internal_address = is_internal_address;
    }

    public String getInternal_org() {
        return internal_org;
    }

    public void setInternal_org(String internal_org) {
        this.internal_org = internal_org;
    }

    public String getInternal_wallet() {
        return internal_wallet;
    }

    public void setInternal_wallet(String internal_wallet) {
        this.internal_wallet = internal_wallet;
    }

    @Override
    public String toString() {
        return "InternalAddressInfo{" +
                "coin='" + coin + '\'' +
                ", address='" + address + '\'' +
                ", is_internal_address=" + is_internal_address +
                ", internal_org='" + internal_org + '\'' +
                ", internal_wallet='" + internal_wallet + '\'' +
                '}';
    }
}
