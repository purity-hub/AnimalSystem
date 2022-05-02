package com.lhy.animalsystem.department.controller;

import com.lhy.animalsystem.department.entity.Department;
import com.lhy.animalsystem.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/department")
public class DepartmentController1 {
    //这个controller专门用于跳转页面

    @Autowired
    DepartmentService departmentService;

}
