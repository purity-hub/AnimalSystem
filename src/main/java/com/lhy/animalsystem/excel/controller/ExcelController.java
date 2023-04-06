package com.lhy.animalsystem.excel.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/excel")
public class ExcelController {

        @RequestMapping("/show")
        public String index(){
            return "excel/index";
        }
}
