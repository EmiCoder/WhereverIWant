package com.example.wherever_i_want.meteostat.client;

import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import com.example.wherever_i_want.meteostat.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MeteostatClient {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Config config;

    public List<MeteostatStationTemperaturesDto> getMeteostatTemperaturesDto() {

        URI url = UriComponentsBuilder.fromHttpUrl(config.getMeteostatApiEndpoint())
                .queryParam("station", "71964")
                .queryParam("key", config.getMeteostatAppKey())
                .build().encode().toUri();

        MeteostatStationTemperaturesDto[] temperaturesResponse = restTemplate.getForObject(
                                                                    url,MeteostatStationTemperaturesDto[].class);
        if (temperaturesResponse != null) {
            return Arrays.asList(temperaturesResponse);
        } return new ArrayList<>();
    }
}
