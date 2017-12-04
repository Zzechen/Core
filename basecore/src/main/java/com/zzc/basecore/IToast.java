package com.zzc.basecore;

import android.content.Context;

/**
 * @auth zzc
 * @date 2017/12/4
 * @desc ${desc}
 */

public interface IToast {
    void showShortToast(Context context, CharSequence msg);

    void showLongToast(Context context, CharSequence msg);

    void hideToast();
}
