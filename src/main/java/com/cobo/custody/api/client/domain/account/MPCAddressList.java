package com.cobo.custody.api.client.domain.account;

import java.util.List;

public class MPCAddressList {
    private List<MPCAddress> addresses;

    public List<MPCAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<MPCAddress> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "{" +
                "addresses='" + addresses + '\'' +
                '}';
    }
}
