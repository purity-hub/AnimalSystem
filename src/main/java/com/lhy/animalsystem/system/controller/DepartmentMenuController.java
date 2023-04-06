package com.lhy.animalsystem.system.controller;

import com.lhy.animalsystem.system.entity.Menu;
import com.lhy.animalsystem.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/menu")
public class DepartmentMenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/departmentMenu")
    public Map<String,Object> departmentMenu(){
        //获取所有菜单树状展示
        //List<Menu> menu = menuService.selectAll();
        List<Menu> menus1 = menuService.selectByPid(0);//一级菜单
        //List<Menu> menus2 = menuService.selectByPid(1);//二级菜单
        ArrayList<Object> list = new ArrayList<>();//存放data
        for(Menu m1:menus1){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",m1.getMenuid());
            map.put("title",m1.getName());
            //查询该节点下面是否存在二级菜单
            List<Menu> menus = menuService.selectByParentId((int) m1.getMenuid());
            if(menus.size()>0){
                ArrayList<Object> list2 = new ArrayList<>();
                for(Menu m2:menus){
                    HashMap<String, Object> map2 = new HashMap<>();
                    map2.put("id",m2.getMenuid());
                    map2.put("title",m2.getName());
                    list2.add(map2);
                }
                map.put("children",list2);
            }else{
                map.put("children",null);
            }
            list.add(map);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",list);
        return map;
    }

    @RequestMapping("/selectMenu")
    public List<Integer> selectMenuByDepartment(@RequestParam("departmentId") Integer departmentId){
        return menuService.selectMenuByDepartment(departmentId);
    }

    @RequestMapping("/editMenu")
    public String editMenu(@RequestParam("departmentId") int departmentId,
                         @RequestParam("ids") String ids){
        //查询之前的菜单选择
        ids= ids.substring(1,ids.length()-1);
        String[] ids1 = ids.split(",");
        //将ids1转换成int数组
        int[] ids2 = new int[ids1.length];
        for(int i=0;i<ids1.length;i++){
            ids2[i]=Integer.parseInt(ids1[i]);
        }
        List<Integer> list = menuService.selectMenuByDepartment(departmentId);
        for(int id:ids2){
            if(menuService.select(departmentId,id)==0){
                //数据库中不存在该记录，插入
                menuService.insert(departmentId,id);
            }
        }
        for(int id:list){
            if(!isContain(id,ids2)){
                //数据库中存在该记录，删除
                menuService.delete(departmentId,id);
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

    @RequestMapping("/MenuByDepartment")
    private Map<String,Object> selectMenuByDepartment(@RequestParam("username") String username){
        String department = menuService.selectDepartmentByUsername(username);//获取部门,设置权限
        int departname = menuService.selectIdByDepartname(department);
        List<Integer> list1 = menuService.selectMenuByDepartment(departname);
        Set<Menu> menus1 = new TreeSet<>((o1, o2) -> o1.getParentid() - o2.getParentid() == 0 ? o1.getOrder() - o2.getOrder() : (int) (o1.getParentid() - o2.getParentid()));//存储子节点
        Set<Menu> menus2 = new TreeSet<>((o1, o2) -> o1.getPid() - o2.getPid() == 0 ? o1.getOrder() - o2.getOrder() : (int) (o1.getPid() - o2.getPid()));//存储父节点
        for(int id:list1){
            //根据id查询菜单
            Menu menu = menuService.selectMenu(id);
            menus1.add(menu);
        }
        for (Menu menu:menus1){
            if(menu.getParentid()!=0){
                //存在父节点
                Menu menu1 = menuService.selectMenu((int) menu.getParentid());
                //删除重复的父节点
                menus2.add(menu1);
            }else{
                //parentid为0的菜单--没有子节点的父节点
                menus2.add(menu);
            }
        }
        List<Map<String,Object>> list = new ArrayList<>();
        for(Menu menu:menus2){
            //对于每个父节点
            HashMap<String,Object> map = new HashMap<>();
            map.put("id",menu.getMenuid());
            map.put("title",menu.getName());
            map.put("url",menu.getUrl());
            ArrayList<Object> list2 = new ArrayList<>();
            for (Menu menu1:menus1){
                //对于每个子节点,查询是否与父节点关联
                if(menu1.getParentid()==menu.getMenuid()){
                    HashMap<String,Object> map2 = new HashMap<>();
                    map2.put("id",menu1.getMenuid());
                    map2.put("title",menu1.getName());
                    map2.put("url",menu1.getUrl());
                    list2.add(map2);
                }
            }
            map.put("children",list2);
            list.add(map);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","动态菜单");
        map.put("data",list);
        return map;
    }

}
