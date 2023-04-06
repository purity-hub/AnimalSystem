package com.lhy.animalsystem.helprequest.service;

import com.lhy.animalsystem.helprequest.entity.Helprequest;
import com.lhy.animalsystem.login.entity.User;

import java.util.List;

public interface HelpRequestService {
    List<Helprequest> showAllByPage(int page, int limit);

    List<Helprequest> showAll();

    Helprequest selectById(int id);

    void addIt(String name, String phone, String animal, String location, java.util.Date time, String source, String description, String recordname, java.util.Date recordtime);

    void editIt(int id, String name, String phone, String animal, String location, java.util.Date time, String source, String description, String recordname, java.util.Date recordtime);

    int deleteById(int id);

    List<Helprequest> selectByName(String name);

    void editInfo(int id, int i, String type, int veterinarianid,int assignpeopleid,java.sql.Date assigntime);

    List<Helprequest> showAll2();

    List<Helprequest> showAllByPage2(int page, int limit);

    List<Helprequest> selectByName2(String name);

    void editInfo2(int id, String type, int veterinarianid);

    void updatetreatment(int id, String injury, String treatmentplan);

    void updatestate(int id, int state);

    List<Helprequest> showAll3();

    List<Helprequest> showAllByPage3(int page, int limit);

    List<Helprequest> selectByName3(String name);
}
