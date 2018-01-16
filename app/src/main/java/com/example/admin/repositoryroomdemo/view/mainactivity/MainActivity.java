package com.example.admin.repositoryroomdemo.view.mainactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.admin.repositoryroomdemo.MyApp;
import com.example.admin.repositoryroomdemo.R;
import com.example.admin.repositoryroomdemo.data.entities.User;
import com.example.admin.repositoryroomdemo.data.local.UserDao;
import com.example.admin.repositoryroomdemo.view.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainActivityContract.View {

    @Inject MainActivityPresenter presenter;
    @Inject
    SharedPreferences preferences;
    @Inject
    UserDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activateToolbar(false);
        setupDagger();
    }

    private void setupDagger() {
        DaggerMainActivityComponent.builder()
                .netComponent(((MyApp) getApplicationContext()).getNetComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void loadUser(User user) {

    }
}
