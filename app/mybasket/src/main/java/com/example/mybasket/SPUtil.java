package com.example.mybasket;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {
    private final static String SP_NAME = "noteSp";

    public static void saveString(Context context,String key,String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public static String getString(Context context,String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }

    public static int getInt(Context context,String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key,-1);

    }
    public static int getIntWithDefault(Context context,String key,int defvalue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key,defvalue);

    }

    public static void saveInt(Context context,String key,int value){
       SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
       SharedPreferences.Editor editor = sharedPreferences.edit();
       editor.putInt(key,value);
       editor.commit();
    }
}
