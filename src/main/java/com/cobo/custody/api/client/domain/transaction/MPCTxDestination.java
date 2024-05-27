package com.cobo.custody.api.client.domain.transaction;

import java.math.BigInteger;

public class MPCTxDestination {
    private String address;
    private BigInteger amount;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MPCTxDestination{" +
                "address='" + address + '\'' +
                ", amount=" + amount +
                '}';
    }
}
