package com.lhy.animalsystem.dictionary.controller;

import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.entity.SysDictValue;
import com.lhy.animalsystem.dictionary.mapper.DictionaryValueMapper;
import com.lhy.animalsystem.dictionary.service.DictionaryValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionaryvalue")
public class DictionaryvalueController1 {

    @Autowired
    DictionaryValueService dictionaryValueService;

    @RequestMapping("/edit/{id}")
    public String Edit(@PathVariable int id, Model model){
        SysDictValue sysDict = dictionaryValueService.selectDictById(id);
        model.addAttribute("dict",sysDict);
        return "dict/dictionaryvalueInfoId";
    }

    @RequestMapping("/edit")
    public String Edit(Model model){
        SysDictValue sysDict = new SysDictValue();
        model.addAttribute("dict",sysDict);
        return "dict/dictionaryvalueInfoId";
    }
}
