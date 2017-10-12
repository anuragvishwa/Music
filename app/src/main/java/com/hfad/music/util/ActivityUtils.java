package com.hfad.music.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by anurag on 12/10/17.
 */

public class ActivityUtils extends AppCompatActivity{

    public static void addFragmentToActivity(FragmentManager fragmentManager,
                                             Fragment fragment,
                                             int frameId,
                                             String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId,fragment,tag);
        transaction.commit();
    }
}
