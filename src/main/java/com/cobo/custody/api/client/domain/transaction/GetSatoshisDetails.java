package com.cobo.custody.api.client.domain.transaction;

import java.util.List;

public class GetSatoshisDetails {
    private List<GetSatoshisDetail> satoshis;

    public List<GetSatoshisDetail> getSatoshis() {
        return satoshis;
    }

    public void setSatoshis(List<GetSatoshisDetail> satoshis) {
        this.satoshis = satoshis;
    }

    @Override
    public String toString() {
        return "GetSatoshisDetail{" +
                "satoshis='" + satoshis + '\'' +
                '}';
    }
}
