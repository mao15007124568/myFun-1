package edu.hubu.myfun.controller;

import edu.hubu.myfun.dto.AccessTokenDTO;
import edu.hubu.myfun.dto.GithubUser;
import edu.hubu.myfun.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.url}")
    private String redirectUrl;

    @Autowired
    GithubProvider githubProvider;

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
        model.addAttribute("user", githubUser);
        session.setAttribute("user",githubUser);
        return "loginExample";
    }
}
