package com.example.admin.repositoryroomdemo.view.mainactivity;

import com.example.admin.repositoryroomdemo.util.CustomScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    private final MainActivityContract.View view;

    public MainActivityModule(MainActivityContract.View view) {
        this.view = view;
    }

    @Provides
    @CustomScope
    MainActivityContract.View providesMainActivityContractView() {
        return view;
    }
}
