package com.example.admin.repositoryroomdemo.view.mainactivity;

import com.example.admin.repositoryroomdemo.data.entities.User;
import com.example.admin.repositoryroomdemo.data.local.UserDao;

import javax.inject.Inject;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;
    UserDao userDao;
    private static final String SSID_PATTERN = "(.*?[.*?\\u0023+.*?\\u0026+.*?\\u002B+.*?\\u0060+.*?]+.*?)";


    @Inject
    public MainActivityPresenter(MainActivityContract.View view, UserDao userDao) {
        this.view = view;
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {



    }

    @Override
    public void getUser() {

    }
}
