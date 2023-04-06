package com.lhy.animalsystem.dictionary.mapper;

import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.entity.SysDictValue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictionaryValueMapper {


    SysDictValue selectDictById(int id);

    void updateDictValue(SysDictValue sysDictValue);

    int deleteDictValue(int id);

    void insertDictValue(SysDictValue sysDictValue);
}
