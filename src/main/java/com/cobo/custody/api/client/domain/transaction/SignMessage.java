package com.cobo.custody.api.client.domain.transaction;

import com.cobo.custody.api.client.domain.account.MPCCoin;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignMessage {
    @JsonProperty(value = "request_id")
    private String requestId;
    @JsonProperty(value = "cobo_id")
    private String coboId;
    private String signature;
    @JsonProperty(value = "chain_code")
    private String chainCode;
    @JsonProperty(value = "from_address")
    private String fromAddress;
    @JsonProperty(value = "sign_version")
    private int signVersion;
    @JsonProperty(value = "extra_parameters")
    private String extraParameters;

    @JsonProperty(value = "coin_detail")
    private MPCCoin coinDetail;

    @JsonProperty(value = "created_time")
    private Long createdTime;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCoboId() {
        return coboId;
    }

    public void setCoboId(String coboId) {
        this.coboId = coboId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public int getSignVersion() {
        return signVersion;
    }

    public void setSignVersion(int signVersion) {
        this.signVersion = signVersion;
    }

    public String getExtraParameters() {
        return extraParameters;
    }

    public void setExtraParameters(String extraParameters) {
        this.extraParameters = extraParameters;
    }

    public MPCCoin getCoinDetail() {
        return coinDetail;
    }

    public void setCoinDetail(MPCCoin coinDetail) {
        this.coinDetail = coinDetail;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "SignMessage{" +
                "requestId='" + requestId + '\'' +
                ", coboId='" + coboId + '\'' +
                ", signature='" + signature + '\'' +
                ", chainCode='" + chainCode + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", signVersion=" + signVersion +
                ", extraParameters='" + extraParameters + '\'' +
                ", coinDetail=" + coinDetail +
                ", createdTime=" + createdTime +
                '}';
    }
}
