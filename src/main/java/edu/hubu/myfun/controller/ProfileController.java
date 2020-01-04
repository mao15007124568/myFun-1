package edu.hubu.myfun.controller;

import edu.hubu.myfun.exception.CustomizeErrorCode;
import edu.hubu.myfun.exception.CustomizeException;
import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.pojo.User;
import edu.hubu.myfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @RequestMapping("/rechargePage")
    public String rechargePage(){
        return "recharge";
    }
    
    @RequestMapping("/recharge")
    public String recharge(@RequestParam("amount") Integer amount,
                           HttpSession session,
                           Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw  new CustomizeException(CustomizeErrorCode.NO_LOGIN);
        }
        if(userService.recharge(user,amount)){
            return  "redirect:/";
        }else {
            model.addAttribute("message","充值失败，请重新尝试");
            return  "error";
        }
    }

}
