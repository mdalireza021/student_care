package com.srsofttech.studentcare.model;

public class AcademicProgressModel {

    private String teacher_name;
    private String designation;
    private String subject;
    private String date;
    private String comment;

    public AcademicProgressModel(String teacher_name, String designation,String subject, String date, String comment) {
        this.teacher_name = teacher_name;
        this.designation = designation;
        this.subject = subject;
        this.date = date;
        this.comment = comment;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
