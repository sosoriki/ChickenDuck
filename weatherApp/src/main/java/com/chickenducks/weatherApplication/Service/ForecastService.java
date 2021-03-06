package com.chickenducks.weatherApplication.Service;


import com.chickenducks.weatherApplication.Model.forecastModel.Forecast;
import com.chickenducks.weatherApplication.Model.forecastModel.ForecastResponse;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;
import java.util.List;

public interface ForecastService {


    List<Forecast> forecast(ResponseEntity<ForecastResponse> forecastResponse);
    ZonedDateTime convertLocalTime(String timezoneId, long timestamp );
    String getTimezoneId(double lat,double lng,long timestamp);
    String convertDegreeToDirection(double degree);
}