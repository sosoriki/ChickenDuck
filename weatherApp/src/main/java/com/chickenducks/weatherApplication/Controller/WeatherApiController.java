package com.chickenducks.weatherApplication.Controller;


import com.chickenducks.weatherApplication.Model.WeatherResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class WeatherApiController {


    //get API key from google doc and remember to remove when push
    private static final String APIKEY = "";

    @RequestMapping("/getMessage")
    public String testing() {
        return "test";
    }

    /**
     * @param lat latitude of the place
     * @param lon longitude of the place
     * @return a weather report of the place
     */
    @RequestMapping("/getWeatherApi/lat={lat}&lon={lon}")
    public WeatherResponse getWeather(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
        ResponseEntity<WeatherResponse> response = new RestTemplate().
                getForEntity("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY + "&units=imperial", WeatherResponse.class);

        return response.getBody();
    }

}
