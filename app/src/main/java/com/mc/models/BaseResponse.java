package com.mc.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse<T> {
    @JsonProperty("data")
    private T data;
    @JsonProperty("message")
    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
        return "BaseResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
