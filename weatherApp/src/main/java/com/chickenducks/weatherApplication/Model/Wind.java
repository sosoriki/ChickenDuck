package com.chickenducks.weatherApplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Wind {
        private double speed;
        private double deg;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

}
