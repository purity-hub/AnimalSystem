package com.lhy.animalsystem.people.service;

import com.lhy.animalsystem.department.entity.Department;
import com.lhy.animalsystem.login.entity.User;

import java.util.Date;
import java.util.List;

public interface PeopleService {

    List<User> selectAll();

    List<User> selectByPage(String name,String departname,int page,int limit);

    User selectByUsername(String username);

    int deleteByUsername(String username);

    int UpdatePeople(String name, String password, String sex, String Idnumber, Date birth, String politicalface, String office, String jobtitle, int worknumber, String profession, String departname, Date worktime, String post, String officephone, String residentialphone, String email, String attribute, String degee, String username);

    int AddIt(String name,String username, String password, String sex, String Idnumber, Date birth, String politicalface, String office, String jobtitle, int worknumber, String profession, String departname, Date worktime, String post, String officephone, String residentialphone, String email, String attribute, String degee);

    User selectByName(String name);

    List<User> selectByDepartname(String departname);
}
