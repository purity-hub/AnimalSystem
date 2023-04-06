package com.lhy.animalsystem.dictionary.entity;



public class SysDict {

  private long id;
  private String name;
  private String code;
  private String info;

  public SysDict() {
  }

  public SysDict(long id, String name, String code, String info) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.info = info;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

}
