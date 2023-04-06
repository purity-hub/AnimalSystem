package com.lhy.animalsystem.veterinarian.service.impl;

import com.lhy.animalsystem.veterinarian.entity.Veterinarian;
import com.lhy.animalsystem.veterinarian.mapper.VeterinarianMapper;
import com.lhy.animalsystem.veterinarian.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianServiceImpl implements VeterinarianService {

    @Autowired
    private VeterinarianMapper veterinarianMapper;
    @Override
    public List<Veterinarian> showAll() {
        return veterinarianMapper.showAll();
    }
}
