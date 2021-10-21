package com.example.myviewmodesp;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {
    private final static String SP_NAME = "NoteSP";

    public static void saveInt(Context context,String key,int value){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key,value);
        editor.commit();
    }

    public static int getInt(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        return sp.getInt(key,0);
    }
}
