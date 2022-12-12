package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCAddress {
    private String id;
    private String address;
    @JsonProperty(value = "hd_path")
    private String hdPath;
    private Integer encoding;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHdPath() {
        return hdPath;
    }

    public void setHdPath(String hdPath) {
        this.hdPath = hdPath;
    }

    public Integer getEncoding() {
        return encoding;
    }

    public void setEncoding(Integer encoding) {
        this.encoding = encoding;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", hdPath='" + hdPath + '\'' +
                ", encoding='" + encoding + '\'' +
                '}';
    }
}
