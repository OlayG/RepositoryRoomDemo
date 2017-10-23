package com.example.admin.repositoryroomdemo.view.mainactivity;

import com.example.admin.repositoryroomdemo.data.local.UserDao;

import javax.inject.Inject;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;
    UserDao userDao;

    @Inject
    public MainActivityPresenter(MainActivityContract.View view, UserDao userDao) {
        this.view = view;
        this.userDao = userDao;
    }
}
