package com.example.wherever_i_want.meteo.client;

import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import com.example.wherever_i_want.mapper.StationTemperaturesMapper;
import com.example.wherever_i_want.service.StationTemperaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.util.UriComponentsBuilder.fromHttpUrl;


@Component
public class StationClient {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StationTemperaturesService stationTemperaturesService;
    @Autowired
    private StationTemperaturesMapper stationTemperaturesMapper;

    public MeteostatStationTemperaturesDto getStation(String id, String uri) {

        MeteostatStationTemperaturesDto station1 = restTemplate.getForObject(fromHttpUrl(uri).build().encode().toUri(),
                                                                             MeteostatStationTemperaturesDto.class);
        stationTemperaturesService.save(stationTemperaturesMapper.mapMeteostatStationTemperaturesDtoToStationTemperatures(id, station1));
        return station1;
    }

}
