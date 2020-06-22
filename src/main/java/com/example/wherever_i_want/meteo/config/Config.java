package com.example.wherever_i_want.meteo.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Config {

    @Value("${meteostat.api.endpoint.prod}")
    private String meteostatApiEndpoint;

    @Value("${meteostat.app.key}")
    private String meteostatAppKey;


}
