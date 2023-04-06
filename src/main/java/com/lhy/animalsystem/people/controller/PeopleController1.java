package com.lhy.animalsystem.people.controller;

import com.lhy.animalsystem.department.entity.Department;
import com.lhy.animalsystem.login.entity.User;
import com.lhy.animalsystem.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/people")
public class PeopleController1 {

    @Autowired
    PeopleService peopleService;

    @RequestMapping("/edit/{username}")
    public String departmentId(@PathVariable String username, Model model) throws IOException {
        User user = peopleService.selectByUsername(username);
        model.addAttribute("user", user);
        return "dict/peopleinfoId";
    }

    @RequestMapping("/edit")
    public String AddIt(Model model) throws IOException {
        model.addAttribute("user", new User());
        return "dict/peopleinfoId";
    }

    @RequestMapping("/authorization")
    public String Authorization(){
        return "dict/peopledrawer";
    }

}
