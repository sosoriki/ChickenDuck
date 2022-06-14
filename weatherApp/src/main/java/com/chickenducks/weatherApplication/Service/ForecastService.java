package com.chickenducks.weatherApplication.Service;


import com.chickenducks.weatherApplication.Model.Forecast;
import com.chickenducks.weatherApplication.Model.ForecastResponse;
import org.springframework.http.ResponseEntity;

public interface ForecastService {


    Forecast forecast(ResponseEntity<ForecastResponse> forecastResponse);

}