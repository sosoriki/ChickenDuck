package com.chickenducks.weatherApplication.Model.forecastModel;


import com.chickenducks.weatherApplication.Model.Condition;
import com.chickenducks.weatherApplication.Model.Wind;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class List {
    private Main main;

    @JsonProperty("weather")
    private Condition[] condition;

    private Wind wind;
    @JsonProperty("dt_txt")
    private String date;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Condition[] getCondition() {
        return condition;
    }

    public void setCondition(Condition[] condition) {
        this.condition = condition;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "List{" +
                "main=" + main +
                ", condition=" + Arrays.toString(condition) +
                ", wind=" + wind +
                ", date='" + date + '\'' +
                '}';
    }
}
