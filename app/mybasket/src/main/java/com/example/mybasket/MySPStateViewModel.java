package com.example.mybasket;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MySPStateViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    private static int aBack,bBack;

    final static String KEY_VAL1 = "ASCORE";
    final static String KEY_VAL2 = "BSCORE";

    final static String KEY_VAL1BACK = "ASCOREBACK";
    final static String KEY_VAL2BACK = "BSCOREBACK";

    public MySPStateViewModel(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if(!handle.contains(KEY_VAL1)){
           loadaTeamScore();
        }

        if(!handle.contains(KEY_VAL2)){
            loadbTeamScore();
        }

    }

    private void loadbTeamScore() {
        int x = SPUtil.getInt(getApplication(),KEY_VAL2);
        if(x != -1){
            handle.set(KEY_VAL2,x);
        }
        else {
            handle.set(KEY_VAL2,0);
        }
    }

    private void loadaTeamScore() {
        int x = SPUtil.getInt(getApplication(),KEY_VAL1);
        if(x != -1){
            handle.set(KEY_VAL1,x);
        }
        else {
            handle.set(KEY_VAL1,0);
        }
    }

    public MutableLiveData<Integer> getaTeamScore(){
        if(!handle.contains(KEY_VAL1)){
            handle.set(KEY_VAL1,0);
        }
        return handle.getLiveData(KEY_VAL1);
    }

    public MutableLiveData<Integer> getbTeamScore(){
        if(!handle.contains(KEY_VAL2)){
            handle.set(KEY_VAL2,0);
        }
        return handle.getLiveData(KEY_VAL2);
    }

    public void addaTeam(int p){
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getaTeamScore().setValue(getaTeamScore().getValue() + p);
    }

    public void addbTeam(int p){
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getbTeamScore().setValue(getbTeamScore().getValue() + p);
    }

    public void reset(){
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getaTeamScore().setValue(0);
        getbTeamScore().setValue(0);
    }

    public void undo(){

        getaTeamScore().setValue(aBack);
        getbTeamScore().setValue(bBack);
    }

    public void save(){
        SPUtil.saveInt(getApplication(),KEY_VAL1,getaTeamScore().getValue());
        SPUtil.saveInt(getApplication(),KEY_VAL2,getbTeamScore().getValue());
    }
}
