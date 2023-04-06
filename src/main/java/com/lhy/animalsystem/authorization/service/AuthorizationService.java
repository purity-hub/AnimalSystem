package com.lhy.animalsystem.authorization.service;

import com.lhy.animalsystem.authorization.entity.Authorization;
import com.lhy.animalsystem.authorization.entity.Roles;

import java.util.List;

public interface AuthorizationService {
    List<Authorization> selectByPid(int pid);

    List<Roles> selectRoles(boolean b);

    List<Integer> selectMenuByDepartment(Integer departmentId);

    List<Integer> selectMenuByRole(Integer roleId);

    int select(int subid, int id);

    void insert(int subid, int id);

    void delete(int subid, int id);

    int selectRole(int subid, int id);

    void insertRole(int subid, int id);

    void deleteRole(int subid, int id);
}
