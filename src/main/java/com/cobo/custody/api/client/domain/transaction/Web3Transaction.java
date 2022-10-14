package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Web3Transaction {
    private String id;
    private Long time;
    private Integer status;
    @JsonProperty(value = "chain_coin")
    private String chainCode;
    private String coin;
    private List<Web3Token> tokens;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public List<Web3Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Web3Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                "time='" + time + '\'' +
                "status='" + status + '\'' +
                "chain_code='" + chainCode + '\'' +
                "coin='" + coin + '\'' +
                "tokens='" + tokens + '\'' +
                '}';
    }
}
