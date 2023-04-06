package com.lhy.animalsystem.treatment.controller;

import com.lhy.animalsystem.animal.service.AnimalService;
import com.lhy.animalsystem.dictionary.service.DictionaryService;
import com.lhy.animalsystem.helprequest.entity.Helprequest;
import com.lhy.animalsystem.helprequest.service.HelpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/treatment")
public class TreatmentController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private HelpRequestService helpRequestService;

    @Autowired
    private DictionaryService dictionaryService;


    @RequestMapping("/treatment")
    public String treatment(){
        return "/treatment/treatmentInfo";
    }

    @RequestMapping("/wait")
    public String Wait(){
        return "/treatment/waitInfo";
    }


    @RequestMapping("/info/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id){
        Helprequest helprequest = helpRequestService.selectById(id);
        model.addAttribute("helprequest", helprequest);
        int animalid = (int) helprequest.getAnimalid();
        model.addAttribute("animal", animalService.selectById(animalid));
        return "treatment/treatmentInfoEdit";
    }

    @RequestMapping("/wait/edit/{id}")
    public String Wait(Model model, @PathVariable("id") int id){
        Helprequest helprequest = helpRequestService.selectById(id);
        model.addAttribute("helprequest", helprequest);
        int animalid = (int) helprequest.getAnimalid();
        model.addAttribute("animal", animalService.selectById(animalid));
        //从字典里获取state
        List<String> states = dictionaryService.selectByType("forword");
        model.addAttribute("states", states);
        return "treatment/waitInfoId";
    }


}
