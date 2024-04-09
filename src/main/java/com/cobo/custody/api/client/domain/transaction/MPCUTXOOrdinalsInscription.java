package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class MPCUTXOOrdinalsInscription {
    @JsonProperty(value = "inscription_id")
    private String inscriptionId;
    @JsonProperty(value = "metadata")
    private Map metaData;
    private String parent;
    private String address;
    @JsonProperty(value = "content_type")
    private String contentType;
    @JsonProperty(value = "genesis_height")
    private Integer genesisHeight;
    @JsonProperty(value = "genesis_transaction")
    private String genesisTransaction;
    private String location;
    private String output;
    private Integer offset;
    @JsonProperty(value = "ethereum_teleburn_address")
    private String ethereumTeleburnAddress;

    public String getInscriptionId() {
        return inscriptionId;
    }

    public void setInscriptionId(String inscriptionId) {
        this.inscriptionId = inscriptionId;
    }

    public Map getMetaData() {
        return metaData;
    }

    public void setMetaData(Map metaData) {
        this.metaData = metaData;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getGenesisHeight() {
        return genesisHeight;
    }

    public void setGenesisHeight(Integer genesisHeight) {
        this.genesisHeight = genesisHeight;
    }

    public String getGenesisTransaction() {
        return genesisTransaction;
    }

    public void setGenesisTransaction(String genesisTransaction) {
        this.genesisTransaction = genesisTransaction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getEthereumTeleburnAddress() {
        return ethereumTeleburnAddress;
    }

    public void setEthereumTeleburnAddress(String ethereumTeleburnAddress) {
        this.ethereumTeleburnAddress = ethereumTeleburnAddress;
    }

    @Override
    public String toString() {
        return "MPCUTXOOrdinalsInscription{" +
                "inscriptionId='" + inscriptionId + '\'' +
                ", metaData=" + metaData +
                ", parent='" + parent + '\'' +
                ", address='" + address + '\'' +
                ", contentType='" + contentType + '\'' +
                ", genesisHeight=" + genesisHeight +
                ", genesisTransaction='" + genesisTransaction + '\'' +
                ", location='" + location + '\'' +
                ", output='" + output + '\'' +
                ", offset=" + offset +
                ", ethereumTeleburnAddress='" + ethereumTeleburnAddress + '\'' +
                '}';
    }
}
