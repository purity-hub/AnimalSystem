package com.lhy.animalsystem.animal.mapper;

import com.lhy.animalsystem.animal.entity.Animal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnimalMapper {

    int addAnimal(@Param("test") Animal animal);

    int getMaxId();

    Animal selectById(int animalid);

    void updatestate(int animalid, String state);
}
