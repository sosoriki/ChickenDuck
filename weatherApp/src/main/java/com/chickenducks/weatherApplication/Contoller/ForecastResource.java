package com.chickenducks.weatherApplication.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.chickenducks.weatherApplication.Model.Forecast;
import com.chickenducks.weatherApplication.Model.ForecastResponse;
import com.chickenducks.weatherApplication.Service.ForecastService;

@RestController
public class ForecastResource {
	private final ForecastService forecastServiceImpl;
	
	@Autowired
    public ForecastResource(ForecastService forecastService) {
        forecastServiceImpl = forecastService;
    }
	
	 @GetMapping("/getForecast/location/{address}")
	 public ResponseEntity<Forecast> getForecast(@PathVariable String address ) {
		 UriComponents uri = UriComponentsBuilder.newInstance()
				 .scheme("http")
				 .host("localhost:8080")
				 .path("getForecast")
				 .queryParam("address", address)
				 .build();
		 System.out.println(uri.toUriString());
		 // calling /getforecast interface in GeocodeApiController
		 ResponseEntity<ForecastResponse> forecastResponse = new RestTemplate().getForEntity(uri.toUriString(), ForecastResponse.class);
		 Forecast forecast = forecastServiceImpl.forecast(forecastResponse);
		 System.out.println(forecast.toString());
		 return new ResponseEntity<Forecast>(forecast, HttpStatus.OK);
    }

}
