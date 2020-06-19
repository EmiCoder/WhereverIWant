package com.example.wherever_i_want.meteostat.client;

import com.example.wherever_i_want.domain.dto.CurrentWeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class CurrentWeatherClient {

    @Value("${weather.api.endpoint.prod}")
    private String weatherApiEndpoint;
    @Value("${weather.app.key}")
    private String weatherAppKey;

    @Autowired
    private RestTemplate restTemplate;

    private static final double TEMPERATURE_INDICATOR =  273.15;

    public CurrentWeatherDto getCurrentWeather(String cityName) {
            CurrentWeatherDto currentWeatherDto = restTemplate.getForObject(prepareURI(cityName), CurrentWeatherDto.class);
            changeKelvinToCelcius(currentWeatherDto);
         return currentWeatherDto;
    }

    private void changeKelvinToCelcius(CurrentWeatherDto currentWeatherDto) {
        currentWeatherDto.getMainDto().setFeels_like((int)(currentWeatherDto.getMainDto().getFeels_like() - TEMPERATURE_INDICATOR));
    }

    private URI prepareURI(String cityName) {
        return UriComponentsBuilder.fromHttpUrl(weatherApiEndpoint)
                .queryParam("q", cityName)
                .queryParam("appid", weatherAppKey).build().encode().toUri();
    }
}
