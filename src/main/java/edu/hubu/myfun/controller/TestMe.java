package edu.hubu.myfun.controller;

import edu.hubu.myfun.mapper.TroubleExtMapper;
import edu.hubu.myfun.mapper.TroubleMapper;
import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.pojo.Trouble;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class TestMe {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TroubleExtMapper troubleMapper;

    @RequestMapping("/test")
    public List<Trouble> test(HttpSession session){

//        User user = (User) session.getAttribute("user");
//        return userMapper.selectByPrimaryKey(user.getId());


        List<Trouble> troubles = troubleMapper.selectAll();
        return troubles;
    }
}
