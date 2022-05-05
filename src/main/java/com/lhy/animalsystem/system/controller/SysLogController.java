package com.lhy.animalsystem.system.controller;

import com.lhy.animalsystem.system.entity.SysLog;
import com.lhy.animalsystem.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/showall")
    public Map<String,Object> ShowAll(@RequestParam(defaultValue="1")int page,
                                      @RequestParam(defaultValue="10")int limit){
        List<SysLog> all = sysLogService.findAll();
        int size = all.size();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "日志信息");
        map.put("count", size);
        map.put("data", all);
        return map;
    }

    //日志删除
    @RequestMapping("/del")
    public int del(@RequestParam("id")int id){
        return sysLogService.deleteLogById(id);

    }
}
