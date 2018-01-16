package com.example.admin.repositoryroomdemo.data.repository;

import com.example.admin.repositoryroomdemo.data.entities.User;
import com.example.admin.repositoryroomdemo.data.local.UserDao;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import timber.log.Timber;

public class Repository {

    UserDao userDao;
    Retrofit retrofit;

    public Repository(UserDao userDao, Retrofit retrofit) {
        this.userDao = userDao;
        this.retrofit = retrofit;
    }

    public Observable<List<User>> getUsers() {
        return Observable.concatArray(getUsersFromDb(), getUsersFromApi());
    }

    private Observable<List<User>> getUsersFromDb() {
        return userDao.getUsers()
                .filter(new Predicate<List<User>>() {
                    @Override
                    public boolean test(@NonNull List<User> users) throws Exception {
                        return !users.isEmpty();
                    }
                })
                .toObservable()
                .doOnNext(new Consumer<List<User>>() {
                    @Override
                    public void accept(@NonNull List<User> users) throws Exception {
                        Timber.d("We have gotten user from API");
                    }
                });
    }

    private Observable<List<User>> getUsersFromApi() {
        return retrofit.create(ApiService.class)
                .observableGetData("")
                .doOnNext(new Consumer<List<User>>() {
                    @Override
                    public void accept(@NonNull List<User> users) throws Exception {
                        storeUsersInDb(users);
                    }
                    
                });
    }

    public void storeUsersInDb(final List<User> users){
        Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                userDao.insertAll(users);
                return true;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe();
    }

    private interface ApiService {
        @GET("")
        Observable<List<User>> observableGetData(
                @Query("text") String text
        );
    }
}
