package com.example.wherever_i_want.repository;

import com.example.wherever_i_want.domain.StationTemperatures;
import org.springframework.data.repository.CrudRepository;

public interface StationTemperaturesRepository extends CrudRepository<StationTemperatures, Integer> {
    @Override
    StationTemperatures save(StationTemperatures task);
}
