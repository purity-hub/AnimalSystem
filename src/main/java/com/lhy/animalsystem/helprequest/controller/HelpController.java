package com.lhy.animalsystem.helprequest.controller;

import com.lhy.animalsystem.helprequest.entity.Helprequest;
import com.lhy.animalsystem.helprequest.service.HelpRequestService;
import com.lhy.animalsystem.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/help")
public class HelpController {

    @Autowired
    private HelpRequestService helpRequestService;

    @RequestMapping("/request/showall")
    public Map<String,Object> request(@RequestParam(defaultValue="1")int page,
                                      @RequestParam(defaultValue="10")int limit,
                                      @RequestParam(name = "name",required = false,defaultValue = "") String name) {
        if(name.equals("")) {
            List<Helprequest> all = helpRequestService.showAll();
            List<Helprequest> helprequests = helpRequestService.showAllByPage((page-1)*limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","求助信息");
            map.put("count",all.size());
            map.put("data",helprequests);
            return map;
        }else{
            List<Helprequest> helprequests = helpRequestService.selectByName(name);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","请求信息");
            map.put("count",helprequests.size());
            map.put("data",helprequests);
            //前端实际调用的是showAll方法,这里留作后续开发备用
            return map;
        }
    }

    @RequestMapping("/request/showall2")
    public Map<String,Object> request2(@RequestParam(defaultValue="1")int page,
                                      @RequestParam(defaultValue="10")int limit,
                                      @RequestParam(name = "name",required = false,defaultValue = "") String name) {
        if(name.equals("")) {
            List<Helprequest> all = helpRequestService.showAll2();
            List<Helprequest> helprequests = helpRequestService.showAllByPage2((page-1)*limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","求助信息");
            map.put("count",all.size());
            map.put("data",helprequests);
            return map;
        }else{
            List<Helprequest> helprequests = helpRequestService.selectByName2(name);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","请求信息");
            map.put("count",helprequests.size());
            map.put("data",helprequests);
            //前端实际调用的是showAll方法,这里留作后续开发备用
            return map;
        }
    }

    @RequestMapping("/request/showall3")
    public Map<String,Object> request3(@RequestParam(defaultValue="1")int page,
                                       @RequestParam(defaultValue="10")int limit,
                                       @RequestParam(name = "name",required = false,defaultValue = "") String name) {
        if(name.equals("")) {
            List<Helprequest> all = helpRequestService.showAll3();
            List<Helprequest> helprequests = helpRequestService.showAllByPage3((page-1)*limit, limit);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","求助信息");
            map.put("count",all.size());
            map.put("data",helprequests);
            return map;
        }else{
            List<Helprequest> helprequests = helpRequestService.selectByName3(name);
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","请求信息");
            map.put("count",helprequests.size());
            map.put("data",helprequests);
            //前端实际调用的是showAll方法,这里留作后续开发备用
            return map;
        }
    }

    @RequestMapping("/request/addIt")
    public String requestAddit(@RequestParam(name = "name",required = false) String name,
                               @RequestParam(name = "phone",required = false) String phone,
                               @RequestParam(name = "animal",required = false) String animal,
                               @RequestParam(name = "location",required = false) String location,
                               @RequestParam(name = "time",required = false) String time,
                               @RequestParam(name = "source",required = false) String source,
                               @RequestParam(name = "description",required = false) String description,
                               HttpSession session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time1 = new Date();
        if(!time.equals("")) {
            try {
                time1 = sdf.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Date recordtime = new Date();
        String recordname = session.getAttribute("loginUser").toString();
        helpRequestService.addIt(name, phone, animal, location, time1, source, description, recordname, recordtime);
        return "success";
    }

    @RequestMapping("/request/editIt")
    //name, phone, animal, location, time, source, description, recordname, recordtime
    public String requestEditit(@RequestParam(name = "id") int id,
                                @RequestParam(name = "name",required = false) String name,
                                @RequestParam(name = "phone",required = false) String phone,
                                @RequestParam(name = "animal",required = false) String animal,
                                @RequestParam(name = "location",required = false) String location,
                                @RequestParam(name = "time",required = false) String time,
                                @RequestParam(name = "source",required = false) String source,
                                @RequestParam(name = "description",required = false) String description,
                                HttpSession session) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time1 = new Date();
        time1 = sdf.parse(time);
        //获取当前时间
        Date recordtime = new Date();
        String recordname = session.getAttribute("loginUser").toString();
        helpRequestService.editIt(id, name, phone, animal, location, time1, source, description, recordname, recordtime);
        return "success";
    }

    @RequestMapping("/request/del")
    public int requestDel(@RequestParam("id")int id) {
        return helpRequestService.deleteById(id);
    }

    @RequestMapping("/request/delAll")
    public String requestDelAll(@RequestParam("ids") String ids) {
        ids = ids.substring(1,ids.length()-1);
        String[] id = ids.split(",");
        int count = 0;
        for (String s : id) {
            count += helpRequestService.deleteById(Integer.parseInt(s));
        }
        return "success";
    }

    @RequestMapping(value = "/request/search")
    public Map<String,Object> search(@RequestParam("name") String name){
        List<Helprequest> helprequests = helpRequestService.selectByName(name);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","请求信息");
        map.put("count",helprequests.size());
        map.put("data",helprequests);
        //前端实际调用的是showAll方法,这里留作后续开发备用
        return map;
    }
}
