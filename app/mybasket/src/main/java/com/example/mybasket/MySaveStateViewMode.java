package com.example.mybasket;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MySaveStateViewMode extends ViewModel {
    private SavedStateHandle handle;
    private static int aBack,bBack;

    final static String KEY_VAL1 = "ASCORE";
    final static String KEY_VAL2 = "BSCORE";

    final static String KEY_VAL1BACK = "ASCOREBACK";
    final static String KEY_VAL2BACK = "BSCOREBACK";

    public MySaveStateViewMode(SavedStateHandle handle) {
        this.handle = handle;
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
}
