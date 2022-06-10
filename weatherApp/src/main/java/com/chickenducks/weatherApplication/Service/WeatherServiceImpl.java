package com.chickenducks.weatherApplication.Service;

import java.util.List;

import com.chickenducks.weatherApplication.Model.Weather;
import com.chickenducks.weatherApplication.Model.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class WeatherServiceImpl implements WeatherService {


    @Override
    public Weather weather(ResponseEntity<WeatherResponse> weatherResponse) {
        Weather weather = new Weather();
        weather.setLatitude(weatherResponse.getBody().getCoordinate().getLat());
        weather.setLongitude(weatherResponse.getBody().getCoordinate().getLon());
        weather.setMax_temp(weatherResponse.getBody().getTemperature().getTemp_max());
        weather.setMin_temp(weatherResponse.getBody().getTemperature().getTemp_min());
        weather.setTemp(weatherResponse.getBody().getTemperature().getTemp());
        weather.setCondition(weatherResponse.getBody().getCondition()[0].getMain());
        weather.setDescription(weatherResponse.getBody().getCondition()[0].getDescription());
        weather.setFormattedAddress(weatherResponse.getBody().getFormattedAddress());

        weather.setDeg(weatherResponse.getBody().getWind().getDeg());
        weather.setSpeed(weatherResponse.getBody().getWind().getSpeed());
        weather.setHumidity(weatherResponse.getBody().getTemperature().getHumidity());
        weather.setFeels_like(weatherResponse.getBody().getTemperature().getFeels_like());
        weather.setPressure(weatherResponse.getBody().getTemperature().getPressure());
        weather.setHumidity(weatherResponse.getBody().getTemperature().getHumidity());
        weather.setIconUrl(weatherResponse.getBody().getCondition()[0].getIcon());  // not finish


        return weather;

    }
}
