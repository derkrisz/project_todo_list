package com.project.codeclan.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {

    TextView detailedTask;
    Task addedTask;
    CheckBox checkBox;
    Button deleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        detailedTask = findViewById(R.id.detailedtask);
        checkBox = findViewById(R.id.task_completion_checkbox);
        deleteButton = findViewById(R.id.delete_task_button);

        Intent intent = getIntent();
        addedTask = (Task)intent.getSerializableExtra("task");
        detailedTask.setText(addedTask.getDetailedTask().toString());
        checkBox.setChecked(addedTask.isTaskCompleted());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete_task:
                SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                String tasks = sharedPref.getString("AllTasks", null);
                SharedPreferences.Editor editor = sharedPref.edit();

                Gson gson = new Gson();
                TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
                ArrayList<Task> allTasks = gson.fromJson(tasks, taskArrayList.getType());

                for (Task task : allTasks) {
                    if (task.getId() == addedTask.getId()) {
                        allTasks.remove(task);
                    }
                }
                editor.putString("AllTasks", gson.toJson(allTasks));
                editor.apply();

                Intent returnToMain  = new Intent(this, ToDoListActivity.class);
                startActivity(returnToMain);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onCheckBoxClick(View view) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String tasks = sharedPref.getString("AllTasks", null);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> allTasks = gson.fromJson(tasks, taskArrayList.getType());


        for (Task task : allTasks) {
            if (task.getId() == addedTask.getId()) {
                if (checkBox.isChecked()) {
                    task.setTaskCompleted();
                } else {
                    task.setTaskNotCompleted();
                }
            }
        }
        editor.putString("AllTasks", gson.toJson(allTasks));
        editor.apply();
    }

    public void onDeleteButtonClick(View button) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String tasks = sharedPref.getString("AllTasks", null);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> allTasks = gson.fromJson(tasks, taskArrayList.getType());

        for (Task task : allTasks) {
            if (task.getId() == addedTask.getId()) {
                allTasks.remove(task);
            }
        }
        editor.putString("AllTasks", gson.toJson(allTasks));
        editor.apply();

        Intent returnToMain  = new Intent(this, ToDoListActivity.class);
        startActivity(returnToMain);
    }
}
