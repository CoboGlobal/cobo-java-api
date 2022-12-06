package com.cobo.custody.api.client.domain.transaction;

public class EstimateFeeDetails {
    private EstimateFeeDetail slow;
    private EstimateFeeDetail average;
    private EstimateFeeDetail fast;

    public EstimateFeeDetail getSlow() {
        return slow;
    }

    public void setSlow(EstimateFeeDetail slow) {
        this.slow = slow;
    }

    public EstimateFeeDetail getAverage() {
        return average;
    }

    public void setAverage(EstimateFeeDetail average) {
        this.average = average;
    }

    public EstimateFeeDetail getFast() {
        return fast;
    }

    public void setFast(EstimateFeeDetail fast) {
        this.fast = fast;
    }

    @Override
    public String toString() {
        return "{" +
                "slow='" + slow + '\'' +
                ", average='" + average + '\'' +
                ", fast='" + fast + '\'' +
                '}';
    }
}
