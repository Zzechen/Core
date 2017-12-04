package com.zzc.basecore;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created : zzc
 * Time : 2017/9/8
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public class DefaultLoadingView extends View implements ILoadingView {
    public DefaultLoadingView(Context context) {
        this(context, null);
    }

    public DefaultLoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DefaultLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVisibility(GONE);
    }

    @Override
    public void showWaiting(int progress) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void hideProgress(@Duration int duration, @Nullable Runnable r) {

    }

    @Override
    public void showSucceed(CharSequence success) {

    }

    @Override
    public void showSucceed(CharSequence success, @Duration int duration, @Nullable Runnable r) {

    }

    @Override
    public void showSucceed(@StringRes int resId) {

    }

    @Override
    public void showSucceed(@StringRes int resId, @Duration int duration, @Nullable Runnable r) {

    }

    @Override
    public void showError(CharSequence error) {

    }

    @Override
    public void showError(CharSequence error, @Duration int duration, @Nullable Runnable r) {

    }

    @Override
    public void showError(@StringRes int resId) {

    }

    @Override
    public void showError(@StringRes int resId, @Duration int duration, @Nullable Runnable r) {

    }

    @Override
    public boolean isShowing() {
        return getVisibility() == VISIBLE;
    }
}
