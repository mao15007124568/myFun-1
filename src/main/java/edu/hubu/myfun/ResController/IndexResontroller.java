package edu.hubu.myfun.ResController;

import edu.hubu.myfun.dto.TroubleDTO;
import edu.hubu.myfun.mapper.CommentMapper;
import edu.hubu.myfun.mapper.TroubleExtMapper;
import edu.hubu.myfun.mapper.TroubleMapper;
import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.pojo.Comment;
import edu.hubu.myfun.pojo.Trouble;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/jyzh")
public class IndexResontroller {
    @Autowired
    TroubleMapper troubleMapper;

    @Autowired
    TroubleExtMapper troubleExtMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/trouble")
    public Object getListTrouble() {

        Trouble trouble = new Trouble();
        trouble.setId((long) 1);
        trouble.setTitle("poiuy");
        trouble.setContent("fghjk");
        trouble.setTagId((long) 43);
        trouble.setCreator((long) 89);

        return trouble;
    }

    @RequestMapping(value = "/comment")
    public Object getComments(){
        Comment comment = new Comment();
        comment.setId(1);
        comment.setTitle("qwer");
        comment.setContent("asdf");
        comment.setIsShare(true);
        comment.setRecipient((long) 90);
        return comment;
    }
}
