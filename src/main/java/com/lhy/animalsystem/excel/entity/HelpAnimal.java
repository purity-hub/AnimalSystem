package com.lhy.animalsystem.excel.entity;

import java.util.Date;

public class HelpAnimal {
    private String name;// 动物名称

    private String type;// 动物类型

    private String helptype;// 动物帮助类型

    private String veterinarian;// 动物医生

    private Date time;// 救治时间

    private String result;// 救治结果

    private String forword;// 救治去向

    public HelpAnimal() {
    }

    public HelpAnimal(String name, String type, String helptype, String veterinarian, Date time, String result, String forword) {
        this.name = name;
        this.type = type;
        this.helptype = helptype;
        this.veterinarian = veterinarian;
        this.time = time;
        this.result = result;
        this.forword = forword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHelptype() {
        return helptype;
    }

    public void setHelptype(String helptype) {
        this.helptype = helptype;
    }

    public String getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(String veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getForword() {
        return forword;
    }

    public void setForword(String forword) {
        this.forword = forword;
    }
}
