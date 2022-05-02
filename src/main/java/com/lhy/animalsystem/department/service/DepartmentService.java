package com.lhy.animalsystem.department.service;

import com.lhy.animalsystem.department.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department selectByDeptname(String deptname);


    List<Department> getDepartment();

    public int edit(String header,String introduction,int order,String phone,String deptname,int departmentId);
}
