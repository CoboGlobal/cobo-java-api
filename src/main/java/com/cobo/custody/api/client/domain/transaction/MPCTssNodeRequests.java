package com.cobo.custody.api.client.domain.transaction;

import java.util.List;

public class MPCTssNodeRequests {
    private List<TssNodeRequestDetail> requests;

    public List<TssNodeRequestDetail> getRequests() {
        return requests;
    }

    public void setRequests(List<TssNodeRequestDetail> requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "{" +
                "requests='" + requests +
                '}';
    }
}
