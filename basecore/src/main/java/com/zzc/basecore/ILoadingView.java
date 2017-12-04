package com.zzc.basecore;

import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created : zzc
 * Time : 2017/9/8
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public interface ILoadingView {
    int DURATION_SHORT = 500;
    int DURATION_MID = 800;
    int DURATION_LONG = 1000;

    @IntDef({DURATION_SHORT, DURATION_MID, DURATION_LONG})
    @Retention(RetentionPolicy.SOURCE)
    @interface Duration {

    }

    void showWaiting(int progress);

    void hideProgress();

    void hideProgress(@Duration int duration, @Nullable Runnable r);

    void showSucceed(CharSequence success);

    void showSucceed(CharSequence success, @Duration int duration, @Nullable Runnable r);

    void showSucceed(@StringRes int resId);

    void showSucceed(@StringRes int resId, @Duration int duration, @Nullable Runnable r);

    void showError(CharSequence error);

    void showError(CharSequence error, @Duration int duration, @Nullable Runnable r);

    void showError(@StringRes int resId);

    void showError(@StringRes int resId, @Duration int duration, @Nullable Runnable r);

    boolean isShowing();
}
