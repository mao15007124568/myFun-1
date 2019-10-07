package edu.hubu.myfun.service;

import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper usermapper;

    public int createMoney(Long userId){
        User user = usermapper.selectByPrimaryKey(userId);
        if(user==null){
            return 0;
        }else {
            user.setMoney(35);
            return usermapper.updateByPrimaryKey(user);
        }
    }

    public int reduceMoney(Long userId){
        User user = usermapper.selectByPrimaryKey(userId);
        user.setMoney(user.getMoney()-5);
        return usermapper.updateByPrimaryKey(user);
    }
}
