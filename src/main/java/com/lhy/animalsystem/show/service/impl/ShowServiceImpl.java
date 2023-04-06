package com.lhy.animalsystem.show.service.impl;

import com.lhy.animalsystem.animal.entity.Animal;
import com.lhy.animalsystem.free.mapper.FreeMapper;
import com.lhy.animalsystem.show.mapper.ShowMapper;
import com.lhy.animalsystem.show.service.ShowService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private ShowMapper showMapper;

    @Override
    public List<Animal> showAll() {
        return showMapper.showAll();
    }

    @Override
    public List<Animal> showAllByPage(int page, int limit) {
        return showMapper.showAllByPage(page, limit);
    }

    @Override
    public Animal selectById(int id) {
        return showMapper.selectById(id);
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
        showMapper.upload(id, "/images/animal/"+id+".jpg");
    }

    @Override
    public void editIt(int id, String name, String type, String time, String people) {
        showMapper.editIt(id,name,type,time,people);
    }

    @Override
    public void addIt(String name, String type, String time, String people) {
        showMapper.addIt(name,type,time,people);
    }

    @Override
    public void del(int id) {
        showMapper.del(id);
    }

    @Override
    public List<Animal> search(String name, int page, int limit) {
        return showMapper.search(name,page,limit);
    }
}
