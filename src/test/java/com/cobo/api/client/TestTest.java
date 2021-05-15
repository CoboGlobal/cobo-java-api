package com.cobo.api.client;

import com.cobo.api.client.domain.CoinInfo;
import com.cobo.api.client.domain.Response;
import com.cobo.api.client.domain.OrgInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.Test;
public class TestTest extends TestCase {
    @Test
    public void testAdd() {
        CoboApiRestClient client = CoboApiClientFactory.newInstance("","").newRestClient();
//        Response<OrgInfo> org = client.getOrgInfo();
//        System.out.println(org.getResult().toString());

        Response<CoinInfo> coin = client.getCoinInfo("BTC");
        System.out.println(coin.toString());
    }

    @Test
    public void testAS() {
        String s = "{\"success\": false, \"error_code\": 1021, \"error_message\": \"API action 'coin_infoqqq' is not supported.\", \"error_id\": \"0d75a572d1f04b75a09f183b7f109244\"}";
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(s);
        CoboApiError e = null;
        try {
            e = mapper.readValue(s, CoboApiError.class);
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
        System.out.println(e.toString());
    }
}