package com.example.fin_reg.apputil;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fin_reg.R;

public class AppConfig {
    private Context context;
    private SharedPreferences sharedPreferences;

    public AppConfig(Context context){
         this.context = context;
         sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file_key), Context.MODE_PRIVATE);

    }

    public boolean isUserLogin(){
        return sharedPreferences.getBoolean(context.getString(R.string.pref_is_user_login), false);
    }

    public void logout() {
        updateUserLoginStatus(false);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();
    }

    public void updateUserLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
         editor.putBoolean(context.getString(R.string.pref_is_user_login), status);
         editor.apply();


    }

    public void saveName(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_name_of_user), name);
        editor.apply();    }



    public String getName(){
        return sharedPreferences.getString(context.getString(R.string.pref_name_of_user), "Unknown");

    }


    public void saveToken(String token){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_token), token);
        editor.apply();    }



    public String getToken(){
        return sharedPreferences.getString(context.getString(R.string.pref_token), "Unknown");

    }


    public void savePost(String post){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_user_post), post);
        editor.apply();    }



    public String getPost(){
        return sharedPreferences.getString(context.getString(R.string.pref_user_post), "Unknown");

    }




}
