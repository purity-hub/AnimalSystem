package com.lhy.animalsystem.helprequest.service.impl;

import com.lhy.animalsystem.helprequest.entity.Helprequest;
import com.lhy.animalsystem.helprequest.mapper.HelpRequestMapper;
import com.lhy.animalsystem.helprequest.service.HelpRequestService;
import com.lhy.animalsystem.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpRequestServiceImpl implements HelpRequestService {

    @Autowired
    private HelpRequestMapper helpRequestMapper;
    @Override
    public List<Helprequest> showAllByPage(int page, int limit) {
        return helpRequestMapper.showAllByPage(page, limit);
    }

    @Override
    public List<Helprequest> showAll() {
        return helpRequestMapper.showAll();
    }

    @Override
    public Helprequest selectById(int id) {
        return helpRequestMapper.selectById(id);
    }

    @Override
    public void addIt(String name, String phone, String animal, String location, java.util.Date time, String source, String description, String recordname, java.util.Date recordtime) {
        helpRequestMapper.addIt(name, phone, animal, location, time, source, description, recordname, recordtime);
    }

    @Override
    public void editIt(int id, String name, String phone, String animal, String location, java.util.Date time, String source, String description, String recordname, java.util.Date recordtime) {
        helpRequestMapper.editIt(id, name, phone, animal, location, time, source, description, recordname, recordtime);
    }

    @Override
    public int deleteById(int id) {
        return helpRequestMapper.deleteById(id);
    }

    @Override
    public List<Helprequest> selectByName(String name) {
        return helpRequestMapper.selectByName("%"+name+"%");
    }

    @Override
    public void editInfo(int id, int i, String type, int veterinarianid,int assignpeopleid,java.sql.Date assigntime) {
        helpRequestMapper.editInfo(id, i, type, veterinarianid,assignpeopleid,assigntime);
    }

    @Override
    public List<Helprequest> showAll2() {
        return helpRequestMapper.showAll2();
    }

    @Override
    public List<Helprequest> showAllByPage2(int page, int limit) {
        return helpRequestMapper.showAllByPage2(page, limit);
    }

    @Override
    public List<Helprequest> selectByName2(String name) {
        return helpRequestMapper.selectByName2("%"+name+"%");
    }

    @Override
    public void editInfo2(int id, String type, int veterinarianid) {
        helpRequestMapper.editInfo2(id, type, veterinarianid);
    }

    @Override
    public void updatetreatment(int id, String injury, String treatmentplan) {
        helpRequestMapper.updatetreatment(id, injury, treatmentplan);
    }

    @Override
    public void updatestate(int id, int state) {
        helpRequestMapper.updatestate(id, state);
    }

    @Override
    public List<Helprequest> showAll3() {
        return helpRequestMapper.showAll3();
    }

    @Override
    public List<Helprequest> showAllByPage3(int page, int limit) {
        return helpRequestMapper.showAllByPage3(page, limit);
    }

    @Override
    public List<Helprequest> selectByName3(String name) {
        return helpRequestMapper.selectByName3("%"+name+"%");
    }
}
