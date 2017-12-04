package com.zzc.basecore;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created : zzc
 * Time : 2017/4/27
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView, IViewFactory<P> {
    protected Context mBaseContext;
    protected P mPresenter;
    protected ILoadingView mLoadingView;
    protected View mRootView;
    private IToast mToastView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mBaseContext = context;
        initPresenter();
    }

    protected void initPresenter() {
        mPresenter = createPresenter();
        mPresenter.attach(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), null);
            beforeInflate(mRootView, savedInstanceState);
            ILoadingView loadingView = createLoadingView();
            mLoadingView = loadingView == null ? new DefaultLoadingView(mBaseContext) : loadingView;
            IToast toast = createToast();
            mToastView = toast == null ? new DefaultToastView() : toast;
            initView(mRootView, savedInstanceState);
            initListener();
            loadData();
        }
        return mRootView;
    }

    protected abstract void beforeInflate(View rootView, Bundle savedInstanceState);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            if (mLoadingView instanceof View) {
                ((ViewGroup) view.getParent()).addView((View) mLoadingView);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }

    @Override
    public void showSucceed(CharSequence success) {
        mLoadingView.showSucceed(success);
    }

    @Override
    public void showSucceed(CharSequence success, @Duration int duration, @Nullable Runnable r) {
        mLoadingView.showSucceed(success, duration, r);
    }

    @Override
    public void showSucceed(@StringRes int resId) {
        showSucceed(getResources().getString(resId));
    }

    @Override
    public void showSucceed(@StringRes int resId, @Duration int duration, @Nullable Runnable r) {
        mLoadingView.showSucceed(resId, duration, r);
    }

    @Override
    public void showError(@StringRes int resId) {
        showError(getResources().getString(resId));
    }

    @Override
    public void showError(@StringRes int resId, @Duration int duration, @Nullable Runnable r) {
        mLoadingView.showError(resId, duration, r);
    }

    @Override
    public void showError(CharSequence error) {
        mLoadingView.showError(error);
    }

    @Override
    public void showError(CharSequence error, @Duration int duration, @Nullable Runnable r) {
        mLoadingView.showError(error, duration, r);
    }

    @Override
    public boolean isShowing() {
        return mLoadingView.isShowing();
    }

    @Override
    public void showWaiting(int progress) {
        mLoadingView.showWaiting(progress);
    }

    @Override
    public void hideProgress() {
        mLoadingView.hideProgress();
    }

    @Override
    public void hideProgress(@Duration int duration, @Nullable Runnable r) {
        mLoadingView.hideProgress(duration, r);
    }

    public abstract void loadData();

    public abstract void initListener();

    public abstract void initView(View view, Bundle savedInstanceState);

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    public void showShortToast(CharSequence msg) {
        mToastView.showShortToast(mBaseContext, msg);
    }

    @Override
    public void showShortToast(int msgId) {
        showShortToast(getString(msgId));
    }

    @Override
    public void showLongToast(CharSequence msg) {
        mToastView.showLongToast(mBaseContext, msg);
    }

    @Override
    public void showLongToast(int msgId) {
        showLongToast(getString(msgId));
    }

    @Override
    public void hideToast() {
        mToastView.hideToast();
    }
}
