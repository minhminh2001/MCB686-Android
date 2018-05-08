package com.mc.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseArrayResponse {
    @JsonProperty("data")
    private ArrayResponse data;
    @JsonProperty("message")
    private String message;

    public ArrayResponse getData() {
        return data;
    }

    public void setData(ArrayResponse data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseArrayResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
