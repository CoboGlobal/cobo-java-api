package com.cobo.custody.api.client.domain.account;

import java.util.List;

public class PrimeBrokerUserAuthInfo {
    private String pubkey;

    private List<PrimeBrokerAddress> addresses;

    public String getPubkey() {
        return pubkey;
    }

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }

    public List<PrimeBrokerAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<PrimeBrokerAddress> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "PrimeBrokerUserAuthInfo{" +
                "pubkey='" + pubkey + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
