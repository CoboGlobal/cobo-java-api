package com.cobo.custody.api.client.domain.account;

public class Address {
    private String coin;
    private String address;

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

    @Override
    public String toString() {
        return "Address{" +
                "coin='" + coin + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
