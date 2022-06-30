package com.chickenducks.weatherApplication.Controller;

import com.chickenducks.weatherApplication.Model.*;
import com.chickenducks.weatherApplication.Model.forecastModel.Forecast;
import com.chickenducks.weatherApplication.Model.forecastModel.ForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.chickenducks.weatherApplication.Service.ForecastService;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ForecastResource {
	private final ForecastService forecastServiceImpl;
	private static final String GEOCODEAPIKEY = "";
	private static final String WEATHERAPIKEY = "";
	@Autowired
    public ForecastResource(ForecastService forecastService) {
        forecastServiceImpl = forecastService;
    }

	@GetMapping("/getForecast/location/{address}")
	 public ResponseEntity<List<Forecast>> getForecast(@PathVariable String address ) {
			 UriComponents uri = UriComponentsBuilder.newInstance()
					 .scheme("https")
					 .host("maps.googleapis.com")
					 .path("maps/api/geocode/json")
					 .queryParam("key", GEOCODEAPIKEY)
					 .queryParam("address", address)
					 .build();
			 System.out.println(uri.toUriString());
			 ResponseEntity<GeocoderResponse> response = new RestTemplate().getForEntity(uri.toUriString(), GeocoderResponse.class);
			 //extract the lag lng from response from geocode api
			 GeocoderResponse geocoderResponse = response.getBody();
			 double lat = geocoderResponse.getResult()[0].getGeometry().getLocation().getLat();
			 double lon = geocoderResponse.getResult()[0].getGeometry().getLocation().getLng();
			 ResponseEntity<ForecastResponse> forecastResponse = new RestTemplate().
					 getForEntity("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + WEATHERAPIKEY + "&units=imperial", ForecastResponse.class);
			 List<Forecast> forecastList = forecastServiceImpl.forecast(forecastResponse);
	System.out.println(forecastList);
			 return new ResponseEntity<>(forecastList, HttpStatus.OK);



		 }

}
