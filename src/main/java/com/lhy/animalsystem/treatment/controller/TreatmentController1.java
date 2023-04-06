package com.lhy.animalsystem.treatment.controller;

import com.lhy.animalsystem.animal.service.AnimalService;
import com.lhy.animalsystem.helprequest.service.HelpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treatment")
public class TreatmentController1 {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private HelpRequestService helpRequestService;

    @RequestMapping("/info/editIt")
    public String editIt(@RequestParam("id") int id,
                            @RequestParam("animalid") int animalid,
                         @RequestParam("injury") String injury,
                         @RequestParam("treatmentplan") String treatmentplan){
        helpRequestService.updatetreatment(animalid, injury, treatmentplan);
        //更新helprequest表中的state字段改为2
        helpRequestService.updatestate(id, 2);
        return "success";
    }

    @RequestMapping("/wait/editIt")
    public String waitEdit(@RequestParam("animalid") int animalid,
                         @RequestParam("state") String state){
        animalService.updatestate(animalid, state);
        return "success";
    }
}
