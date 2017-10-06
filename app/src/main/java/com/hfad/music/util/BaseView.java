package com.hfad.music.util;

import android.support.annotation.StringRes;

/**
 * Created by anurag on 23/9/17.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void makeToast(@StringRes int stringId);

    void makeToast(String message);
}
