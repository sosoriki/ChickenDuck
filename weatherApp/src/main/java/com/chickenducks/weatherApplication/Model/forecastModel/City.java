package com.chickenducks.weatherApplication.Model.forecastModel;

import com.chickenducks.weatherApplication.Model.Coordinate;
import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
    @JsonProperty("coord")
    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
