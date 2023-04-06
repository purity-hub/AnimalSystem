package com.lhy.animalsystem.free.controller;

import com.lhy.animalsystem.animal.entity.Animal;
import com.lhy.animalsystem.free.service.FreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/free")
public class FreeController1 {

    @Autowired
    private FreeService freeService;

    @RequestMapping("/info")
    public String info() {
        return "free/freeInfo";
    }

    @RequestMapping("/info/edit/{id}")
    public String edit(@PathVariable("id")int id,Model model) {
        Animal animal = freeService.selectById(id);
        model.addAttribute("animal",animal);
        return "free/freeInfoId";
    }

    @RequestMapping("/info/edit")
    public String edit1(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal",animal);
        return "free/freeInfoId";
    }
}
