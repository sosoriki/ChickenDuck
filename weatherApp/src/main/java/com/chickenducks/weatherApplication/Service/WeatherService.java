package com.chickenducks.weatherApplication.Service;


public interface WeatherService {

    double getLatitude(String zipcode);

    double getLongitude(String zipcode);

    Integer getMaxWeather(double latitude, double longitude);

    Integer getMinWeather(double latitude, double longitude);


}
