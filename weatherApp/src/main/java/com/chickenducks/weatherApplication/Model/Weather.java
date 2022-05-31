package com.chickenducks.weatherApplication.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Weather implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String zipcode;
    private double latitude;
    private double longitude;
    private int max_temp;
    private int min_temp;

    public Weather(String zipcode, Long latitude, Long longitude, int max_temp, int min_temp) {
        this.zipcode = zipcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.max_temp = max_temp;
        this.min_temp = min_temp;
    }

    public Weather() {
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(int max_temp) {
        this.max_temp = max_temp;
    }

    public int getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(int min_temp) {
        this.min_temp = min_temp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "zipcode='" + zipcode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", max_temp=" + max_temp +
                ", min_temp=" + min_temp +
                '}';
    }
}
