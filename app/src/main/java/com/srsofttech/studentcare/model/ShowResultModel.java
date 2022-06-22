package com.srsofttech.studentcare.model;

public class ShowResultModel {

    String subject;
    int full_marks;
    int obtain_marks;
    int highest_marks;
    String comment;

    public ShowResultModel(String subject, int full_marks, int obtain_marks, int highest_marks, String comment) {
        this.subject = subject;
        this.full_marks = full_marks;
        this.obtain_marks = obtain_marks;
        this.highest_marks = highest_marks;
        this.comment = comment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getFull_marks() {
        return full_marks;
    }

    public void setFull_marks(int full_marks) {
        this.full_marks = full_marks;
    }

    public int getObtain_marks() {
        return obtain_marks;
    }

    public void setObtain_marks(int obtain_marks) {
        this.obtain_marks = obtain_marks;
    }

    public int getHighest_marks() {
        return highest_marks;
    }

    public void setHighest_marks(int highest_marks) {
        this.highest_marks = highest_marks;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
