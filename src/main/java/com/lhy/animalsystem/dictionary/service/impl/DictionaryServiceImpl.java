package com.lhy.animalsystem.dictionary.service.impl;

import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.entity.SysDictValue;
import com.lhy.animalsystem.dictionary.mapper.DictionaryMapper;
import com.lhy.animalsystem.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public List<SysDict> selectAllDict() {
        return dictionaryMapper.selectAllDict();
    }

    @Override
    public List<SysDict> selectByPage(int page, int limit) {
        return dictionaryMapper.selectByPage(page,limit);
    }

    @Override
    public List<SysDictValue> selectDictValue(int parentid) {
        return dictionaryMapper.selectDictValue(parentid);
    }

    @Override
    public List<SysDictValue> selectValueByPage(int parentid, int page, int limit) {
        return dictionaryMapper.selectValueByPage(parentid, page, limit);
    }

    @Override
    public int insertDict(String name, String code, String info) {
        return dictionaryMapper.insertDict(name,code,info);
    }

    @Override
    public SysDict selectDictById(int id) {
        return dictionaryMapper.selectDictById(id);
    }

    @Override
    public int updateDict(int id, String name, String code, String info) {
        return dictionaryMapper.updateDict(id,name,code,info);
    }

    @Override
    public int deleteDict(int id) {
        return dictionaryMapper.deleteDict(id);
    }

    @Override
    public int deleteAllDict(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            dictionaryMapper.deleteDict(list.get(i));
        }
        return 1;
    }

    @Override
    public List<SysDict> selectDictByName(String name) {
        return dictionaryMapper.selectDictByName('%'+name+'%');
    }

    @Override
    public List<SysDict> selectByName(String name) {
        return dictionaryMapper.selectByName('%'+name+'%');
    }

    @Override
    public List<SysDict> selectByNamePage(String name, int page, int limit) {
        return dictionaryMapper.selectByNamePage('%'+name+'%',page,limit);
    }

    @Override
    public List<String> selectByType(String code) {
        return dictionaryMapper.selectByType(code);
    }
}
