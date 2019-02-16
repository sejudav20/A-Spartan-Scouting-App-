package com.example.davin.scoutingapp2019;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class TeamViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    private Application mApplication;



    public TeamViewModelFactory(Application application) {
        super(application);
        mApplication = application;

    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new TeamViewModel(mApplication);
    }
}
