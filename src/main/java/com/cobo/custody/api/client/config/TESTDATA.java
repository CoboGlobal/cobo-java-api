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
    static Map<String, String> develop_depositAddress =  new HashMap<String, String>(){{
            put("BTC", "3HMVjbnkFqg6pD1cJ7PZeLsFkNGDh9Nqy2");
            put("XRP", "rfKyCMyoV6Ln2GZ7YDbrBrnXCbAyBbxRqB|2047482901");
        }};
    static List<String> developBTCDepositAddresse = new ArrayList<String>(){{
            add("3HMVjbnkFqg6pD1cJ7PZeLsFkNGDh9Nqy2");
            add("bc1qf22hpu33u2tkyy528mdvpnre45n8lu5s3ycatu");
        }};

    static List<String> developXRPDepositAddresse = new ArrayList<String>(){{
            add("rfKyCMyoV6Ln2GZ7YDbrBrnXCbAyBbxRqB|20474829019");
            add("rfKyCMyoV6Ln2GZ7YDbrBrnXCbAyBbxRqB|3752417374");
        }};
    static Map<String, List> develop_depositAddresses = new HashMap<String, List>(){{
            put("BTC", developBTCDepositAddresse);
            put("XRP", developXRPDepositAddresse);
        }};

    static Map<String, String> develop_loopAddress = new HashMap<String, String>(){{
            put("BTC", "3FKpEfhsULvsnutcbX8gXPpTo4ewXy7jWJ");
            put("XRP", "rBphERztHKga1cyMgWiDen7WDkbkfn1iPE|2284746463");
        }};
    static Map<String, String> develop_loopAddresses =  new HashMap<String, String>(){{
            put("BTC", "3FKpEfhsULvsnutcbX8gXPpTo4ewXy7jWJ,3FhponzJguuN2nvoKkdb5bJJMT1zyZvH8w");
            put("XRP", "rBphERztHKga1cyMgWiDen7WDkbkfn1iPE|2284746463,rBphERztHKga1cyMgWiDen7WDkbkfn1iPE|2446372187");
        }};

    public static TESTDATA DEV_TESTDATA = new TESTDATA(
            "20231213152104000114035000006167",
            "332d0377c0cc08bc9f9d5b07320add949e30d8da0b5fea5140de63e3779101a0",
            "82ddd375-901a-4d0f-81a4-36d04fbc69a4",
            develop_depositAddress,
            develop_depositAddresses,
            develop_loopAddress,
            develop_loopAddresses);

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
