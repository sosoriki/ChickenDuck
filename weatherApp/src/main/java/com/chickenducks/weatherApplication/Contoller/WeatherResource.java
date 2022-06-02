package com.chickenducks.weatherApplication.Contoller;

import com.chickenducks.weatherApplication.Model.Response;
import com.chickenducks.weatherApplication.Model.Weather;
import com.chickenducks.weatherApplication.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class WeatherResource {
    private final WeatherService weatherServiceImpl;

    @Autowired
    public WeatherResource(WeatherService weatherService) {
        weatherServiceImpl = weatherService;
    }

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<String>("Hello my friend, it is raining..", HttpStatus.OK);
        //return  ResponseEntity.ok("Hello my friend, it is raining..");
    }

    //This method will be changed in the future update
    @GetMapping("/getWeather/location/{address}")
    public ResponseEntity<Weather> getWeather(@PathVariable String address) {

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost:8080")
                .path("getWeather")
                .queryParam("address", address)
                .build();
        System.out.println(uri.toUriString());
        ResponseEntity<Response> response = new RestTemplate().getForEntity(uri.toUriString(), Response.class);
        Weather weather = new Weather();
        weather.setLatitude(response.getBody().getCoordinate().getLat());
        weather.setLongitude(response.getBody().getCoordinate().getLon());
        weather.setMax_temp(response.getBody().getTemperature().getTemp_max());
        weather.setMin_temp(response.getBody().getTemperature().getTemp_min());
        weather.setTemp(response.getBody().getTemperature().getTemp());
        weather.setCondition(response.getBody().getCondition()[0].getMain());
        weather.setDescription(response.getBody().getCondition()[0].getDescription());
        return new ResponseEntity<Weather>(weather, HttpStatus.OK);
    }


}
