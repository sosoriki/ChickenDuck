package com.chickenducks.weatherApplication.repo;

import com.chickenducks.weatherApplication.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;



public interface WeatherRepo extends JpaRepository<Weather, String> {
    //No use for now
}
