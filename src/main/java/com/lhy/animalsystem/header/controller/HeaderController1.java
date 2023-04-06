package com.lhy.animalsystem.header.controller;

import com.lhy.animalsystem.header.service.HeaderService;
import com.lhy.animalsystem.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/header")
public class HeaderController1 {

    @Autowired
    HeaderService headerService;

    @RequestMapping("/information")
    public String Information(Model model,HttpSession session){
        String loginUser = (String) session.getAttribute("loginUser");//用户名
        //根据用户名查询用户信息
        User user = headerService.selectUser(loginUser);
        model.addAttribute("user",user);
        return "header/information";
    }
}
