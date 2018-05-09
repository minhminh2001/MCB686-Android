package com.mc.models.gift;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GiftResponse {

    public GiftResponse(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GiftResponse{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
