package com.chickenducks.weatherApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

//Response from weather API
public class Response {
    @JsonProperty("coord")
    private Coordinate coordinate;
    @JsonProperty("weather")
    private Condition[] condition;

    @JsonProperty("main")
    private Temperature temperature;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Condition[] getCondition() {
        return condition;
    }

    public void setCondition(Condition[] condition) {
        this.condition = condition;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
