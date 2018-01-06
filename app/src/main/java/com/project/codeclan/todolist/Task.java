package com.project.codeclan.todolist;

/**
 * Created by derkrisz on 2018. 01. 06..
 */

public class Task {

    String briefTask;
    String detailedTask;

    public Task(String briefTask, String detailedTask) {
        this.briefTask = briefTask;
        this.detailedTask = detailedTask;
    }

    public String getBriefTask() {
        return briefTask;
    }

    public String getDetailedTask() {
        return detailedTask;
    }
}