package com.example.mybasket;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;

    private int aBack,bBack;

    public MyViewModel() {
        aTeamScore = new MutableLiveData<>();
        bTeamScore= new MutableLiveData<>();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

    public MutableLiveData<Integer> getaTeamScore() {
        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        return bTeamScore;
    }

    public void addaTeam(int p){
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(aTeamScore.getValue() + p);
    }

    public void addbTeam(int p){
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        bTeamScore.setValue(bTeamScore.getValue() + p);
    }

    public void reset(){
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

    public void undo(){
        aTeamScore.setValue(aBack);
        bTeamScore.setValue(bBack);
    }

}
