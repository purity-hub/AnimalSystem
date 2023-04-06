package com.lhy.animalsystem.dictionary.entity;


public class SysDictValue {

  private long id;
  private String name;
  private long parentid;
  private String value;
  private String code;
  private String info;

  public SysDictValue() {
  }

  public SysDictValue(long id, String name, long parentid, String value, String code, String info) {
    this.id = id;
    this.name = name;
    this.parentid = parentid;
    this.value = value;
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


  public long getParentid() {
    return parentid;
  }

  public void setParentid(long parentid) {
    this.parentid = parentid;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
