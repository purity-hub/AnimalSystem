package com.lhy.animalsystem.system.entity;


import java.sql.Date;

public class SysLog {

  private long id;
  private String username;
  private String operation;
  private String method;
  private String params;
  private String ip;
  private java.sql.Date createdDate;

  public SysLog() {
  }

  public SysLog(long id, String username, String operation, String method, String params, String ip, Date createdDate) {
    this.id = id;
    this.username = username;
    this.operation = operation;
    this.method = method;
    this.params = params;
    this.ip = ip;
    this.createdDate = createdDate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }


  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }


  public String getParams() {
    return params;
  }

  public void setParams(String params) {
    this.params = params;
  }


  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
