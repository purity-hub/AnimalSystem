package com.lhy.animalsystem.people.controller;

import com.lhy.animalsystem.department.entity.Department;
import com.lhy.animalsystem.login.entity.User;
import com.lhy.animalsystem.people.service.PeopleService;
import com.lhy.animalsystem.system.annotation.MyLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.DateUtils;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/people")
public class PeopleController {
    //这个controller专门用于json数据传递

    @Autowired
    PeopleService peopleService;

    @RequestMapping(value = "/showall",produces="application/json")
    public Map<String,Object> AllDepartment(@RequestParam(defaultValue="1")int page,
                                            @RequestParam(defaultValue="10")int limit,
                                            @RequestParam(name = "name",required = false,defaultValue = "") String name,
                                            @RequestParam(name = "departname",required = false,defaultValue = "") String departname){
        List<User> users = peopleService.selectAll();
        int size = users.size();
        List<User> peoples = new ArrayList<>();
        if(!Objects.equals(departname, "动物园")){
            //查询部门
            peoples = peopleService.selectByPage("%"+name+"%","%"+departname+"%",(page-1) * limit, limit);
        }else{
            //点击动物园时，查询所有人员
            peoples = peopleService.selectAll();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        //name用于搜索框搜索
        map.put("name",name);
        //departname用于树状图搜索
        map.put("departname",departname);
        map.put("msg","人员信息");
        if(departname.equals("")){
            //未选择部门时,其总数是所有人员的总数
            map.put("count",size);
        }else{
            //选择部门时,其总数是该部门人员的总数
            map.put("count",peoples.size());
        }
        map.put("data",peoples);
        return map;
    }

    @RequestMapping("/editIt")
    @MyLog("修改人员信息")
    public int edit(@RequestParam("name") String name,
                    @RequestParam("username") String username,
                    @RequestParam("password") String password,
                    @RequestParam("sex") String sex,
                    @RequestParam("Idnumber") String Idnumber,
                    @RequestParam("birth") String birth,
                    @RequestParam("politicalface") String politicalface,
                    @RequestParam("office") String office,
                    @RequestParam("jobtitle") String jobtitle,
                    @RequestParam("worknumber") int worknumber,
                    @RequestParam("profession") String profession,
                    @RequestParam("departname") String departname,
                    @RequestParam("worktime") String worktime,
                    @RequestParam("post") String post,
                    @RequestParam("officephone") String officephone,
                    @RequestParam("residentialphone") String residentialphone,
                    @RequestParam("email") String email,
                    @RequestParam("attribute") String attribute,
                    @RequestParam("degee") String degee) throws ParseException {
        //将字符串类型转化为时间类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth1 = sdf.parse(birth);
        Date worktime1 = sdf.parse(worktime);
        return peopleService.UpdatePeople(name, password, sex, Idnumber, birth1, politicalface, office, jobtitle, worknumber, profession, departname, worktime1, post, officephone, residentialphone, email, attribute, degee, username);
    }

    @RequestMapping("/del")
    @MyLog("删除人员信息")
    public int del(@RequestParam("username") String username){
        return peopleService.deleteByUsername(username);
    }

    @RequestMapping("/delAll")
    @MyLog("批量删除人员信息")
    public String delAll(@RequestParam("usernames") String usernames){
        //批量删除
        usernames=usernames.substring(1,usernames.length()-1);
        usernames=usernames.replace("\"","");
        String[] arr = usernames.split(",");
        for(int i=0;i<arr.length;i++){
            del(arr[i]);
        }
        return "success";
    }
    @RequestMapping("/addIt")
    @MyLog("添加人员信息")
    public int addIt(@RequestParam("name") String name,
                     @RequestParam("username") String username,
                     @RequestParam("password") String password,
                     @RequestParam("sex") String sex,
                     @RequestParam("Idnumber") String Idnumber,
                     @RequestParam("birth") String birth,
                     @RequestParam("politicalface") String politicalface,
                     @RequestParam("office") String office,
                     @RequestParam("jobtitle") String jobtitle,
                     @RequestParam("worknumber") int worknumber,
                     @RequestParam("profession") String profession,
                     @RequestParam("departname") String departname,
                     @RequestParam("worktime") String worktime,
                     @RequestParam("post") String post,
                     @RequestParam("officephone") String officephone,
                     @RequestParam("residentialphone") String residentialphone,
                     @RequestParam("email") String email,
                     @RequestParam("attribute") String attribute,
                     @RequestParam("degee") String degee) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth1 = sdf.parse(birth);
        Date worktime1 = sdf.parse(worktime);
        return peopleService.AddIt(name,username, password, sex, Idnumber, birth1, politicalface, office, jobtitle, worknumber, profession, departname, worktime1, post, officephone, residentialphone, email, attribute, degee);
    }

    @RequestMapping(value = "/search")
    public Map<String,Object> search(@RequestParam("name") String name){
        List<User> user = peopleService.selectByName(name);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","人员信息");
        map.put("count",user.size());
        map.put("data",user);
        //前端实际调用的是showAll方法,这里留作后续开发备用
        return map;
    }
    @RequestMapping(value = "/departname")
    public Map<String,Object> searchByDepartname(@RequestParam("departname") String departname){
        List<User> user = peopleService.selectByDepartname(departname);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","人员信息");
        map.put("count",user.size());
        map.put("data",user);
        //前端实际调用的是showAll方法,这里留作后续开发备用
        return map;
    }

}
