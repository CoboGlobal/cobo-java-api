package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCTransaction {
    private String id;
    @JsonProperty(value = "create_time")
    private Long createTime;
    private Integer status;
    @JsonProperty(value = "chain_code")
    private String chainCode;
    private String coin;
    private List<MPCToken> tokens;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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

    public List<MPCToken> getTokens() {
        return tokens;
    }

    public void setTokens(List<MPCToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", create_time='" + createTime + '\'' +
                ", status='" + status + '\'' +
                ", chain_code='" + chainCode + '\'' +
                ", coin='" + coin + '\'' +
                ", tokens='" + tokens + '\'' +
                '}';
    }
}
