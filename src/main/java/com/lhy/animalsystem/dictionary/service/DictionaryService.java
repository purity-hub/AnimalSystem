package com.lhy.animalsystem.dictionary.service;

import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.entity.SysDictValue;

import java.util.List;

public interface DictionaryService {

    List<SysDict> selectAllDict();

    List<SysDict> selectByPage(int page, int limit);

    List<SysDictValue> selectDictValue(int parentid);

    List<SysDictValue> selectValueByPage(int parentid,int page, int limit);

    int insertDict(String name,String code,String info);

    SysDict selectDictById(int id);

    int updateDict(int id,String name,String code,String info);

    int deleteDict(int id);

    int deleteAllDict(List<Integer> list);

    List<SysDict> selectDictByName(String name);

    List<SysDict> selectByName(String name);

    List<SysDict> selectByNamePage(String name, int page, int limit);

    List<String> selectByType(String code);
}
