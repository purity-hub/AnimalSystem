package com.lhy.animalsystem.veterinarian.controller;

import com.lhy.animalsystem.veterinarian.entity.Veterinarian;
import com.lhy.animalsystem.veterinarian.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veterinarian")
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;

    @RequestMapping("/showall")
    public List<Veterinarian> showAll() {
        return veterinarianService.showAll();
    }
}
