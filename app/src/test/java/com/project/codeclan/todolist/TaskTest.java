package com.project.codeclan.todolist;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by derkrisz on 2018. 01. 06..
 */

public class TaskTest {

    Task task1;


    @Before
    public void before() {
        task1 = new Task("Take out bin", "Take out the recycling bins");
    }

    @Test
    public void getBriefTask() {
        assertEquals("Take out bin", task1.getBriefTask());
    }

    @Test
    public void getDetailedTask() {
        assertEquals("Take out the recycling bins", task1.getDetailedTask());
    }

    @Test
    public void taskNotCompleted() {
        assertEquals(false, task1.isTaskCompleted());
    }

    @Test
    public void taskIsCompleted() {
        task1.setTaskCompleted();
        assertEquals(true, task1.isTaskCompleted());
    }
}
