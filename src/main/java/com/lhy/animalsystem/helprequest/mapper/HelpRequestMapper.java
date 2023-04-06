package com.lhy.animalsystem.helprequest.mapper;

import com.lhy.animalsystem.helprequest.entity.Helprequest;
import com.lhy.animalsystem.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HelpRequestMapper {
    List<Helprequest> showAllByPage(@Param("page") int page, @Param("limit") int limit);

    List<Helprequest> showAll();

    Helprequest selectById(int id);

    void addIt(@Param("name") String name, @Param("phone") String phone, @Param("animal") String animal, @Param("location") String location, @Param("time") java.util.Date time, @Param("source") String source, @Param("description") String description, @Param("recordname") String recordname, @Param("recordtime") java.util.Date recordtime);

    void editIt(@Param("id") int id, @Param("name") String name, @Param("phone") String phone, @Param("animal") String animal, @Param("location") String location, @Param("time") java.util.Date time, @Param("source") String source, @Param("description") String description, @Param("recordname") String recordname, @Param("recordtime") java.util.Date recordtime);

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
