package com.zzc.basecore;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created : zzc
 * Time : 2017/6/19
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public abstract class BaseDialogFragment<P extends IPresenter> extends DialogFragment implements IView, IViewFactory<P> {
    protected Context mBaseContext;
    protected P mPresenter;
    protected ILoadingView mLoadingView;
    private Dialog mDialog;
    private IToast mToastView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mBaseContext = context;
        initPresenter();
    }

    protected void initPresenter() {
        mPresenter.attach(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int styleId = getStyleId();
        if (styleId != 0) {
            mDialog = new Dialog(getContext(), styleId);
        } else {
            mDialog = new Dialog(getContext());
        }

        ILoadingView loadingView = createLoadingView();
        mLoadingView = loadingView == null ? new DefaultLoadingView(mBaseContext) : loadingView;
        IToast toast = createToast();
        mToastView = toast == null ? new DefaultToastView() : toast;
        mDialog.setContentView(getContentId());
        int[] size = size();
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = gravity();
        lp.width = size[0];
        lp.height = size[1];
        window.setAttributes(lp);
        int animStyle = getAnimStyle();
        if (animStyle != 0) {
            mDialog.getWindow().setWindowAnimations(animStyle);
        }
        View decorView = mDialog.getWindow().getDecorView();
        if (mLoadingView instanceof View) {
            ((ViewGroup) decorView).addView((View) mLoadingView);//add statusView
        }
        beforeInflate(decorView, savedInstanceState);
        initView(decorView, savedInstanceState);
        afterInflate();
        initListener();
        return mDialog;
    }

    /**
     *
     */
    protected abstract void beforeInflate(View rootView, Bundle savedInstanceState);

    protected abstract void afterInflate();

    /**
     * 动画
     *
     * @return
     */
    @StyleRes
    protected abstract int getAnimStyle();

    /**
     * 布局ID
     *
     * @return
     */
    @LayoutRes
    protected abstract int getContentId();

    /**
     * 大小 0 --- width,1 --- height
     *
     * @return
     */
    protected abstract int[] size();

    /**
     * 内容位置 -- {@link Gravity}
     *
     * @return
     */
    protected abstract int gravity();

    @StyleRes
    protected abstract int getStyleId();

    public abstract void initListener();

    public abstract void initView(View decorView, Bundle savedInstanceState);

    public void setCanceledOnTouchOutside(boolean cancel) {
        mDialog.setCanceledOnTouchOutside(cancel);
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
    public void showLongToast(CharSequence msg) {
        mToastView.showLongToast(mBaseContext, msg);
    }

    @Override
    public void showLongToast(@StringRes int msgId) {
        showLongToast(getString(msgId));
    }

    @Override
    public void showWaiting(int progress) {
        mLoadingView.showWaiting(0);
    }

    @Override
    public void hideProgress() {
        mLoadingView.hideProgress();
    }

    @Override
    public void hideProgress(@Duration int duration, @Nullable Runnable r) {
        mLoadingView.hideProgress(duration, r);
    }

    @Override
    public void showShortToast(CharSequence msg) {
        mToastView.showShortToast(mBaseContext, msg);
    }

    @Override
    public void showShortToast(@StringRes int msgId) {
        showShortToast(getString(msgId));
    }
}
