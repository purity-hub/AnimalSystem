package com.lhy.animalsystem.department.controller;

import com.lhy.animalsystem.department.entity.Department;
import com.lhy.animalsystem.department.service.DepartmentService;
import com.lhy.animalsystem.system.annotation.MyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    //这个controller专门用于json数据传递

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/list")
    public Department list(@RequestParam("deptname") String deptname){
        return departmentService.selectByDeptname(deptname);
    }

    @RequestMapping("/getDepartment")
    public Map<String,Object> getDepartment(){
        List<Department> department = departmentService.getDepartment();
        HashMap<String, Object> ChangeMap = new HashMap<>();
        ArrayList<Object> list1 = new ArrayList<>();
        for (Department d : department) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",d.getDepartmentId());
            map.put("title",d.getDeptname());
            map.put("icon","layui-icon layui-icon-group");
            list1.add(map);
        }
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<String,Object>();
        //加入父级树
        map.put("title","动物园");
        map.put("spread",true);//展开
        map.put("children",list1);
        list.add(map);
        Map<String, Object> Resultmap = new HashMap<String,Object>();
        Resultmap.put("code",0);
        Resultmap.put("msg","");
        Resultmap.put("count",list.size());
        Resultmap.put("data",list);
        return Resultmap;
    }

    @RequestMapping("edit")
    @MyLog(value = "修改部门")
    public String edit(@RequestParam("departmentId") int departmentId,
                    @RequestParam("deptname") String deptname,
                    @RequestParam("people") String people,
                    @RequestParam("phone") String phone,
                    @RequestParam("order") int order,
                    @RequestParam("introduction") String introduction){
            departmentService.edit(people,introduction,order,phone,deptname,departmentId);
            return "success";
    }
}
