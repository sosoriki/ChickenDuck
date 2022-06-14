package com.chickenducks.weatherApplication.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chickenducks.weatherApplication.Model.Forecast;
import com.chickenducks.weatherApplication.Model.ForecastResponse;

@Service
public class ForecastServiceImpl implements ForecastService{
	
	 @Override
	 public Forecast forecast(ResponseEntity<ForecastResponse> forecastResponse) {
		 Forecast forecast = new Forecast();
		 forecast.setMax_temp(forecastResponse.getBody().getTemperature().getTemp_max());
		 forecast.setMin_temp(forecastResponse.getBody().getTemperature().getTemp_min());
		 forecast.setTemp(forecastResponse.getBody().getTemperature().getTemp());
		 forecast.setCondition(forecastResponse.getBody().getCondition()[0].getMain());
		 forecast.setDescription(forecastResponse.getBody().getCondition()[0].getDescription());
		 forecast.setDate(forecastResponse.getBody().getDate().getDate());
		 forecast.setFormattedAddress(forecastResponse.getBody().getFormattedAddress());
		 return forecast;
	 }

}
