package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboMPCPrimeBrokerRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CoboMPCPrimeBrokerRestClientImplTest {
    private String MPCAPISecret = "";
    private CoboMPCPrimeBrokerRestClient primeBrokerClient;
    private Env TestEnv = Env.SANDBOX;

    @BeforeEach
    public void setUp() throws Exception {
        MPCAPISecret = System.getProperty("MPCApiSecret");
        primeBrokerClient = CoboApiClientFactory.newInstance(
                new LocalSigner(MPCAPISecret),
                TestEnv,
                false).newMPCPrimeBrokerRestClient();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCreateBinding() {
        String userId = String.valueOf(System.currentTimeMillis());
        ApiResponse<PrimeBrokerBinderInfo> res = primeBrokerClient.createBinding(userId);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testQueryBinding() {
        String binderId = "xmxGDg2hQsiqoo8D5WffyQ==";
        ApiResponse<PrimeBrokerUserBindInfo> res = primeBrokerClient.queryBinding(binderId);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testQueryUserAuth() {
        String userId = "";
        ApiResponse<PrimeBrokerUserAuthInfo> res = primeBrokerClient.queryUserAuth(userId);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testChangeBinding() {
        String userId = "yangming0407";
        ApiResponse<PrimeBrokerBinderInfo> res = primeBrokerClient.changeBinding(userId);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testBindAddresses() throws JsonProcessingException {
        String userId = "";
        List<PrimeBrokerAddress> addresses = Arrays.asList(new PrimeBrokerAddress("ETH", "0x542b14c29b506e586e18c784f85419cca86cc185"));
        ApiResponse<PrimeBrokerUserAuthInfo> res = primeBrokerClient.bindAddresses(userId, addresses);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testUnbindBinding() throws JsonProcessingException {
        String userId = "yangming0407";
        ApiResponse<StatementId> res = primeBrokerClient.unbindBinding(userId);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testQueryStatement() {
        String statementId = "";
        ApiResponse<Statement> res = primeBrokerClient.queryStatement(statementId);
        assertTrue(res.isSuccess());
        System.out.println(res);
    }
}
