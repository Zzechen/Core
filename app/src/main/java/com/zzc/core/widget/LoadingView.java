package com.zzc.core.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.zzc.basecore.ILoadingView;
import com.zzc.core.R;

/**
 * @auth zzc
 * @date 2017/12/4
 * @desc ${desc}
 */

public class LoadingView extends RelativeLayout implements ILoadingView {
    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_loading, this);
        setVisibility(GONE);
    }

    @Override
    public void showWaiting(int progress) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void hideProgress(int duration, @Nullable Runnable r) {

    }

    @Override
    public void showSucceed(CharSequence success) {

    }

    @Override
    public void showSucceed(CharSequence success, int duration, @Nullable Runnable r) {

    }

    @Override
    public void showSucceed(int resId) {

    }

    @Override
    public void showSucceed(int resId, int duration, @Nullable Runnable r) {

    }

    @Override
    public void showError(CharSequence error) {

    }

    @Override
    public void showError(CharSequence error, int duration, @Nullable Runnable r) {

    }

    @Override
    public void showError(int resId) {

    }

    @Override
    public void showError(int resId, int duration, @Nullable Runnable r) {

    }

    @Override
    public boolean isShowing() {
        return false;
    }
}
