package com.example.wherever_i_want;

import com.example.wherever_i_want.domain.URI_List;
import com.example.wherever_i_want.domain.dto.MeteostatStationTemperaturesDto;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<MeteostatStationTemperaturesDto> list = new ArrayList<>();
        list.add(new MeteostatStationTemperaturesDto(null));
        list.add(new MeteostatStationTemperaturesDto(null));
        System.out.println(list.size());
        for (MeteostatStationTemperaturesDto s : list) {
            System.out.println(s);
        }
    }
}
