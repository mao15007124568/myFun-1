package edu.hubu.myfun.service;

import edu.hubu.myfun.dto.TroubleDTO;
import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.pojo.Trouble;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranstformUtils {

    @Autowired
    UserMapper userMapper;

    public  List<TroubleDTO> troubleSetUser(List<Trouble> troubles){


        List<TroubleDTO> troubleDTOList=new ArrayList<TroubleDTO>();

        for (int i=0;i<troubles.size();i++){
            User user = userMapper.selectByPrimaryKey(troubles.get(i).getCreator());
            TroubleDTO troubleDTO = new TroubleDTO();
            BeanUtils.copyProperties(troubles.get(i).getCreator(),troubleDTO);
            troubleDTO.setUser(user);
            troubleDTOList.add(troubleDTO);
        }
        return troubleDTOList;

    }
}
