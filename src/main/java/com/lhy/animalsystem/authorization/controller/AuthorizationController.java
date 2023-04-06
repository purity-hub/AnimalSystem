package com.lhy.animalsystem.authorization.controller;

import com.lhy.animalsystem.authorization.entity.Authorization;
import com.lhy.animalsystem.authorization.entity.Roles;
import com.lhy.animalsystem.authorization.service.AuthorizationService;
import com.lhy.animalsystem.department.entity.Department;
import com.lhy.animalsystem.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/showtree")
    public Map<String, Object> showTree() {
        List<Authorization> authorizationList = authorizationService.selectByPid(0);
        ArrayList<Object> list = new ArrayList<>();//存放data
        for (Authorization a1 : authorizationList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", a1.getId());
            map.put("title", a1.getName());
            map.put("icon", a1.getIcon());
            //查询该节点下面是否存在二级菜单
            List<Authorization> authorizations = authorizationService.selectByPid((int) a1.getId());
            if (authorizations.size() > 0) {
                ArrayList<Object> list2 = new ArrayList<>();
                for (Authorization a2 : authorizations) {
                    HashMap<String, Object> map2 = new HashMap<>();
                    map2.put("id", a2.getId());
                    map2.put("title", a2.getName());
                    map2.put("icon", a2.getIcon());
                    //查询该节点下面是否存在三级菜单
                    List<Authorization> authorizations2 = authorizationService.selectByPid((int) a2.getId());
                    if (authorizations2.size() > 0) {
                        ArrayList<Object> list3 = new ArrayList<>();
                        for (Authorization a3 : authorizations2) {
                            HashMap<String, Object> map3 = new HashMap<>();
                            map3.put("id", a3.getId());
                            map3.put("title", a3.getName());
                            map3.put("icon", a3.getIcon());
                            list3.add(map3);
                        }
                        map2.put("children", list3);
                    } else {
                        map2.put("children", null);
                    }
                    list2.add(map2);
                }
                map.put("children", list2);
            } else {
                map.put("children", null);
            }
            list.add(map);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", list);
        return map;
    }

    @RequestMapping("/getDepartment")
    public Map<String,Object> getDepartment(){
        List<Department> department = departmentService.getDepartment();
        //用户roles表
        List<Roles> roles = authorizationService.selectRoles(true);
        ArrayList<Object> list1 = new ArrayList<>();
        for (Roles r : roles) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id","r"+r.getRoleid());//加入前缀r，区分部门和角色
            map.put("title",r.getName());
            map.put("icon","layui-icon layui-icon-user");
            list1.add(map);
        }
        for (Department d : department) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id","d"+d.getDepartmentId());//加入前缀d，区分部门和角色
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

    @RequestMapping("/selectMenu")
    public List<Integer> selectMenu(@RequestParam("departmentId") String departmentId) {
        //将departmentId截取，去掉前缀
        String type = departmentId.substring(0, 1);
        if (type.equals("r")) {
            //角色
            return authorizationService.selectMenuByRole(Integer.valueOf(departmentId.substring(1)));
        } else {
            //部门
            return authorizationService.selectMenuByDepartment(Integer.valueOf(departmentId.substring(1)));
        }
    }

    @RequestMapping("/editMenu")
    public String editMenu(@RequestParam("departmentId") String departmentId,
                           @RequestParam("ids") String ids){
        //查询之前的菜单选择
        ids= ids.substring(1,ids.length()-1);
        String[] ids1 = ids.split(",");
        //将ids1转换成int数组
        int[] ids2 = new int[ids1.length];
        for(int i=0;i<ids1.length;i++){
            ids2[i]=Integer.parseInt(ids1[i]);
        }
        String type = departmentId.substring(0, 1);
        int subid = Integer.parseInt(departmentId.substring(1));
        if (type.equals("r")) {
            //角色
            List<Integer> list = authorizationService.selectMenuByRole(subid);
            for(int id:ids2){
                if(authorizationService.selectRole(subid,id)==0){
                    //数据库中不存在该记录，插入
                    authorizationService.insertRole(subid,id);
                }
            }
            for(int id:list){
                if(!isContain(id,ids2)){
                    //数据库中存在该记录，删除
                    authorizationService.deleteRole(subid,id);
                }
            }
        } else {
            //部门
            List<Integer> list = authorizationService.selectMenuByDepartment(subid);
            for(int id:ids2){
                //id为authorization表中的id
                if(authorizationService.select(subid,id)==0){
                    //数据库中不存在该记录，插入
                    authorizationService.insert(subid,id);
                }
            }
            for(int id:list){
                if(!isContain(id,ids2)){
                    //数据库中存在该记录，删除
                    authorizationService.delete(subid,id);
                }
            }
        }

        return "success";
    }

    private boolean isContain(int id, int[] ids) {
        for(int i:ids){
            if(i==id){
                return true;
            }
        }
        return false;
    }

}
