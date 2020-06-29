package com.example.wherever_i_want.dao;

import com.example.wherever_i_want.domain.Request;
import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import com.example.wherever_i_want.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestDaoTestSuite {

    @Autowired
    private RequestDao requestDao;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindById() {
        Request userRequest = new Request();
                    userRequest.setUser(userRepository.findById(220).get());
                    userRequest.setTemperature(23);
                    userRequest.setMonth("APRIL");
                    userRequest.setCountry("NewNamedCountry");
                    userRequest.setRequestDate("20-12-2010");
                    requestDao.save(userRequest);

        Assert.assertEquals(1, requestDao.findByCountry("NewNamedCountry").size());
        requestDao.deleteById(userRequest.getId());
    }
}
