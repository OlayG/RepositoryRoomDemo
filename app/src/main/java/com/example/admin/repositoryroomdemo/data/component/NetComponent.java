package com.example.admin.repositoryroomdemo.data.component;

import android.content.SharedPreferences;

import com.example.admin.repositoryroomdemo.data.local.AppDatabase;
import com.example.admin.repositoryroomdemo.data.local.UserDao;
import com.example.admin.repositoryroomdemo.data.module.AppModule;
import com.example.admin.repositoryroomdemo.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    UserDao userDao();
    AppDatabase appDatabase();
    SharedPreferences preferences();
    Retrofit retrofit();
}
