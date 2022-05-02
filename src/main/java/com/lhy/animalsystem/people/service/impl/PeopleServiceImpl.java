package com.lhy.animalsystem.people.service.impl;

import com.lhy.animalsystem.login.entity.User;
import com.lhy.animalsystem.people.mapper.PeopleMapper;
import com.lhy.animalsystem.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    PeopleMapper peopleMapper;

    @Override
    public List<User> selectAll() {
        return peopleMapper.selectAll();
    }

    @Override
    public List<User> selectByPage(String name,String departname,int page, int limit) {
        return peopleMapper.selectByPage(name,departname,page, limit);
    }

    @Override
    public User selectByUsername(String username) {
        return peopleMapper.selectByUsername(username);
    }

    @Override
    public int deleteByUsername(String username) {
        return peopleMapper.deleteByUsername(username);
    }

    @Override
    public int UpdatePeople(String name, String password, String sex, String Idnumber, Date birth, String politicalface, String office, String jobtitle, int worknumber, String profession, String departname, Date worktime, String post, String officephone, String residentialphone, String email, String attribute, String degee, String username) {
        return peopleMapper.UpdatePeople(name, password, sex, Idnumber, birth, politicalface, office, jobtitle, worknumber, profession, departname, worktime, post, officephone, residentialphone, email, attribute, degee, username);
    }

    @Override
    public int AddIt(String name, String username, String password, String sex, String Idnumber, Date birth, String politicalface, String office, String jobtitle, int worknumber, String profession, String departname, Date worktime, String post, String officephone, String residentialphone, String email, String attribute, String degee) {
        return peopleMapper.AddIt(name, username, password, sex, Idnumber, birth, politicalface, office, jobtitle, worknumber, profession, departname, worktime, post, officephone, residentialphone, email, attribute, degee);
    }

    @Override
    public User selectByName(String name) {
        return peopleMapper.selectByName(name);
    }

    @Override
    public List<User> selectByDepartname(String departname) {
        return peopleMapper.selectByDepartname(departname);
    }


}
