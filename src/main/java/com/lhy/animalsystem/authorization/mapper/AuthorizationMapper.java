package com.lhy.animalsystem.authorization.mapper;

import com.lhy.animalsystem.authorization.entity.Authorization;
import com.lhy.animalsystem.authorization.entity.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorizationMapper {
    List<Authorization> selectByPid(@Param("pid")int pid);

    List<Roles> selectRoles(@Param("b")boolean b);

    List<Integer> selectMenuByDepartment(Integer departmentId);

    List<Integer> selectMenuByRole(Integer roleId);

    int select(int subid, int id);

    void insert(int subid, int id);

    void delete(int subid, int id);

    int selectRole(int subid, int id);

    void insertRole(int subid, int id);

    void deleteRole(int subid, int id);
}
