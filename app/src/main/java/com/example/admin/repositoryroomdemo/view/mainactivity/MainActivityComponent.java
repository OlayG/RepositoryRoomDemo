package com.example.admin.repositoryroomdemo.view.mainactivity;

import com.example.admin.repositoryroomdemo.data.component.NetComponent;
import com.example.admin.repositoryroomdemo.util.CustomScope;

import dagger.Component;
@CustomScope
@Component(dependencies = {NetComponent.class}, modules = {MainActivityModule.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
