package com.lhy.animalsystem.dictionary.mapper;


import com.lhy.animalsystem.dictionary.entity.SysDict;
import com.lhy.animalsystem.dictionary.entity.SysDictValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictionaryMapper {

    List<SysDict> selectAllDict();

    List<SysDict> selectByPage(@Param("page") int page,@Param("limit") int limit);

    List<SysDictValue> selectDictValue(@Param("parentid") int parentid);

    List<SysDictValue> selectValueByPage(@Param("parentid") int parentid,@Param("page") int page,@Param("limit") int limit);

    int insertDict(@Param("name") String name,@Param("code") String code,@Param("info") String info);

    SysDict selectDictById(int id);

    int updateDict(@Param("id") int id,@Param("name") String name,@Param("code") String code,@Param("info") String info);

    int deleteDict(int id);

    List<SysDict> selectDictByName(String name);

    List<SysDict> selectByName(String name);

    List<SysDict> selectByNamePage(String name, int page, int limit);

    void updateDictValue(SysDictValue sysDictValue);

    List<String> selectByType(String code);
}
