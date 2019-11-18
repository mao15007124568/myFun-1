package edu.hubu.myfun.controller;

import edu.hubu.myfun.pojo.Comment;
import edu.hubu.myfun.pojo.User;
import edu.hubu.myfun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment")
public class ResponseController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/page")
    public String getPage(){
        return "writeLetter";
    }

    @RequestMapping("/write")
    public String comment (@RequestParam("title")String title,
                            @RequestParam("content")String content,
                           @RequestParam(value = "id",required = false)Long id,
                           HttpSession session,
                           Model model){
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("message","当前用户为登录，请先登录哦");
            return "error";
        }

        Comment comment = new Comment();
        comment.setCreator(user.getId());
        comment.setContent(content);
        comment.setTroubleId(id);
        comment.setGmtCreate(System.currentTimeMillis());
        commentService.handleComment(comment, user);
        return "successful";
    }
}
