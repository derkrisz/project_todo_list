package com.project.codeclan.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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


        ListView listView = (ListView) findViewById(R.id.todolist);
        listView.setAdapter(toDoListAdapter);
    }

    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();

        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }
}
