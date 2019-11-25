package edu.hubu.myfun.controller;

import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class Test {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/test")
    public User test(HttpSession session){
        User user = (User) session.getAttribute("user");
        return userMapper.selectByPrimaryKey(user.getId());

    }
}
