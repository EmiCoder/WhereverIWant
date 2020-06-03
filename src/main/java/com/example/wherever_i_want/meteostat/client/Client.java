package com.example.wherever_i_want.meteostat.client;

import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import com.example.wherever_i_want.domain.dto.TemperatureDto;
import com.example.wherever_i_want.meteostat.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Client {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Config config;

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);


    public List<MeteostatStationTemperaturesDto> getMeteostatTemperaturesDto() {

        MeteostatStationTemperaturesDto[] temperaturesResponse = restTemplate.getForObject(
                                                                    buildURI(),MeteostatStationTemperaturesDto[].class);
        if (temperaturesResponse != null) {
            return Arrays.asList(temperaturesResponse);
        } return new ArrayList<>();

    }


//    public MeteostatStationTemperaturesDto getMeteostatTemperaturesDto() {
//
//        MeteostatStationTemperaturesDto temperaturesResponse = restTemplate.getForObject(
//                buildURI(),MeteostatStationTemperaturesDto.class);
//        if (temperaturesResponse != null) {
//            return temperaturesResponse;
//        } return new MeteostatStationTemperaturesDto();
//
//    }

    public URI buildURI() {
        return UriComponentsBuilder.fromHttpUrl("https://api.meteostat.net/v1/climate/normals?station=71964&key=erPSGcB5")
//                .queryParam("station", "71964")
//                .queryParam("key", "erPSGcB5")
                .build().encode().toUri();
    }
}
