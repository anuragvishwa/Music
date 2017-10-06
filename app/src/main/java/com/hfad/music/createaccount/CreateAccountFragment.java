package com.hfad.music.createaccount;


import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hfad.music.R;
import com.hfad.music.data.auth.AuthInjection;
import com.hfad.music.data.database.DatabaseInjection;
import com.hfad.music.data.database.DatabaseSource;
import com.hfad.music.data.scheduler.SchedulerInjection;
import com.hfad.music.util.ScheduleProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateAccountFragment extends Fragment implements CreateAccountContract.View {


    public CreateAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account2, container, false);
    }

    private Button createAccount;
    private TextView emailLabel, passwordLabel, confirmLabel, nameLabel;
    private EditText emailInput, passwordInput, confirmInput, nameInput;
    private ProgressBar progressBar;
    private View contentContainer;
    private CreateAccountContract.Presenter presenter;

    @Override
    public void makeToast(String message) {

    }

    @Override
    public void makeToast(@StringRes int stringId) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getPasswordConfirmation() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void startProfilePageActivity() {

    }

    @Override
    public void setPresenter(CreateAccountContract.Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void showProgressIndicator(boolean show) {

    }

    /*@Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(presenter==null){
            presenter = new CreateAccountPresenter(
                    AuthInjection.provideAuthSource(),
                    DatabaseInjection.provideDatabaseSource(),
                    this,
                    SchedulerInjection.provideSchedulerProvider()


            );
        }
    }*/
}
