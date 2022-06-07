package com.chickenducks.weatherApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

//Response from weather API
public class WeatherResponse {
    @JsonProperty("coord")
    private Coordinate coordinate;
    @JsonProperty("weather")
    private Condition[] condition;

    @JsonProperty("main")
    private Temperature temperature;

    private String formattedAddress;

    private String cod;

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

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "coordinate=" + coordinate +
                ", condition=" + Arrays.toString(condition) +
                ", temperature=" + temperature +
                ", formattedAddress='" + formattedAddress + '\'' +
                ", cod='" + cod + '\'' +
                '}';
    }
}
