package com.lhy.animalsystem.helprequest.entity;


import java.sql.Timestamp;

public class Helprequest {

  private long id;
  private String name;
  private String phone;
  private String animal;
  private String location;
  private java.sql.Timestamp time;
  private String source;
  private String description;
  private String recordname;
  private java.sql.Timestamp recordtime;
  private long animalid;
  private long veterinarianid;
  private String type;
  private java.sql.Timestamp assigntime;
  private long assignpeopleid;
  private java.sql.Timestamp starttime;
  private int state;

  public Helprequest() {
  }

  public Helprequest(long id, String name, String phone, String animal, String location, Timestamp time, String source, String description, String recordname, Timestamp recordtime, long animalid, long veterinarianid, String type, Timestamp assigntime, long assignpeopleid, Timestamp starttime, int state) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.animal = animal;
    this.location = location;
    this.time = time;
    this.source = source;
    this.description = description;
    this.recordname = recordname;
    this.recordtime = recordtime;
    this.animalid = animalid;
    this.veterinarianid = veterinarianid;
    this.type = type;
    this.assigntime = assigntime;
    this.assignpeopleid = assignpeopleid;
    this.starttime = starttime;
    this.state = state;
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


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getAnimal() {
    return animal;
  }

  public void setAnimal(String animal) {
    this.animal = animal;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getRecordname() {
    return recordname;
  }

  public void setRecordname(String recordname) {
    this.recordname = recordname;
  }


  public java.sql.Timestamp getRecordtime() {
    return recordtime;
  }

  public void setRecordtime(java.sql.Timestamp recordtime) {
    this.recordtime = recordtime;
  }


  public long getAnimalid() {
    return animalid;
  }

  public void setAnimalid(long animalid) {
    this.animalid = animalid;
  }


  public long getVeterinarianid() {
    return veterinarianid;
  }

  public void setVeterinarianid(long veterinarianid) {
    this.veterinarianid = veterinarianid;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public java.sql.Timestamp getAssigntime() {
    return assigntime;
  }

  public void setAssigntime(java.sql.Timestamp assigntime) {
    this.assigntime = assigntime;
  }


  public long getAssignpeopleid() {
    return assignpeopleid;
  }

  public void setAssignpeopleid(long assignpeopleid) {
    this.assignpeopleid = assignpeopleid;
  }


  public java.sql.Timestamp getStarttime() {
    return starttime;
  }

  public void setStarttime(java.sql.Timestamp starttime) {
    this.starttime = starttime;
  }


  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

}
