package com.example.wherever_i_want.controller;
import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import com.example.wherever_i_want.meteostat.client.StationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.wherever_i_want.meteostat.client.Client;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/meteostat")
public class MeteostatController {

    @Autowired
    private Client client;

    @RequestMapping(value = "/getStationTemperatures", method = RequestMethod.GET)
    public MeteostatStationTemperaturesDto getMeteostatStationTemperatures() {
        return client.getMeteostatTemperaturesDto();
    }
}
