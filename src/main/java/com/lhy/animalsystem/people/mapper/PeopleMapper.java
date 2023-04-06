package com.lhy.animalsystem.people.mapper;

import com.lhy.animalsystem.department.entity.Department;
import com.lhy.animalsystem.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface PeopleMapper {

    List<User> selectAll();

    List<User> selectByPage(@Param("name") String name,@Param("departname") String departname,@Param("page")int page,@Param("limit")int limit);

    User selectByUsername(@Param("username") String username);

    int deleteByUsername(@Param("username")String username);

    int UpdatePeople(@Param("name")String name,  @Param("password")String password, @Param("sex")String sex, @Param("Idnumber") String Idnumber,@Param("birth") Date birth,@Param("politicalface") String politicalface,@Param("office") String office,@Param("jobtitle") String jobtitle,@Param("worknumber")int worknumber,@Param("profession")String profession,@Param("departname") String departname,@Param("worktime") Date worktime,@Param("post") String post,@Param("officephone") String officephone,@Param("residentialphone") String residentialphone,@Param("email") String email,@Param("attribute") String attribute,@Param("degee") String degee,@Param("username")String username);

    int AddIt(@Param("name")String name,@Param("username")String username,  @Param("password")String password, @Param("sex")String sex, @Param("Idnumber") String Idnumber,@Param("birth") Date birth,@Param("politicalface") String politicalface,@Param("office") String office,@Param("jobtitle") String jobtitle,@Param("worknumber")int worknumber,@Param("profession")String profession,@Param("departname") String departname,@Param("worktime") Date worktime,@Param("post") String post,@Param("officephone") String officephone,@Param("residentialphone") String residentialphone,@Param("email") String email,@Param("attribute") String attribute,@Param("degee") String degee);

    List<User> selectByName(@Param("name")String name);

    List<User> selectByDepartname(@Param("departname")String departname);
}
