package com.lhy.animalsystem.header.service.impl;

import com.lhy.animalsystem.header.mapper.HeaderMapper;
import com.lhy.animalsystem.header.service.HeaderService;
import com.lhy.animalsystem.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaderServiceImpl implements HeaderService {

    @Autowired
    HeaderMapper headerMapper;
    @Override
    public User selectUser(String loginUser) {
        return headerMapper.selectUser(loginUser);
    }

    @Override
    public int editInfo(String username, String name, String password, String loginUser) {
        return headerMapper.editInfo(username,name,password,loginUser);
    }
}
