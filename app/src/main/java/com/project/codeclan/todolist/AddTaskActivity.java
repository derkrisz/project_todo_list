package com.project.codeclan.todolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

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

    public void onCreateButtonClick(View button) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String allTasks = sharedPref.getString("AllTasks", new ArrayList<Task>().toString());

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> allTaskObjects = gson.fromJson(allTasks, taskArrayList.getType());

        Task task = new Task(briefTask.getText().toString(), detailedTask.getText().toString());
        allTaskObjects.add(task);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("AllTasks", gson.toJson(allTaskObjects));
        editor.apply();

    }

}
