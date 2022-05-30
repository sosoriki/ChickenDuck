package com.chickenducks.weatherApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomePage {

//    @GetMapping("/")
//    public ModelAndView homepage(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("weatherApplication/src/app/app.component.html");
//        return modelAndView;
//    }
    @GetMapping("/weather")
    public String getWeather(){
        return "Rain";
    }

}
