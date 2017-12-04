package com.zzc.core.base;

import android.os.Bundle;
import android.view.View;

import com.zzc.basecore.BaseFragment;
import com.zzc.basecore.ILoadingView;
import com.zzc.basecore.IPresenter;
import com.zzc.basecore.IToast;
import com.zzc.core.widget.LoadingView;
import com.zzc.core.widget.ToastView;

/**
 * @auth zzc
 * @date 2017/12/4
 * @desc ${desc}
 */

public abstract class BaseBizFragment<P extends IPresenter> extends BaseFragment<P> {
    @Override
    public IToast createToast() {
        return new ToastView();
    }

    @Override
    public ILoadingView createLoadingView() {
        return new LoadingView(mBaseContext);
    }

    @Override
    protected void beforeInflate(View rootView, Bundle savedInstanceState) {

    }

    @Override
    protected void afterInflate() {

    }
}
