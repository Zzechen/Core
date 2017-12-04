package com.zzc.basecore;

/**
 * Created : zzc
 * Time : 2017/4/27
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public interface IView extends ILoadingView {
    void showShortToast(CharSequence msg);

    void showShortToast(int msgId);

    void showLongToast(CharSequence msg);

    void showLongToast(int msgId);

    void hideToast();
}
