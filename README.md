# The Official Java SDK for Cobo WaaS API

![JitPack](https://jitpack.io/v/CoboGlobal/cobo-java-api.svg)
[![License: GPL v2](https://img.shields.io/badge/License-GPL_v2-blue.svg)](https://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html)
[![GitHub Release](https://img.shields.io/github/release/CoboGlobal/cobo-java-api.svg?style=flat)]()

## About
This repository contains the official Java SDK for Cobo WaaS API, enabling developers to integrate with Cobo's Custodial and/or MPC services seamlessly using the Java programming language.

## Documentation
To access the API documentation, navigate to the [API references](https://www.cobo.com/developers/api-references/overview/).

For more information on Cobo's Java SDK, refer to the [Java SDK Guide](https://www.cobo.com/developers/sdks-and-tools/sdks/waas/java).

## Usage

### Before You Begin
Ensure that you have created an account and configured Cobo's Custodial and/or MPC services. 
For detailed instructions, please refer to the [Quickstart](https://www.cobo.com/developers/get-started/overview/quickstart) guide.

### Requirements
- JDK8 
- JDK17 or newer

### Installation
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
    implementation 'com.github.CoboGlobal:cobo-java-api:v0.71'
}
```

maven:

```
<dependency>
    <groupId>com.github.CoboGlobal</groupId>
    <artifactId>cobo-java-api</artifactId>
    <version>v0.71</version>
</dependency>
```

### Code Sample
#### Generate Key Pair
```java
import com.cobo.custody.api.client.impl.LocalSigner;

String[] key = LocalSigner.generateKeyPair();
String secretKey = key[0];
String apiKey = key[1];
```
For more information on the API key, please [click here](https://www.cobo.com/developers/api-references/overview/authentication).

#### Initialize ApiSigner
`ApiSigner` can be instantiated through `new LocalSigner("secretkey" )`


In certain scenarios, the private key may be restricted from export, such as when it is stored in AWS Key Management Service (KMS). 
In such cases, please pass in a custom implementation using the ApiSigner interface:
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

#### Initialize RestClient
These can be instantiated using the corresponding factory method provided by `CoboApiClientFactory`.

```java
import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboApiRestClient;
import com.cobo.custody.api.client.config.CoboApiConfig;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.impl.LocalSigner;

CoboApiRestClient client = CoboApiClientFactory.newInstance(
                new LocalSigner(apiSecret),
                Env.DEV,
                false).newRestClient();
```

#### Complete Code Sample
```java
import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboApiRestClient;
import com.cobo.custody.api.client.config.CoboApiConfig;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.impl.LocalSigner;

String[] key = LocalSigner.generateKeyPair();
String secretKey = key[0];
String apiKey = key[1];

CoboApiRestClient client = CoboApiClientFactory.newInstance(
                new LocalSigner(secretKey),
                Env.DEV,
                false).newRestClient();
                
ApiResponse<OrgInfo> orgInfo = client.getOrgInfo()
System.out.println(orgInfo);
```