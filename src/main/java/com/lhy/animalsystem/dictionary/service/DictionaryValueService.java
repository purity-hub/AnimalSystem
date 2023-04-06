package com.lhy.animalsystem.dictionary.service;

import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.entity.SysDictValue;

public interface DictionaryValueService {
    SysDictValue selectDictById(int id);

    void updateDictValue(SysDictValue sysDictValue);

    int deleteDictValue(int id);

    void insertDictValue(SysDictValue sysDictValue);
}
