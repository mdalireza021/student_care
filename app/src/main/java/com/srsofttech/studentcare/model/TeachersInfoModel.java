package com.srsofttech.studentcare.model;

public class TeachersInfoModel {
    private  String name;
    private String designation;
    private String teaching_area;
    private String email;
    private  String phone;

    public TeachersInfoModel(String name, String designation, String teaching_area, String email, String phone) {
        this.name = name;
        this.designation = designation;
        this.teaching_area = teaching_area;
        this.email = email;
        this.phone = phone;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTeaching_area() {
        return teaching_area;
    }

    public void setTeaching_area(String teaching_area) {
        this.teaching_area = teaching_area;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
