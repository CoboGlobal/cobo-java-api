package com.cobo.custody.api.client.callback;

import com.blade.Blade;
import com.blade.mvc.RouteContext;
import com.blade.mvc.handler.RouteHandler;
import com.cobo.custody.api.client.impl.LocalSigner;
import org.apache.commons.lang3.StringUtils;

public class Demo {
    private static final String coboPubKey = "032f45930f652d72e0c90f71869dfe9af7d713b1f67dc2f7cb51f9572778b9c876";
    static RouteHandler custodyCallback = ctx -> {
        String timestamp = ctx.header("Biz-Timestamp");
        String signature = ctx.header("Biz-Resp-Signature");
        boolean verifyResult = false;
        try {
            if (!StringUtils.isEmpty(timestamp) && !StringUtils.isEmpty(signature)) {
                String body = ctx.bodyToString();
                String content = body + "|" + timestamp;
                verifyResult = LocalSigner.verifyEcdsaSignature(content, signature, coboPubKey);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        verifyResult &= customCheck(ctx);
        System.out.println("verifyResult: " + verifyResult);
        ctx.text(verifyResult ? "ok" : "deny");
    };

    public static void main(String[] args) {
        Blade.of().listen(9000)
                .get("/", ctx -> ctx.text("ok!"))
                .post("/custody_callback", custodyCallback).start();
    }

    public static boolean customCheck(RouteContext ctx) {
        //add you checking policy
        return true;
    }

    public static void signatureCheck() {
        // Sandbox env verify Cobo signature data:

        // 1.Withdrawal Confirmation Callback:
        // timestamp: 1673345213334
        // signature: 304402200c4735e8d2a8cbeb68f1c2624b9b81db9d1a897b053f0e08647e019e638771ee022025e33dbb67f6d548919237bf152b3643b0ba23b85e1a5d6c0327be97f78a4513
        // body: {"id": "", "coin": "GETH", "display_code": "GETH", "description": "Ethereum Goerli Testnet", "address": "0x9414933Ff7777bb28cA22D15c178596A6e58d957", "source_address": "", "side": "withdraw", "amount": "12345", "decimal": 18, "abs_amount": "0.000000000000012345", "txid": "", "vout_n": 0, "request_id": "request_id_dbe9541f_1673345211103_1107", "status": "pending", "created_time": 1673345212430, "last_time": 1673345212430, "memo": "", "confirming_threshold": 32, "confirmed_num": 0, "type": "external"}
        String withdrawTimestamp = "1673345213334";
        String withdrawSignature = "304402200c4735e8d2a8cbeb68f1c2624b9b81db9d1a897b053f0e08647e019e638771ee022025e33dbb67f6d548919237bf152b3643b0ba23b85e1a5d6c0327be97f78a4513";
        boolean withdrawVerifyResult = false;
        try {
            if (!StringUtils.isEmpty(withdrawTimestamp) && !StringUtils.isEmpty(withdrawSignature)) {
                String withdrawBody = "{\"id\": \"\", \"coin\": \"GETH\", \"display_code\": \"GETH\", \"description\": \"Ethereum Goerli Testnet\", \"address\": \"0x9414933Ff7777bb28cA22D15c178596A6e58d957\", \"source_address\": \"\", \"side\": \"withdraw\", \"amount\": \"12345\", \"decimal\": 18, \"abs_amount\": \"0.000000000000012345\", \"txid\": \"\", \"vout_n\": 0, \"request_id\": \"request_id_dbe9541f_1673345211103_1107\", \"status\": \"pending\", \"created_time\": 1673345212430, \"last_time\": 1673345212430, \"memo\": \"\", \"confirming_threshold\": 32, \"confirmed_num\": 0, \"type\": \"external\"}";
                String content = withdrawBody + "|" + withdrawTimestamp;
                withdrawVerifyResult = LocalSigner.verifyEcdsaSignature(content, withdrawSignature, coboPubKey);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        System.out.println("withdrawVerifyResult: " + withdrawVerifyResult);


        // 2.Transaction Notification Callback:
        // timestamp: 1673530794575
        // signature: 304402207f1a49a302bece956da7e0a3e9a77f0fb33ccc368ef2fa4dacac5c96d7d5f542022052dc95dbf0f409e290e38481b8b624ba2748ee08de6141be067ab80f5daf9b92
        // body: {"id": "20230110151203000381527000003478", "coin": "BTC", "display_code": "BTC", "description": "Bitcoin", "decimal": 8, "address": "3DPAyjXaYtBfZMbY8XVEUQShr2fYu9MMcg", "source_address": "bc1q46uh8ywdq22p7dhzkwxg49v5guvpx9kwgrjzlm", "side": "withdraw", "amount": "1000", "abs_amount": "0.00001", "txid": "c1a9b2d97c548cfd1c564d563d84ca136b247c96f0ad1fc7e0e2fb7cf05d74cb", "vout_n": 0, "request_id": "web_send_by_user_1272_1673332884996", "status": "success", "abs_cobo_fee": "0", "created_time": 1673332885187, "last_time": 1673334723525, "confirmed_num": 3, "request_created_time": 1673332885187, "tx_detail": {"txid": "c1a9b2d97c548cfd1c564d563d84ca136b247c96f0ad1fc7e0e2fb7cf05d74cb", "blocknum": 771229, "blockhash": "000000000000000000056f5be0c51de238fa793ca2ba76f81c7245842e1c0bbd", "fee": 0, "actualgas": 1460, "gasprice": 1, "hexstr": ""}, "source_address_detail": "bc1q46uh8ywdq22p7dhzkwxg49v5guvpx9kwgrjzlm", "memo": "", "confirming_threshold": 3, "fee_coin": "BTC", "fee_amount": 40000, "fee_decimal": 8, "type": "external"}

        String txTimestamp = "1673530794575";
        String txSignature = "304402207f1a49a302bece956da7e0a3e9a77f0fb33ccc368ef2fa4dacac5c96d7d5f542022052dc95dbf0f409e290e38481b8b624ba2748ee08de6141be067ab80f5daf9b92";
        boolean txVerifyResult = false;
        try {
            if (!StringUtils.isEmpty(txTimestamp) && !StringUtils.isEmpty(txSignature)) {
                String txBody = "{\"id\": \"20230110151203000381527000003478\", \"coin\": \"BTC\", \"display_code\": \"BTC\", \"description\": \"Bitcoin\", \"decimal\": 8, \"address\": \"3DPAyjXaYtBfZMbY8XVEUQShr2fYu9MMcg\", \"source_address\": \"bc1q46uh8ywdq22p7dhzkwxg49v5guvpx9kwgrjzlm\", \"side\": \"withdraw\", \"amount\": \"1000\", \"abs_amount\": \"0.00001\", \"txid\": \"c1a9b2d97c548cfd1c564d563d84ca136b247c96f0ad1fc7e0e2fb7cf05d74cb\", \"vout_n\": 0, \"request_id\": \"web_send_by_user_1272_1673332884996\", \"status\": \"success\", \"abs_cobo_fee\": \"0\", \"created_time\": 1673332885187, \"last_time\": 1673334723525, \"confirmed_num\": 3, \"request_created_time\": 1673332885187, \"tx_detail\": {\"txid\": \"c1a9b2d97c548cfd1c564d563d84ca136b247c96f0ad1fc7e0e2fb7cf05d74cb\", \"blocknum\": 771229, \"blockhash\": \"000000000000000000056f5be0c51de238fa793ca2ba76f81c7245842e1c0bbd\", \"fee\": 0, \"actualgas\": 1460, \"gasprice\": 1, \"hexstr\": \"\"}, \"source_address_detail\": \"bc1q46uh8ywdq22p7dhzkwxg49v5guvpx9kwgrjzlm\", \"memo\": \"\", \"confirming_threshold\": 3, \"fee_coin\": \"BTC\", \"fee_amount\": 40000, \"fee_decimal\": 8, \"type\": \"external\"}";
                String content = txBody + "|" + txTimestamp;
                txVerifyResult = LocalSigner.verifyEcdsaSignature(content, txSignature, coboPubKey);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        System.out.println("txVerifyResult: " + txVerifyResult);
    }
}




