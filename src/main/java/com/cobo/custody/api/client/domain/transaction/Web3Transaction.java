package com.cobo.custody.api.client.domain.transaction;

import com.cobo.custody.api.client.domain.account.Web3Fee;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Web3Transaction {
    private String id;

    private String txid;
    @JsonProperty(value = "create_time")
    private Long createTime;
    private Integer status;
    @JsonProperty(value = "chain_code")
    private String chainCode;
    private List<Web3Token> tokens;

    @JsonProperty(value = "fee_detail")
    private Web3Fee feeDetail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
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

    public List<Web3Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Web3Token> tokens) {
        this.tokens = tokens;
    }

    public Web3Fee getFeeDetail() {
        return feeDetail;
    }

    public void setFeeDetail(Web3Fee feeDetail) {
        this.feeDetail = feeDetail;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", txid='" + txid + '\'' +
                ", create_time='" + createTime + '\'' +
                ", status='" + status + '\'' +
                ", chain_code='" + chainCode + '\'' +
                ", tokens='" + tokens + '\'' +
                ", feeDetail='" + feeDetail + '\'' +
                '}';
    }
}
