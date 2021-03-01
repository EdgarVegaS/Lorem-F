package com.lorem.otaku.models;

import com.fasterxml.jackson.databind.JsonNode;

public class ServiceResponse {

    private String responseCode;
    private JsonNode responseMessage;

    public ServiceResponse(String responseCode, JsonNode responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public JsonNode getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(JsonNode responseMessage) {
        this.responseMessage = responseMessage;
    }
    
}
