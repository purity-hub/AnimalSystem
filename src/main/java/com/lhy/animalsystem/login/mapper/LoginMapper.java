package com.lhy.animalsystem.login.mapper;

import com.lhy.animalsystem.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper {

    //查询全部的用户名---用于测试mybatis是否正常工作
    List<User> selectAllUser();
    //用户名和密码查询
    int selectUserPass(@Param("username") String username,@Param("password") String password);
}
