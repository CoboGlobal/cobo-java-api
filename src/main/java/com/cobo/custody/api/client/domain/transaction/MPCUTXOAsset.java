package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class MPCUTXOAsset {
    @JsonProperty(value = "brc_20")
    private Map<String, MPCUTXOBRC20Asset> brc20;
    @JsonProperty(value = "ordinals_inscription")
    private List<MPCUTXOOrdinalsInscription> ordinalsInscription;

    public Map<String, MPCUTXOBRC20Asset> getBrc20() {
        return brc20;
    }

    public void setBrc20(Map<String, MPCUTXOBRC20Asset> brc20) {
        this.brc20 = brc20;
    }

    public List<MPCUTXOOrdinalsInscription> getOrdinalsInscription() {
        return ordinalsInscription;
    }

    public void setOrdinalsInscription(List<MPCUTXOOrdinalsInscription> ordinalsInscription) {
        this.ordinalsInscription = ordinalsInscription;
    }

    @Override
    public String toString() {
        return "MPCUTXOAsset{" +
                "brc20=" + brc20 +
                ", ordinalsInscription=" + ordinalsInscription +
                '}';
    }
}
