package com.example.admin.repositoryroomdemo.data.component;

import com.example.admin.repositoryroomdemo.MyApp;
import com.example.admin.repositoryroomdemo.data.module.AppModule;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MyApp myApp);
}
