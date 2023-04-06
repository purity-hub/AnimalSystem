package com.lhy.animalsystem.authorization.service.impl;

import com.lhy.animalsystem.authorization.entity.Authorization;
import com.lhy.animalsystem.authorization.entity.Roles;
import com.lhy.animalsystem.authorization.mapper.AuthorizationMapper;
import com.lhy.animalsystem.authorization.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    AuthorizationMapper authorizationMapper;
    @Override
    public List<Authorization> selectByPid(int pid) {
        return authorizationMapper.selectByPid(pid);
    }

    @Override
    public List<Roles> selectRoles(boolean b) {
        return authorizationMapper.selectRoles(b);
    }

    @Override
    public List<Integer> selectMenuByDepartment(Integer departmentId) {
        return authorizationMapper.selectMenuByDepartment(departmentId);
    }

    @Override
    public List<Integer> selectMenuByRole(Integer roleId) {
        return authorizationMapper.selectMenuByRole(roleId);
    }

    @Override
    public int select(int subid, int id) {
        return authorizationMapper.select(subid,id);
    }

    @Override
    public void insert(int subid, int id) {
        authorizationMapper.insert(subid,id);
    }

    @Override
    public void delete(int subid, int id) {
        authorizationMapper.delete(subid,id);
    }

    @Override
    public int selectRole(int subid, int id) {
        return authorizationMapper.selectRole(subid,id);
    }

    @Override
    public void insertRole(int subid, int id) {
        authorizationMapper.insertRole(subid,id);
    }

    @Override
    public void deleteRole(int subid, int id) {
        authorizationMapper.deleteRole(subid,id);
    }
}
