package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCAmount {
    private String amount;
    @JsonProperty(value = "abs_amount")
    private String absAmount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAbsAmount() {
        return absAmount;
    }

    public void setAbsAmount(String absAmount) {
        this.absAmount = absAmount;
    }

    @Override
    public String toString() {
        return "{" +
                "amount='" + amount + '\'' +
                ", absAmount='" + absAmount + '\'' +
                '}';
    }
}
