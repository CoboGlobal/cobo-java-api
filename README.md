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
```java
CoboApiClientFactory factory = BinanceApiClientFactory.newInstance("API-KEY", "API-SECRET"，"COBO-PUB");
CoboApiClientFactory client = factory.newRestClient();

//get org info
Response<OrgInfo> org = client.getOrgInfo();

//get coin info
Response<CoinInfo> coin = client.getCoinInfo("BTC");
```

