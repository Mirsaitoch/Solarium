package com.example.fin_reg.ui.note;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fin_reg.R;
import com.example.fin_reg.UserAdapter;


public class NoteFragment extends Fragment {

    private NoteViewModel noteViewModel;
    UserAdapter userAdapter;

    TextView textView;
    RecyclerView recyclerView;
    Context this_context;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        noteViewModel =
                ViewModelProviders.of(this).get(NoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_note, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.text_note);

//        userAdapter = new UserAdapter();


        textView.setText("note fragment");



    }

}