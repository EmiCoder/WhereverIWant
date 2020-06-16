package com.example.wherever_i_want.service;

import com.example.wherever_i_want.domain.StationTemperatures;
import com.example.wherever_i_want.repository.StationTemperaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StationTemperaturesService {

    @Autowired
    private StationTemperaturesRepository stationTemperaturesRepository;

    public StationTemperatures save(StationTemperatures stationTemperatures) {
        return stationTemperaturesRepository.save(stationTemperatures);
    }


}
