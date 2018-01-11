package com.project.codeclan.todolist;

/**
 * Created by derkrisz on 2018. 01. 11..
 */

public enum CategoryType {
    HOME ("Home"),
    WORK ("Work"),
    CHORES ("Chores"),
    LEISURE ("Leisure");

    private final String category;

    CategoryType(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }
}
