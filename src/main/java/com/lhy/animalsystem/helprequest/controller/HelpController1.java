package com.lhy.animalsystem.helprequest.controller;

import com.lhy.animalsystem.helprequest.entity.Helprequest;
import com.lhy.animalsystem.helprequest.service.HelpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("/help")
public class HelpController1 {

    @Autowired
    private HelpRequestService helpRequestService;

    @RequestMapping("/request")
    public String request() {
        return "help/request/helprequest";
    }

    @RequestMapping("/request/edit/{id}")
    public String requestEdit(@PathVariable("id") int id, Model model) {
        Helprequest helprequest = helpRequestService.selectById(id);
        model.addAttribute("helprequest",helprequest);
        return "help/request/helprequestInfoId";
    }

    @RequestMapping("/request/edit")
    public String requestAdd(Model model) {
        model.addAttribute("helprequest",new Helprequest());
        return "help/request/helprequestInfoId";
    }


}
