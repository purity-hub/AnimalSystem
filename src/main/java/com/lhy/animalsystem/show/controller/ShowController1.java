package com.lhy.animalsystem.show.controller;

import com.lhy.animalsystem.animal.entity.Animal;
import com.lhy.animalsystem.free.service.FreeService;
import com.lhy.animalsystem.show.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/show")
public class ShowController1 {
    @Autowired
    private ShowService showService;

    @RequestMapping("/info")
    public String info() {
        return "show/showInfo";
    }

    @RequestMapping("/info/edit/{id}")
    public String edit(@PathVariable("id")int id, Model model) {
        Animal animal = showService.selectById(id);
        model.addAttribute("animal",animal);
        return "show/showInfoId";
    }

    @RequestMapping("/info/edit")
    public String edit1(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal",animal);
        return "show/showInfoId";
    }
}
