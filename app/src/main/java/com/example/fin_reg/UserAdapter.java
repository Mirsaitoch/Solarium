package com.example.fin_reg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.EachUser;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder >{
    List<EachUser> eachUserList;
    Context context;

    public UserAdapter(Context context, List<EachUser> eachUserList) {
        this.context = context;
        this.eachUserList = eachUserList;

    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_users, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        holder.username.setText(eachUserList.get(position).getUsername());
        holder.organization.setText(eachUserList.get(position).getOrganization());

    }

    @Override
    public int getItemCount() {
        return eachUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username, organization;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.row_username);
            organization = itemView.findViewById(R.id.row_organization);
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

