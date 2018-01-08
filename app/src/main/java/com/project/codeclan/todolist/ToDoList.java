package com.project.codeclan.todolist;

import java.util.ArrayList;

/**
 * Created by derkrisz on 2018. 01. 06..
 */

public class ToDoList {

    private ArrayList<Task> toDoList;

    public ToDoList() {
        this.toDoList = new ArrayList<Task>();
        toDoList.add(new Task("Take out bin", "Take out recycling bins"));
        toDoList.add(new Task("Weekend cleaning", "Clean out bathroom and kitchen"));

    }

    public ArrayList<Task> getToDoList() {
        return toDoList;
    }

    public void addToList(Task task) {
        toDoList.add(task);
    }
}
