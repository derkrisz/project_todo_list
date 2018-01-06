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
}
