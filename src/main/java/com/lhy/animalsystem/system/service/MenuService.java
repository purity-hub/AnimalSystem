package com.lhy.animalsystem.system.service;

import com.lhy.animalsystem.system.entity.Menu;

import java.util.List;

public interface MenuService {

    public List<Menu> selectAll();

    public List<Menu> selectByPid(int pid);

    List<Menu> selectByParentId(int parentid);

    public List<Integer> selectMenuByDepartment(int departmentid);

    int select(int departmentid, int menuid);

    int insert(int departmentid, int menuid);

    int delete(int departmentid, int menuid);

}
