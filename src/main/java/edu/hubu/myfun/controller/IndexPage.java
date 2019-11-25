package edu.hubu.myfun.controller;

import com.sun.javafx.scene.transform.TransformUtils;
import edu.hubu.myfun.dto.TroubleDTO;
import edu.hubu.myfun.mapper.CommentMapper;
import edu.hubu.myfun.mapper.TroubleExtMapper;
import edu.hubu.myfun.mapper.TroubleMapper;
import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.pojo.Comment;
import edu.hubu.myfun.pojo.Trouble;
import edu.hubu.myfun.pojo.User;
import edu.hubu.myfun.service.TransUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexPage {
   @Autowired
    TroubleMapper troubleMapper;

    @Autowired
    TroubleExtMapper troubleExtMapper;

   @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;


    @RequestMapping
    public String getIndexPage(){
        return "loginExample";
    }

    @RequestMapping("trouble")
    public String ListLetters(Model model){
        List<Trouble> troubles = troubleExtMapper.selectAll();

//        TransUtils transUtils = new TransUtils();
//        List<TroubleDTO> troubleDTOList =transUtils.troubleSetUser(troubles);

        List<TroubleDTO> troubleDTOList=new ArrayList<TroubleDTO>();

        for (int i=0;i<troubles.size();i++){
            User user = userMapper.selectByPrimaryKey(troubles.get(i).getCreator());
            TroubleDTO troubleDTO = new TroubleDTO();
            BeanUtils.copyProperties(troubles.get(i),troubleDTO);
            troubleDTO.setUser(user);
            troubleDTOList.add(troubleDTO);
        }

        model.addAttribute("troubles",troubleDTOList);
        return "list";
    }

    @RequestMapping("comment")
    public List<Comment> ListComment(Model model){
        List<Comment> comments = commentMapper.selectByExample(null);
        model.addAttribute("list",comments);
        return comments;
    }
}
