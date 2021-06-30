package com.cobo.custody.api.client.domain.account;

import java.util.List;

public class NewAddresses {

    private String coin;
    private List<String> addresses;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "NewAddresses{" +
                "coin='" + coin + '\'' +
                ", addresses=" + addresses.stream().reduce("", (s1, s2) -> s1 + "," + s2) +
                '}';
    }

}