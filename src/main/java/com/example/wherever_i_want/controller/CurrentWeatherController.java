package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.dto.CurrentWeatherDto;
import com.example.wherever_i_want.domain.dto.MainDto;
import com.example.wherever_i_want.meteo.client.CurrentWeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/currentWeather")
public class CurrentWeatherController {

    @Autowired
    private CurrentWeatherClient currentWeatherClient;

    @GetMapping(value = "/getCurrentWeather/{cityName}")
    public CurrentWeatherDto getCurrentWeather(@PathVariable String cityName) {
        try {
           return currentWeatherClient.getCurrentWeather(cityName);
        } catch (HttpClientErrorException e) {
            e.getStackTrace();
        } return new CurrentWeatherDto(new MainDto(0, 0, 0));
    }
}
