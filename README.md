# Cobo Java API

cobo-java-api is a lightweight Java library for interacting with the [Cobo Custody API](https://doc.custody.cobo.com/?#cobo-custody-waas-api), providing complete API coverage, and supporting synchronous and asynchronous requests.


## Installation

```
 TODO
```



## Examples
TODO
### Getting Started


These can be instantiated through the corresponding factory method of [`CoboApiClientFactory`](https://github.com/xxx)

#### initialize
```java
CoboApiClientFactory factory = BinanceApiClientFactory.newInstance("API-KEY", ApiSigner，"COBO-PUB");
CoboApiClientFactory client = factory.newRestClient();
```
`ApiSigner` can be instantiated through `new LocalSigner("your private key" )`

In some cases, your private key cannot be exported, for example, your private key is in aws kms, you should pass in your own implementation by implements `ApiSigner` interface:


```java
new ApiSigner() {
    @Override
    public String sign(byte[] message) {
        signature = yourAWSSignMethod(message);
        return signature;
    }
}
```


#### get org info
```java
Response<OrgInfo> res = client.getOrgInfo();
```



<details>
 <summary>View Response</summary>
 
```java
OrgInfo{name='cobo_test', assets=[Assets{coin='ADA', display_code='ADA', description='Cardano', decimal=6, can_deposit=true, can_withdraw=true, balance='29880892', abs_balance='29.880892', fee_coin='ADA', abs_estimate_fee='1', confirming_threshold=9, dust_threshold=1000000, token_address='', require_memo=false}, ...]}
```
</details>


#### get coin info
```java
Response<CoinInfo> res = client.getCoinInfo("BTC");
```
<details>
 <summary>View Response</summary>
 
```java
CoinInfo{coin='ETH', display_code='ETH', description='Ethereum', decimal=18, can_deposit=true, can_withdraw=true, require_memo=false, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.004', confirming_threshold=12, dust_threshold=1, token_address=''}
```
</details>




