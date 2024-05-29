package com.cobo.custody.api.client.domain.transaction;

import com.cobo.custody.api.client.domain.account.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCTransaction {
    @JsonProperty(value = "cobo_id")
    private String coboId;
    @JsonProperty(value = "request_id")
    private String requestId;

    private Integer status;

    @JsonProperty(value = "coin_detail")
    private MPCCoin coinDetail;

    @JsonProperty(value = "nft_detail")
    private MPCNft nftDetail;

    @JsonProperty(value = "amount_detail")
    private MPCAmount amountDetail;

    @JsonProperty(value = "fee_detail")
    private MPCFee feeDetail;

    @JsonProperty(value = "source_addresses")
    private String sourceAddresses;

    @JsonProperty(value = "from_address")
    private String fromAddress;

    @JsonProperty(value = "to_address")
    private String toAddress;

    @JsonProperty(value = "tx_hash")
    private String txHash;

    @JsonProperty(value = "vout_n")
    private Integer voutN;

    private Integer nonce;

    @JsonProperty(value = "confirmed_number")
    private Integer confirmedNumber;

    @JsonProperty(value = "replace_cobo_id")
    private String replaceCoboId;

    @JsonProperty(value = "transaction_type")
    private Integer transactionType;

    private Integer operation;

    @JsonProperty(value = "block_detail")
    private MPCBlock blockDetail;

    @JsonProperty(value = "tx_detail")
    private MPCTx txDetail;

    @JsonProperty(value = "extra_parameters")
    private String extraParameters;

    @JsonProperty(value = "created_time")
    private Long createdTime;

    @JsonProperty(value = "updated_time")
    private Long updatedTime;
    @JsonProperty(value = "failed_reason")
    private String failedReason;

    @JsonProperty(value = "to_address_details")
    private String toAddressDetails;

    @JsonProperty(value = "approval_process")
    private String approvalProcess;
    
    @JsonProperty(value = "gas_station_child_id")
    private String gasStationChildID;

    private String signature;

    private String memo;

    @JsonProperty(value = "is_gas_station_tx")
    private Boolean isGasStationTx;

    private String remark;

    @Override
    public String toString() {
        return "MPCTransaction{" +
                "coboId='" + coboId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", status=" + status +
                ", coinDetail=" + coinDetail +
                ", nftDetail=" + nftDetail +
                ", amountDetail=" + amountDetail +
                ", feeDetail=" + feeDetail +
                ", sourceAddresses='" + sourceAddresses + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", txHash='" + txHash + '\'' +
                ", voutN=" + voutN +
                ", nonce=" + nonce +
                ", confirmedNumber=" + confirmedNumber +
                ", replaceCoboId='" + replaceCoboId + '\'' +
                ", transactionType=" + transactionType +
                ", operation=" + operation +
                ", blockDetail=" + blockDetail +
                ", txDetail=" + txDetail +
                ", extraParameters='" + extraParameters + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", failedReason='" + failedReason + '\'' +
                ", toAddressDetails='" + toAddressDetails + '\'' +
                ", approvalProcess='" + approvalProcess + '\'' +
                ", gasStationChildID='" + gasStationChildID + '\'' +
                ", signature='" + signature + '\'' +
                ", memo='" + memo + '\'' +
                ", isGasStationTx=" + isGasStationTx +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Boolean getGasStationTx() {
        return isGasStationTx;
    }

    public void setGasStationTx(Boolean gasStationTx) {
        isGasStationTx = gasStationTx;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApprovalProcess() {
        return approvalProcess;
    }

    public void setApprovalProcess(String approvalProcess) {
        this.approvalProcess = approvalProcess;
    }

    public String getCoboId() {
        return coboId;
    }

    public void setCoboId(String coboId) {
        this.coboId = coboId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public MPCCoin getCoinDetail() {
        return coinDetail;
    }

    public void setCoinDetail(MPCCoin coinDetail) {
        this.coinDetail = coinDetail;
    }

    public MPCAmount getAmountDetail() {
        return amountDetail;
    }

    public void setAmountDetail(MPCAmount amountDetail) {
        this.amountDetail = amountDetail;
    }

    public MPCFee getFeeDetail() {
        return feeDetail;
    }

    public void setFeeDetail(MPCFee feeDetail) {
        this.feeDetail = feeDetail;
    }

    public String getSourceAddresses() {
        return sourceAddresses;
    }

    public void setSourceAddresses(String sourceAddresses) {
        this.sourceAddresses = sourceAddresses;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public Integer getVoutN() {
        return voutN;
    }

    public void setVoutN(Integer voutN) {
        this.voutN = voutN;
    }

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public Integer getConfirmedNumber() {
        return confirmedNumber;
    }

    public void setConfirmedNumber(Integer confirmedNumber) {
        this.confirmedNumber = confirmedNumber;
    }

    public String getReplaceCoboId() {
        return replaceCoboId;
    }

    public void setReplaceCoboId(String replaceCoboId) {
        this.replaceCoboId = replaceCoboId;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public MPCBlock getBlockDetail() {
        return blockDetail;
    }

    public void setBlockDetail(MPCBlock blockDetail) {
        this.blockDetail = blockDetail;
    }

    public MPCTx getTxDetail() {
        return txDetail;
    }

    public void setTxDetail(MPCTx txDetail) {
        this.txDetail = txDetail;
    }

    public String getExtraParameters() {
        return extraParameters;
    }

    public void setExtraParameters(String extraParameters) {
        this.extraParameters = extraParameters;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    public String getToAddressDetails() {
        return toAddressDetails;
    }

    public void setToAddressDetails(String toAddressDetails) {
        this.toAddressDetails = toAddressDetails;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public MPCNft getNftDetail() {
        return nftDetail;
    }

    public void setNftDetail(MPCNft nftDetail) {
        this.nftDetail = nftDetail;
    }

    public String getGasStationChildID() {
        return gasStationChildID;
    }

    public Boolean getIsGasStationTx() {
        return isGasStationTx;
    }

    public void setIsGasStationTx(Boolean isGasStationTx) {
        this.isGasStationTx = isGasStationTx;
    }

    public void setGasStationChildID(String gasStationChildID) {
        this.gasStationChildID = gasStationChildID;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
