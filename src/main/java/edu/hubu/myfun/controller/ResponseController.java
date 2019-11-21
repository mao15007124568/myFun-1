package edu.hubu.myfun.controller;

import edu.hubu.myfun.exception.CustomizeErrorCode;
import edu.hubu.myfun.exception.CustomizeException;
import edu.hubu.myfun.mapper.TroubleMapper;
import edu.hubu.myfun.pojo.Comment;
import edu.hubu.myfun.pojo.Trouble;
import edu.hubu.myfun.pojo.TroubleExample;
import edu.hubu.myfun.pojo.User;
import edu.hubu.myfun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/letter")
public class ResponseController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private TroubleMapper troubleMapper;

    @RequestMapping("/page")
    public String getPage() {
        return "writeLetter";
    }

    @RequestMapping("/{action}")
    public String comment(
            @PathVariable("action") String actionName,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam(value = "id", required = false) Long id,
            HttpSession session,
            Model model) {

        User user = (User) session.getAttribute("user");
        //标记是否插入成功
        int i = 0;

        if (user == null) {
            model.addAttribute("message", "当前用户为登录，请先登录哦");
            return "error";
        }

        if ("comment".equals(actionName)) {
            Comment comment = new Comment();
            comment.setCreator(user.getId());
            comment.setContent(content);
            comment.setTroubleId(id);
            comment.setGmtCreate(System.currentTimeMillis());
            i = commentService.handleComment(comment, user);
        }

        if ("write".equals(actionName)) {
            Trouble trouble = new Trouble();
            trouble.setContent(content);
            trouble.setCreator(user.getId());
            trouble.setGmtCreate(System.currentTimeMillis());
            trouble.setGmtModify(System.currentTimeMillis());
            trouble.setTitle(title);
            i = troubleMapper.insert(trouble);
        }

        if (i == 0) {
            throw new CustomizeException(CustomizeErrorCode.INSERT_ERROR);
        }

        return "successful";
    }
}
