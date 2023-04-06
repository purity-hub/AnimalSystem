package com.lhy.animalsystem.login.service;

import com.lhy.animalsystem.login.entity.User;

import java.util.List;

public interface LoginService {
    List<User> selectAllUser();
    //用户名和密码查询
    int selectUserPass(String username,String password);

    int selectIdByName(String username);
}
