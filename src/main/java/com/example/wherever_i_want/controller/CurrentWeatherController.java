package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.dto.CurrentWeatherDto;
import com.example.wherever_i_want.meteostat.client.CurrentWeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currentWeather")
public class CurrentWeatherController {

    @Autowired
    private CurrentWeatherClient currentWeatherClient;

    @GetMapping(value = "/getCurrentWeather/{cityName}")
    public CurrentWeatherDto getCurrentWeather(@PathVariable String cityName) {
        return currentWeatherClient.getCurrentWeather(cityName);
    }
}
