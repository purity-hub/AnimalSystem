package com.lhy.animalsystem.veterinarian.mapper;

import com.lhy.animalsystem.veterinarian.entity.Veterinarian;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VeterinarianMapper {
    List<Veterinarian> showAll();
}
