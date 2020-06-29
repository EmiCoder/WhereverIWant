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
    private UserDao userDao;

    @Test
    public void testFindByUserId() {

//        LogIn logIn = new LogIn();
//        logIn.setId(10000);
//        User user = new User();
//        user.setId(1000);
//            user.setNick("user1");
//            user.setFirstname("firstname1");
//            user.setLastname("lastname1");
//            user.setAge(100);
//            user.setEMail("email1");
//            user.setPassword("password1");
//        userDao.save(user);
//        logIn.setUser(user);
//        logIn.setLoginDate("10-05-2020");
//        logIn.setLoginTime("15:24:34");
//        logInDao.save(logIn);
//
//        Assert.assertEquals(1, logInDao.findByUserId(user.getId()).size());
//        userDao.deleteById(user.getId());
//        logInDao.deleteById(logIn.getId());
    }

}
