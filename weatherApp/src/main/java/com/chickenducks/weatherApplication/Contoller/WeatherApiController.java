package com.chickenducks.weatherApplication.Contoller;


import com.chickenducks.weatherApplication.Model.Response;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class WeatherApiController {


    private static final String APIKEY = "9846d9ed0f08a27e943b6150269d6330";

    @RequestMapping("/testing")
    public String testing(){
        return "test";
    }
    //Put in the latitude and longitude, api will send back response contain lots of weather information
    @RequestMapping("/getWeatherApi/lat={lat}&lon={lon}")
    public Response getWeather(@PathVariable("lat") double lat, @PathVariable("lon") double lon){
        ResponseEntity<Response> response = new RestTemplate().
                getForEntity("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+APIKEY,Response.class);

        return response.getBody();
    }




}
