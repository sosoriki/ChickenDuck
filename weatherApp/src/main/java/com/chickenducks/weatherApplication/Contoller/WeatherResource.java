package com.chickenducks.weatherApplication.Contoller;

import com.chickenducks.weatherApplication.Model.Weather;
import com.chickenducks.weatherApplication.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/getWeather/{zipcode}")
    public ResponseEntity<Weather> getWeather(@PathVariable String zipcode) {
        //TODO: After finish set up API, this method might be removed or changed
        Weather weather = new Weather();
        weather.setZipcode(zipcode);
        weather.setLatitude(weatherServiceImpl.getLatitude(zipcode));
        weather.setLongitude(weatherServiceImpl.getLongitude(zipcode));
        weather.setMax_temp(weatherServiceImpl.getMaxWeather(weatherServiceImpl.getLatitude(zipcode), weatherServiceImpl.getLongitude(zipcode)));
        weather.setMin_temp(weatherServiceImpl.getMinWeather(weatherServiceImpl.getLatitude(zipcode), weatherServiceImpl.getLongitude(zipcode)));

        return new ResponseEntity<Weather>(weather, HttpStatus.OK);
    }


}