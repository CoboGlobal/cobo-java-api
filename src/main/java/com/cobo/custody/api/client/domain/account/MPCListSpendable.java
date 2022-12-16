package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCListSpendable {
    @JsonProperty(value = "utxos")
    private List<UTXO> utxos;

    public List<UTXO> getUtxos() {
        return utxos;
    }

    public void setUtxos(List<UTXO> utxos) {
        this.utxos = utxos;
    }

    @Override
    public String toString() {
        return "{" +
                "utxos=" + utxos +
                '}';
    }
}
