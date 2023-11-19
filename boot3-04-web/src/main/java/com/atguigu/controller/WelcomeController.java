package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 朱俊伟
 * @date 2023/10/25 14:50
 */
@Controller
public class WelcomeController {

    @GetMapping("welcome")
    public String welcome(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "welcome";
    }

    @GetMapping("welcome2")
    public String welcome2(@RequestParam("name") String name, Model model){
        model.addAttribute("name","<span style='color:red'>" + name +"</span>");
        return "welcome";
    }
}
