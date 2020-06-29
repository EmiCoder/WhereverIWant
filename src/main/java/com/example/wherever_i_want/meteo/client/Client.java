package com.example.wherever_i_want.meteo.client;

import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import com.example.wherever_i_want.meteo.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.springframework.web.util.UriComponentsBuilder.*;

@Component
public class Client {


    @Autowired
    private RestTemplate restTemplate;


    public MeteostatStationTemperaturesDto getMeteostatTemperaturesDto()  {
        return restTemplate.getForObject(buildURI(),MeteostatStationTemperaturesDto.class);
    }



    public URI buildURI() {
        return fromHttpUrl("https://api.meteostat.net/v1/climate/normals?station=01026&key=erPSGcB5")
                .build().encode().toUri();
    }

}
