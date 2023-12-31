package com.example.exam2.entity;

import java.util.Date;

public class Employee {
    private int id;
    private String fullName;
    private Date birthDay;
    private String address;
    private String position;
    private String department;

    public Employee() {
    }

    public Employee(int id, String fullName, Date birthDay, String address, String position, String department) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

