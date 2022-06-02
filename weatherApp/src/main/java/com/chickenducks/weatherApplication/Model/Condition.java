package com.chickenducks.weatherApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Condition {
    private String main;
    private String description;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
