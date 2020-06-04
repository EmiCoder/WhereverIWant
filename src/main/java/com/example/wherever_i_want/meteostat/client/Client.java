package com.example.wherever_i_want.meteostat.client;

import com.example.wherever_i_want.domain.URI_List;
import com.example.wherever_i_want.domain.dto.DataDto;
import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;
import com.example.wherever_i_want.domain.dto.TemperatureDto;
import com.example.wherever_i_want.meteostat.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Client {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Config config;


    public MeteostatStationTemperaturesDto getMeteostatTemperaturesDto()  {
        return restTemplate.getForObject(buildURI(),MeteostatStationTemperaturesDto.class);
    }

    public List<MeteostatStationTemperaturesDto> getMeteostatTemperaturesDtoList() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        int URI_list_size = getURI_List().size();
        List<MeteostatStationTemperaturesDto> list = new ArrayList<>();

        for (int i = 0; i < URI_list_size; i++) {
            getURI_List().get(i);
            MeteostatStationTemperaturesDto temp = restTemplate.getForObject(getURI_List().get(i), MeteostatStationTemperaturesDto.class);
            list.add(temp);
        }
        return list;
    }

    public URI buildURI() {
        return UriComponentsBuilder.fromHttpUrl("https://api.meteostat.net/v1/climate/normals?station=06781&key=erPSGcB5")
                .build().encode().toUri();
    }

    public List<URI> getURI_List() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        List<URI> list = new ArrayList<>();
        for (String s : URI_List.getURI_List().getUriList()) {
            list.add(UriComponentsBuilder.fromHttpUrl(s).build().encode().toUri());
        }
        return list;
    }
}
