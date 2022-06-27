package com.chickenducks.weatherApplication.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chickenducks.weatherApplication.Model.forecastModel.Forecast;
import com.chickenducks.weatherApplication.Model.forecastModel.ForecastResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService{
	private double latitude;
	private double longitude;
	private double temp;
	private double max_temp;
	private double min_temp;
	private String condition;
	private String description;


	private double feels_like;
	private double pressure;
	private double humidity;
	private String iconUrl;
	private double speed;
	private double deg;
	private double gust;

	@Override
	 public List<Forecast> forecast(ResponseEntity<ForecastResponse> forecastResponse) {
		List<Forecast> forecastList = new ArrayList<Forecast>();

		for (int i =0;i<40;i++) {
			Forecast forecast = new Forecast();
			forecast.setLatitude(forecastResponse.getBody().getCity().getCoordinate().getLat());
			forecast.setLongitude(forecastResponse.getBody().getCity().getCoordinate().getLon());
			forecast.setMax_temp(forecastResponse.getBody().getList()[i].getMain().getTemp_max());
			forecast.setMin_temp(forecastResponse.getBody().getList()[i].getMain().getTemp_min());
			forecast.setTemp(forecastResponse.getBody().getList()[i].getMain().getTemp());
			forecast.setCondition(forecastResponse.getBody().getList()[i].getCondition()[0].getMain());
			forecast.setDescription(forecastResponse.getBody().getList()[i].getCondition()[0].getDescription());
			//weather detail
			forecast.setDate(forecastResponse.getBody().getList()[i].getDate());
			forecast.setDeg(forecastResponse.getBody().getList()[i].getWind().getDeg());
			forecast.setSpeed(forecastResponse.getBody().getList()[i].getWind().getSpeed());
			forecast.setGust(forecastResponse.getBody().getList()[i].getWind().getGust());
			forecast.setHumidity(forecastResponse.getBody().getList()[i].getMain().getHumidity());
			forecast.setFeels_like(forecastResponse.getBody().getList()[i].getMain().getFeels_like());
			forecast.setPressure(forecastResponse.getBody().getList()[i].getMain().getPressure());
			forecast.setHumidity(forecastResponse.getBody().getList()[i].getMain().getHumidity());
			forecast.setIconUrl(forecastResponse.getBody().getList()[i].getCondition()[0].getIcon());  // not finish
			forecastList.add(forecast);
		}
		 return forecastList;
	 }

}
