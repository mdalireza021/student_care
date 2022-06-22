package com.srsofttech.studentcare.model;

public class NoticeBoardModel {
    private String notice_title;
    private String notice_date;
    private String notice_des;

    public NoticeBoardModel(String notice_title, String notice_date, String notice_des) {
        this.notice_title = notice_title;
        this.notice_date = notice_date;
        this.notice_des = notice_des;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(String notice_date) {
        this.notice_date = notice_date;
    }

    public String getNotice_des() {
        return notice_des;
    }

    public void setNotice_des(String notice_des) {
        this.notice_des = notice_des;
    }
}
