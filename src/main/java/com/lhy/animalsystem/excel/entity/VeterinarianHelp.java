package com.lhy.animalsystem.excel.entity;

public class VeterinarianHelp {

    private int id;// 兽医id

    private String name;// 兽医姓名

    private String degee;// 兽医资质

    private String profession;// 兽医专业

    private int count;// 兽医指派救治任务数

    private int count1;//待救治任务数

    private int count2;//已救治任务数

    public VeterinarianHelp() {
    }

    public VeterinarianHelp(int id, String name, String degee, String profession, int count, int count1, int count2) {
        this.id = id;
        this.name = name;
        this.degee = degee;
        this.profession = profession;
        this.count = count;
        this.count1 = count1;
        this.count2 = count2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegee() {
        return degee;
    }

    public void setDegee(String degee) {
        this.degee = degee;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }
}
