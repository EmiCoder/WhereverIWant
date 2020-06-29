package com.example.wherever_i_want.dao;

import com.example.wherever_i_want.domain.Request;
import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTestSuite {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindByNick() {
//        User user = new User();
//            user.setNick("Hello");
//            user.setFirstname("MyFirstName");
//            user.setLastname("MyLastName");
//            user.setEMail("MyEMail");
//            user.setPassword("MyPassword");
//            LogIn logIn = new LogIn();
//                    logIn.setUser(user);
//                    logIn.setLoginDate("2020-06023");
//                    logIn.setLoginTime("20:23:12");
//            user.getLogsIn().add(logIn);
//        Request request = new Request();
//                request.setUser(user);
//                request.setTemperature(23);
//                request.setMonth("APRIL");
//                request.setCountry("Albania");
//                request.setRequestDate("24-12-2010");
//                user.getRequests().add(request);
//            userDao.save(user);
//
//        Assert.assertEquals(1, userDao.findByNick("Hello").size());
    }
}
