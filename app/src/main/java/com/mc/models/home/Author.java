package com.mc.models.home;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;

    public Author(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
