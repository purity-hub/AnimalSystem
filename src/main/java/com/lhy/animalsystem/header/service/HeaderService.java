package com.lhy.animalsystem.header.service;

import com.lhy.animalsystem.login.entity.User;

public interface HeaderService {
    User selectUser(String loginUser);

    int editInfo(String username, String name, String password, String loginUser);
}
