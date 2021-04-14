package com.example.fin_reg;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fin_reg.ModelResponse.LessonsTime.LesTime;

import java.util.List;

public class TimeTableAdapter  extends RecyclerView.Adapter<TimeTableAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<LesTime> lesTimes;
    private final int id;

    public TimeTableAdapter(Context context, List<LesTime> lesTime, int id) {
        this.id = id;
        this.lesTimes = lesTime;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public TimeTableAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.row_lessons_timetable, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TimeTableAdapter.ViewHolder holder, int position) {
        LesTime lesTime = lesTimes.get(position);
        holder.lessonView.setText(lesTime.getLesson_object());
        holder.timeView.setText(lesTime.getTime());
        if (position == id){
            holder.itemView.setBackgroundColor(Color.parseColor("#C55FFC"));
            holder.lessonView.setTextColor(Color.parseColor("#EFDCF9"));
            holder.timeView.setTextColor(Color.parseColor("#EFDCF9"));


        }
    }

    @Override
    public int getItemCount() {
        return lesTimes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView lessonView, timeView;
        ViewHolder(View view){
            super(view);
            lessonView = (TextView) view.findViewById(R.id.lesson_name);
            timeView = (TextView) view.findViewById(R.id.lesson_time);
        }
    }
}