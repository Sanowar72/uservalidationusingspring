package com.geekster.UniversityEventManagment.model;

public enum Department {


    ME("Mechanical Engineering"),
    ECE("Electronics and Communication Engineering"),
    CIVIL("Civil Engineering"),
    CSE("Computer Science Engineering");

    private String departmentName;

    Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}