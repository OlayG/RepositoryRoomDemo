package com.example.admin.repositoryroomdemo;

import android.app.Application;

import com.example.admin.repositoryroomdemo.data.component.DaggerNetComponent;
import com.example.admin.repositoryroomdemo.data.component.NetComponent;
import com.example.admin.repositoryroomdemo.data.module.AppModule;
import com.example.admin.repositoryroomdemo.data.module.NetModule;

import timber.log.Timber;

public class MyApp extends Application {
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDagger();
        setupTimber();
    }

    private void setupTimber() {
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(""))
                .build();
    }

    private void setupDagger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
