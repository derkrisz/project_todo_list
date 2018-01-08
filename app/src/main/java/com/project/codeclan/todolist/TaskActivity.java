package com.project.codeclan.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {

    TextView detailedTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        detailedTask = findViewById(R.id.detailedtask);

        Intent intent = getIntent();
        Task addedTask = (Task)intent.getSerializableExtra("task");
        detailedTask.setText(addedTask.getDetailedTask().toString());
    }
}
