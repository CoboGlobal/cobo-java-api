package com.cobo.custody.api.client;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.PrimeBrokerAddress;
import com.cobo.custody.api.client.domain.account.PrimeBrokerBinderInfo;
import com.cobo.custody.api.client.domain.account.PrimeBrokerUserAuthInfo;
import com.cobo.custody.api.client.domain.account.PrimeBrokerUserBindInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CoboMPCPrimeBrokerRestClient {

    ApiResponse<PrimeBrokerBinderInfo> createBinding(String userId);

    ApiResponse<PrimeBrokerUserBindInfo> queryBinding(String binderId);

    ApiResponse<PrimeBrokerUserAuthInfo> queryUserAuth(String userId);

    ApiResponse<PrimeBrokerUserAuthInfo> bindAddresses(String userId, List<PrimeBrokerAddress> addresses) throws JsonProcessingException;

    ApiResponse<PrimeBrokerBinderInfo> changeBinding(String userId);

    ApiResponse<Void> unbindBinding(String userId);
}
