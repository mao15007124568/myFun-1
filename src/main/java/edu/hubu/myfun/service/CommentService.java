package edu.hubu.myfun.service;

import edu.hubu.myfun.mapper.CommentMapper;
import edu.hubu.myfun.mapper.InformationMapper;
import edu.hubu.myfun.pojo.Comment;
import edu.hubu.myfun.pojo.Information;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    InformationMapper informationMapper;

    public int handleComment(Comment comment, User user){
        Information information=new Information();
        information.setStatus(false);
        information.setSender(user.getId());
        information.setGmtCreate(System.currentTimeMillis());
        information.setGmtModify(System.currentTimeMillis());
        information.setRecipient(comment.getRecipient());
        informationMapper.insert(information);
        return commentMapper.insert(comment);
    }
}
