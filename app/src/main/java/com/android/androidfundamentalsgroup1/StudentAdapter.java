package com.android.androidfundamentalsgroup1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private List<Student> students;
    private Context context;

    public StudentAdapter(List<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(itemView);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student currentStudent = students.get(position);
        holder.getTextViewFirstName().setText(currentStudent.getFirstName());
        holder.getTextViewLastName().setText(currentStudent.getLastName());
        if (position % 2 == 1) {
            holder.getLinearLayoutStudentItem().setBackgroundColor(ContextCompat.getColor(context, R.color.gray));
        }

    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}