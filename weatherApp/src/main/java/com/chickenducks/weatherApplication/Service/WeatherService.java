package com.chickenducks.weatherApplication.Service;


import com.chickenducks.weatherApplication.Model.Weather;
import com.chickenducks.weatherApplication.Model.WeatherResponse;
import org.springframework.http.ResponseEntity;

public interface WeatherService {


    Weather weather(ResponseEntity<WeatherResponse> weatherResponse);

}
