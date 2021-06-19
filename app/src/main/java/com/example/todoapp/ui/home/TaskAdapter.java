package com.example.todoapp.ui.home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.todoapp.Models.Task;
import com.example.todoapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> list = new ArrayList<>();
    View view;


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(Task task) {
        list.add(task);
        notifyItemInserted(list.indexOf(task));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }


        public void bind(Task task) {
            textTitle.setText(task.getTitle());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(), "Position:"+ (getAdapterPosition()+1) + " Text:" + task.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
