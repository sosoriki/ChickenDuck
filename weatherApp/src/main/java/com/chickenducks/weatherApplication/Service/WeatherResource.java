package com.chickenducks.weatherApplication.Service;

import com.chickenducks.weatherApplication.Model.Weather;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherResource {


    @GetMapping("/getWeather")
    public ResponseEntity<String> getWeather(){
        return new ResponseEntity<String>("Hello my friend, it is raining..", HttpStatus.OK);
        //return  ResponseEntity.ok("Hello my friend, it is raining..");
    }

}
