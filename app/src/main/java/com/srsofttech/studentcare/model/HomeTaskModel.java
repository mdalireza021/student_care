package com.srsofttech.studentcare.model;

public class HomeTaskModel {
    private String task_name;
    private String created_date;
    private String submission_date;
    private String evaluated_date;
    private String status;

    public HomeTaskModel(String task_name, String created_date, String submission_date, String evaluated_date, String status) {
        this.task_name = task_name;
        this.created_date = created_date;
        this.submission_date = submission_date;
        this.evaluated_date = evaluated_date;
        this.status = status;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(String submission_date) {
        this.submission_date = submission_date;
    }

    public String getEvaluated_date() {
        return evaluated_date;
    }

    public void setEvaluated_date(String evaluated_date) {
        this.evaluated_date = evaluated_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
