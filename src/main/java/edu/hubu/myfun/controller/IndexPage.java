package edu.hubu.myfun.controller;

import edu.hubu.myfun.mapper.CommentMapper;
import edu.hubu.myfun.mapper.TroubleMapper;
import edu.hubu.myfun.pojo.Comment;
import edu.hubu.myfun.pojo.Trouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexPage {
   @Autowired
    TroubleMapper troubleMapper;

   @Autowired
    CommentMapper commentMapper;

    @RequestMapping
    public String getIndexPage(){
        return "loginExample";
    }

    @RequestMapping("trouble")
    public String ListLetters(Model model){
//        public List<Trouble> ListLetters(Model model){
        List<Trouble> troubles = troubleMapper.selectByExample(null);
        model.addAttribute("troubles",troubles);
//        return troubles;
        return "list";
    }

    @RequestMapping("comment")
//    public String ListLetters(Model model){
    public List<Comment> ListComment(Model model){
        List<Comment> comments = commentMapper.selectByExample(null);
        model.addAttribute("list",comments);
        return comments;
//        return "";
    }
}
