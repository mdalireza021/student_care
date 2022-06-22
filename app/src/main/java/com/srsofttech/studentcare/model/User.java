package com.srsofttech.studentcare.model;

public class User {

    String student_id,guardian_name,email,phone,password;

    public User(String student_id, String guardian_name, String email, String phone, String password) {
        this.student_id = student_id;
        this.guardian_name = guardian_name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getGuardian_name() {
        return guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
