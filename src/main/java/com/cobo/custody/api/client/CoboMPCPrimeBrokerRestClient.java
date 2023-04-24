package com.cobo.custody.api.client;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CoboMPCPrimeBrokerRestClient {

    ApiResponse<PrimeBrokerBinderInfo> createBinding(String userId);

    ApiResponse<PrimeBrokerUserBindInfo> queryBinding(String binderId);

    ApiResponse<PrimeBrokerUserAuthInfo> queryUserAuth(String userId);

    ApiResponse<PrimeBrokerUserAuthInfo> bindAddresses(String userId, List<PrimeBrokerAddress> addresses) throws JsonProcessingException;

    ApiResponse<PrimeBrokerBinderInfo> changeBinding(String userId);

    ApiResponse<StatementId> unbindBinding(String userId);

    ApiResponse<Statement> queryStatement(String statementId);
}
