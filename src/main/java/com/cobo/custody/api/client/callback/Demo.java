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
        String timestamp = "1669376201198";
        String signature = "304402202485670f2579c3cbbbed9817f9263cb2210d57e322540aa87b9ba1c57703c66602200c0f09f182c33087c43af3096ff0f55b4cedd746287e73bd197369b89f1408ff";
        String body = "{\"id\": \"20221125163239000340987000006912\", \"coin\": \"TRON_USDT\", \"display_code\": \"USDT\", \"description\": \"Tether\", \"decimal\": 6, \"address\": \"TAc4jeURBoCjztN78KcJvezEGihKod4zvW\", \"source_address\": \"TSaRZDiBPD8Rd5vrvX8a4zgunHczM9mj8S\", \"side\": \"deposit\", \"amount\": \"10000000\", \"abs_amount\": \"10\", \"txid\": \"6a63e49b60a0b74bd146e90c8703fe3745bad78a551048e5b7660e0bcec9150e\", \"vout_n\": 0, \"request_id\": null, \"status\": \"success\", \"abs_cobo_fee\": \"0\", \"created_time\": 1669365257204, \"last_time\": 1669365257204, \"confirmed_num\": 33, \"tx_detail\": {\"txid\": \"6a63e49b60a0b74bd146e90c8703fe3745bad78a551048e5b7660e0bcec9150e\", \"blocknum\": 46259387, \"blockhash\": \"0000000002c1dcbbbd3ffa9a999c340d7e4d6814ccef3fcb4f996e38afe7bc8f\", \"hexstr\": \"\"}, \"source_address_detail\": \"TSaRZDiBPD8Rd5vrvX8a4zgunHczM9mj8S\", \"confirming_threshold\": 33, \"type\": \"external\"}";
        String content = body + "|" + timestamp;
        boolean verifyResult = LocalSigner.verifyEcdsaSignature(content, signature, coboPubKey);
        System.out.println("verifyResult:\t"  + verifyResult);
    }

    public static boolean customCheck(RouteContext ctx) {
        //add you checking policy
        return true;
    }

}
