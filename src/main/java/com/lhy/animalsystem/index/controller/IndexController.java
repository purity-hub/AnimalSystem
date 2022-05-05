package com.lhy.animalsystem.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/dict/relevancy")
    public String Relevancy(){
        return "dict/relevancy";
    }

    @RequestMapping("/dict/department")
    public String Department(){
        return "dict/department";
    }

    @RequestMapping("/dict/peopleinfo")
    public String People(){
        return "dict/peopleinfo";
    }

    @RequestMapping("/dict/authorization")
    public String Authorization(){
        return "dict/authorization";
    }

    @RequestMapping("/dict/syslog")
    public String Syslog(){
        return "dict/syslog";
    }
}
