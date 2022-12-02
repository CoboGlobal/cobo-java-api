package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCTransactions {
    private List<MPCTransaction> transactions;
    private Integer total;

    public List<MPCTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<MPCTransaction> transactions) {
        this.transactions = transactions;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
                "transactions='" + transactions + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
