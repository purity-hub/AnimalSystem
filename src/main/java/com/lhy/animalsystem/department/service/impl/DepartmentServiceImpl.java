package com.lhy.animalsystem.department.service.impl;

import com.lhy.animalsystem.department.entity.Department;
import com.lhy.animalsystem.department.mapper.DepartmentMapper;
import com.lhy.animalsystem.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public Department selectByDeptname(String deptname) {
        return departmentMapper.selectByDeptname(deptname);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentMapper.getDepartment();
    }

    @Override
    public int edit(String header, String introduction, int order, String phone, String deptname, int departmentId) {
        return departmentMapper.edit(header, introduction, order, phone, deptname, departmentId);
    }
}
