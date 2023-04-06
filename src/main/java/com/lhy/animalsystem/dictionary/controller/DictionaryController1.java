package com.lhy.animalsystem.dictionary.controller;

import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.entity.SysDictValue;
import com.lhy.animalsystem.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController1 {

    @Autowired
    DictionaryService dictionaryService;

    @RequestMapping("/dictvalue/{id}")
    public String DictValue(@PathVariable int id, Model model){
        List<SysDictValue> sysDictValues = dictionaryService.selectDictValue(id);
        model.addAttribute("id",id);
        return "dict/dictionaryvalue";
    }

    @RequestMapping("/edit/{id}")
    public String Edit(@PathVariable int id, Model model){
        SysDict sysDict = dictionaryService.selectDictById(id);
        model.addAttribute("dict",sysDict);
        return "dict/dictionaryInfoId";
    }

    @RequestMapping("/edit")
    public String Add(Model model){
        model.addAttribute("dict",new SysDict());
        return "dict/dictionaryInfoId";
    }
}
