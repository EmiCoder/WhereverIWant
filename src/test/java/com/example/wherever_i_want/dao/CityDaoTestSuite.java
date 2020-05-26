package com.example.wherever_i_want.dao;


import com.example.wherever_i_want.domain.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityDaoTestSuite {

    @Autowired
    private CityDao cityDao;

    @Test
    public void testTaskDaoSave() {

        City city = new City();
        city.setName("Qabāghlū");
        city.setCountry("IR");
        cityDao.save(city);

        Assert.assertEquals(1, cityDao.findByName("Town_1").size());

        Optional<City> readCity = cityDao.findById(city.getId());
        Assert.assertTrue(readCity.isPresent());

        cityDao.deleteById(city.getId());
    }
}