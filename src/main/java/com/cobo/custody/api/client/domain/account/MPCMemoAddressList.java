package com.cobo.custody.api.client.domain.account;

import java.util.List;

public class MPCMemoAddressList {
    private List<String> addresses;

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "{" +
                "addresses='" + addresses + '\'' +
                '}';
    }
}
