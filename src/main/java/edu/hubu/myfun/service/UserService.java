package edu.hubu.myfun.service;

import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
public class UserService {

    @Autowired
    UserMapper usermapper;

    public int createMoney(Long userId){
        User user = usermapper.selectByPrimaryKey(userId);
        if(user==null){
            return 0;
        }else {
            user.setMoney(user.getMoney()+5);
            return usermapper.updateByPrimaryKey(user);
        }
    }

    public int reduceMoney(Long userId){
        User user = usermapper.selectByPrimaryKey(userId);
        user.setMoney(user.getMoney()-5);
        return usermapper.updateByPrimaryKey(user);
    }

    @Transactional
    public boolean recharge(User user,Integer amount){

        User user1 = usermapper.selectByPrimaryKey(user.getId());
        user1.setMoney(user.getMoney()+amount);
        int i = usermapper.updateByPrimaryKey(user1);
        if(i>0){
            return true;
        }else {
            return  false;
        }
    }
}
