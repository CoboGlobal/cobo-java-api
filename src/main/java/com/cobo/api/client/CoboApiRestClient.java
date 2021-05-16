package com.cobo.api.client;

import com.cobo.api.client.domain.*;

import java.util.List;

public interface CoboApiRestClient {
    Response<OrgInfo> getOrgInfo();

    Response<CoinInfo> getCoinInfo(String coin);

    Response<Address> newAddress(String coin, boolean native_segwit);

    Response<NewAddresses> newAddresses(String coin, int count, boolean native_segwit);

    Response<Address> addressInfo(String coin, String address);

    Response<Addresses> addressesInfo(String coin, List<String> addresses);

    Response<Boolean> isValidAddress(String coin, String address);

    Response<List<Address>> getAddressHistory(String coin);

    Response<InternalAddressInfo> getInternalAddressInfo(String coin, String address);

    Response<List<InternalAddressInfo>> getInternalAddressInfoBatch(String coin, String addresses);

    Response<Transaction> getTransaction(String txId);

}
