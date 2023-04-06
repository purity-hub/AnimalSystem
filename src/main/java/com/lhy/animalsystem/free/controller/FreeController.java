package com.lhy.animalsystem.free.controller;

import com.lhy.animalsystem.animal.entity.Animal;
import com.lhy.animalsystem.free.service.FreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/free")
public class FreeController {

    @Autowired
    private FreeService freeService;

    @RequestMapping("/info/showall")
    public Map<String,Object> showAll(@RequestParam(defaultValue="1")int page,
                                      @RequestParam(defaultValue="10")int limit,
                                      @RequestParam(defaultValue="")String name) {
        if(name.equals("")){
            List<Animal> all = freeService.showAll();
            List<Animal> animals = freeService.showAllByPage((page-1)*limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","免费领养信息");
            map.put("count",all.size());
            map.put("data",animals);
            return map;
        }else{
            List<Animal> all = freeService.showAll();
            List<Animal> animals = freeService.search(name,(page-1)*limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","免费领养信息");
            map.put("count",all.size());
            map.put("data",animals);
            return map;
        }
    }

    @RequestMapping("/info/editIt")
    public String editIt(@RequestParam("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("type") String type,
                         @RequestParam("time") String time,
                         @RequestParam("people") String people) {
        //time转化
        time = time.replace("T"," ");
        freeService.editIt(id,name,type,time,people);
        return "success";
    }

    @RequestMapping("/info/upload")
    public String upload(@RequestParam("id") int id,
                         @RequestParam("imageSrc") String imageSrc) throws IOException {
        if(!imageSrc.equals("")){
            freeService.upload(id,imageSrc);
        }
        return "success";
    }

    @RequestMapping("/info/addIt")
    public String addIt(@RequestParam("name") String name,
                        @RequestParam("type") String type,
                        @RequestParam("time") String time,
                        @RequestParam("people") String people,
                        @RequestParam("imageSrc") String imageSrc) throws IOException {
        //time转化
        time = time.replace("T"," ");
        freeService.addIt(name,type,time,people);
        return "success";
    }

    @RequestMapping("/info/del")
    public String del(@RequestParam("id") int id) {
        freeService.del(id);
        return "success";
    }

    @RequestMapping("/info/delAll")
    public String delAll(@RequestParam("ids") String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            freeService.del(Integer.parseInt(s));
        }
        return "success";
    }

    @RequestMapping("/info/search")
    public Map<String,Object> search(@RequestParam("name") String name,
                                     @RequestParam(defaultValue="1")int page,
                                     @RequestParam(defaultValue="10")int limit) {
        List<Animal> animals = freeService.search(name,(page-1)*limit, limit);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","免费领养信息");
        map.put("count",animals.size());
        map.put("data",animals);
        return map;
    }

}
