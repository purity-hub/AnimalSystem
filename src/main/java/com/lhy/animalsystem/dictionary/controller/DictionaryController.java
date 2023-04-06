package com.lhy.animalsystem.dictionary.controller;

import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.service.DictionaryService;
import com.lhy.animalsystem.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @RequestMapping(value = "/showall",produces="application/json")
    public Map<String,Object> AllDepartment(@RequestParam(defaultValue="1")int page,
                                            @RequestParam(defaultValue="10")int limit,
                                            @RequestParam(name = "name",required = false,defaultValue = "") String name){
        if(Objects.equals(name, "")){
            //全部查询
            List<SysDict> sysDicts = dictionaryService.selectAllDict();
            int size = sysDicts.size();//总页数
            List<SysDict> list = new ArrayList<>();
            list = dictionaryService.selectByPage((page-1) * limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","全局字典信息");
            map.put("count",size);
            map.put("data",list);
            return map;
        }else{
            //搜索查询
            List<SysDict> sysDicts = dictionaryService.selectByName("%"+name+"%");
            int size = sysDicts.size();//总页数
            List<SysDict> list = new ArrayList<>();
            list = dictionaryService.selectByNamePage("%"+name+"%",(page-1) * limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","全局字典信息");
            map.put("count",size);
            map.put("data",list);
            return map;
        }

    }

    @RequestMapping("/add")
    public Map<String,Object> AddDepartment(SysDict sysDict){
        HashMap<String, Object> map = new HashMap<>();
//        int i = dictionaryService.insertDict(sysDict);
//        if(i == 1){
//            map.put("code",0);
//            map.put("msg","添加成功");
//        }else{
//            map.put("code",1);
//            map.put("msg","添加失败");
//        }
        return map;
    }

    @RequestMapping("/editIt")
    public Map<String,Object> EditDepartment(@RequestParam(defaultValue="1")int id,
                                             @RequestParam(defaultValue="1")String name,
                                             @RequestParam(defaultValue="1")String code,
                                             @RequestParam(defaultValue="1")String info){
        HashMap<String, Object> map = new HashMap<>();
        int sysDict = dictionaryService.updateDict(id,name,code,info);
        map.put("code",0);
        map.put("msg","编辑成功");
        map.put("data",sysDict);
        return map;
    }

    @RequestMapping("/del")
    public Map<String,Object> DelDepartment(@RequestParam(defaultValue="1")int id){
        HashMap<String, Object> map = new HashMap<>();
        int i = dictionaryService.deleteDict(id);
        if(i == 1){
            map.put("code",0);
            map.put("msg","删除成功");
        }else{
            map.put("code",1);
            map.put("msg","删除失败");
        }
        return map;
    }

    @RequestMapping("/delAll")
    public String DelAllDepartment(@RequestParam(defaultValue="1")String ids){
        ids = ids.substring(1,ids.length()-1);
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        int i = dictionaryService.deleteAllDict(list);
        if(i == 1){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/search")
    public Map<String,Object> SearchDepartment(@RequestParam(defaultValue="1")String name){
        List<SysDict> sysDicts = dictionaryService.selectDictByName(name);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","全局字典信息");
        map.put("count",sysDicts.size());
        map.put("data",sysDicts);
        return map;
    }

    @RequestMapping("/addIt")
    public Map<String,Object> AddItDepartment(@RequestParam(defaultValue="1")String name,
                                              @RequestParam(defaultValue="1")String code,
                                              @RequestParam(defaultValue="1")String info){
        HashMap<String, Object> map = new HashMap<>();
        int i = dictionaryService.insertDict(name,code,info);
        if(i == 1){
            map.put("code",0);
            map.put("msg","添加成功");
        }else{
            map.put("code",1);
            map.put("msg","添加失败");
        }
        return map;
    }
}
