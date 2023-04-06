package com.lhy.animalsystem.excel.entity;

import java.sql.Date;

public class HelpTask {

    private Date date;//申请时间

    private String animal;//救助动物

    private String type;//救助类型

    private int state;//流转状态

    public HelpTask() {
    }

    public HelpTask(Date date, String animal, String type, int state) {
        this.date = date;
        this.animal = animal;
        this.type = type;
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
