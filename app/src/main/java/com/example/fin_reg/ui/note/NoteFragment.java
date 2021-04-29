package com.example.fin_reg.ui.note;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fin_reg.ModelResponse.LessonsTime.LesTime;
import com.example.fin_reg.R;
import com.example.fin_reg.TimeTableAdapter;
import com.example.fin_reg.UserAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class NoteFragment extends Fragment {

    private NoteViewModel noteViewModel;

    ArrayList<LesTime> lesTimes = new ArrayList<LesTime>();

    UserAdapter userAdapter;

    TextView textView;
    RecyclerView recyclerView;
    Context this_context;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        noteViewModel =
                ViewModelProviders.of(this).get(NoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_note, container, false);
        Button button_logout = (Button) root.findViewById(R.id.Button_logout);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.timetable_list);


        GregorianCalendar first_lesson_ten = new GregorianCalendar();
        first_lesson_ten.set(Calendar.HOUR, 8);
        first_lesson_ten.set(Calendar.MINUTE, 5);
        first_lesson_ten.set(Calendar.SECOND, 0);

        GregorianCalendar first_break = new GregorianCalendar();
        first_break.set(Calendar.HOUR, 8);
        first_break.set(Calendar.MINUTE, 45);
        first_break.set(Calendar.SECOND, 0);

        GregorianCalendar second_lesson_ten = new GregorianCalendar();
        second_lesson_ten.set(Calendar.HOUR, 8);
        second_lesson_ten.set(Calendar.MINUTE, 55);
        second_lesson_ten.set(Calendar.SECOND, 0);

        GregorianCalendar second_break = new GregorianCalendar();
        second_break.set(Calendar.HOUR, 9);
        second_break.set(Calendar.MINUTE, 35);
        second_break.set(Calendar.SECOND, 0);

        GregorianCalendar third_lesson_ten = new GregorianCalendar();
        third_lesson_ten.set(Calendar.HOUR, 9);
        third_lesson_ten.set(Calendar.MINUTE, 45);
        third_lesson_ten.set(Calendar.SECOND, 0);

        GregorianCalendar third_break = new GregorianCalendar();
        third_break.set(Calendar.HOUR, 10);
        third_break.set(Calendar.MINUTE, 25);
        third_break.set(Calendar.SECOND, 0);

        GregorianCalendar forth_lesson_ten = new GregorianCalendar();
        forth_lesson_ten.set(Calendar.HOUR, 10);
        forth_lesson_ten.set(Calendar.MINUTE, 40);
        forth_lesson_ten.set(Calendar.SECOND, 0);

        GregorianCalendar forth_break = new GregorianCalendar();
        forth_break.set(Calendar.HOUR, 11);
        forth_break.set(Calendar.MINUTE, 20);
        forth_break.set(Calendar.SECOND, 0);

        GregorianCalendar fifth_lesson_ten = new GregorianCalendar();
        fifth_lesson_ten.set(Calendar.HOUR, 11);
        fifth_lesson_ten.set(Calendar.MINUTE, 30);
        fifth_lesson_ten.set(Calendar.SECOND, 0);

        GregorianCalendar fifth_break = new GregorianCalendar();
        fifth_break.set(Calendar.HOUR, 12);
        fifth_break.set(Calendar.MINUTE, 10);
        fifth_break.set(Calendar.SECOND, 0);

        GregorianCalendar sixth_lesson_ten = new GregorianCalendar();
        sixth_lesson_ten.set(Calendar.HOUR, 12);
        sixth_lesson_ten.set(Calendar.MINUTE, 20);
        sixth_lesson_ten.set(Calendar.SECOND, 0);


        GregorianCalendar lunch_time = new GregorianCalendar();
        lunch_time.set(Calendar.HOUR, 13);
        lunch_time.set(Calendar.MINUTE, 0);
        lunch_time.set(Calendar.SECOND, 0);

        GregorianCalendar first_additional = new GregorianCalendar();
        first_additional.set(Calendar.HOUR, 14);
        first_additional.set(Calendar.MINUTE, 35);
        first_additional.set(Calendar.SECOND, 0);

        GregorianCalendar additional_break = new GregorianCalendar();
        additional_break.set(Calendar.HOUR, 15);
        additional_break.set(Calendar.MINUTE, 15);
        additional_break.set(Calendar.SECOND, 0);

        GregorianCalendar second__additional = new GregorianCalendar();
        second__additional.set(Calendar.HOUR, 15);
        second__additional.set(Calendar.MINUTE, 20);
        second__additional.set(Calendar.SECOND, 0);

        GregorianCalendar free_time = new GregorianCalendar();
        free_time.set(Calendar.HOUR, 16);
        free_time.set(Calendar.MINUTE, 0);
        free_time.set(Calendar.SECOND, 0);

//        lesTimes.add(new LesTime ("Обеденный перерыв", "13:00-14:35"));
//        lesTimes.add(new LesTime ("1-ы дополнительный урок", "14:35-15:15"));
//        lesTimes.add(new LesTime ("Перемена", "15:15-15:20"));
//        lesTimes.add(new LesTime ("2-ы дополнительный урок", "15:20-16:00"));
//        lesTimes.add(new LesTime ("Свободное время", "16:00-∞"));


        Date date = new Date();


        Boolean lesson_bool = false;
        String monthString;
        int id = -1;

        GregorianCalendar real_time = new GregorianCalendar();
        int real_hour = date.getHours();
        int real_minutes = date.getMinutes();
        int real_seconds = date.getSeconds();
        real_time.set(Calendar.HOUR, real_hour);
        real_time.set(Calendar.MINUTE, real_minutes);
        real_time.set(Calendar.SECOND, real_seconds);


        System.out.println(real_time);

        if (free_time.before(real_time)) id = 15;
        else if (second__additional.before(real_time)) id = 14;
        else if (additional_break.before(real_time)) id = 13;
        else if (first_additional.before(real_time)) id = 12;
        else if (lunch_time.before(real_time)) id = 11;
        else if (sixth_lesson_ten.before(real_time)) id = 10;
        else if (fifth_break.before(real_time)) id = 9;
        else if (fifth_lesson_ten.before(real_time)) id = 8;
        else if (forth_break.before(real_time)) id = 7;
        else if (forth_lesson_ten.before(real_time)) id = 6;
        else if (third_break.before(real_time)) id = 5;
        else if (third_lesson_ten.before(real_time)) id = 4;
        else if (second_break.before(real_time)) id = 3;
        else if (second_lesson_ten.before(real_time)) id = 2;
        else if (first_break.before(real_time)) id = 1;
        else if (first_lesson_ten.before(real_time)) id = 0;

        System.out.println(id);

        setInitialData();
        TimeTableAdapter adapter = new TimeTableAdapter(getContext(), lesTimes, id);

        LesTime lesTime = lesTimes.get(id);
        recyclerView.setAdapter(adapter);


        return root;
    }

    private void setInitialData() {
//        String[] days = {
//                "Первый урок", "Перемена", "Второй урок", "Перемена", "Третий урок",
//                "Перемена", "Четвертый урок", "Перемена", "Пятый урок", "Перемена",
//                "Шестой урок","Обеденный перерыв", "Свободное время"
//        };

        lesTimes.add(new LesTime("Первый урок", "8:05-8:45"));
        lesTimes.add(new LesTime("Перемена", "8:45-8:55"));
        lesTimes.add(new LesTime("Второй урок", "8:55-9:35"));
        lesTimes.add(new LesTime("Перемена", "9:35-9:45"));
        lesTimes.add(new LesTime("Третий урок", "9:45-10:25"));
        lesTimes.add(new LesTime("Перемена", "10:25-10:40"));
        lesTimes.add(new LesTime("Четвертый урок", "10:40-11:20"));
        lesTimes.add(new LesTime("Перемена", "11:20-11:30"));
        lesTimes.add(new LesTime("Пятый урок", "11:30-12:10"));
        lesTimes.add(new LesTime("Перемена", "12:10-12:20"));
        lesTimes.add(new LesTime("Шестой урок", "12:20-13:00"));
        lesTimes.add(new LesTime("Обеденный перерыв", "13:00-14:35"));
        lesTimes.add(new LesTime("1-ы дополнительный урок", "14:35-15:15"));
        lesTimes.add(new LesTime("Перемена", "15:15-15:20"));
        lesTimes.add(new LesTime("2-ы дополнительный урок", "15:20-16:00"));
        lesTimes.add(new LesTime("Свободное время", "16:00-∞"));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


}

