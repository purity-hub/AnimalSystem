package com.lhy.animalsystem.system.entity;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class Menu {

  private long menuid;
  private String name;
  private String url;
  private String ismenu;
  private String remark;
  private long pid;
  private long parentid;

  private int order;


  public long getMenuid() {
    return menuid;
  }

  public void setMenuid(long menuid) {
    this.menuid = menuid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getIsmenu() {
    return ismenu;
  }

  public void setIsmenu(String ismenu) {
    this.ismenu = ismenu;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public long getParentid() {
    return parentid;
  }

  public void setParentid(long parentid) {
    this.parentid = parentid;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }
}
