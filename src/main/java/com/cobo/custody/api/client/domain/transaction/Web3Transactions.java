package com.cobo.custody.api.client.domain.transaction;

import java.util.List;

public class Web3Transactions {
    private List<Web3Transaction> transactions;

    public List<Web3Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Web3Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "{" +
                "transactions='" + transactions + '\'' +
                '}';
    }
}
