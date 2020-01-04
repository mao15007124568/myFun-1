package edu.hubu.myfun.controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import edu.hubu.myfun.mapper.CommentMapper;
import edu.hubu.myfun.pojo.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class IndexPageTest {
    @LocalServerPort
    private int port;

    private URL base;

    private URL baseone;

    private URL basetwo;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    CommentMapper commentMapper;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        this.baseone = new URL("http://localhost:" + port + "/trouble");
        this.basetwo = new URL("http://localhost:"  + port + "/rest/jyzh/comment");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getIndexPage() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody(), containsString("解忧杂货店"));
    }

    @Test
    public void listLetters() {
        ResponseEntity<String> response = template.getForEntity(baseone.toString(),
                String.class);
        assertThat(response.getBody(), containsString("忧愁列表"));
    }

    @Test
    public void listComment() throws Exception {
        Comment result = template.getForObject(basetwo.toString(), Comment.class);
        assertThat("qwer", equalTo(result.getTitle()));
    }
}