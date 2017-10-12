package com.hfad.music.createaccount;

import android.support.v7.widget.LinearLayoutCompat;

import com.hfad.music.data.auth.AuthSource;
import com.hfad.music.data.auth.Credentials;
import com.hfad.music.data.database.DatabaseSource;
import com.hfad.music.util.BaseScheduleProvider;

import javax.sql.DataSource;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;

/**
 * Created by anurag on 6/10/17.
 */

public class CreateAccountPresenter implements CreateAccountContract.Presenter{

    private AuthSource auth;
    private CreateAccountContract.View view;
    private CompositeDisposable disposableSubscriptions;
    private BaseScheduleProvider scheduleProvider;
    private DatabaseSource database;

    public CreateAccountPresenter(
            AuthSource auth,
            DatabaseSource database,
            CreateAccountContract.View view,
            BaseScheduleProvider scheduleProvider
    )
    {
        this.auth = auth;
        this.database= database;
        this.view = view;
        this.scheduleProvider = scheduleProvider;
        this.disposableSubscriptions = new CompositeDisposable();
        view.setPresenter(this);
    }

    @Override
    public void onCreateAccountClick() {
        if(validateAccountCredentials(view.getName(),view.getEmail(),view.getPassword(),view.getPasswordConfirmation())){

        }

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    public boolean validateAccountCredentials(String name,String email,String password,String passwordConfirmation) {
        if (email.isEmpty()) {
            view.makeToast("Inputs may not be empty");
            return false;
        } else if (name.isEmpty()) {
            view.makeToast("Inputs may not be empty");
            return false;
        } else if (password.isEmpty()) {
            view.makeToast("Password is empty");
            return false;
        } else if (passwordConfirmation.isEmpty()) {
            view.makeToast("Password Confirmation is empty");
            return false;
        } else if (!email.contains("@")) {
            view.makeToast("Email doesn't contain @");
            return false;
        } else if (password.length() > 19) {
            view.makeToast("Password length is more than 19");
            return false;
        } else if (!passwordConfirmation.equals(password)) {
            view.makeToast("Confirm password doesn't match");
            return false;
        } else {
            return true;
        }
    }

    public void attemptAccountCreation(Credentials cred){
        view.showProgressIndicator(true);
        disposableSubscriptions.add(
                auth.createAccount(cred)
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribeWith(
                        new DisposableCompletableObserver(){
                            @Override
                            public void onComplete(){
                                view.startProfilePageActivity();
                            }
                            @Override
                            public void onError(Throwable e){
                                view.makeToast(e.getMessage());
                            }

                        }
                )
        )

    }
}
