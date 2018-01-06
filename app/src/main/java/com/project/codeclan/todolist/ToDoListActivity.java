package com.project.codeclan.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        ToDoList toDoList = new ToDoList();
        ArrayList<Task> list = toDoList.getToDoList();

        ToDoListAdapter toDoListAdapter = new ToDoListAdapter(this, list);


        ListView listView = (ListView) findViewById(R.id.todolist); //UPDATED
        listView.setAdapter(toDoListAdapter);
    }
}
