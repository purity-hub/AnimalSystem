package com.lhy.animalsystem.system.mapper;

import com.lhy.animalsystem.system.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> selectAll();

    List<Menu> selectByPid(@Param("pid") int pid);

    List<Menu> selectByParentId(@Param("parentid") int parentid);

    List<Integer> selectMenuByDepartment(@Param("departmentid") int departmentid);

    int select(@Param("departmentid") int departmentid, @Param("menuid") int menuid);

    int insert(@Param("departmentid") int departmentid, @Param("menuid") int menuid);

    int delete(@Param("departmentid") int departmentid, @Param("menuid") int menuid);
}
