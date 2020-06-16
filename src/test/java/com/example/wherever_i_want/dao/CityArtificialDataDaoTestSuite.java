package com.example.wherever_i_want.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityArtificialDataDaoTestSuite {

    @Autowired
    CityArtificialDataDao cityArtificialDataDao;

    @Autowired
    CityArtificialDataService cityArtificialDataService;

    @Test
    public void doCompanyNameNativeQueriesWorkCorrectly() throws SQLException {

//        Assert.assertNotEquals(0, cityArtificialDataDao.getByUserRequest().size());
//        System.out.println(cityArtificialDataDao.getByUserRequest().size());

        System.out.println(cityArtificialDataService.getAll().size());
//        for (int i = 0; i < 10; i++) {
//            Object object = cityArtificialDataService.getAll().get(i);
//            CityArtificialData city = (CityArtificialData) object;
//            System.out.println(city.getId());
//            System.out.println(" ");
//        }
    }
}
