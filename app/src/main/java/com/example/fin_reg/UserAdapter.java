package com.example.fin_reg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.Student;
import com.example.fin_reg.ui.StudentTeacherInfo.StudentTeacherInfoFragment;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<Student> students;
    Context context;

    public UserAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;


    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_users, parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        String surname_name_text = students.get(position).getInfo().firstname +" "+ students.get(position).getInfo().lastname;
        String group_number = students.get(position).getSchoolClass().group + "." + students.get(position).getSchoolClass().subgroup;
        holder.username.setText(surname_name_text);
        holder.organization.setText(group_number);
        int stud_id = students.get(position).getId();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_id", stud_id);
                StudentTeacherInfoFragment studentTeacherInfoFragment = new StudentTeacherInfoFragment();
                studentTeacherInfoFragment.setArguments(bundle);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec_cont, studentTeacherInfoFragment).addToBackStack(null).commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username, organization;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.row_username);
            organization = itemView.findViewById(R.id.group_id);
        }
    }

}

//    private List<LoginData> userResponseList;
//    private Context context;
//
//    public UserAdapter() {
//
//    }
//    public void setData (List<LoginData> userResponseList) {
//        this.userResponseList = userResponseList;
//        notifyDataSetChanged();
//
//    }
//
//    @NonNull
//    @Override
//    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        context = parent.getContext();
//        return new UserAdapter.UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_users,parent,false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {
//
//        LoginData userResponse = userResponseList.get(position);
//
//        String username = userResponse.getData().getUser().getUsername();
//
//
//        holder.username.setText(username);
//        holder.imageMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                clickedItem.ClickedUser(userResponse);
//            }
//        });
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return userResponseList.size();
//    }
//
//    public class UserAdapterVH extends RecyclerView.ViewHolder {
//
//        TextView username;
//
//        TextView prefix;
//
//        ImageView imageMore;
//
//        public UserAdapterVH(@NonNull View itemView) {
//            super(itemView);
//
//            username = itemView.findViewById(R.id.username);
//            prefix = itemView.findViewById(R.id.prefix);
//
//            imageMore = itemView.findViewById(R.id.imageMore);
//
//        }
//    }

