package com.lhy.animalsystem.helpinfo.controller;

import com.lhy.animalsystem.helprequest.entity.Helprequest;
import com.lhy.animalsystem.helprequest.service.HelpRequestService;
import com.lhy.animalsystem.veterinarian.entity.Veterinarian;
import com.lhy.animalsystem.veterinarian.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/help")
public class HelpinfoController1 {

    @Autowired
    private HelpRequestService helpRequestService;

    @Autowired
    private VeterinarianService veterinarianService;

    @RequestMapping("/info")
    public String info() {
        return "/help/info/requestinfo";
    }

    @RequestMapping("/info/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Helprequest helprequest = helpRequestService.selectById(id);
        model.addAttribute("helprequest",helprequest);
        List<Veterinarian> veterinarians = veterinarianService.showAll();
        model.addAttribute("veterinarians", veterinarians);
        return "/help/info/requestinfoId";
    }

    @RequestMapping("/assign")
    public String assign() {
        return "/help/assign/assigninfo";
    }
}
