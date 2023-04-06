package com.lhy.animalsystem.login.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class User {

  private int id;
  private String name;
  private String username;
  private String password;
  private String sex;
  private String idnumber;

  @DateTimeFormat(pattern = "yy-mm-dd")
  private java.sql.Date birth;
  private String politicalface;
  private String office;
  private String jobtitle;
  private long worknumber;
  private String profession;
  private String departname;
  @DateTimeFormat(pattern = "yy-mm-dd")
  private java.sql.Date worktime;
  private String post;
  private String officephone;
  private String residentialphone;
  private String email;
  private String attribute;
  private String degee;

  public User() {
  }

  public User(int id, String name, String username, String password, String sex, String idnumber, Date birth, String politicalface, String office, String jobtitle, long worknumber, String profession, String departname, Date worktime, String post, String officephone, String residentialphone, String email, String attribute, String degee) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.sex = sex;
    this.idnumber = idnumber;
    this.birth = birth;
    this.politicalface = politicalface;
    this.office = office;
    this.jobtitle = jobtitle;
    this.worknumber = worknumber;
    this.profession = profession;
    this.departname = departname;
    this.worktime = worktime;
    this.post = post;
    this.officephone = officephone;
    this.residentialphone = residentialphone;
    this.email = email;
    this.attribute = attribute;
    this.degee = degee;
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


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getIdnumber() {
    return idnumber;
  }

  public void setIdnumber(String idnumber) {
    this.idnumber = idnumber;
  }


  public java.sql.Date getBirth() {
    return birth;
  }

  public void setBirth(java.sql.Date birth) {
    this.birth = birth;
  }


  public String getPoliticalface() {
    return politicalface;
  }

  public void setPoliticalface(String politicalface) {
    this.politicalface = politicalface;
  }


  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }


  public String getJobtitle() {
    return jobtitle;
  }

  public void setJobtitle(String jobtitle) {
    this.jobtitle = jobtitle;
  }


  public long getWorknumber() {
    return worknumber;
  }

  public void setWorknumber(long worknumber) {
    this.worknumber = worknumber;
  }


  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }


  public String getDepartname() {
    return departname;
  }

  public void setDepartname(String departname) {
    this.departname = departname;
  }


  public java.sql.Date getWorktime() {
    return worktime;
  }

  public void setWorktime(java.sql.Date worktime) {
    this.worktime = worktime;
  }


  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }


  public String getOfficephone() {
    return officephone;
  }

  public void setOfficephone(String officephone) {
    this.officephone = officephone;
  }


  public String getResidentialphone() {
    return residentialphone;
  }

  public void setResidentialphone(String residentialphone) {
    this.residentialphone = residentialphone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }


  public String getDegee() {
    return degee;
  }

  public void setDegee(String degee) {
    this.degee = degee;
  }

}
