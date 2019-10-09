package edu.hubu.myfun.service;

import edu.hubu.myfun.MyfunApplication;
import edu.hubu.myfun.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyfunApplication.class)
public class UserServiceTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void createMoney(){
        Assert.assertEquals(1, userService.createMoney(1l));
    }
}