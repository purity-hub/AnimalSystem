package com.lhy.animalsystem.login.service.impl;

import com.lhy.animalsystem.login.entity.User;
import com.lhy.animalsystem.login.mapper.LoginMapper;
import com.lhy.animalsystem.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public List<User> selectAllUser() {
        return loginMapper.selectAllUser();
    }

    @Override
    public int selectUserPass(String username, String password) {
        return loginMapper.selectUserPass(username,password);
    }

    @Override
    public int selectIdByName(String username) {
        return loginMapper.selectIdByName(username);
    }
}
