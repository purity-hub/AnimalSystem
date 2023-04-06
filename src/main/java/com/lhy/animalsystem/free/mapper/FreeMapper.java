package com.lhy.animalsystem.free.mapper;

import com.lhy.animalsystem.animal.entity.Animal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FreeMapper {
    List<Animal> showAll();

    List<Animal> showAllByPage(int page, int limit);

    Animal selectById(int id);

    void upload(int id, String path);

    void editIt(int id, String name, String type, String time, String people);

    void addIt(String name, String type, String time, String people);

    void del(int id);

    List<Animal> search(String name, int page, int limit);
}
