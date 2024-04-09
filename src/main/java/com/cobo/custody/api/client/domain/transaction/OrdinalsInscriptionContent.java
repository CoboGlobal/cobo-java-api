package com.cobo.custody.api.client.domain.transaction;

public class OrdinalsInscriptionContent {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "OrdinalsInscriptionContent{" +
                "content='" + content + '\'' +
                '}';
    }
}
