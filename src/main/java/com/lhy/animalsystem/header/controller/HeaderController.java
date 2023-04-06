package com.lhy.animalsystem.header.controller;

import com.lhy.animalsystem.header.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/header")
public class HeaderController {

    @Autowired
    HeaderService headerService;

    @RequestMapping("/editInfo")
    public String editInfo(@RequestParam("username") String username,
                           @RequestParam("name") String name,
                           @RequestParam("password") String password,
                           HttpSession session){
        String loginUser = (String) session.getAttribute("loginUser");//用户名
        int res = headerService.editInfo(username,name,password,loginUser);
        if(res == 1){
            session.setAttribute("loginUser",username);
            return "success";
        }else{
            return "fail";
        }
    }
}
