package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCTx {
    @JsonProperty(value = "tx_hash")
    private String txHash;
    @JsonProperty(value = "selected_utxos")
    private List<SelectedUTXO> selectedUTXOs;
    @JsonProperty(value = "target_destinations")
    private List<Destination> targetDestinations;

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public List<SelectedUTXO> getSelectedUTXOs() {
        return selectedUTXOs;
    }

    public void setSelectedUTXOs(List<SelectedUTXO> selectedUTXOs) {
        this.selectedUTXOs = selectedUTXOs;
    }

    public List<Destination> getTargetDestinations() {
        return targetDestinations;
    }

    public void setTargetDestinations(List<Destination> targetDestinations) {
        this.targetDestinations = targetDestinations;
    }

    @Override
    public String toString() {
        return "{" +
                "txHash='" + txHash + '\'' +
                ", selectedUTXOs=" + selectedUTXOs +
                ", targetDestinations=" + targetDestinations +
                '}';
    }
}
