package com.example.wherever_i_want.dao;

import com.example.wherever_i_want.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CityDao extends CrudRepository<City, Integer> {
    Optional<City> findById(int id);
    List<City> findByName(String name);
}
