package edu.hubu.myfun.ResController;

import edu.hubu.myfun.mapper.*;
import edu.hubu.myfun.pojo.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/jyzh")
public class MapperRescontroller {
    @Autowired
    UserMapper userMapper;

    @Autowired
    TroubleExtMapper troubleMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    TroubleExtMapper troubleExtMapper;

    @Autowired
    InformationMapper informationMapper;

    @RequestMapping(value = "/users")
    public Object getLUsers(){
        return userMapper.selectByPrimaryKey(1L);
    }

    @RequestMapping(value = "/troubles")
    public Object getTrouble(){
        return troubleMapper.selectAll();
    }

    @RequestMapping(value = "/comments")
    public Object getComments(){
        return commentMapper.selectAll();
    }

    @RequestMapping(value = "/informations")
    public Object getInformations(){
        return informationMapper.selectAll();
    }
}
