package com.cobo.custody.api.client.domain.account;

public class Addresses {
    private String coin;
    private String addresses;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "NewAddress{" +
                "coin='" + coin + '\'' +
                ", addresses='" + addresses + '\'' +
                '}';
    }
}
