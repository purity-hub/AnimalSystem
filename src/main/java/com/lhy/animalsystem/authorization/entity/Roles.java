package com.lhy.animalsystem.authorization.entity;

public class Roles {
    private int roleid;
    private String name;
    private String info;
    private byte state;
    private String remark;

    public Roles() {
    }

    public Roles(int roleid, String name, String info, byte state, String remark) {
        this.roleid = roleid;
        this.name = name;
        this.info = info;
        this.state = state;
        this.remark = remark;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
