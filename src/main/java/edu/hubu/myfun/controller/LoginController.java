package edu.hubu.myfun.controller;

import com.alibaba.fastjson.JSON;
import edu.hubu.myfun.dto.AccessTokenDTO;
import edu.hubu.myfun.dto.GithubUser;
import edu.hubu.myfun.mapper.UserMapper;
import edu.hubu.myfun.pojo.User;
import edu.hubu.myfun.pojo.UserExample;
import edu.hubu.myfun.provider.GithubProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.awt.peer.LightweightPeer;

@Controller
@Slf4j
public class LoginController {

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.url}")
    private String redirectUrl;

    @Autowired
    GithubProvider githubProvider;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("callback")
    public String login(@RequestParam(name = "code") String code,
                        @RequestParam(name = "state") String state,
                        Model model,
                        HttpSession session) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUrl);
        accessTokenDTO.setState(state);
        GithubUser githubUser = githubProvider.getGithubUser(githubProvider.getAccess(accessTokenDTO));
        if (githubUser != null) {
            User user = userMapper.selectByPrimaryKey(githubUser.getId());
            if (user == null) {
                User newUser = new User();
                newUser.setAvatarUrl(githubUser.getAvatarUrl());
                newUser.setGmtCreator(System.currentTimeMillis());
                newUser.setGmtModify(System.currentTimeMillis());
                newUser.setName(githubUser.getName());
                userMapper.insert(newUser);
                session.setAttribute("user", newUser);
                model.addAttribute("user", newUser);
                return "redirect:/";
            } else {
                model.addAttribute("user", user);
                System.out.println(JSON.toJSONString(user));
                session.setAttribute("user", user);
                return "redirect:/";
            }
        } else {
            model.addAttribute("error", "用户不存在,请重新登录");
            log.error("error of login ,{}", new RuntimeException("无法从github得到用户信息"));
            return "error";
        }
    }
}
