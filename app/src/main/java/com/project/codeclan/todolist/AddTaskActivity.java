package com.project.codeclan.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity{

    EditText briefTask;
    EditText detailedTask;
    Button createButton;
    Spinner categorySpinner;
    String categoryString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        briefTask = findViewById(R.id.add_brief);
        detailedTask = findViewById(R.id.add_detailed);
        createButton = findViewById(R.id.create_button);
        categorySpinner = findViewById(R.id.category_spinner);

        categorySpinner.setAdapter(new ArrayAdapter<CategoryType>(this, android.R.layout.simple_spinner_dropdown_item, CategoryType.values()));
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> adapterView, View view,
                            int i, long l) {
                       categoryString = categorySpinner.getItemAtPosition(i).toString();
                    }

                    public void onNothingSelected(
                            AdapterView<?> adapterView) {
                    }
                });
            }

    public void onCreateButtonClick(View button) {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String allTasks = sharedPref.getString("AllTasks", new ArrayList<Task>().toString());
        int counter = sharedPref.getInt("counter", 1);

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> allTaskObjects = gson.fromJson(allTasks, taskArrayList.getType());

        Task task = new Task(briefTask.getText().toString(), detailedTask.getText().toString(), counter, CategoryType.valueOf(categoryString));
        allTaskObjects.add(task);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putInt("counter", counter + 1);
        editor.putString("AllTasks", gson.toJson(allTaskObjects));
        editor.apply();

        Toast.makeText(this, "New task created!", Toast.LENGTH_LONG).show();

        final Intent takeBack  = new Intent(this, ToDoListActivity.class);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(takeBack);
            }
        }, 2000);
    }

}
