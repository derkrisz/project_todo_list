package com.project.codeclan.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {

    TextView detailedTask;
    TextView taskCategory;
    Task addedTask;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        detailedTask = findViewById(R.id.detailedtask);
        taskCategory = findViewById(R.id.category);
        checkBox = findViewById(R.id.task_completion_checkbox);

        Intent intent = getIntent();
        addedTask = (Task)intent.getSerializableExtra("task");
        detailedTask.setText(addedTask.getDetailedTask().toString());
        taskCategory.setText(addedTask.getCategoryFromEnum());
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

        final Intent takeBack = new Intent(this, ToDoListActivity.class);

        final  Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(takeBack);
            }
        }, 1000);
    }
}
