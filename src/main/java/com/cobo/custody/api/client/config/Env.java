package com.cobo.custody.api.client.config;

public class Env {
    public static Env SANDBOX = new Env("https://api.sandbox.cobo.com", "032f45930f652d72e0c90f71869dfe9af7d713b1f67dc2f7cb51f9572778b9c876");
    public static Env DEV = new Env("https://api.dev.cobo.com","03596da539963fb1dd29d5859e25903eb76b9f7ed2d58516e29c9f80c201ff2c1b");
    public static Env PROD = new Env("https://api.custody.cobo.com", "02c3e5bacf436fbf4da78597e791579f022a2e85073ae36c54a361ff97f2811376");

    public String host;
    public String coboPub;

    public Env(String host, String coboPub) {
        this.host = host;
        this.coboPub = coboPub;
    }

}
