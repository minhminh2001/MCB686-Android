package com.mc.models.home;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProgramStudy {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;

    public ProgramStudy(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProgramStudy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
