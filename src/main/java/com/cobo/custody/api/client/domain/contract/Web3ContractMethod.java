package com.cobo.custody.api.client.domain.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Web3ContractMethod {
    private String type;
    @JsonProperty(value = "method_name")
    private String methodName;
    @JsonProperty(value = "method_id")
    private String methodId;
    private String inputs;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getInputs() {
        return inputs;
    }

    public void setInputs(String inputs) {
        this.inputs = inputs;
    }

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                "method_name='" + methodName + '\'' +
                "method_id='" + methodId + '\'' +
                "inputs='" + inputs + '\'' +
                '}';
    }
}
