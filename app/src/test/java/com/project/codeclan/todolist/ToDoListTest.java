package com.project.codeclan.todolist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by derkrisz on 2018. 01. 06..
 */

public class ToDoListTest {

    @Test
    public void getToDoList() {
        ToDoList toDolist = new ToDoList();
        assertEquals(2, toDolist.getToDoList().size());
    }

    @Test
    public void addTaskToList() {
        ToDoList toDoList = new ToDoList();
        Task task = new Task("Mop floor", "Mop floor in living room");
        toDoList.addToList(task);
        assertEquals(3, toDoList.getToDoList().size());
    }
}
