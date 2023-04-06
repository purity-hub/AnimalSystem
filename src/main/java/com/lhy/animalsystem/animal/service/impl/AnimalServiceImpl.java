package com.lhy.animalsystem.animal.service.impl;

import com.lhy.animalsystem.animal.entity.Animal;
import com.lhy.animalsystem.animal.mapper.AnimalMapper;
import com.lhy.animalsystem.animal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalMapper animalMapper;
    @Override
    public int addAnimal(Animal animal) {
        return animalMapper.addAnimal(animal);
    }

    @Override
    public int getMaxId() {
        return animalMapper.getMaxId();
    }

    @Override
    public Animal selectById(int animalid) {
        return animalMapper.selectById(animalid);
    }

    @Override
    public void updatestate(int animalid, String state) {
        animalMapper.updatestate(animalid, state);
    }
}
