package com.project.codeclan.todolist;

import java.io.Serializable;

/**
 * Created by derkrisz on 2018. 01. 06..
 */

public class Task implements Serializable {

    private String briefTask;
    private String detailedTask;
    private boolean taskCompleted;

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
}
