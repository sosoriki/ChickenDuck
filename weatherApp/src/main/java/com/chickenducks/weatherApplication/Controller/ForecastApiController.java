package com.chickenducks.weatherApplication.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chickenducks.weatherApplication.Model.ForecastResponse;

@RestController
public class ForecastApiController {
	private static final String APIKEY = "";
	
	@RequestMapping("/getForecastApi/lat={lat}&lon={lon}")
	public ForecastResponse getForecast(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
		ResponseEntity<ForecastResponse> response = new RestTemplate().
				getForEntity("https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY + "&units=imperial", ForecastResponse.class);
	 	System.out.println(response.getBody());
	 	response.toString();
	 	return response.getBody();
	}

}