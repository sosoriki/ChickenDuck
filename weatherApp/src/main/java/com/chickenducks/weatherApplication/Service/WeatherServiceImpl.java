package com.chickenducks.weatherApplication.Service;

import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {


    //TODO:get latitude,longitude from geocode API,collect data from Weather API

    @Override
    public double getLatitude(String zipcode) {
        return -77.0364;
    }

    @Override
    public double getLongitude(String zipcode) {
        return 66.0134;
    }

    @Override
    public Integer getMaxWeather(double latitude, double longitude) {
        return 90;
    }

    @Override
    public Integer getMinWeather(double latitude, double longitude) {
        return 80;
    }


}
