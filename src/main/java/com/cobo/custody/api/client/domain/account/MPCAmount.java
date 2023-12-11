package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCAmount {
    private String amount;
    @JsonProperty(value = "abs_amount")
    private String absAmount;

    @JsonProperty(value = "nft_amount")
    private String nftAmount;

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

    public String getNftAmount() {
        return nftAmount;
    }

    public void setNftAmount(String nftAmount) {
        this.nftAmount = nftAmount;
    }

    @Override
    public String toString() {
        return "{" +
                "amount='" + amount + '\'' +
                ", absAmount='" + absAmount + '\'' +
                ", nftAmount='" + nftAmount + '\'' +
                '}';
    }
}
