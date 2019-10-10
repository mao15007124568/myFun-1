package edu.hubu.myfun.ServiceTest;

import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest{

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void createMoney(){
        Assert.assertEquals(1, userService.createMoney(1l));
    }
}
