package com.lhy.animalsystem.department.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Department {

  private String deptname;
  private String header;
  private String introduction;
  private long order;
  private String phone;
  private long departmentId;


  public String getDeptname() {
    return deptname;
  }

  public void setDeptname(String deptname) {
    this.deptname = deptname;
  }


  public String getHeader() {
    return header;
  }

  public void setHead(String header) {
    this.header = header;
  }


  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }


  public long getOrder() {
    return order;
  }

  public void setOrder(long order) {
    this.order = order;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }

}
