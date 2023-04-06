package com.lhy.animalsystem.helpinfo.controller;

import com.lhy.animalsystem.animal.entity.Animal;
import com.lhy.animalsystem.animal.service.AnimalService;
import com.lhy.animalsystem.helprequest.service.HelpRequestService;
import com.lhy.animalsystem.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/help")
public class HelpinfoController {

    @Autowired
    private HelpRequestService helpRequestService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/info/editIt")
    public String editIt(@RequestParam("id") int id,
                         @RequestParam("animal") String animal,
                         @RequestParam("type") String type,
                         @RequestParam("veterinarianid") int veterinarianid,
                         HttpSession session) {
        //先将动物信息存入数据库
        Animal animal1 = new Animal();
        animal1.setName(animal);
        animalService.addAnimal(animal1);
        //查询最大的id
        int i = animalService.getMaxId();
        //获取指派人的id
        //再将求助信息存入数据库
        String username = (String) session.getAttribute("loginUser");
        int assignpeopleid = loginService.selectIdByName(username);
        //获取当前时间
        java.util.Date date = new java.util.Date();
        java.sql.Date assigntime = new java.sql.Date(date.getTime());
        helpRequestService.editInfo(id, i, type, veterinarianid,assignpeopleid,assigntime);
        return "success";
    }

    @RequestMapping("/info/editIt2")
    public String editIt2(@RequestParam("id") int id,
                         @RequestParam("animal") String animal,
                         @RequestParam("type") String type,
                         @RequestParam("veterinarianid") int veterinarianid) {
        helpRequestService.editInfo2(id, type, veterinarianid);
        return "success";
    }
}
