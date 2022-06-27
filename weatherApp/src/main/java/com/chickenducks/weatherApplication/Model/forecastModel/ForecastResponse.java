package com.chickenducks.weatherApplication.Model.forecastModel;

import com.chickenducks.weatherApplication.Model.Temperature;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class ForecastResponse {


    private List[] list;
    private City city;

    public List[] getList() {
        return list;
    }


    public void setList(List[] list) {
        this.list = list;
    }



    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ForecastResponse{" +
                "list=" + Arrays.toString(list) +
                ", city=" + city +
                '}';
    }
}
