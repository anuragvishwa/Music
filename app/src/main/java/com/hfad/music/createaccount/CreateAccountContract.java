package com.hfad.music.createaccount;

import android.support.annotation.StringRes;

import com.hfad.music.util.BasePresenter;
import com.hfad.music.util.BaseView;

/**
 * Created by anurag on 6/10/17.
 */

public interface CreateAccountContract {

    interface View extends BaseView<Presenter>{
        void makeToast(@StringRes int stringId);

        String getEmail();

        String getPassword();

        String getPasswordConfirmation();

        String getName();

        void startProfilePageActivity();

        void setPresenter(CreateAccountContract.Presenter presenter);

        void showProgressIndicator(boolean show);

    }


    interface Presenter extends BasePresenter{
        void onCreateAccountClick();

        void subscribe();

        void unsubscribe();
    }
}
