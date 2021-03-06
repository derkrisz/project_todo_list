package com.project.codeclan.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by derkrisz on 2018. 01. 06..
 */

public class ToDoListAdapter extends ArrayAdapter<Task> {

    public ToDoListAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent, false);
        }

        Task currentTask = getItem(position);

        TextView briefTask = (TextView) listItemView.findViewById(R.id.brieftask);
        briefTask.setText(currentTask.getBriefTask().toString());

        listItemView.setTag(currentTask);
        listItemView.setBackgroundResource(currentTask.isTaskCompleted() ? R.drawable.task_item_shape_completed : R.drawable.task_item_shape_not_completed);

        return listItemView;
    }
}
