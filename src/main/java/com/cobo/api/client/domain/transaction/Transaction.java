package com.cobo.api.client.domain.transaction;

public class Transaction {

    private String id;
    private String coin;
    private String display_code;
    private String description;
    private int decimal;
    private String address;
    private String source_address;
    private String side;
    private String amount;
    private String abs_amount;
    private String txid;
    private int vout_n;
    private String request_id;
    private String status;
    private String abs_cobo_fee;
    private long created_time;
    private long last_time;
    private int confirmed_num;
    private TxDetail tx_detail;
    private String source_address_detail;
    private String memo;
    private int confirming_threshold;
    private String fee_coin;
    private String fee_amount;
    private int fee_decimal;
    private String type;
    private boolean waiting_audit;

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

    public String getSource_address() {
        return source_address;
    }

    public void setSource_address(String source_address) {
        this.source_address = source_address;
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

    public String getAbs_amount() {
        return abs_amount;
    }

    public void setAbs_amount(String abs_amount) {
        this.abs_amount = abs_amount;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public int getVout_n() {
        return vout_n;
    }

    public void setVout_n(int vout_n) {
        this.vout_n = vout_n;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAbs_cobo_fee() {
        return abs_cobo_fee;
    }

    public void setAbs_cobo_fee(String abs_cobo_fee) {
        this.abs_cobo_fee = abs_cobo_fee;
    }

    public long getCreated_time() {
        return created_time;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public long getLast_time() {
        return last_time;
    }

    public void setLast_time(long last_time) {
        this.last_time = last_time;
    }

    public int getConfirmed_num() {
        return confirmed_num;
    }

    public void setConfirmed_num(int confirmed_num) {
        this.confirmed_num = confirmed_num;
    }

    public TxDetail getTx_detail() {
        return tx_detail;
    }

    public void setTx_detail(TxDetail tx_detail) {
        this.tx_detail = tx_detail;
    }

    public String getSource_address_detail() {
        return source_address_detail;
    }

    public void setSource_address_detail(String source_address_detail) {
        this.source_address_detail = source_address_detail;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getConfirming_threshold() {
        return confirming_threshold;
    }

    public void setConfirming_threshold(int confirming_threshold) {
        this.confirming_threshold = confirming_threshold;
    }

    public String getFee_coin() {
        return fee_coin;
    }

    public void setFee_coin(String fee_coin) {
        this.fee_coin = fee_coin;
    }

    public String getFee_amount() {
        return fee_amount;
    }

    public void setFee_amount(String fee_amount) {
        this.fee_amount = fee_amount;
    }

    public int getFee_decimal() {
        return fee_decimal;
    }

    public void setFee_decimal(int fee_decimal) {
        this.fee_decimal = fee_decimal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWaiting_audit() {
        return waiting_audit;
    }

    public void setWaiting_audit(boolean waiting_audit) {
        this.waiting_audit = waiting_audit;
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
                ", source_address='" + source_address + '\'' +
                ", side='" + side + '\'' +
                ", amount='" + amount + '\'' +
                ", abs_amount='" + abs_amount + '\'' +
                ", txid='" + txid + '\'' +
                ", vout_n=" + vout_n +
                ", request_id='" + request_id + '\'' +
                ", status='" + status + '\'' +
                ", abs_cobo_fee='" + abs_cobo_fee + '\'' +
                ", created_time=" + created_time +
                ", last_time=" + last_time +
                ", confirmed_num=" + confirmed_num +
                ", tx_detail=" + tx_detail +
                ", source_address_detail='" + source_address_detail + '\'' +
                ", memo='" + memo + '\'' +
                ", confirming_threshold=" + confirming_threshold +
                ", fee_coin='" + fee_coin + '\'' +
                ", fee_amount='" + fee_amount + '\'' +
                ", fee_decimal=" + fee_decimal +
                ", type='" + type + '\'' +
                ", waiting_audit=" + waiting_audit +
                '}';
    }

    public static class TxDetail {
        private String txid;
        private int blocknum;
        private String blockhash;
        private long fee;
        private long actualgas;
        private long gasprice;
        private String hexstr;

        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
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
                    "txid='" + txid + '\'' +
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


