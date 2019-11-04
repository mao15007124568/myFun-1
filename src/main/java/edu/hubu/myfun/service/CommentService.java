package edu.hubu.myfun.service;

import edu.hubu.myfun.mapper.CommentMapper;
import edu.hubu.myfun.pojo.Comment;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public void handleComment(Comment comment, User user){
        commentMapper.insert(comment);
    }
}
