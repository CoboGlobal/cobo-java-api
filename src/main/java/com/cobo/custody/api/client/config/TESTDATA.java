package com.cobo.custody.api.client.config;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class TESTDATA {
    static Map<String, String> prodDepositAddress = new HashMap<String, String>(){{
            put("BTC", "36xYx7vf7DUKpJDixpY3EoV2jchFwYSNCb");
            put("XRP", "rBWpYJhuJWBPAkzJ4kYQqHShSkkF3rgeD|3992922539");
        }};

    static List<String> prodBTCDepositAddresse = new ArrayList<String>(){{
            add("36xYx7vf7DUKpJDixpY3EoV2jchFwYSNCb");
            add("bc1q0l24tf5sjdu9t7l6hrlhxz9aq9yeej9h2sc7tk");
        }};
    static List<String> prodXRPDepositAddresse = new ArrayList<String>(){{
            add("rBWpYJhuJWBPAkzJ4kYQqHShSkkF3rgeD|3992922539");
            add("rBWpYJhuJWBPAkzJ4kYQqHShSkkF3rgeD|1492154866");
        }};
    static Map<String, List> prodDepositAddresses = new HashMap<String, List>(){{
            put("BTC", prodBTCDepositAddresse);
            put("XRP", prodXRPDepositAddresse);
        }};

    static Map<String, String> prodLoopAddress = new HashMap<String, String>(){{
            put("BTC", "34WLjtk9ta96BVxc1jRF7j5eVvehoftsVV");
            put("XRP", "rBWpYJhuJWBPAkzJ4kYQqHShSkkF3rgeD|633829231");
        }};
    static Map<String, String> prodLoopAddresses = new HashMap<String, String>(){{
             put("BTC", "34WLjtk9ta96BVxc1jRF7j5eVvehoftsVV,33P1kjMfDCKipR58S7XbsCqbmPT5YGrhUo");
             put("XRP", "rBWpYJhuJWBPAkzJ4kYQqHShSkkF3rgeD|633829231,rBWpYJhuJWBPAkzJ4kYQqHShSkkF3rgeD|935940214");
        }};

    public static TESTDATA PROD_TESTDATA = new TESTDATA(
            "20220311154108000184408000002833",
            "4041A888C9966BE8916FE65F2FEE7AE9A9DC3F49D0F1643A768C842CA95FA736",
            "sdk_request_id_fe80cc5f_1647068483396",
            prodDepositAddress,
            prodDepositAddresses,
            prodLoopAddress,
            prodLoopAddresses);
    static Map<String, String> sandbox_depositAddress =  new HashMap<String, String>(){{
            put("BTC", "3JBYNrbB4bHtGWHTEa3ZPuRK9kwTiEUo4D");
            put("XRP", "rfKyCMyoV6Ln2GZ7YDbrBrnXCbAyBbxRqB|2047482901");
        }};
    static List<String> sandboxBTCDepositAddresse = new ArrayList<String>(){{
            add("3JBYNrbB4bHtGWHTEa3ZPuRK9kwTiEUo4D");
            add("bc1qf22hpu33u2tkyy528mdvpnre45n8lu5s3ycatu");
        }};

    static List<String> sandboxXRPDepositAddresse = new ArrayList<String>(){{
            add("rfKyCMyoV6Ln2GZ7YDbrBrnXCbAyBbxRqB|20474829019");
            add("rfKyCMyoV6Ln2GZ7YDbrBrnXCbAyBbxRqB|3752417374");
        }};
    static Map<String, List> sandbox_depositAddresses = new HashMap<String, List>(){{
            put("BTC", sandboxBTCDepositAddresse);
            put("XRP", sandboxXRPDepositAddresse);
        }};

    static Map<String, String> sandbox_loopAddress = new HashMap<String, String>(){{
            put("BTC", "35eXJPLRTSp4Wn8n2f6pkQF4t3KdU2cuhz");
            put("XRP", "rfKyCMyoV6Ln2GZ7YDbrBrnXCbAyBbxRqB|477817505");
        }};
    static Map<String, String> sandbox_loopAddresses =  new HashMap<String, String>(){{
            put("BTC", "35eXJPLRTSp4Wn8n2f6pkQF4t3KdU2cuhz,34R4JHecUwGNEFVGKz1vR8R6BHGi5FUqPt");
            put("XRP", "rfKyCMyoV6Ln2GZ7YDbrBrnXCbAyBbxRqB|477817505,rfKyCMyoV6Ln2GZ7YDbrBrnXCbAyBbxRqB|2874421071");
        }};

    public static TESTDATA SANDBOX_TESTDATA = new TESTDATA(
            "20220314181458000331767000003732",
            "0x1c4d137bc2a2ee8f22cbdf9e90405974e72e65d922f42eb81d9f7a05d0f64fc6",
            "web_send_by_user_915_1647252768642",
            sandbox_depositAddress,
            sandbox_depositAddresses,
            sandbox_loopAddress,
            sandbox_loopAddresses);

    public String coboId;
    public String txId;
    public String withdrawId;
    public Map<String, String> depositAddress;
    public Map<String, List> depositAddresses;
    public Map<String, String> loopAddress;
    public Map<String, String> loopAddresses;



    public TESTDATA(String coboId, String txId, String withdrawId,
                    Map<String, String> depositAddress,
                    Map<String, List> depositAddresses,
                    Map<String, String> loopAddress,
                    Map<String, String> loopAddresses){
        this.coboId = coboId;
        this.txId = txId;
        this.withdrawId = withdrawId;
        this.depositAddress = depositAddress;
        this.depositAddresses = depositAddresses;
        this.loopAddress = loopAddress;
        this.loopAddresses = loopAddresses;
    }
}
