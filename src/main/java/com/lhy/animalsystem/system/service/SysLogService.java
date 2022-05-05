package com.lhy.animalsystem.system.service;

import com.lhy.animalsystem.system.entity.SysLog;

import java.util.List;

public interface SysLogService {

    void save(String username,String operation,String method,String params,String ip);

    List<SysLog> findAll();

    int deleteLogById(int id);
}
