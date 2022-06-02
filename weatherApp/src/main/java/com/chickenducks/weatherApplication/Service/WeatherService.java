package com.chickenducks.weatherApplication.Service;


import com.chickenducks.weatherApplication.Model.Weather;

public interface WeatherService {

    double getLatitude(String zipcode);

    double getLongitude(String zipcode);

    Integer getMaxWeather(double latitude, double longitude);

    Integer getMinWeather(double latitude, double longitude);


}
