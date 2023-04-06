package com.lhy.animalsystem.animal.service;

import com.lhy.animalsystem.animal.entity.Animal;

public interface AnimalService {
    int addAnimal(Animal animal);

    int getMaxId();

    Animal selectById(int animalid);

    void updatestate(int animalid, String state);
}
