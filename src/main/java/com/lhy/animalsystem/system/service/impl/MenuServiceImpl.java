package com.lhy.animalsystem.system.service.impl;

import com.lhy.animalsystem.system.entity.Menu;
import com.lhy.animalsystem.system.mapper.MenuMapper;
import com.lhy.animalsystem.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> selectAll() {
        return menuMapper.selectAll();
    }

    @Override
    public List<Menu> selectByPid(int pid) {
        return menuMapper.selectByPid(pid);
    }

    @Override
    public List<Menu> selectByParentId(int parentid) {
        return menuMapper.selectByParentId(parentid);
    }

    @Override
    public List<Integer> selectMenuByDepartment(int departmentid) {
        return menuMapper.selectMenuByDepartment(departmentid);
    }

    @Override
    public int select(int departmentid, int menuid) {
        return menuMapper.select(departmentid, menuid);
    }

    @Override
    public int insert(int departmentid, int menuid) {
        return menuMapper.insert(departmentid, menuid);
    }

    @Override
    public int delete(int departmentid, int menuid) {
        return menuMapper.delete(departmentid, menuid);
    }

    @Override
    public String selectDepartmentByUsername(String username) {
        return menuMapper.selectDepartmentByUsername(username);
    }

    @Override
    public int selectIdByDepartname(String deptname) {
        return menuMapper.selectIdByDepartname(deptname);
    }

    @Override
    public List<Integer> selectMenuid(int departmentId) {
        return menuMapper.selectMenuid(departmentId);
    }

    @Override
    public Menu selectMenu(int menuid) {
        return menuMapper.selectMenu(menuid);
    }
}
