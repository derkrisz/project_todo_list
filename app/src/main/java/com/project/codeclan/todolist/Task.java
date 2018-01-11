package com.project.codeclan.todolist;

import java.io.Serializable;

/**
 * Created by derkrisz on 2018. 01. 06..
 */

public class Task implements Serializable {

    private String briefTask;
    private String detailedTask;
    private boolean taskCompleted;
    private int id;
    private CategoryType category;

    public Task(String briefTask, String detailedTask, int counter, CategoryType category) {
        this.briefTask = briefTask;
        this.detailedTask = detailedTask;
        this.taskCompleted = false;
        this.id = counter;
        this.category = category;

    }

    public Task(String briefTask, String detailedTask) {
        this.briefTask = briefTask;
        this.detailedTask = detailedTask;
        this.taskCompleted = false;
    }

    public String getBriefTask() {
        return briefTask;
    }

    public String getDetailedTask() {
        return detailedTask;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted() {
        this.taskCompleted = true;
    }

    public void setTaskNotCompleted() {this.taskCompleted = false;}

    public int getId() {
        return id;
    }

    public String getCategoryFromEnum() {
       return this.category.getCategory();
    }
}
