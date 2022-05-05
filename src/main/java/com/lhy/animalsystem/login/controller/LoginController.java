package com.lhy.animalsystem.login.controller;

import com.lhy.animalsystem.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/")
    public String Welcome(){
        //配置欢迎页为login
        return "login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public String loginUser(@RequestParam(name = "username",required = true) String username,
                            @RequestParam(name = "password",required = true) String password,
                            Map<String,Object> map, HttpSession session){
        if(loginService.selectUserPass(username, password)>0){
            session.setAttribute("loginUser",username);
            return "index";
        }else{
            map.put("msg","用户名或者密码错误");
            return "login";
        }
    }
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("loginUser");
        return "login";
    }
}
