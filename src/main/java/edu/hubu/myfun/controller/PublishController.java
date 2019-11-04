package edu.hubu.myfun.controller;

import edu.hubu.myfun.mapper.TroubleMapper;
import edu.hubu.myfun.pojo.Trouble;
import edu.hubu.myfun.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Demo class
 * @author qianliyin
 * @date 2016/10/31
 */

@Controller
public class PublishController {

    @Autowired
    private TroubleMapper troubleMapper;

    @RequestMapping("/publish")
    public String envelope(@RequestParam String title,
                           @RequestParam String content,
                           @RequestParam Long tag,
                           HttpSession session,
                           Model model){
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        Trouble trouble = new Trouble();
        trouble.setTitle(title);
        trouble.setContent(content);
        trouble.setId(tag);
        trouble.setCreator(user.getId());
        trouble.setGmtCreate(System.currentTimeMillis());
        trouble.setGmtModify(trouble.getGmtCreate());
        troubleMapper.insert(trouble);
        return "redirect:/";
    }
}
