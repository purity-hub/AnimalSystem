package com.lhy.animalsystem.system.service.impl;

import com.lhy.animalsystem.system.entity.SysLog;
import com.lhy.animalsystem.system.mapper.SysLogMapper;
import com.lhy.animalsystem.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogMapper sysLogMapper;


    @Override
    public void save(String username, String operation, String method, String params, String ip) {
        sysLogMapper.save(username,operation,method,params,ip);
    }

    @Override
    public List<SysLog> findAll() {
        return sysLogMapper.findAll();
    }

    @Override
    public int deleteLogById(int id) {
        return sysLogMapper.deleteLogById(id);
    }
}
