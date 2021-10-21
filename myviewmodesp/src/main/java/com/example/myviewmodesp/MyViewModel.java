package com.example.myviewmodesp;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    public final static String KEY_VAR_1 = "var1" ;
    public MyViewModel(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        Log.i("TAG", "MyViewModel: ");
        if(!handle.contains(KEY_VAR_1)){
            int x =SPUtil.getInt(application,KEY_VAR_1);
            handle.set(KEY_VAR_1,x);
        }
    }

    public MutableLiveData<Integer> getNum(){
        return handle.getLiveData(KEY_VAR_1);
    }

    public void save(){
         SPUtil.saveInt(getApplication(),KEY_VAR_1,getNum().getValue());
    }

    public void add(int p){
        getNum().setValue(getNum().getValue() + p);
        save();
    }


}
