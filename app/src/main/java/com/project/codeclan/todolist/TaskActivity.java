package com.project.codeclan.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    TextView detailedTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        detailedTask = findViewById(R.id.detailedtask);

        Intent intent = getIntent();
        Task task = (Task)intent.getSerializableExtra("task");
        detailedTask.setText(task.getDetailedTask().toString());
    }
}
