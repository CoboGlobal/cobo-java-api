# Cobo Java API

cobo-java-api is a lightweight Java library for interacting with the [Cobo Custody API](https://doc.custody.cobo.com/?#cobo-custody-waas-api), providing complete API coverage.


* [Installation](#installation)
* [Test](#test)
* [Usage](#usage)
  * [Initialize](#initialize)
     * [Generate Key Pair](#generate-key-pair)
     * [Initialize RestClient](#initialize-restclient)
     * [Initialize ApiSigner](#initialize-apisigner)
  * [Account](#account)
     * [Check Account Details](#check-account-details)
     * [Get Coin Details](#get-coin-details)
     * [Get New Deposit Address](#get-new-deposit-address)
     * [Batch New Deposit Address](#batch-new-deposit-address)
     * [Verify Deposit Address](#verify-deposit-address)
     * [Batch Verify Deposit Address](#batch-verify-deposit-address)
     * [Verify Valid Address](#verify-valid-address)
     * [Get Address History List](#get-address-history-list)
     * [Get Address History List With Page](#get-address-history-list-with-page)
     * [Get Address History List With Page Sort](#get-address-history-list-with-page-sort)
  * [Loop Alliance](#loop-alliance)
     * [Check Loop Address Details](#check-loop-address-details)
     * [Verify Loop Address List](#verify-loop-address-list)
     * [Loop Transaction Explorer](#loop-transaction-explorer)
  * [Transactions](#transactions)
     * [Get Transaction Details](#get-transaction-details)
     * [Get Transactions By Txid](#get-transactions-by-txid)
     * [Obtain the list of confirmed transactions through ID query(deposit&amp;withdraw)](#obtain-the-list-of-confirmed-transactions-through-id-querydepositwithdraw)
     * [Obtain the list of confirmed transactions through time query(deposit&amp;withdraw)](#obtain-the-list-of-confirmed-transactions-through-time-querydepositwithdraw)
     * [Get Pending Transactions](#get-pending-transactions)
     * [Get Pending Deposit Details](#get-pending-deposit-details)
     * [Get Transaction History](#get-transaction-history)
  * [Withdrawal](#withdrawal)
     * [Submit Withdraw Request](#submit-withdraw-request)
     * [Get Withdraw Information](#get-withdraw-information)
  * [Staking](#staking)
     * [Get a Staking Product Details](#get-a-staking-product-details)
     * [Get All Staking Product List](#get-all-staking-product-list)
     * [Stake](#stake)
     * [Unstake](#unstake)
     * [Get Staking Data](#get-staking-data)
     * [Get Unstaking Data](#get-unstaking-data)
     * [Get All Staking History](#get-all-staking-history)
  * [Trading](#trading)
  * [Transaction Notification](#transaction-notification)
  * [Withdrawal Confirmation](#withdrawal-confirmation)

## Installation

Step 1. Add the JitPack repository to your build file

gradle:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

maven:

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency

gradle:

```
dependencies {
    implementation 'com.github.CoboCustody:cobo-java-api:v0.34'
}
```

maven:

```
<dependency>
    <groupId>com.github.CoboCustody</groupId>
    <artifactId>cobo-java-api</artifactId>
    <version>v0.34</version>
</dependency>
```



## Test

```
 ./gradlew test -DEnv=sandbox/prod -DApiSecret=<yourApiSecret>
```

## Usage

### Initialize

#### Generate Key Pair
```java
import com.cobo.custody.api.client.impl.LocalSigner;

String[] key = LocalSigner.generateKeyPair();
Stirng secretKey = key[0];
Stirng apiKey = key[1];
```
Please refer to the link [link](https://doc.custody.cobo.com/en.html#api-authentication) for how to use apiKey

#### Initialize RestClient
These can be instantiated through the corresponding factory method of `CoboApiClientFactory`

```java
import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboApiRestClient;
import com.cobo.custody.api.client.config.CoboApiConfig;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.impl.LocalSigner;

CoboApiRestClient client = CoboApiClientFactory.newInstance(
                new LocalSigner(apiSecret),
                Env.SANDBOX,
                false).newRestClient();
```

#### Initialize ApiSigner


`ApiSigner` can be instantiated through `new LocalSigner("secretkey" )`

In some cases, your private key cannot be exported, for example, your private key is in aws kms, you should pass in your own implementation by implements `ApiSigner` interface:


```java

import com.cobo.custody.api.client.ApiSigner;
new ApiSigner() {
    @Override
    public String sign(byte[] message) {
        return null;
    }

    @Override
    public String getPublicKey() {
        return null;
    }
}
```

### Account

#### Check Account Details
```java
ApiResponse<OrgInfo> orgInfo = client.getOrgInfo()
```
<details>
<summary>View Response</summary>


```java
OrgInfo{name='cobo_test', assets=[Assets{coin='ADA', display_code='ADA', description='Cardano', decimal=6, can_deposit=true, can_withdraw=true, balance='29880892', abs_balance='29.880892', fee_coin='ADA', abs_estimate_fee='1', confirming_threshold=9, dust_threshold=1000000, token_address='', require_memo=false}, Assets{coin='AE', display_code='AE', description='Aeternity', decimal=18, can_deposit=true, can_withdraw=true, balance='24842627669924526173', abs_balance='24.842627669924526173', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x5ca9a71b1d01849c0a95490cc00559717fcf0d1d', require_memo=false}, Assets{coin='AISI', display_code='AISI', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x092cc6dad6f7828ea81a78edd9f83b376bdf888d', require_memo=false}, Assets{coin='ALGO', display_code='ALGO', description='Algorand', decimal=6, can_deposit=true, can_withdraw=true, balance='8359337', abs_balance='8.359337', fee_coin='ALGO', abs_estimate_fee='0.8', confirming_threshold=12, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='ATP', display_code='ATP', description='Alaya', decimal=18, can_deposit=true, can_withdraw=true, balance='199970000000000000', abs_balance='0.19997', fee_coin='ATP', abs_estimate_fee='0.0021', confirming_threshold=10, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='BAT', display_code='BAT', description='Basic Attention Token', decimal=18, can_deposit=true, can_withdraw=true, balance='9525643010824022346', abs_balance='9.525643010824022346', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x0d8775f648430679a709e98d2b0cb6250d2887ef', require_memo=false}, Assets{coin='BCH', display_code='BCH', description='Bitcoin Cash', decimal=8, can_deposit=true, can_withdraw=true, balance='36067', abs_balance='0.00036067', fee_coin='BCH', abs_estimate_fee='0.0008', confirming_threshold=10, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='BCHA', display_code='BCHA', description='Bitcoin Cash ABC', decimal=8, can_deposit=true, can_withdraw=true, balance='107067', abs_balance='0.00107067', fee_coin='BCHA', abs_estimate_fee='0', confirming_threshold=60, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='BCHSV', display_code='BCHSV', description='Bitcoin SV', decimal=8, can_deposit=true, can_withdraw=true, balance='2886576', abs_balance='0.02886576', fee_coin='BCHSV', abs_estimate_fee='0.0008', confirming_threshold=100, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='BNB_BNB', display_code='BNB', description='Binance Coin', decimal=8, can_deposit=true, can_withdraw=true, balance='8907', abs_balance='0.00008907', fee_coin='BNB_BNB', abs_estimate_fee='0.01', confirming_threshold=12, dust_threshold=1, token_address='BNB', require_memo=false}, Assets{coin='BNB_MTV', display_code='MTV', description='MultiVAC', decimal=8, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='BNB_BNB', abs_estimate_fee='0.01', confirming_threshold=12, dust_threshold=1, token_address='MTV-4C6', require_memo=false}, Assets{coin='BNB_ONE', display_code='ONE', description='Harmony', decimal=8, can_deposit=true, can_withdraw=true, balance='169900000', abs_balance='1.699', fee_coin='BNB_BNB', abs_estimate_fee='0.01', confirming_threshold=12, dust_threshold=1, token_address='ONE-5F9', require_memo=false}, Assets{coin='BTC', display_code='BTC', description='Bitcoin', decimal=8, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='BTC', abs_estimate_fee='0.00025912', confirming_threshold=3, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='BTC_USDT', display_code='USDT', description='Tether', decimal=8, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='BTC', abs_estimate_fee='0.00025912', confirming_threshold=3, dust_threshold=1, token_address='31', require_memo=false}, Assets{coin='BTM', display_code='BTM', description='Bytom', decimal=8, can_deposit=true, can_withdraw=true, balance='18120018265', abs_balance='181.20018265', fee_coin='BTM', abs_estimate_fee='4', confirming_threshold=12, dust_threshold=1, token_address='ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff', require_memo=false}, Assets{coin='CFX', display_code='CFX', description='Conflux Network', decimal=18, can_deposit=true, can_withdraw=true, balance='2123000000000000000', abs_balance='2.123', fee_coin='CFX', abs_estimate_fee='0.1', confirming_threshold=50, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='CFX_FC', display_code='FC', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='10000000000000000', abs_balance='0.01', fee_coin='CFX', abs_estimate_fee='0.1', confirming_threshold=50, dust_threshold=1, token_address='0x8e2f2e68eb75bb8b18caafe9607242d4748f8d98', require_memo=false}, Assets{coin='CKB', display_code='CKB', description='Nervos Network', decimal=8, can_deposit=true, can_withdraw=true, balance='70744624300', abs_balance='707.446243', fee_coin='CKB', abs_estimate_fee='8', confirming_threshold=30, dust_threshold=6100000000, token_address='', require_memo=false}, Assets{coin='CMT', display_code='CMT', description='CyberMiles', decimal=18, can_deposit=true, can_withdraw=true, balance='309769000000000000', abs_balance='0.309769', fee_coin='CMT', abs_estimate_fee='20', confirming_threshold=12, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='DASH', display_code='DASH', description='Dash', decimal=8, can_deposit=true, can_withdraw=true, balance='8685930', abs_balance='0.0868593', fee_coin='DASH', abs_estimate_fee='0.0016', confirming_threshold=24, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='DCR', display_code='DCR', description='Decred', decimal=8, can_deposit=false, can_withdraw=false, balance='71546657', abs_balance='0.71546657', fee_coin='DCR', abs_estimate_fee='0.008', confirming_threshold=6, dust_threshold=10000, token_address='', require_memo=false}, Assets{coin='DOGE', display_code='DOGE', description='Dogecoin', decimal=8, can_deposit=true, can_withdraw=true, balance='42275040550', abs_balance='422.7504055', fee_coin='DOGE', abs_estimate_fee='40', confirming_threshold=12, dust_threshold=100000000, token_address='', require_memo=false}, Assets{coin='DOT', display_code='DOT', description='Polkadot', decimal=10, can_deposit=true, can_withdraw=true, balance='37960000000', abs_balance='3.796', fee_coin='DOT', abs_estimate_fee='0.1', confirming_threshold=12, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='EDG', display_code='EDG', description='Edgeware', decimal=18, can_deposit=true, can_withdraw=true, balance='55500001000000000000', abs_balance='55.500001', fee_coin='EDG', abs_estimate_fee='8', confirming_threshold=12, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='EON', display_code='EON', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x3032b9e916a575db2d5a0c865f413a82891bd260', require_memo=false}, Assets{coin='EOSDAC', display_code='EOSDAC', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x7e9e431a0b8c4d532c745b1043c7fa29a48d4fba', require_memo=false}, Assets{coin='EOS_ADD', display_code='ADD', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosadddddddd', require_memo=true}, Assets{coin='EOS_ARN', display_code='ARN', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='aeronaerozzz', require_memo=true}, Assets{coin='EOS_ATD', display_code='ATD', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosatidiumio', require_memo=true}, Assets{coin='EOS_BAC', display_code='BAC', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='bancordexbac', require_memo=true}, Assets{coin='EOS_BET', display_code='BET', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='betdividends', require_memo=true}, Assets{coin='EOS_BLACK', display_code='BLACK', description='eosBLACK', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosblackteam', require_memo=true}, Assets{coin='EOS_BOID', display_code='BOID', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='boidcomtoken', require_memo=true}, Assets{coin='EOS_BT', display_code='BT', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosbtextoken', require_memo=true}, Assets{coin='EOS_CAN', display_code='CAN', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eoscancancan', require_memo=true}, Assets{coin='EOS_CAT', display_code='CAT', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='tokenbyeocat', require_memo=true}, Assets{coin='EOS_CET', display_code='CET', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosiochaince', require_memo=true}, Assets{coin='EOS_CHIP', display_code='CHIP', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='bet24tokens1', require_memo=true}, Assets{coin='EOS_CHL', display_code='CHL', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='challengedac', require_memo=true}, Assets{coin='EOS_CITY', display_code='CITY', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='funcitytoken', require_memo=true}, Assets{coin='EOS_DAB', display_code='DAB', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eoscafekorea', require_memo=true}, Assets{coin='EOS_DEOS', display_code='DEOS', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='thedeosgames', require_memo=true}, Assets{coin='EOS_DICE', display_code='DICE', description='Dice', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='betdicetoken', require_memo=true}, Assets{coin='EOS_EATCOIN', display_code='EATCOIN', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eatscience14', require_memo=true}, Assets{coin='EOS_EBT', display_code='EBT', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='theeosbutton', require_memo=true}, Assets{coin='EOS_ECTT', display_code='ECTT', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='ectchaincoin', require_memo=true}, Assets{coin='EOS_EDNA', display_code='EDNA', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='ednazztokens', require_memo=true}, Assets{coin='EOS_EETH', display_code='EETH', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='ethsidechain', require_memo=true}, Assets{coin='EOS_EGT', display_code='EGT', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosiotokener', require_memo=true}, Assets{coin='EOS_ENB', display_code='ENB', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosenbpocket', require_memo=true}, Assets{coin='EOS_EOS', display_code='EOS', description='EOS', decimal=4, can_deposit=true, can_withdraw=true, balance='28242', abs_balance='2.8242', fee_coin='EOS_EOS', abs_estimate_fee='0.08', confirming_threshold=1, dust_threshold=1, token_address='eosio.token', require_memo=true}, Assets{coin='EOS_EOSDAC', display_code='EOSDAC', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosdactokens', require_memo=true}, Assets{coin='EOS_EOSDT', display_code='EOSDT', description='EOSDT', decimal=9, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosdtsttoken', require_memo=true}, Assets{coin='EOS_EOSNTS', display_code='EOSNTS', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosninetiess', require_memo=true}, Assets{coin='EOS_GTM', display_code='GTM', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosguotianmi', require_memo=true}, Assets{coin='EOS_HORUS', display_code='HORUS', description='HorusPay', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='horustokenio', require_memo=true}, Assets{coin='EOS_INF', display_code='INF', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='infinicoinio', require_memo=true}, Assets{coin='EOS_IPOS', display_code='IPOS', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='oo1122334455', require_memo=true}, Assets{coin='EOS_IQ', display_code='IQ', description='Everipedia', decimal=3, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='everipediaiq', require_memo=true}, Assets{coin='EOS_JKR', display_code='JKR', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosjackscoin', require_memo=true}, Assets{coin='EOS_KEY', display_code='KEY', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='mkstaketoken', require_memo=true}, Assets{coin='EOS_LLG', display_code='LLG', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='llgonebtotal', require_memo=true}, Assets{coin='EOS_MEETONE', display_code='MEETONE', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='eosiomeetone', require_memo=true}, Assets{coin='EOS_PIZZA', display_code='PIZZA', description='Pizza', decimal=4, can_deposit=true, can_withdraw=true, balance='81958', abs_balance='8.1958', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='pizzatotoken', require_memo=true}, Assets{coin='EOS_USDE', display_code='USDE', description='', decimal=4, can_deposit=true, can_withdraw=true, balance='5000', abs_balance='0.5', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='usdetotokens', require_memo=true}, Assets{coin='EOS_USDT', display_code='USDT', description='Tether', decimal=4, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='EOS_EOS', abs_estimate_fee='0.1', confirming_threshold=1, dust_threshold=1, token_address='tethertether', require_memo=true}, Assets{coin='ETC', display_code='ETC', description='Ethereum Classic', decimal=18, can_deposit=true, can_withdraw=true, balance='443674719765929776', abs_balance='0.443674719765929776', fee_coin='ETC', abs_estimate_fee='0.008', confirming_threshold=8000, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='ETH', display_code='ETH', description='Ethereum', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.006069', confirming_threshold=12, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='ETH_ART', display_code='ART', description='Maecenas', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xfec0cf7fe078a500abf15f1284958f22049c2c7e', require_memo=false}, Assets{coin='ETH_CCOIN', display_code='CCOIN', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='100000000000000000000000', abs_balance='100000', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xcfab12070c174966eab8c88e5e133d92e8a6c567', require_memo=false}, Assets{coin='ETH_CNNS', display_code='CNNS', description='CNNS', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x6c3be406174349cfa4501654313d97e6a31072e1', require_memo=false}, Assets{coin='ETH_DAI_V1', display_code='DAI', description='Dai', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x6b175474e89094c44da98b954eedeac495271d0f', require_memo=false}, Assets{coin='ETH_LINK', display_code='LINK', description='Chainlink', decimal=18, can_deposit=true, can_withdraw=true, balance='100000000000000000', abs_balance='0.1', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x514910771af9ca656af840dff83e8264ecf986ca', require_memo=false}, Assets{coin='ETH_LOOM', display_code='LOOM', description='Loom Network', decimal=18, can_deposit=true, can_withdraw=true, balance='3000000000000000000', abs_balance='3', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xa4e8c3ec456107ea67d3075bf9e3df3a75823db0', require_memo=false}, Assets{coin='ETH_MKR', display_code='MKR', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x9f8f72aa9304c8b593d555f12ef6589cc3a579a2', require_memo=false}, Assets{coin='ETH_OKB', display_code='OKB', description='OKB', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x75231f58b43240c9718dd58b4967c5114342a86c', require_memo=false}, Assets{coin='ETH_ORS', display_code='ORS', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xeb9a4b185816c354db92db09cc3b50be60b901b6', require_memo=false}, Assets{coin='ETH_PAX', display_code='PAX', description='Paxos Standard', decimal=18, can_deposit=true, can_withdraw=true, balance='3299899269999999998', abs_balance='3.299899269999999998', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x8e870d67f660d95d5be530380d0ec0bd388289e1', require_memo=false}, Assets{coin='ETH_REP', display_code='ETH_REP', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xe94327d07fc17907b4db788e5adf2ed424addff6', require_memo=false}, Assets{coin='ETH_TOP', display_code='TOP', description='TOP', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xdcd85914b8ae28c1e62f1c488e1d968d5aaffe2b', require_memo=false}, Assets{coin='ETH_UNISWAP', display_code='ETH_UNISWAP', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x1f9840a85d5af5bf1d1762f925bdaddc4201f984', require_memo=false}, Assets{coin='ETH_USDC', display_code='USDC', description='USD Coin', decimal=6, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xa0b86991c6218b36c1d19d4a2e9eb0ce3606eb48', require_memo=false}, Assets{coin='ETH_USDT', display_code='USDT', description='Tether', decimal=6, can_deposit=true, can_withdraw=true, balance='45926490', abs_balance='45.92649', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xdac17f958d2ee523a2206206994597c13d831ec7', require_memo=false}, Assets{coin='ETH_WBTC', display_code='WBTC', description='Wrapped Bitcoin', decimal=8, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x2260fac5e5542a773aa44fbcfedf7c193bc2c599', require_memo=false}, Assets{coin='FIL', display_code='FIL', description='Filecoin', decimal=18, can_deposit=true, can_withdraw=true, balance='16999412434400000', abs_balance='0.0169994124344', fee_coin='FIL', abs_estimate_fee='0.003', confirming_threshold=900, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='GRS', display_code='GRS', description='Groestlcoin', decimal=8, can_deposit=true, can_withdraw=true, balance='5041087875', abs_balance='50.41087875', fee_coin='GRS', abs_estimate_fee='0.04', confirming_threshold=18, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='HECO_HT', display_code='HECO_HT', description='Heco Chain HT', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='HECO_HT', abs_estimate_fee='0.01', confirming_threshold=30, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='HECO_HUSD', display_code='HECO_HUSD', description='Heco Chain HUSD', decimal=8, can_deposit=true, can_withdraw=true, balance='284505801', abs_balance='2.84505801', fee_coin='HECO_HT', abs_estimate_fee='0.01', confirming_threshold=30, dust_threshold=1, token_address='0x0298c2b32eae4da002a15f36fdf7615bea3da047', require_memo=false}, Assets{coin='HECO_USDT', display_code='HECO_USDT', description='Heco Chain USDT', decimal=18, can_deposit=true, can_withdraw=true, balance='2870279120000000000', abs_balance='2.87027912', fee_coin='HECO_HT', abs_estimate_fee='0.01', confirming_threshold=30, dust_threshold=1, token_address='0xa71edc38d189767582c38a3145b5873052c3e47a', require_memo=false}, Assets{coin='HNS', display_code='HNS', description='Handshake', decimal=6, can_deposit=true, can_withdraw=true, balance='9640000', abs_balance='9.64', fee_coin='HNS', abs_estimate_fee='0.8', confirming_threshold=12, dust_threshold=500, token_address='', require_memo=false}, Assets{coin='HT', display_code='HT', description='Huobi Token', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x6f259637dcd74c767781e37bc6133cd6a68aa161', require_memo=false}, Assets{coin='IOST', display_code='IOST', description='IosToken', decimal=8, can_deposit=true, can_withdraw=true, balance='472731814', abs_balance='4.72731814', fee_coin='IOST', abs_estimate_fee='8', confirming_threshold=1, dust_threshold=1, token_address='iost', require_memo=true}, Assets{coin='IOST_JOY', display_code='JOY', description='', decimal=8, can_deposit=true, can_withdraw=true, balance='190000099', abs_balance='1.90000099', fee_coin='IOST', abs_estimate_fee='10', confirming_threshold=1, dust_threshold=1, token_address='iostjoy', require_memo=true}, Assets{coin='IOST_LOL', display_code='LOL', description='Emogi Network', decimal=8, can_deposit=true, can_withdraw=true, balance='10120000', abs_balance='0.1012', fee_coin='IOST', abs_estimate_fee='10', confirming_threshold=1, dust_threshold=1, token_address='lol', require_memo=true}, Assets{coin='IOST_MOON', display_code='MOON', description='', decimal=8, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='IOST', abs_estimate_fee='10', confirming_threshold=1, dust_threshold=1, token_address='moon', require_memo=true}, Assets{coin='IOST_TDON', display_code='TDON', description='Test Donnie Finance', decimal=8, can_deposit=true, can_withdraw=true, balance='9987700000', abs_balance='99.877', fee_coin='IOST', abs_estimate_fee='10', confirming_threshold=1, dust_threshold=1, token_address='tdon', require_memo=true}, Assets{coin='IOTX_IOTX', display_code='IOTX', description='IoTeX', decimal=18, can_deposit=true, can_withdraw=true, balance='899899999999999970', abs_balance='0.89989999999999997', fee_coin='IOTX_IOTX', abs_estimate_fee='10', confirming_threshold=1, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='KNC', display_code='KNC', description='Kyber Network', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xdd974d5c2e2928dea5f71b9825b8b646686bd200', require_memo=false}, Assets{coin='KSM', display_code='KSM', description='Kusama', decimal=12, can_deposit=true, can_withdraw=true, balance='380600000001', abs_balance='0.380600000001', fee_coin='KSM', abs_estimate_fee='0.1', confirming_threshold=12, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='LAT', display_code='LAT', description='PlatON Mainnet', decimal=18, can_deposit=true, can_withdraw=true, balance='98790000000000000', abs_balance='0.09879', fee_coin='LAT', abs_estimate_fee='0.01', confirming_threshold=30, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='LBTC_LBTC', display_code='LBTC', description='Lightning Bitcoin', decimal=8, can_deposit=true, can_withdraw=true, balance='2952580', abs_balance='0.0295258', fee_coin='LBTC_LBTC', abs_estimate_fee='0.1', confirming_threshold=300, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='LTC', display_code='LTC', description='Litecoin', decimal=8, can_deposit=true, can_withdraw=true, balance='73004664', abs_balance='0.73004664', fee_coin='LTC', abs_estimate_fee='0.008', confirming_threshold=6, dust_threshold=5460, token_address='', require_memo=false}, Assets{coin='MATIC', display_code='MATIC', description='Matic Network', decimal=18, can_deposit=true, can_withdraw=true, balance='1213000000000000', abs_balance='0.001213', fee_coin='MATIC', abs_estimate_fee='0.000021', confirming_threshold=30, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='MDU', display_code='MDU', description='MDUKEY', decimal=6, can_deposit=true, can_withdraw=true, balance='613250', abs_balance='0.61325', fee_coin='MDU', abs_estimate_fee='0.8', confirming_threshold=12, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='MP', display_code='MP', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='1000000000000000000', abs_balance='1', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x6337ea6bd863ff7c3c2cdb39810a672d2aa4d126', require_memo=false}, Assets{coin='NEAR', display_code='NEAR', description='NEAR Protocol', decimal=24, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='NEAR', abs_estimate_fee='0.05', confirming_threshold=5, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='NEO', display_code='NEO', description='NEO', decimal=0, can_deposit=true, can_withdraw=true, balance='2', abs_balance='2', fee_coin='NEOGAS', abs_estimate_fee='0', confirming_threshold=1, dust_threshold=0, token_address='0xc56f33fc6ecfcd0c225c4ab356fee59390af8560be0e930faebe74a6daff7c9b', require_memo=false}, Assets{coin='NEOGAS', display_code='GAS', description='Neo Gas', decimal=8, can_deposit=true, can_withdraw=true, balance='919750124', abs_balance='9.19750124', fee_coin='NEOGAS', abs_estimate_fee='0', confirming_threshold=1, dust_threshold=1, token_address='0x602c79718b16e442de58778e148d0b1084e3b2dffd5de6b7b16cee7969282de7', require_memo=false}, Assets{coin='NTY', display_code='NTY', description='Nexty', decimal=18, can_deposit=true, can_withdraw=true, balance='500000000000000000', abs_balance='0.5', fee_coin='NTY', abs_estimate_fee='1000', confirming_threshold=31, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='OMG', display_code='OMG', description='OMG Network', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xd26114cd6ee289accf82350c8d8487fedb8a0c07', require_memo=false}, Assets{coin='ONE', display_code='ONE', description='Harmony', decimal=18, can_deposit=true, can_withdraw=true, balance='3997599999999940000', abs_balance='3.99759999999994', fee_coin='ONE', abs_estimate_fee='0.8', confirming_threshold=1, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='ONT_ONG', display_code='ONG', description='Ontology Gas', decimal=9, can_deposit=true, can_withdraw=true, balance='1656655228', abs_balance='1.656655228', fee_coin='ONT_ONG', abs_estimate_fee='1', confirming_threshold=5, dust_threshold=1, token_address='0200000000000000000000000000000000000000', require_memo=false}, Assets{coin='ONT_ONT', display_code='ONT', description='Ontology', decimal=0, can_deposit=true, can_withdraw=true, balance='17', abs_balance='17', fee_coin='ONT_ONG', abs_estimate_fee='1', confirming_threshold=5, dust_threshold=0, token_address='0100000000000000000000000000000000000000', require_memo=false}, Assets{coin='PAY', display_code='PAY', description='TenX', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xb97048628db6b661d4c2aa833e95dbe1a905b280', require_memo=false}, Assets{coin='RBTC', display_code='RBTC', description='RSK Smart Bitcoin', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='RBTC', abs_estimate_fee='0.0004', confirming_threshold=600, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='READ', display_code='READ', description='', decimal=8, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0x13d0bf45e5f319fa0b58900807049f23cae7c40d', require_memo=false}, Assets{coin='RVN', display_code='RVN', description='Ravencoin', decimal=8, can_deposit=true, can_withdraw=true, balance='150974087', abs_balance='1.50974087', fee_coin='RVN', abs_estimate_fee='8', confirming_threshold=60, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='SEELE', display_code='SEELE', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xb1eef147028e9f480dbc5ccaa3277d417d1b85f0', require_memo=false}, Assets{coin='TBSC_BNB', display_code='TBSC_BNB', description='Binance Smart Chain Testnet', decimal=18, can_deposit=true, can_withdraw=true, balance='18748380000000000000', abs_balance='18.74838', fee_coin='TBSC_BNB', abs_estimate_fee='0.00021', confirming_threshold=15, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='TBSC_CC', display_code='CC', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='100000000000000000000000000', abs_balance='100000000', fee_coin='TBSC_BNB', abs_estimate_fee='0.0005', confirming_threshold=15, dust_threshold=1, token_address='0x7a4904f230a646cb64a6cae05f7abacb5fb917af', require_memo=false}, Assets{coin='TETH', display_code='TETH', description='Ethereum Testnet', decimal=18, can_deposit=true, can_withdraw=true, balance='5674457458869780422', abs_balance='5.674457458869780422', fee_coin='TETH', abs_estimate_fee='0.004', confirming_threshold=32, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='TETH_CTT', display_code='CTT', description='Cobo Test Token', decimal=18, can_deposit=true, can_withdraw=true, balance='39226487660000000000', abs_balance='39.22648766', fee_coin='TETH', abs_estimate_fee='0.006', confirming_threshold=32, dust_threshold=1, token_address='0x68bc61972e2ac0d9dd8900be01032d02028f3026', require_memo=false}, Assets{coin='TETH_CTT1', display_code='TETH_CTT1', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='999000000000000000000', abs_balance='999', fee_coin='TETH', abs_estimate_fee='0.006', confirming_threshold=32, dust_threshold=1, token_address='0xa282d886e54d29044ccaaacfac7e4760cae54033', require_memo=false}, Assets{coin='TETH_CTT2', display_code='TETH_CTT2', description='', decimal=18, can_deposit=true, can_withdraw=true, balance='9999000000000000000000', abs_balance='9999', fee_coin='TETH', abs_estimate_fee='0.006', confirming_threshold=32, dust_threshold=1, token_address='0xed64b6fd1d813270844e821ea5f5dbb9ce1efd67', require_memo=false}, Assets{coin='TNEAR', display_code='TNEAR', description='', decimal=24, can_deposit=true, can_withdraw=true, balance='4881000000000000000000000', abs_balance='4.881', fee_coin='TNEAR', abs_estimate_fee='0.05', confirming_threshold=10, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='TOMO', display_code='TOMO', description='TomoChain', decimal=18, can_deposit=true, can_withdraw=true, balance='49763202657999998175', abs_balance='49.763202657999998175', fee_coin='TOMO', abs_estimate_fee='0.1', confirming_threshold=100, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='TOMO_TIIM', display_code='TIIM', description='TriipMiles', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TOMO', abs_estimate_fee='0.1', confirming_threshold=100, dust_threshold=1, token_address='0x3c6475f8b4200e0a6acf5aeb2b44b769a3d37216', require_memo=false}, Assets{coin='TRON', display_code='TRX', description='TRON', decimal=6, can_deposit=true, can_withdraw=true, balance='1638127', abs_balance='1.638127', fee_coin='TRON', abs_estimate_fee='1', confirming_threshold=27, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='TRON_BTT', display_code='BTT', description='BitTorrent', decimal=6, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1002000', require_memo=false}, Assets{coin='TRON_CDF', display_code='CDF', description='CryptoDivaFund', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1001351', require_memo=false}, Assets{coin='TRON_DEX', display_code='DEX', description='TRON DEX', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1000554', require_memo=false}, Assets{coin='TRON_GAC', display_code='GAC', description='GAcoin', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1000998', require_memo=false}, Assets{coin='TRON_IGG', display_code='IGG', description='', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1000317', require_memo=false}, Assets{coin='TRON_JST', display_code='JST', description='JUST', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='TCFLL5dx5ZJdKnWuesXxi1VPwjLVmWZZy9', require_memo=false}, Assets{coin='TRON_KDG', display_code='KDG', description='Kingdom Game 4.0', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='TYM9eM22SCynRc5YaMxE2PX1kwv7H2rXAu', require_memo=false}, Assets{coin='TRON_ONEPIECE', display_code='ONEPIECE', description='OnePiece', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1000093', require_memo=false}, Assets{coin='TRON_SEED', display_code='SEED', description='Sesameseed', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1000001', require_memo=false}, Assets{coin='TRON_SIT', display_code='SIT', description='', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1001384', require_memo=false}, Assets{coin='TRON_TARQUIN', display_code='TARQUIN', description='Tarquin', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1000017', require_memo=false}, Assets{coin='TRON_TRONGOLD', display_code='TRONGOLD', description='', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1000231', require_memo=false}, Assets{coin='TRON_TRONONE', display_code='TRONONE', description='TronOne', decimal=0, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='1001090', require_memo=false}, Assets{coin='TRON_USDT', display_code='USDT', description='Tether', decimal=6, can_deposit=true, can_withdraw=true, balance='1799899', abs_balance='1.799899', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t', require_memo=false}, Assets{coin='TRON_ZZZ', display_code='ZZZ', description='', decimal=8, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='TRON', abs_estimate_fee='8', confirming_threshold=27, dust_threshold=1, token_address='TF7egXrC175NRkZSdg3zd42KEXE1bobZZ2', require_memo=false}, Assets{coin='TWAVES', display_code='TWAVES', description='', decimal=8, can_deposit=true, can_withdraw=true, balance='999900000', abs_balance='9.999', fee_coin='TWAVES', abs_estimate_fee='0.001', confirming_threshold=10, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='UATOM', display_code='ATOM', description='Cosmos', decimal=6, can_deposit=true, can_withdraw=true, balance='501999', abs_balance='0.501999', fee_coin='UATOM', abs_estimate_fee='0.04', confirming_threshold=12, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='VAPOR', display_code='VAPOR', description='Bytom Side Chain', decimal=8, can_deposit=true, can_withdraw=true, balance='97700000', abs_balance='0.977', fee_coin='VAPOR', abs_estimate_fee='4', confirming_threshold=32, dust_threshold=1, token_address='ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff', require_memo=false}, Assets{coin='VEE', display_code='VSYS', description='v.systems', decimal=8, can_deposit=true, can_withdraw=true, balance='414999999', abs_balance='4.14999999', fee_coin='VEE', abs_estimate_fee='1', confirming_threshold=31, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='VEE_IPX', display_code='IPX', description='Tachyon Protocol', decimal=9, can_deposit=true, can_withdraw=true, balance='800000000', abs_balance='0.8', fee_coin='VEE', abs_estimate_fee='1', confirming_threshold=31, dust_threshold=1, token_address='TWZZfKFqcaNVe5TrphLRNEm5DQFnBRJMjDDByqv84', require_memo=false}, Assets{coin='VET', display_code='VET', description='VeChain', decimal=18, can_deposit=true, can_withdraw=true, balance='4000000000000000100', abs_balance='4.0000000000000001', fee_coin='VTHO', abs_estimate_fee='150', confirming_threshold=20, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='VET_JUR', display_code='JUR', description='VET JUR Token', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='VTHO', abs_estimate_fee='150', confirming_threshold=20, dust_threshold=1, token_address='0x46209d5e5a49c1d403f4ee3a0a88c3a27e29e58d', require_memo=false}, Assets{coin='VET_OCE', display_code='OCE', description='OceanEx Token', decimal=18, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='VTHO', abs_estimate_fee='150', confirming_threshold=20, dust_threshold=1, token_address='0x0ce6661b4ba86a0ea7ca2bd86a0de87b0b860f14', require_memo=false}, Assets{coin='VET_TIC', display_code='TIC', description='TicTalk Token', decimal=18, can_deposit=true, can_withdraw=true, balance='198000000000000000000', abs_balance='198', fee_coin='VTHO', abs_estimate_fee='150', confirming_threshold=20, dust_threshold=1, token_address='0xa94a33f776073423e163088a5078feac31373990', require_memo=false}, Assets{coin='VTHO', display_code='VTHO', description='VeThor Token', decimal=18, can_deposit=true, can_withdraw=true, balance='16058097372036855775805', abs_balance='16058.097372036855775805', fee_coin='VTHO', abs_estimate_fee='150', confirming_threshold=20, dust_threshold=1, token_address='0x0000000000000000000000000000456e65726779', require_memo=false}, Assets{coin='WAVES', display_code='WAVES', description='Waves', decimal=8, can_deposit=true, can_withdraw=true, balance='549000000', abs_balance='5.49', fee_coin='WAVES', abs_estimate_fee='0.001', confirming_threshold=30, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='WAVES_USDN', display_code='USDN', description='', decimal=6, can_deposit=true, can_withdraw=true, balance='1000000', abs_balance='1', fee_coin='WAVES', abs_estimate_fee='0.001', confirming_threshold=30, dust_threshold=1, token_address='DG2xFkPdDwKUoBkzGAhQtLpSGzfXLiCYPEzeKH2Ad24p', require_memo=false}, Assets{coin='XLM', display_code='XLM', description='Stellar', decimal=7, can_deposit=true, can_withdraw=true, balance='7739810', abs_balance='0.773981', fee_coin='XLM', abs_estimate_fee='0.8', confirming_threshold=1, dust_threshold=1, token_address='', require_memo=true}, Assets{coin='XRP', display_code='XRP', description='Ripple', decimal=6, can_deposit=true, can_withdraw=true, balance='1930811', abs_balance='1.930811', fee_coin='XRP', abs_estimate_fee='1', confirming_threshold=1, dust_threshold=1, token_address='', require_memo=true}, Assets{coin='XTN', display_code='XTN', description='Bitcoin Testnet3', decimal=8, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='XTN', abs_estimate_fee='0.0004', confirming_threshold=3, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='XTN_OMNI', display_code='TOMNI', description='Omni Testnet', decimal=8, can_deposit=true, can_withdraw=true, balance='1611000000', abs_balance='16.11', fee_coin='XTN', abs_estimate_fee='0.0005', confirming_threshold=3, dust_threshold=1, token_address='1', require_memo=false}, Assets{coin='XTZ', display_code='XTZ', description='Tezos', decimal=6, can_deposit=true, can_withdraw=true, balance='8320000', abs_balance='8.32', fee_coin='XTZ', abs_estimate_fee='0.4', confirming_threshold=6, dust_threshold=1, token_address='', require_memo=false}, Assets{coin='XZC', display_code='FIRO', description='Zcoin', decimal=8, can_deposit=true, can_withdraw=true, balance='700546', abs_balance='0.00700546', fee_coin='XZC', abs_estimate_fee='0.08', confirming_threshold=50, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='YEC', display_code='YEC', description='Ycash', decimal=8, can_deposit=true, can_withdraw=true, balance='0', abs_balance='0', fee_coin='YEC', abs_estimate_fee='0.04', confirming_threshold=12, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='ZEC', display_code='ZEC', description='Zcash', decimal=8, can_deposit=true, can_withdraw=true, balance='2608854', abs_balance='0.02608854', fee_coin='ZEC', abs_estimate_fee='0.004', confirming_threshold=12, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='ZEL', display_code='ZEL', description='Zel', decimal=8, can_deposit=true, can_withdraw=true, balance='8959454', abs_balance='0.08959454', fee_coin='ZEL', abs_estimate_fee='5', confirming_threshold=20, dust_threshold=546, token_address='', require_memo=false}, Assets{coin='ZRX', display_code='ZRX', description='0x', decimal=18, can_deposit=true, can_withdraw=true, balance='98586644750000989995', abs_balance='98.586644750000989995', fee_coin='ETH', abs_estimate_fee='0.01445', confirming_threshold=12, dust_threshold=1, token_address='0xe41d2489571d322189246dafa5ebde1f4699f498', require_memo=false}]}
```
</details>

#### Get Coin Details
```java
ApiResponse<CoinInfo> coinInfo = client.getCoinInfo("ETH")
```
<details>
<summary>View Response</summary>


```java
CoinInfo{coin='ETH', display_code='ETH', description='Ethereum', decimal=18, can_deposit=true, can_withdraw=true, require_memo=false, balance='0', abs_balance='0', fee_coin='ETH', abs_estimate_fee='0.006069', confirming_threshold=12, dust_threshold=1, token_address=''}
```
</details>

#### Get New Deposit Address
```java
ApiResponse<Address> res = client.newAddress("ETH", false);
```
<details>
<summary>View Response</summary>


```java
Address{coin='ETH', address='0x6a60f0d7ef6e5d2a4a31d65c8b73ac19a020bb16'}
```
</details>

#### Batch New Deposit Address
```java
ApiResponse<Address> res = client.newAddress("ETH", false);
```
<details>
<summary>View Response</summary>


```java
NewAddresses{coin='ETH', addresses=,0x7568cd7c5b051540eaeff22becbb35d716aa063e,0x17e5bce063d14bdf75e41df8673ce0ee1978c452,0x65e7b319837edab8ce9155b87dfce5ad599ab517,0xd192fb0d43615c7743f6229b1488e1a268b3c402}
```
</details>

#### Verify Deposit Address
```java
ApiResponse<Address> res = client.addressInfo("ETH", "0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee");
```
<details>
<summary>View Response</summary>


```java
Address{coin='ETH', address='0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee'}
```
</details>

#### Batch Verify Deposit Address
```java
ApiResponse<List<InternalAddressInfo>> res = client.getInternalAddressInfoBatch("ETH", "0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a,0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a");
```
<details>
<summary>View Response</summary>


```java
[InternalAddressInfo{coin='ETH', address='0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a', is_internal_address=false, internal_org='null', internal_wallet='null'}, InternalAddressInfo{coin='ETH', address='0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a', is_internal_address=false, internal_org='null', internal_wallet='null'}]
```
</details>

#### Verify Valid Address
```java
ApiResponse<Boolean> res = client.isValidAddress("ETH", "0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d");
```
<details>
<summary>View Response</summary>


```java
true
```
</details>

#### Get Address History List
```java
ApiResponse<List<Address>> res = client.getAddressHistory("ETH");
```
<details>
<summary>View Response</summary>


```java
[Address{coin='ETH', address='0x6a60f0d7ef6e5d2a4a31d65c8b73ac19a020bb16'}, Address{coin='ETH', address='0xd192fb0d43615c7743f6229b1488e1a268b3c402'}, Address{coin='ETH', address='0x65e7b319837edab8ce9155b87dfce5ad599ab517'}, Address{coin='ETH', address='0x17e5bce063d14bdf75e41df8673ce0ee1978c452'}, Address{coin='ETH', address='0x7568cd7c5b051540eaeff22becbb35d716aa063e'}]
```
</details>

#### Get Address History List With Page
```java
ApiResponse<List<Address>> res = client.getAddressHistory("ETH" ,0, 50);
```
<details>
<summary>View Response</summary>


```java
[Address{coin='ETH', address='0x6a60f0d7ef6e5d2a4a31d65c8b73ac19a020bb16'}, Address{coin='ETH', address='0xd192fb0d43615c7743f6229b1488e1a268b3c402'}, Address{coin='ETH', address='0x65e7b319837edab8ce9155b87dfce5ad599ab517'}, Address{coin='ETH', address='0x17e5bce063d14bdf75e41df8673ce0ee1978c452'}, Address{coin='ETH', address='0x7568cd7c5b051540eaeff22becbb35d716aa063e'}]
```
</details>

#### Get Address History List With Page Sort
```java
ApiResponse<List<Address>> res = client.getAddressHistory("ETH" ,0, 50, SortFlagEnum.DESCENDING);
```
<details>
<summary>View Response</summary>


```java
[Address{coin='ETH', address='0x6a60f0d7ef6e5d2a4a31d65c8b73ac19a020bb16'}, Address{coin='ETH', address='0xd192fb0d43615c7743f6229b1488e1a268b3c402'}, Address{coin='ETH', address='0x65e7b319837edab8ce9155b87dfce5ad599ab517'}, Address{coin='ETH', address='0x17e5bce063d14bdf75e41df8673ce0ee1978c452'}, Address{coin='ETH', address='0x7568cd7c5b051540eaeff22becbb35d716aa063e'}]
```
</details>

### Loop Alliance

#### Check Loop Address Details 
```java
ApiResponse<InternalAddressInfo> res = client.getInternalAddressInfo("ETH", "0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a");
```
<details>
<summary>View Response</summary>


```java
InternalAddressInfo{coin='ETH', address='0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a', is_internal_address=false, internal_org='', internal_wallet=''}
```
</details>

#### Verify Loop Address List
```java
List<String> list = new ArrayList<>();
        list.add("0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee");
        list.add("0xe105a42297428575086387de415900a08765a8af");
        list.add("0x641733cde30e99fe0d6082c2ed96601c37a1718b");
        list.add("0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d");

        ApiResponse<Addresses> res = client.addressesInfo("ETH", list);
```
<details>
<summary>View Response</summary>


```java
NewAddress{coin='ETH', addresses='0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee,0x641733cde30e99fe0d6082c2ed96601c37a1718b,0xe105a42297428575086387de415900a08765a8af,0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d'}
```
</details>

#### Loop Transaction Explorer
To help your user to check the Loop transaction, we offer you an explorer, you may insert the following URL in your platform：https://loop.top/tx/[Loop_ID] 
e.g. https://loop.top/tx/L456e5cb652dcfe557a43fd9d8e48627


### Transactions

#### Get Transaction Details
```java
ApiResponse<Transaction> res = client.getTransactionById("20210422193807000343569000002370");
```
<details>
<summary>View Response</summary>


```java
Transaction{id='20210422193807000343569000002370', coin='TETH', display_code='TETH', description='Ethereum Testnet', decimal=18, address='0x14ce095a3593db7db1d13a0765eb826e00d4fc91', source_address='0x7ca60000afea5a1730e40cf6b51abbf8b594ad91', side='withdraw', amount='210000000000000000', abs_amount='0.21', txid='0xb40d0ca5a5fadda884a67a46f979741e96be92c69f767fed57ccc000d5c0a14b', vout_n=0, request_id='web_send_by_user_424_1619091344352', status='success', abs_cobo_fee='0', created_time=1619091344501, last_time=1619091838174, confirmed_num=36, tx_detail=TxDetail{txid='0xb40d0ca5a5fadda884a67a46f979741e96be92c69f767fed57ccc000d5c0a14b', blocknum=10088274, blockhash='0x1b9e862f4056cbc55fe70f817fd1b92e32ddfd7eb5092f56ffc36b91ebd69074', fee=0, actualgas=21000000000000, gasprice=1, hexstr=''}, source_address_detail='0x7ca60000afea5a1730e40cf6b51abbf8b594ad91', memo='', confirming_threshold=36, fee_coin='TETH', fee_amount='4000000000000000', fee_decimal=18, type='external', waiting_audit=false}
```
</details>

#### Get Transactions By txId
```java
ApiResponse<List<Transaction>> res = client.getTransactionByTxId("0x5d5396c3992ed524bf68a22a7ab6ae503f0349354ad69bc5204d5214085d4e9f");
```
<details>
<summary>View Response</summary>


```java
[Transaction{id='20220620112255000399219000004796', coin='COBO_ETH', display_code='COBO_ETH', description='Cobo Ethereum Testnet', decimal=18, address='0x9e6d2c7a9561ae9c7651768038c7d40da78920c9', source_address='0x929590a1428dffa67df664482cf2cad3c230ec6d', side='withdraw', amount='100000000000000', abs_amount='0.0001', txid='0x5d5396c3992ed524bf68a22a7ab6ae503f0349354ad69bc5204d5214085d4e9f', vout_n=0, request_id='web_send_by_user_1272_1655694295628', status='success', abs_cobo_fee='0', created_time=1655695375730, last_time=1655695375730, confirmed_num=13, tx_detail=TxDetail{txid='0x5d5396c3992ed524bf68a22a7ab6ae503f0349354ad69bc5204d5214085d4e9f', blocknum=8025087, blockhash='0xfef9d77a7d1e473c88272cef449fea7d5ef7eefe29f43f56ee27b8f7f1f1d8cf', fee=0, actualgas=21000000000000, gasprice=1, hexstr=''}, source_address_detail='0x929590a1428dffa67df664482cf2cad3c230ec6d', memo='for test', confirming_threshold=13, fee_coin='COBO_ETH', fee_amount='21000000000000', fee_decimal=18, type='external', waiting_audit=false}, Transaction{id='20220620112258000399219000009986', coin='COBO_ETH', display_code='COBO_ETH', description='Cobo Ethereum Testnet', decimal=18, address='0x9e6d2c7a9561ae9c7651768038c7d40da78920c9', source_address='0x929590a1428dffa67df664482cf2cad3c230ec6d', side='deposit', amount='100000000000000', abs_amount='0.0001', txid='0x5d5396c3992ed524bf68a22a7ab6ae503f0349354ad69bc5204d5214085d4e9f', vout_n=0, request_id='null', status='success', abs_cobo_fee='0', created_time=1655695378377, last_time=1655695378377, confirmed_num=15, tx_detail=TxDetail{txid='0x5d5396c3992ed524bf68a22a7ab6ae503f0349354ad69bc5204d5214085d4e9f', blocknum=8025087, blockhash='0xfef9d77a7d1e473c88272cef449fea7d5ef7eefe29f43f56ee27b8f7f1f1d8cf', fee=0, actualgas=0, gasprice=0, hexstr=''}, source_address_detail='0x929590a1428dffa67df664482cf2cad3c230ec6d', memo='null', confirming_threshold=15, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}]

```
</details>

#### Obtain the list of confirmed transactions through ID query(deposit&withdraw)
```java
ApiResponse<List<Transaction>> res = client.getTransactionsById(null, Side.Any, null, null, null, 2, null);
```
<details>
<summary>View Response</summary>


```java
[Transaction{id='3228776326735331328', coin='ETH', display_code='ETH', description='Ethereum', decimal=18, address='0x62b3f5f1717e46bec22c52c1607f84a25b4e7f83', source_address='0xa9c7d31bb1879bff8be25ead2f59b310a52b7c5a', side='deposit', amount='100000000000000', abs_amount='0.0001', txid='0xe90e064eb9fbaff12501325875df722484579f451bfe1db3a227495dcc54c568', vout_n=0, request_id='null', status='success', abs_cobo_fee='0', created_time=1539600528114, last_time=1539600528114, confirmed_num=12, tx_detail=TxDetail{txid='0xe90e064eb9fbaff12501325875df722484579f451bfe1db3a227495dcc54c568', blocknum=6519238, blockhash='0x2abf41e86a9cd37d481d7a3212ca0eab80fa2f4d10e70e94b2623c5318c383c8', fee=0, actualgas=0, gasprice=0, hexstr=''}, source_address_detail='0xa9c7d31bb1879bff8be25ead2f59b310a52b7c5a', memo='null', confirming_threshold=12, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}, Transaction{id='3228768325479694336', coin='BTC', display_code='BTC', description='Bitcoin', decimal=8, address='1Q1xfp8UkQagCn2pbJFpG89Cd6Ku3yUixE', source_address='185qKpZNnwaX5ebJ4DBQ3rgy85HgRWKgEi', side='deposit', amount='1000', abs_amount='0.00001', txid='dfa0d24c29cf39ddbeab4aad04d8883f2f544dd85d43c9db34fde968e4d9a63b', vout_n=0, request_id='null', status='success', abs_cobo_fee='0', created_time=1539596712818, last_time=1539596712818, confirmed_num=3, tx_detail=TxDetail{txid='dfa0d24c29cf39ddbeab4aad04d8883f2f544dd85d43c9db34fde968e4d9a63b', blocknum=545845, blockhash='0000000000000000001fb2c338e7aed6560d852a3a0836f8aac7409b99f8d624', fee=0, actualgas=0, gasprice=0, hexstr=''}, source_address_detail='185qKpZNnwaX5ebJ4DBQ3rgy85HgRWKgEi', memo='null', confirming_threshold=3, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}]
```
</details>

#### Obtain the list of confirmed transactions through time query(deposit&withdraw)
```java
ApiResponse<List<Transaction>> res = client.getTransactionsByTime(null, Side.Any, null, 0, 0, 2, null);
```
<details>
<summary>View Response</summary>


```java
[Transaction{id='20210520115758000378235000004875', coin='CKB', display_code='CKB', description='Nervos Network', decimal=8, address='ckb1qyq8a5r5hpm4zw5ugpakyc847ml36dntng9qkd76ln', source_address='ckb1qyq2ug0jlynj6n95esm5rgu6zk5l047a964s4qr3ag', side='deposit', amount='6200000000', abs_amount='62', txid='0x8cd86358ff61b17c3d453717306a919a4c2672657175306a2ce7f07f05095c45', vout_n=0, request_id='null', status='success', abs_cobo_fee='0', created_time=1621483452136, last_time=1621483452136, confirmed_num=30, tx_detail=TxDetail{txid='0x8cd86358ff61b17c3d453717306a919a4c2672657175306a2ce7f07f05095c45', blocknum=4364392, blockhash='0xb40788e7185ad0d845708e0e6757fcf7817c73bb8a5fe1806da626ee5b7c4f6f', fee=0, actualgas=0, gasprice=0, hexstr=''}, source_address_detail='ckb1qyq2ug0jlynj6n95esm5rgu6zk5l047a964s4qr3ag', memo='null', confirming_threshold=30, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}, Transaction{id='20210520115644000378235000004289', coin='CKB', display_code='CKB', description='Nervos Network', decimal=8, address='ckb1qyq8a5r5hpm4zw5ugpakyc847ml36dntng9qkd76ln', source_address='ckb1qyq2ug0jlynj6n95esm5rgu6zk5l047a964s4qr3ag', side='withdraw', amount='6200000000', abs_amount='62', txid='0x8cd86358ff61b17c3d453717306a919a4c2672657175306a2ce7f07f05095c45', vout_n=0, request_id='ckb29398728476738', status='success', abs_cobo_fee='0', created_time=1621483451938, last_time=1621483451938, confirmed_num=30, tx_detail=TxDetail{txid='0x8cd86358ff61b17c3d453717306a919a4c2672657175306a2ce7f07f05095c45', blocknum=4364392, blockhash='0xb40788e7185ad0d845708e0e6757fcf7817c73bb8a5fe1806da626ee5b7c4f6f', fee=0, actualgas=24800, gasprice=1, hexstr=''}, source_address_detail='ckb1qyq2ug0jlynj6n95esm5rgu6zk5l047a964s4qr3ag', memo='', confirming_threshold=30, fee_coin='CKB', fee_amount='800000000', fee_decimal=8, type='external', waiting_audit=false}]
```
</details>

#### Get Pending Transactions
```java
ApiResponse<List<Transaction>> pendingTransactions = client.getPendingTransactions(null, Side.Any, null, null, 50);
```
<details>
<summary>View Response</summary>


```java
[Transaction{id='20200630175208000359964000002754', coin='TOMO', display_code='TOMO', description='TomoChain', decimal=18, address='0xab65bdd2e1fd20878d2cf8b09fe87a34059519fc', source_address='0x1a7d388963fa4ea8bb7a5822802a48ccb0ff08b5', side='withdraw', amount='1000000000000000000', abs_amount='1', txid='0xc19e50b0b15116a146f033ad3f3e1e77ae84a604fca50b77b54b72dfb21cd7e5', vout_n=0, request_id='tool9207389726', status='pending', abs_cobo_fee='null', created_time=1593510728558, last_time=1593510728558, confirmed_num=0, tx_detail=TxDetail{txid='0xc19e50b0b15116a146f033ad3f3e1e77ae84a604fca50b77b54b72dfb21cd7e5', blocknum=0, blockhash='', fee=10000000000000000, actualgas=0, gasprice=1, hexstr=''}, source_address_detail='0x1a7d388963fa4ea8bb7a5822802a48ccb0ff08b5', memo='', confirming_threshold=100, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}, Transaction{id='20200604173207000367545000002794', coin='ETH', display_code='ETH', description='Ethereum', decimal=18, address='0x0c1a06710fac5e6ec6681c2a5a7e20b9e90319c0', source_address='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', side='withdraw', amount='100000000000000000', abs_amount='0.1', txid='0xe433dc4cb1ac9c576b4d9c2b4c10fec1e73e92cf97ecfe4d222599a6fd0e5d2a', vout_n=0, request_id='web_send_by_user_194_1591263071240', status='success', abs_cobo_fee='null', created_time=1591263127392, last_time=1591263127392, confirmed_num=12, tx_detail=TxDetail{txid='0xe433dc4cb1ac9c576b4d9c2b4c10fec1e73e92cf97ecfe4d222599a6fd0e5d2a', blocknum=10198480, blockhash='0x81c3da0a9aa3737bf32066a5961b489364284039a5da074fad9a69d2df5d285c', fee=400000000000000, actualgas=1134000045948000, gasprice=1, hexstr=''}, source_address_detail='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', memo='tesing', confirming_threshold=12, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}, Transaction{id='20200604171238000354106000006405', coin='ETH_USDT', display_code='USDT', description='Tether', decimal=6, address='0x0c1a06710fac5e6ec6681c2a5a7e20b9e90319c0', source_address='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', side='withdraw', amount='1000000', abs_amount='1', txid='0xe967fb51b1a32dc73c1db51395993a7ccee66645376f524df5ae7960887e2f6a', vout_n=0, request_id='web_send_by_user_194_1591261893993', status='success', abs_cobo_fee='null', created_time=1591261958382, last_time=1591261958382, confirmed_num=12, tx_detail=TxDetail{txid='0xe967fb51b1a32dc73c1db51395993a7ccee66645376f524df5ae7960887e2f6a', blocknum=10198392, blockhash='0x3816eee4d54720ddfd14a0472061bf928bd4d8001da53c2e2ec58b03be81f0a3', fee=600000000000000, actualgas=2973446068854969, gasprice=1, hexstr=''}, source_address_detail='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', memo='', confirming_threshold=12, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}, Transaction{id='20200603204256000357500000001342', coin='EOS_EOS', display_code='EOS', description='EOS', decimal=4, address='cobotodamoon', source_address='cobocustodyb', side='withdraw', amount='10', abs_amount='0.001', txid='ac869373555b8f4dac53e1c66f578fb67a4bd6344959262b8ae18265d35a187e', vout_n=0, request_id='web_send_by_user_194_1591187644510', status='success', abs_cobo_fee='null', created_time=1591188176768, last_time=1591188176768, confirmed_num=1, tx_detail=TxDetail{txid='ac869373555b8f4dac53e1c66f578fb67a4bd6344959262b8ae18265d35a187e', blocknum=124092043, blockhash='07657e8bec40ab44c65fae85bc81dc9337a88b8c316b963cfdbe514343252a23', fee=80, actualgas=0, gasprice=1, hexstr=''}, source_address_detail='cobocustodyb', memo='', confirming_threshold=1, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}, Transaction{id='20200602190308000332509000005562', coin='ETH', display_code='ETH', description='Ethereum', decimal=18, address='0xd60290095179F35Cf50C8C4b2c76FD1fc2FD3C08', source_address='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', side='withdraw', amount='100000000000000', abs_amount='0.0001', txid='0xb026be260ce3d64f59274655ff48d5a7065b597b234061936131eb6619e66355', vout_n=0, request_id='web_send_by_user_421_1591095764807', status='success', abs_cobo_fee='null', created_time=1591095788809, last_time=1591095788809, confirmed_num=12, tx_detail=TxDetail{txid='0xb026be260ce3d64f59274655ff48d5a7065b597b234061936131eb6619e66355', blocknum=10186022, blockhash='0x8e7fd9b55ab927e939bd5363f89f65a7b06c5e59d9fd916e35f7957f215d28fa', fee=400000000000000, actualgas=913500000000000, gasprice=1, hexstr=''}, source_address_detail='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', memo='', confirming_threshold=12, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}]
```
</details>

#### Get Pending Deposit Details
```java
ApiResponse<Transaction> res = client.getPendingTransaction("20200604171238000354106000006405");
```
<details>
<summary>View Response</summary>


```java
Transaction{id='20200604171238000354106000006405', coin='ETH_USDT', display_code='USDT', description='Tether', decimal=6, address='0x0c1a06710fac5e6ec6681c2a5a7e20b9e90319c0', source_address='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', side='withdraw', amount='1000000', abs_amount='1', txid='0xe967fb51b1a32dc73c1db51395993a7ccee66645376f524df5ae7960887e2f6a', vout_n=0, request_id='web_send_by_user_194_1591261893993', status='success', abs_cobo_fee='null', created_time=1591261958382, last_time=1591261958382, confirmed_num=12, tx_detail=TxDetail{txid='0xe967fb51b1a32dc73c1db51395993a7ccee66645376f524df5ae7960887e2f6a', blocknum=10198392, blockhash='0x3816eee4d54720ddfd14a0472061bf928bd4d8001da53c2e2ec58b03be81f0a3', fee=600000000000000, actualgas=2973446068854969, gasprice=1, hexstr=''}, source_address_detail='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', memo='', confirming_threshold=12, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}
```
</details>

#### Get Transaction History
```java
ApiResponse<List<Transaction>> res = client.getTransactionHistory("ETH", Side.Any, null, null, null, 50, 0, System.currentTimeMillis(), null);
```
<details>
<summary>View Response</summary>


```java
[Transaction{id='3228776326735331328', coin='ETH', display_code='ETH', description='Ethereum', decimal=18, address='0x62b3f5f1717e46bec22c52c1607f84a25b4e7f83', source_address='0xa9c7d31bb1879bff8be25ead2f59b310a52b7c5a', side='deposit', amount='100000000000000', abs_amount='0.0001', txid='0xe90e064eb9fbaff12501325875df722484579f451bfe1db3a227495dcc54c568', vout_n=0, request_id='null', status='success', abs_cobo_fee='0', created_time=1539600528114, last_time=1539600528114, confirmed_num=12, tx_detail=TxDetail{txid='0xe90e064eb9fbaff12501325875df722484579f451bfe1db3a227495dcc54c568', blocknum=6519238, blockhash='0x2abf41e86a9cd37d481d7a3212ca0eab80fa2f4d10e70e94b2623c5318c383c8', fee=0, actualgas=0, gasprice=0, hexstr=''}, source_address_detail='0xa9c7d31bb1879bff8be25ead2f59b310a52b7c5a', memo='null', confirming_threshold=12, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}, Transaction{id='20210108144127000380088000002302', coin='ETH', display_code='ETH', description='Ethereum', decimal=18, address='0xfdf2b1f888d09fc7602f700bd214600b51d6f31a', source_address='cobo_test', side='withdraw', amount='1000000000000000000', abs_amount='1', txid='L8b3e42961795285d315adad46262cfc', vout_n=0, request_id='web_send_by_user_427_1610088044313', status='success', abs_cobo_fee='0', created_time=1610088044385, last_time=1610088087145, confirmed_num=12, tx_detail=TxDetail{txid='L8b3e42961795285d315adad46262cfc', blocknum=0, blockhash='', fee=0, actualgas=0, gasprice=1, hexstr=''}, source_address_detail='cobo_test', memo='null', confirming_threshold=12, fee_coin='null', fee_amount='null', fee_decimal=0, type='internal', waiting_audit=false}, Transaction{id='20210108134603000380088000006360', coin='ETH', display_code='ETH', description='Ethereum', decimal=18, address='0x576bd96937027284aa904a4f6a628d8f51d88913', source_address='cobo_test', side='withdraw', amount='1000000000000000000', abs_amount='1', txid='L9a29cb8401bea72fd6b54628007bfb1', vout_n=0, request_id='web_send_by_user_427_1610084709617', status='success', abs_cobo_fee='0', created_time=1610084709710, last_time=1610084763272, confirmed_num=12, tx_detail=TxDetail{txid='L9a29cb8401bea72fd6b54628007bfb1', blocknum=0, blockhash='', fee=0, actualgas=0, gasprice=1, hexstr=''}, source_address_detail='cobo_test', memo='null', confirming_threshold=12, fee_coin='null', fee_amount='null', fee_decimal=0, type='internal', waiting_audit=false}, Transaction{id='20201218105542000388092000006926', coin='ETH', display_code='ETH', description='Ethereum', decimal=18, address='0x3b838adc736b1e9fc86b55ccbb576d8c5d55f9df', source_address='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', side='deposit', amount='10000000000000000', abs_amount='0.01', txid='0x2d7706b7976e5da8ce696dee05f78ffdfd1d544184b33582dbb434504432be8e', vout_n=0, request_id='null', status='success', abs_cobo_fee='0', created_time=1608260301987, last_time=1608260301987, confirmed_num=12, tx_detail=TxDetail{txid='0x2d7706b7976e5da8ce696dee05f78ffdfd1d544184b33582dbb434504432be8e', blocknum=11474579, blockhash='0x96d003facee421441277d405d1e63fae685ad16eea9aead13a27730117e15f8c', fee=0, actualgas=0, gasprice=0, hexstr=''}, source_address_detail='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', memo='null', confirming_threshold=12, fee_coin='null', fee_amount='null', fee_decimal=0, type='external', waiting_audit=false}, Transaction{id='20201218105454000388092000008595', coin='ETH', display_code='ETH', description='Ethereum', decimal=18, address='0x3b838adc736b1e9fc86b55ccbb576d8c5d55f9df', source_address='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', side='withdraw', amount='10000000000000000', abs_amount='0.01', txid='0x2d7706b7976e5da8ce696dee05f78ffdfd1d544184b33582dbb434504432be8e', vout_n=0, request_id='web_send_by_user_194_1608259983524', status='success', abs_cobo_fee='0', created_time=1608259983761, last_time=1608260300136, confirmed_num=12, tx_detail=TxDetail{txid='0x2d7706b7976e5da8ce696dee05f78ffdfd1d544184b33582dbb434504432be8e', blocknum=11474579, blockhash='0x96d003facee421441277d405d1e63fae685ad16eea9aead13a27730117e15f8c', fee=0, actualgas=1281000000000000, gasprice=1, hexstr=''}, source_address_detail='0x93d8cbb5354d06ddd7bc50ff2c71b5c0b6e1af66', memo='', confirming_threshold=12, fee_coin='ETH', fee_amount='4000000000000000', fee_decimal=18, type='external', waiting_audit=false}]
```
</details>


###  Withdrawal
#### Submit Withdraw Request
```java
ApiResponse<String> res = client.withdraw("TETH",
                "api_request_id_8888888",
                "0xb744adc8d75e115eec8e582eb5e8d60eb0972037",
                "1", null, "true", null);
```
<details>
<summary>View Response</summary>


```java
Response{success=true, error_code=0, error_message='null', error_id='null', error_description='null', result=}
```
</details>

#### Get Withdraw Information
```java
ApiResponse<Transaction> res = client.queryWithdrawInfo("teth29374893624");
```
<details>
<summary>View Response</summary>


```java
Transaction{id='20210511151005000324213000009776', coin='TETH', display_code='TETH', description='Ethereum Testnet', decimal=18, address='0xb744adc8d75e115eec8e582eb5e8d60eb0972037', source_address='0x7ca60000afea5a1730e40cf6b51abbf8b594ad91', side='withdraw', amount='1', abs_amount='0.000000000000000001', txid='0xd67169392144c9400224f07a6fe7efcfa4bf7e19445a361359c2c9530bca64d6', vout_n=0, request_id='teth29374893624', status='success', abs_cobo_fee='0', created_time=1620712218490, last_time=1620724457693, confirmed_num=32, tx_detail=TxDetail{txid='0xd67169392144c9400224f07a6fe7efcfa4bf7e19445a361359c2c9530bca64d6', blocknum=10212633, blockhash='0x444fe10d583194687c32223fd884dae82d0f0f2ebeacfb8040b4d83808253b59', fee=0, actualgas=21000000000000, gasprice=1, hexstr=''}, source_address_detail='0x7ca60000afea5a1730e40cf6b51abbf8b594ad91', memo='', confirming_threshold=32, fee_coin='TETH', fee_amount='4000000000000000', fee_decimal=18, type='external', waiting_audit=false}
```
</details>

### Staking

#### Get a Staking Product Details
```java
ApiResponse<List<StakingProduct>> res = client.getStakingProducts(null, Lang.CHINESE);
```
<details>
<summary>View Response</summary>


```java
StakingProduct{product_id=159145, name='DASH FP TEST', description='注：0.01 DASH起投，阶梯收益率，质押越多，收益率越高 质押后第二天开始产生收益，每10天根据转入时约定的收益率发放收益，选择【到期后自动续期】，无缝衔接下一期收益 随时可划出，T+1到账，收益周期内取出损失当期收益 每次取出赎回费: 0.01 DASH', doc_src='https://support.cobo.com/hc/zh-cn/articles/360023826033', coin='DASH', coin_decimal=8, reward_coin='DASH', reward_coin_decimal=8, unstake_fee='1000000', min_amount='1000000', rate='0.0002000000', rate_type=1, days=1, stake_type='masternode', lockup=true, start_stake_time=1621432800000, stop_stake_time=1621519200000, start_staking_time=1621526400000, stop_staking_time=1621612800000, liquidate_time=1621612800000, reward_liquidate_time=1621612800000, product_group='DASHFPTEST'}
```
</details>

#### Get All Staking Product List
```java
ApiResponse<List<StakingProduct>> res = client.getStakingProducts(null, Lang.CHINESE);
```
<details>
<summary>View Response</summary>


```java
[StakingProduct{product_id=159150, name='DASH FP TEST', description='hint: Min. 0.01 DASH, differential return rate, stake more, earn more Rewards start from the next day, will be released every 10 days according to the fixed rate, choose [Stake continuously] to earn continuously! Withdraw available anytime, return to wallet in T+1 Withdrawal fee per time: 0.01 DASH', doc_src='https://support.cobo.com/hc/en-us/articles/360023826033', coin='DASH', coin_decimal=8, reward_coin='DASH', reward_coin_decimal=8, unstake_fee='1000000', min_amount='1000000', rate='0.0002000000', rate_type=1, days=1, stake_type='masternode', lockup=true, start_stake_time=1621519200000, stop_stake_time=1621605600000, start_staking_time=1621612800000, stop_staking_time=1621699200000, liquidate_time=1621699200000, reward_liquidate_time=1621699200000, product_group='DASHFPTEST'}, StakingProduct{product_id=159146, name='ZEL FP TEST', description='Min. 30 ZEL, differential return rate, stake more, earn more Rewards start from the next day, will be released every day according to the fixed rate, choose [Stake continuously] to earn continuously! Withdraw available anytime, return to wallet in T+1 Withdrawal fee per time: 10 ZEL', doc_src='https://support.cobo.com/hc/en-us/articles/360025623054', coin='ZEL', coin_decimal=8, reward_coin='ZEL', reward_coin_decimal=8, unstake_fee='1000000000', min_amount='3000000000', rate='0.2000000000', rate_type=1, days=1, stake_type='masternode', lockup=false, start_stake_time=1621494000000, stop_stake_time=1621580400000, start_staking_time=1621612800000, stop_staking_time=1621699200000, liquidate_time=1621785600000, reward_liquidate_time=1621785600000, product_group='ZELFPTEST'}, StakingProduct{product_id=159148, name='ZEL FP TEST 2', description='Min. 30 ZEL, differential return rate, stake more, earn more Rewards start from the next day, will be released every day according to the fixed rate, choose [Stake continuously] to earn continuously! Withdraw available anytime, return to wallet in T+1 Withdrawal fee per time: 10 ZEL', doc_src='https://support.cobo.com/hc/en-us/articles/360025623054', coin='ZEL', coin_decimal=8, reward_coin='ZEL', reward_coin_decimal=8, unstake_fee='1000000000', min_amount='3000000000', rate='0.2000000000', rate_type=1, days=1, stake_type='masternode', lockup=false, start_stake_time=1621494000000, stop_stake_time=1621580400000, start_staking_time=1621612800000, stop_staking_time=1621699200000, liquidate_time=1621785600000, reward_liquidate_time=1621785600000, product_group='ZELFPTEST2'}, StakingProduct{product_id=159149, name='IOST PPS Wallet', description='IOST PPS Wallet', doc_src='https://support.cobo.com/hc/en-us/articles/360025765593', coin='IOST', coin_decimal=8, reward_coin='IOST', reward_coin_decimal=8, unstake_fee='5000000000', min_amount='10000000000', rate='0.1000000000', rate_type=2, days=1, stake_type='dpos', lockup=false, start_stake_time=1621494000000, stop_stake_time=1621580400000, start_staking_time=1621612800000, stop_staking_time=1621699200000, liquidate_time=1622304000000, reward_liquidate_time=1622304000000, product_group='IOSTPPSW'}, StakingProduct{product_id=159147, name='IOST FP TEST', description='Min. 1 IOST
Rewards start from the next day, will be released every day according to the dynamic reward, choose [Stake continuously] to earn continuously!
Withdraw available anytime, return to wallet in T+8 (7 days required by IOST)
Withdrawal fee per time: 1 IOST', doc_src='https://support.cobo.com/hc/en-us/articles/360023713454', coin='IOST', coin_decimal=8, reward_coin='IOST', reward_coin_decimal=8, unstake_fee='100000000', min_amount='100000000', rate='0.0001000000', rate_type=1, days=1, stake_type='dpos', lockup=false, start_stake_time=1621494000000, stop_stake_time=1621580400000, start_staking_time=1621612800000, stop_staking_time=1621699200000, liquidate_time=1622390400000, reward_liquidate_time=1622390400000, product_group='IOSTFPTEST'}]
```
</details>

#### Stake
```java
ApiResponse<Void> res = client.stake("159165", new BigInteger("1000000"));
```
<details>
<summary>View Response</summary>


```java
Response{success=true, error_code=0, error_message='null', error_id='null', error_description='null', result=null}
```
</details>

#### Unstake
```java
ApiResponse<Void> res = client.unstake("159165", new BigInteger("1000000"));
```
<details>
<summary>View Response</summary>


```java
Response{success=true, error_code=0, error_message='null', error_id='null', error_description='null', result=null}
```
</details>

#### Get Staking Data
```java
ApiResponse<List<StakingProduct>> res = client.getStakings(null, Lang.ENGLISG);
```
<details>
<summary>View Response</summary>


```java
[StakingData{staking_id=9456, coin='DASH', coin_decimal=8, amount=2000000, reward_coin='DASH', reward_coin_decimal=8, reward_amount=0, product=StakingProduct{product_id=159150, name='DASH FP TEST', description='hint: Min. 0.01 DASH, differential return rate, stake more, earn more Rewards start from the next day, will be released every 10 days according to the fixed rate, choose [Stake continuously] to earn continuously! Withdraw available anytime, return to wallet in T+1 Withdrawal fee per time: 0.01 DASH', doc_src='https://support.cobo.com/hc/en-us/articles/360023826033', coin='DASH', coin_decimal=8, reward_coin='DASH', reward_coin_decimal=8, unstake_fee='1000000', min_amount='1000000', rate='0.0002000000', rate_type=1, days=1, stake_type='masternode', lockup=true, start_stake_time=1621519200000, stop_stake_time=1621605600000, start_staking_time=1621612800000, stop_staking_time=1621699200000, liquidate_time=1621699200000, reward_liquidate_time=1621699200000, product_group='DASHFPTEST'}}]
```
</details>

#### Get Unstaking Data
```java
ApiResponse<List<Unstaking>> res = client.getUnstakings(null, Lang.ENGLISG);
```
<details>
<summary>View Response</summary>


```java
[]
```
</details>

#### Get All Staking History
```java
ApiResponse<List<StakingHistory>> res = client.getStakingHistory(null, null, null, null, null);
```
<details>
<summary>View Response</summary>


```java
[StakingHistory{activity_id='20210521155238000315481000001883', coin='DASH', amount='1000000', type='stake', time=1621583558551, product=StakingProduct{product_id=159150, name='DASH FP TEST', description='hint: Min. 0.01 DASH, differential return rate, stake more, earn more Rewards start from the next day, will be released every 10 days according to the fixed rate, choose [Stake continuously] to earn continuously! Withdraw available anytime, return to wallet in T+1 Withdrawal fee per time: 0.01 DASH', doc_src='https://support.cobo.com/hc/en-us/articles/360023826033', coin='DASH', coin_decimal=8, reward_coin='DASH', reward_coin_decimal=8, unstake_fee='1000000', min_amount='1000000', rate='0.0002000000', rate_type=1, days=1, stake_type='masternode', lockup=true, start_stake_time=1621519200000, stop_stake_time=1621605600000, start_staking_time=1621612800000, stop_staking_time=1621699200000, liquidate_time=1621699200000, reward_liquidate_time=1621699200000, product_group='DASHFPTEST'}, raw_type='0'}, StakingHistory{activity_id='20210521153656000323896000002896', coin='DASH', amount='1000000', type='stake', time=1621582616527, product=StakingProduct{product_id=159150, name='DASH FP TEST', description='hint: Min. 0.01 DASH, differential return rate, stake more, earn more Rewards start from the next day, will be released every 10 days according to the fixed rate, choose [Stake continuously] to earn continuously! Withdraw available anytime, return to wallet in T+1 Withdrawal fee per time: 0.01 DASH', doc_src='https://support.cobo.com/hc/en-us/articles/360023826033', coin='DASH', coin_decimal=8, reward_coin='DASH', reward_coin_decimal=8, unstake_fee='1000000', min_amount='1000000', rate='0.0002000000', rate_type=1, days=1, stake_type='masternode', lockup=true, start_stake_time=1621519200000, stop_stake_time=1621605600000, start_staking_time=1621612800000, stop_staking_time=1621699200000, liquidate_time=1621699200000, reward_liquidate_time=1621699200000, product_group='DASHFPTEST'}, raw_type='0'}, StakingHistory{activity_id='20210410000004000309420000008919', coin='IOST', amount='27', type='unstake', time=1617984004959, product=StakingProduct{product_id=158887, name='IOST FP TEST', description='Min. 1 IOST
Rewards start from the next day, will be released every day according to the dynamic reward, choose [Stake continuously] to earn continuously!
Withdraw available anytime, return to wallet in T+8 (7 days required by IOST)
Withdrawal fee per time: 1 IOST', doc_src='https://support.cobo.com/hc/en-us/articles/360023713454', coin='IOST', coin_decimal=8, reward_coin='IOST', reward_coin_decimal=8, unstake_fee='100000000', min_amount='100000000', rate='0.0001000000', rate_type=1, days=1, stake_type='dpos', lockup=false, start_stake_time=1617087600000, stop_stake_time=1617174000000, start_staking_time=1617206400000, stop_staking_time=1617292800000, liquidate_time=1617984000000, reward_liquidate_time=1617984000000, product_group='IOSTFPTEST'}, raw_type='-3'}, StakingHistory{activity_id='20210410000004000309420000008914', coin='IOST', amount='100000000', type='fee', time=1617984004749, product=StakingProduct{product_id=158887, name='IOST FP TEST', description='Min. 1 IOST
Rewards start from the next day, will be released every day according to the dynamic reward, choose [Stake continuously] to earn continuously!
Withdraw available anytime, return to wallet in T+8 (7 days required by IOST)
Withdrawal fee per time: 1 IOST', doc_src='https://support.cobo.com/hc/en-us/articles/360023713454', coin='IOST', coin_decimal=8, reward_coin='IOST', reward_coin_decimal=8, unstake_fee='100000000', min_amount='100000000', rate='0.0001000000', rate_type=1, days=1, stake_type='dpos', lockup=false, start_stake_time=1617087600000, stop_stake_time=1617174000000, start_staking_time=1617206400000, stop_staking_time=1617292800000, liquidate_time=1617984000000, reward_liquidate_time=1617984000000, product_group='IOSTFPTEST'}, raw_type='-5'}, StakingHistory{activity_id='20210410000004000309420000008913', coin='IOST', amount='135', type='unstake', time=1617984004745, product=StakingProduct{product_id=158887, name='IOST FP TEST', description='Min. 1 IOST
Rewards start from the next day, will be released every day according to the dynamic reward, choose [Stake continuously] to earn continuously!
Withdraw available anytime, return to wallet in T+8 (7 days required by IOST)
Withdrawal fee per time: 1 IOST', doc_src='https://support.cobo.com/hc/en-us/articles/360023713454', coin='IOST', coin_decimal=8, reward_coin='IOST', reward_coin_decimal=8, unstake_fee='100000000', min_amount='100000000', rate='0.0001000000', rate_type=1, days=1, stake_type='dpos', lockup=false, start_stake_time=1617087600000, stop_stake_time=1617174000000, start_staking_time=1617206400000, stop_staking_time=1617292800000, liquidate_time=1617984000000, reward_liquidate_time=1617984000000, product_group='IOSTFPTEST'}, raw_type='-2'}]
```
</details>

### Trading

### Transaction Notification
Doc: https://doc.custody.cobo.com/en.html#transaction-notification

Demo: src/main/com/cobo/api/client/callback/Demo.java

### Withdrawal Confirmation
Doc: https://doc.custody.cobo.com/en.html#withdrawal-confirmation

Demo: src/main/com/cobo/api/client/callback/Demo.java

### Web3
Demo: src/test/java/com/cobo/api/client/impl/CoboWeb3ApiRestClientImplTest.java
