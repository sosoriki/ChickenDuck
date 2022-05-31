package com.chickenducks.weatherApplication.repo;

import com.chickenducks.weatherApplication.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepo extends JpaRepository<Weather, Integer> {

}
