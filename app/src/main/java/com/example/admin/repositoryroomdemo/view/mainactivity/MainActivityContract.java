package com.example.admin.repositoryroomdemo.view.mainactivity;

import com.example.admin.repositoryroomdemo.data.entities.User;
import com.example.admin.repositoryroomdemo.view.base.BasePresenter;
import com.example.admin.repositoryroomdemo.view.base.BaseView;

public interface MainActivityContract {

    interface View extends BaseView {
        void loadUser(User user);
    }

    interface Presenter extends BasePresenter {
        void saveUser(User user);
        void getUser();
    }
}
