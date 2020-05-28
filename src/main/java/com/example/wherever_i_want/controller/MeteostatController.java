package com.example.wherever_i_want.controller;
import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.wherever_i_want.meteostat.client.Client;

import java.util.List;

@RestController
@RequestMapping("/meteostat")
public class MeteostatController {

    @Autowired
    private Client client;

    @RequestMapping(method = RequestMethod.GET, value = "/getStationTemperatures")
    public void getMeteostatStationTemperatures() {
        List<MeteostatStationTemperaturesDto> temperaturesDtos = client.getMeteostatTemperaturesDto();
        temperaturesDtos.forEach(meteostatStationTemperaturesDto -> meteostatStationTemperaturesDto
                                                                            .getDataDto()
                                                                            .getTemperature()
                                                                            .toString());
    }
}
