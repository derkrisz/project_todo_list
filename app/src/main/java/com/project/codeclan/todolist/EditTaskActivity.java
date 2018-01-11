package com.project.codeclan.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EditTaskActivity extends AppCompatActivity {

    TextView editTextBrief;
    TextView editTextDetailed;
    Task editableTask;
    Button finaliseEditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        editTextBrief = findViewById(R.id.edit_brief);
        editTextDetailed = findViewById(R.id.edit_detailed);
        finaliseEditButton = findViewById(R.id.finalise_edit_button);

        Intent intent = getIntent();
        editableTask = (Task)intent.getSerializableExtra("editTask");

        editTextBrief.setText(editableTask.getBriefTask().toString());
        editTextDetailed.setText(editableTask.getDetailedTask().toString());
    }

    public void onFinaliseEditButtonClick(View button) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String tasks = sharedPref.getString("AllTasks", null);
        SharedPreferences.Editor editor = sharedPref.edit();
        String editedBriefText = editTextBrief.getText().toString();
        String editedDetailedText = editTextDetailed.getText().toString();

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> allTasks = gson.fromJson(tasks, taskArrayList.getType());

        for (Task task : allTasks) {
            if (task.getId() == editableTask.getId()) {
                task.setBriefTask(editedBriefText);
                task.setDetailedTask(editedDetailedText);
            }
        }
        editor.putString("AllTasks", gson.toJson(allTasks));
        editor.apply();

        Intent takeBack = new Intent(this, ToDoListActivity.class);
        startActivity(takeBack);
    }
}
