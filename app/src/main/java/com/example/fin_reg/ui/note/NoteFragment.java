package com.example.fin_reg.ui.note;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fin_reg.R;
import com.example.fin_reg.UserAdapter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class NoteFragment extends Fragment {

    private NoteViewModel noteViewModel;
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


        ListView listView = (ListView) root.findViewById(R.id.days_listView);

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
        sixth_lesson_ten.set(Calendar.HOUR, 13);
        sixth_lesson_ten.set(Calendar.MINUTE, 5);
        sixth_lesson_ten.set(Calendar.SECOND, 0);

        GregorianCalendar sixth_break = new GregorianCalendar();
        sixth_break.set(Calendar.HOUR, 13);
        sixth_break.set(Calendar.MINUTE, 45);
        sixth_break.set(Calendar.SECOND, 0);

        GregorianCalendar free_time = new GregorianCalendar();
        sixth_break.set(Calendar.HOUR, 19);
        sixth_break.set(Calendar.MINUTE, 0);
        sixth_break.set(Calendar.SECOND, 0);





        Date date = new Date();


        String[] days = {
                "Первый урок", "Перемена", "Второй урок", "Перемена", "Третий урок",
                "Перемена", "Четвертый урок", "Перемена", "Пятый урок", "Перемена", "Шестой урок","Обеденный перерыв", "Свободное время"
        };

        Boolean lesson_bool = false;
        String monthString;
        int id = -1;

        GregorianCalendar real_time = new GregorianCalendar();
        int real_hour =  date.getHours();
        int real_minutes  =  date.getMinutes();
        int real_seconds = date.getSeconds();
        real_time.set(Calendar.HOUR,real_hour);
        real_time.set(Calendar.MINUTE, real_minutes);
        real_time.set(Calendar.SECOND, real_seconds);


        System.out.println(real_time);



        if (first_lesson_ten.before(real_time) == false) id  = 0;
        else if (first_break.before(real_time) == false) id  = 1;
        else if (second_lesson_ten.before(real_time) == false) id  = 2;
        else if (second_break.before(real_time) == false) id  = 3;
        else if (third_lesson_ten.before(real_time) == false) id  = 4;
        else if (third_break.before(real_time) == false){
            id  = 5;

        }
        else if (forth_lesson_ten.before(real_time) == false) {
            id  = 6;

        }
        else if (forth_break.before(real_time) == false) id  = 7;
        else if (fifth_lesson_ten.before(real_time) == false) id  = 8;
        else if (fifth_break.before(real_time) == false) id  = 9;
        else if (sixth_lesson_ten.before(real_time) == false) id  = 10;
        else if (sixth_break.before(real_time) == false) id  = 11;
        else if (free_time.before(real_time)) id = 12;


        System.out.println(days[id]);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(getParentFragment().getContext(), android.R.layout.simple_list_item_1, days);


        listView.setAdapter(adapter);



        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





    }

}