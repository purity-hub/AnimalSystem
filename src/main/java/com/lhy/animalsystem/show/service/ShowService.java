package com.lhy.animalsystem.show.service;

import com.lhy.animalsystem.animal.entity.Animal;

import java.io.IOException;
import java.util.List;

public interface ShowService {
    List<Animal> showAll();

    List<Animal> showAllByPage(int page, int limit);

    Animal selectById(int id);

    void upload(int id, String imageSrc) throws IOException;

    void editIt(int id, String name, String type, String time, String people);

    void addIt(String name, String type, String time, String people);

    void del(int id);

    List<Animal> search(String name, int page, int limit);
}
