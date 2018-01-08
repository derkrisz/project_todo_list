package com.project.codeclan.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        newButton = findViewById(R.id.new_button);

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

    public void onNewButtonClick(View button) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }
}
