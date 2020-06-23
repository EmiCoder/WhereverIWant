package com.example.wherever_i_want.dao;

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
        User user = new User();
            user.setNick("MyNick");
            user.setFirstname("MyFirstName");
            user.setLastname("MyLastName");
            user.setEMail("MyEMail");
            user.setPassword("MyPassword");
            userDao.save(user);

        Assert.assertEquals(1, userDao.findByNick("MyNick").size());
    }
}
