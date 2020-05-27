package com.example.wherever_i_want.controller;
import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.wherever_i_want.meteostat.client.MeteostatClient;

import java.util.List;

@RestController
@RequestMapping("/meteostat")
public class MeteostatController {

    @Autowired
    private MeteostatClient meteostatClient;

    @RequestMapping(method = RequestMethod.GET, value = "/getStationTemperatures")
    public void getMeteostatStationTemperatures() {
        List<MeteostatStationTemperaturesDto> temperaturesDtos = meteostatClient.getMeteostatTemperaturesDto();
        temperaturesDtos.forEach(meteostatStationTemperaturesDto -> meteostatStationTemperaturesDto.getTemperature().toString());
    }
}
