package com.chickenducks.weatherApplication.Contoller;


import com.chickenducks.weatherApplication.Model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class WeatherApiController {


    //get API key from google doc and remember to remove when push
    private static final String APIKEY = "";

    @RequestMapping("/testing")
    public String testing() {
        return "test";
    }

    @RequestMapping("/getWeatherApi/lat={lat}&lon={lon}")
    public Response getWeather(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
        ResponseEntity<Response> response = new RestTemplate().
                getForEntity("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + APIKEY + "&units=imperial", Response.class);

        return response.getBody();
    }


}
