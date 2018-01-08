package com.project.codeclan.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddTaskActivity extends AppCompatActivity {

    EditText briefTask;
    EditText detailedTask;
    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        briefTask = findViewById(R.id.add_brief);
        detailedTask = findViewById(R.id.add_detailed);
        createButton = findViewById(R.id.create_button);
    }

}
