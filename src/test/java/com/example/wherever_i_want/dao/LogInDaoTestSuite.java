package com.example.wherever_i_want.dao;

import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import com.example.wherever_i_want.domain.loginRegisterStaff.Register;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogInDaoTestSuite {
    @Autowired
    LogInDao logInDao;

    @Test
    public void testFindByUserId() {
        User user = new User();
        user.setNick("MyNick");
        user.setFirstname("MyFirstName");
        user.setLastname("MyLastName");
        user.setEMail("MyEMail");
        user.setAge(24);
        user.setPassword("MyPassword");

        LogIn logIn = new LogIn();
        logIn.setUser(user);
        logIn.setLoginDate("10-05-2020");
        logIn.setLoginTime("15:24:34");
        logInDao.save(logIn);

        Assert.assertEquals(1, logInDao.findByUserId(user.getId()).size());
    }

}
