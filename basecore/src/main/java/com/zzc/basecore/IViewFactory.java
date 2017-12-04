package com.zzc.basecore;

/**
 * @auth zzc
 * @date 2017/12/4
 * @desc ${desc}
 */

public interface IViewFactory<P extends IPresenter> {
    IToast createToast();

    ILoadingView createLoadingView();

    P createPresenter();
}
