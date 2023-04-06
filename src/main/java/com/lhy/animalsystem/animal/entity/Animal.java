package com.lhy.animalsystem.animal.entity;


import java.sql.Timestamp;

public class Animal {

  private long id;
  private String name;
  private String injury;
  private String treatmentplan;
  private String type;
  private String state;
  private java.sql.Timestamp time;
  private String people;
  private String image;

    public Animal() {
    }

  public Animal(long id, String name, String injury, String treatmentplan, String type, String state, Timestamp time, String people, String image) {
    this.id = id;
    this.name = name;
    this.injury = injury;
    this.treatmentplan = treatmentplan;
    this.type = type;
    this.state = state;
    this.time = time;
    this.people = people;
    this.image = image;
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


  public String getInjury() {
    return injury;
  }

  public void setInjury(String injury) {
    this.injury = injury;
  }


  public String getTreatmentplan() {
    return treatmentplan;
  }

  public void setTreatmentplan(String treatmentplan) {
    this.treatmentplan = treatmentplan;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getPeople() {
    return people;
  }

  public void setPeople(String people) {
    this.people = people;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

}
