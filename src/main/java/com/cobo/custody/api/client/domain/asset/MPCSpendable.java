package com.cobo.custody.api.client.domain.asset;

import java.util.List;

public class MPCSpendable {
    private List<MPCUtxo> utxos;

    public List<MPCUtxo> getUtxos() {
        return utxos;
    }

    public void setUtxos(List<MPCUtxo> utxos) {
        this.utxos = utxos;
    }

    @Override
    public String toString() {
        return "{" +
                "utxos='" + utxos + '\'' +
                '}';
    }
}
