package edu.hubu.myfun.service;

import edu.hubu.myfun.mapper.CommentMapper;
import edu.hubu.myfun.pojo.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CommentServiceTest {

    @Autowired
    private CommentMapper commentMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void handleComment() {
        Comment comment = new Comment();
        comment.setId(1);
        comment.setTitle("qwer");
        comment.setContent("asdf");
        comment.setIsShare(true);
        comment.setRecipient((long) 90);
        assertEquals(1,commentMapper.insert(comment));
    }
}