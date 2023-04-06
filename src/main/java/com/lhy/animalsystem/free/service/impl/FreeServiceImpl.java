package com.lhy.animalsystem.free.service.impl;

import com.lhy.animalsystem.animal.entity.Animal;
import com.lhy.animalsystem.free.mapper.FreeMapper;
import com.lhy.animalsystem.free.service.FreeService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FreeServiceImpl implements FreeService {

    @Autowired
    private FreeMapper freeMapper;

    @Override
    public List<Animal> showAll() {
        return freeMapper.showAll();
    }

    @Override
    public List<Animal> showAllByPage(int page, int limit) {
        return freeMapper.showAllByPage(page, limit);
    }

    @Override
    public Animal selectById(int id) {
        return freeMapper.selectById(id);
    }

    @Override
    public void upload(int id, String imageSrc) throws IOException {
        //上传图片
        imageSrc = imageSrc.substring(imageSrc.indexOf(",")+1);
        imageSrc = imageSrc.replaceAll(" ","+");
        byte[] bytes = Base64.decodeBase64(imageSrc);
        String path = "D:\\AnimalSystem\\target\\classes\\static\\images\\animal\\"+id+".jpg";
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes,0,bytes.length);
        fileOutputStream.flush();
        fileOutputStream.close();
        //更新数据库
        freeMapper.upload(id, "/images/animal/"+id+".jpg");
    }

    @Override
    public void editIt(int id, String name, String type, String time, String people) {
        freeMapper.editIt(id,name,type,time,people);
    }

    @Override
    public void addIt(String name, String type, String time, String people) {
        freeMapper.addIt(name,type,time,people);
    }

    @Override
    public void del(int id) {
        freeMapper.del(id);
    }

    @Override
    public List<Animal> search(String name, int page, int limit) {
        return freeMapper.search(name,page,limit);
    }
}
