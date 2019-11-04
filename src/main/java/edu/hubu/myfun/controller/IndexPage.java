package edu.hubu.myfun.controller;

import edu.hubu.myfun.mapper.TroubleMapper;
import edu.hubu.myfun.pojo.Trouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexPage {
   @Autowired
    TroubleMapper troubleMapper;

    @RequestMapping
    public String getIndexPage(){
        return "loginExample";
    }

    @RequestMapping("list")
    public String ListLetters(Model model){
        List<Trouble> troubles = troubleMapper.selectByExample(null);
        model.addAttribute("list",troubles);
        return "";
    }
}
