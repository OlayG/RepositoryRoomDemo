package com.example.admin.repositoryroomdemo.data.repository;

import com.example.admin.repositoryroomdemo.data.entities.User;
import com.example.admin.repositoryroomdemo.data.local.UserDao;

import java.util.List;
import java.util.Timer;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import timber.log.Timber;

public class UserRepository {

    UserDao userDao;
    Retrofit retrofit;

    public UserRepository(UserDao userDao, Retrofit retrofit) {
        this.userDao = userDao;
        this.retrofit = retrofit;
    }

    public Observable<List<User>> getUsers() {
        return Observable.concatArray(getUsersFromDb(), getUsersFromApi());
    }

    private Observable<List<User>> getUsersFromApi() {
        return userDao.getUsers()
                .filter()
                .toObservable()
                .doOnNext(Timber.d("We have gotten user from API"));
    }

    private Observable<List<User>> getUsersFromDb() {
        return retrofit.create(ApiService.class)
                .observableGetData("")
                .doOnNext(storeUsersInDb;x());
    }

    public void storeUsersInDb(List<User> users){
        Observable.fromCallable(userDao.insertAll(users))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(Timber.d("Added ${users.size} to the DB..."));
    }

    private interface ApiService {
        @GET("")
        Observable<User> observableGetData(
                @Query("text") String text
        );
    }
}
