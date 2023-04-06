package com.lhy.animalsystem.header.mapper;

import com.lhy.animalsystem.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HeaderMapper {
    User selectUser(@Param("username") String username);

    int editInfo(String username, String name, String password, String loginUser);
}
