package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

    private String id;
    private String coin;
    private String display_code;
    private String description;
    private int decimal;
    private String address;
    @JsonProperty(value = "source_address")
    private String sourceAddress;
    private String side;
    private String amount;
    @JsonProperty(value = "abs_amount")
    private String absAmount;
    @JsonProperty(value = "txid")
    private String txId;
    @JsonProperty(value = "vout_n")
    private int voutN;
    @JsonProperty(value = "request_id")
    private String requestId;
    private String status;
    @JsonProperty(value = "abs_cobo_fee")
    private String absCoboFee;
    @JsonProperty(value = "created_time")
    private long createdTime;
    @JsonProperty(value = "last_time")
    private long lastTime;
    @JsonProperty(value = "confirmed_num")
    private int confirmedNum;
    @JsonProperty(value = "tx_detail")
    private TxDetail txDetail;
    @JsonProperty(value = "source_address_detail")
    private String sourceAddressDetail;
    private String memo;
    @JsonProperty(value = "confirming_threshold")
    private int confirmingThreshold;
    @JsonProperty(value = "fee_coin")
    private String feeCoin;
    @JsonProperty(value = "fee_amount")
    private String feeAmount;
    @JsonProperty(value = "fee_decimal")
    private int feeDecimal;
    private String type;
    @JsonProperty(value = "waiting_audit")
    private boolean waitingAudit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getDisplay_code() {
        return display_code;
    }

    public void setDisplay_code(String display_code) {
        this.display_code = display_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAbsAmount() {
        return absAmount;
    }

    public void setAbsAmount(String absAmount) {
        this.absAmount = absAmount;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public int getVoutN() {
        return voutN;
    }

    public void setVoutN(int voutN) {
        this.voutN = voutN;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAbsCoboFee() {
        return absCoboFee;
    }

    public void setAbsCoboFee(String absCoboFee) {
        this.absCoboFee = absCoboFee;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public int getConfirmedNum() {
        return confirmedNum;
    }

    public void setConfirmedNum(int confirmedNum) {
        this.confirmedNum = confirmedNum;
    }

    public TxDetail getTxDetail() {
        return txDetail;
    }

    public void setTxDetail(TxDetail txDetail) {
        this.txDetail = txDetail;
    }

    public String getSourceAddressDetail() {
        return sourceAddressDetail;
    }

    public void setSourceAddressDetail(String sourceAddressDetail) {
        this.sourceAddressDetail = sourceAddressDetail;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getConfirmingThreshold() {
        return confirmingThreshold;
    }

    public void setConfirmingThreshold(int confirmingThreshold) {
        this.confirmingThreshold = confirmingThreshold;
    }

    public String getFeeCoin() {
        return feeCoin;
    }

    public void setFeeCoin(String feeCoin) {
        this.feeCoin = feeCoin;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public int getFeeDecimal() {
        return feeDecimal;
    }

    public void setFeeDecimal(int feeDecimal) {
        this.feeDecimal = feeDecimal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWaitingAudit() {
        return waitingAudit;
    }

    public void setWaitingAudit(boolean waitingAudit) {
        this.waitingAudit = waitingAudit;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", coin='" + coin + '\'' +
                ", display_code='" + display_code + '\'' +
                ", description='" + description + '\'' +
                ", decimal=" + decimal +
                ", address='" + address + '\'' +
                ", source_address='" + sourceAddress + '\'' +
                ", side='" + side + '\'' +
                ", amount='" + amount + '\'' +
                ", abs_amount='" + absAmount + '\'' +
                ", txid='" + txId + '\'' +
                ", vout_n=" + voutN +
                ", request_id='" + requestId + '\'' +
                ", status='" + status + '\'' +
                ", abs_cobo_fee='" + absCoboFee + '\'' +
                ", created_time=" + createdTime +
                ", last_time=" + lastTime +
                ", confirmed_num=" + confirmedNum +
                ", tx_detail=" + txDetail +
                ", source_address_detail='" + sourceAddressDetail + '\'' +
                ", memo='" + memo + '\'' +
                ", confirming_threshold=" + confirmingThreshold +
                ", fee_coin='" + feeCoin + '\'' +
                ", fee_amount='" + feeAmount + '\'' +
                ", fee_decimal=" + feeDecimal +
                ", type='" + type + '\'' +
                ", waiting_audit=" + waitingAudit +
                '}';
    }

    public static class TxDetail {
        @JsonProperty(value = "txid")
        private String txId;
        private int blocknum;
        private String blockhash;
        private long fee;
        private long actualgas;
        private long gasprice;
        private String hexstr;

        public String getTxId() {
            return txId;
        }

        public void setTxId(String txId) {
            this.txId = txId;
        }

        public int getBlocknum() {
            return blocknum;
        }

        public void setBlocknum(int blocknum) {
            this.blocknum = blocknum;
        }

        public String getBlockhash() {
            return blockhash;
        }

        public void setBlockhash(String blockhash) {
            this.blockhash = blockhash;
        }

        public long getFee() {
            return fee;
        }

        public void setFee(long fee) {
            this.fee = fee;
        }

        public long getActualgas() {
            return actualgas;
        }

        public void setActualgas(long actualgas) {
            this.actualgas = actualgas;
        }

        public long getGasprice() {
            return gasprice;
        }

        public void setGasprice(long gasprice) {
            this.gasprice = gasprice;
        }

        public String getHexstr() {
            return hexstr;
        }

        public void setHexstr(String hexstr) {
            this.hexstr = hexstr;
        }

        @Override
        public String toString() {
            return "TxDetail{" +
                    "txid='" + txId + '\'' +
                    ", blocknum=" + blocknum +
                    ", blockhash='" + blockhash + '\'' +
                    ", fee=" + fee +
                    ", actualgas=" + actualgas +
                    ", gasprice=" + gasprice +
                    ", hexstr='" + hexstr + '\'' +
                    '}';
        }
    }
}


