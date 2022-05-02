package com.lhy.animalsystem.department.mapper;

import com.lhy.animalsystem.department.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    Department selectByDeptname(@Param("deptname") String deptname);

    List<Department> getDepartment();

    int edit(@Param("header") String header, @Param("introduction") String introduction, @Param("order") int order,@Param("phone") String phone,@Param("deptname") String deptname,@Param("departmentId") int departmentId);
}
