package com.lhy.animalsystem.dictionary.service.impl;

import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.entity.SysDictValue;
import com.lhy.animalsystem.dictionary.mapper.DictionaryMapper;
import com.lhy.animalsystem.dictionary.mapper.DictionaryValueMapper;
import com.lhy.animalsystem.dictionary.service.DictionaryValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryValueServiceImpl implements DictionaryValueService {

    @Autowired
    DictionaryValueMapper dictionaryValueMapper;

    @Override
    public SysDictValue selectDictById(int id) {
        return dictionaryValueMapper.selectDictById(id);
    }

    @Override
    public void updateDictValue(SysDictValue sysDictValue) {
        dictionaryValueMapper.updateDictValue(sysDictValue);
    }

    @Override
    public int deleteDictValue(int id) {
        return dictionaryValueMapper.deleteDictValue(id);
    }

    @Override
    public void insertDictValue(SysDictValue sysDictValue) {
        dictionaryValueMapper.insertDictValue(sysDictValue);
    }
}
