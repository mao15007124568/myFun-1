package edu.hubu.myfun.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShiftController {

    @RequestMapping("/shift")
    public String shiftPage(){
        return "shift";
    }
}
