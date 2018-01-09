package com.project.codeclan.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {

    TextView detailedTask;
    Task addedTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        detailedTask = findViewById(R.id.detailedtask);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.task_completion_checkbox);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        }


        Intent intent = getIntent();
        addedTask = (Task)intent.getSerializableExtra("task");
        detailedTask.setText(addedTask.getDetailedTask().toString());
    }

    public void onCheckBoxClick(View view) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        boolean getCompleted = sharedPref.getBoolean("taskCompleted", false);
        SharedPreferences.Editor editor = sharedPref.edit();

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.task_completion_checkbox:
                if (checked)
                    editor.putBoolean("getCompleted", true);
                else
                    Log.d("checkbox uncheked", "unchecked");

        } editor.commit();
    }
}
