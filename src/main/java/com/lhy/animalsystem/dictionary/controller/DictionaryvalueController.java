package com.lhy.animalsystem.dictionary.controller;

import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.entity.SysDictValue;
import com.lhy.animalsystem.dictionary.service.DictionaryService;
import com.lhy.animalsystem.dictionary.service.DictionaryValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dictionaryvalue")
public class DictionaryvalueController {

    @Autowired
    DictionaryService dictionaryService;

    @Autowired
    DictionaryValueService dictionaryValueService;

    @RequestMapping("/showall/{id}")
    public Map<String,Object> ShowAll(@PathVariable int id,
                                      @RequestParam(defaultValue="1")int page,
                                      @RequestParam(defaultValue="10")int limit){
        List<SysDictValue> sysDictValues = dictionaryService.selectDictValue(id);
        int size = sysDictValues.size();//这里优化时可以改成mysql获取count
        List<SysDictValue> list = new ArrayList<>();
        list = dictionaryService.selectValueByPage(id,(page-1) * limit, limit);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","全局字典信息");
        map.put("count",size);
        map.put("data",list);
        return map;
    }

    @RequestMapping("/editIt")
    public String EditIt(SysDictValue sysDictValue){
        dictionaryValueService.updateDictValue(sysDictValue);
        return "success";
    }

    @RequestMapping("/del")
    public int Del(int id){
        return dictionaryValueService.deleteDictValue(id);
    }

    @RequestMapping("/addIt")
    public String AddIt(SysDictValue sysDictValue){
        dictionaryValueService.insertDictValue(sysDictValue);
        return "success";
    }

    @RequestMapping("/delAll")
    public String DelAll(@RequestParam("ids")String ids){
        ids = ids.substring(1,ids.length()-1);
        String[] split = ids.split(",");
        for (String s : split) {
            dictionaryValueService.deleteDictValue(Integer.parseInt(s));
        }
        return "success";
    }
}
