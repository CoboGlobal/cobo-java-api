package com.cobo.custody.api.client.domain.account;

import java.util.List;

public class PrimeBrokerUserBindInfo {
    private String pubkey;

    private Integer status;

    private List<PrimeBrokerAddress> addresses;

    public String getPubkey() {
        return pubkey;
    }

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<PrimeBrokerAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<PrimeBrokerAddress> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "PrimeBrokerUserBindInfo{" +
                "pubkey='" + pubkey + '\'' +
                ", status=" + status +
                ", addresses=" + addresses +
                '}';
    }
}
