package com.cobo.custody.api.client.domain.transaction;

public class MPCToken {
    private String name;
    private String amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
