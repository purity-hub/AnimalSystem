package com.lhy.animalsystem.system.mapper;

import com.lhy.animalsystem.system.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysLogMapper {

    public int save(@Param("username") String username, @Param("operation") String operation, @Param("method") String method, @Param("params") String params, @Param("ip") String ip);

    public List<SysLog> findAll();

    public int deleteLogById(@Param("id") int id);
}
