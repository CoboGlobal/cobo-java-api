package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.ApiSigner;
import com.cobo.custody.api.client.CoboMPCPrimeBrokerRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static com.cobo.custody.api.client.impl.CoboApiServiceGenerator.createService;
import static com.cobo.custody.api.client.impl.CoboApiServiceGenerator.executeSync;

public class CoboMPCPrimeBrokerRestClientImpl implements CoboMPCPrimeBrokerRestClient {
    private final CoboMPCPrimeBrokerService coboMPCPrimeBrokerService;

    public CoboMPCPrimeBrokerRestClientImpl(ApiSigner signer, Env env, boolean debug) {
        this.coboMPCPrimeBrokerService = createService(CoboMPCPrimeBrokerService.class, signer, env, debug);
    }
    @Override
    public ApiResponse<PrimeBrokerBinderInfo> createBinding(String userId) {
        return executeSync(coboMPCPrimeBrokerService.createBinding(userId));
    }

    @Override
    public ApiResponse<PrimeBrokerUserBindInfo> queryBinding(String binderId) {
        return executeSync(coboMPCPrimeBrokerService.queryBinding(binderId));
    }

    @Override
    public ApiResponse<PrimeBrokerUserAuthInfo> queryUserAuth(String userId) {
        return executeSync(coboMPCPrimeBrokerService.queryUserAuth(userId));
    }

    @Override
    public ApiResponse<PrimeBrokerUserAuthInfo> bindAddresses(String userId, List<PrimeBrokerAddress> addresses) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return executeSync(coboMPCPrimeBrokerService.bindAddresses(userId, mapper.writeValueAsString(addresses)));
    }

    @Override
    public ApiResponse<PrimeBrokerBinderInfo> changeBinding(String userId) {
        return executeSync(coboMPCPrimeBrokerService.changeBinding(userId));
    }

    @Override
    public ApiResponse<StatementId> unbindBinding(String userId) {
        return executeSync(coboMPCPrimeBrokerService.unbindBinding(userId));
    }

    @Override
    public ApiResponse<Statement> queryStatement(String statementId) {
        return executeSync(coboMPCPrimeBrokerService.queryStatement(statementId));
    }
}
