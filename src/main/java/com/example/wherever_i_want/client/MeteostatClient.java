package com.example.wherever_i_want.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MeteostatClient {

    @Autowired
    private RestTemplate restTemplate;
}
