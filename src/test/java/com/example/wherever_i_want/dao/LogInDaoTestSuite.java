package com.example.wherever_i_want.dao;

import com.example.wherever_i_want.domain.loginRegisterStaff.LogIn;
import com.example.wherever_i_want.domain.loginRegisterStaff.Register;
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
public class LogInDaoTestSuite {
    @Autowired
    LogInDao logInDao;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserId() {

        LogIn logIn = new LogIn();
        logIn.setUser(userRepository.findById(140).get());
        logIn.setLoginDate("10-05-2020");
        logIn.setLoginTime("15:24:34");
        logInDao.save(logIn);
        Assert.assertEquals(2, logInDao.findByUserId(140).size());
    }

}
