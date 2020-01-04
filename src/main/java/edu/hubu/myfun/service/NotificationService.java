package edu.hubu.myfun.service;

import edu.hubu.myfun.mapper.InformationMapper;
import edu.hubu.myfun.pojo.Information;
import edu.hubu.myfun.pojo.InformationExample;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    InformationMapper informationMapper;

    public int getNotificationCount(User user){
        InformationExample informationExample = new InformationExample();
        informationExample.createCriteria().andRecipientEqualTo(user.getId()).andStatusEqualTo(false);
        List<Information> information = informationMapper.selectByExample(informationExample);
        return information.size();
    }

}
