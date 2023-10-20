package com.example.a16oct_firebase;

public class updatehelper {
    String name, department, rollNo;

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public updatehelper(String name, String department, String rollNo) {
        this.name = name;
        this.department = department;
        this.rollNo = rollNo;
    }

}
