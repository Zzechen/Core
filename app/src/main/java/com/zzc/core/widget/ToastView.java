package com.zzc.core.widget;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

import com.zzc.basecore.IToast;

/**
 * @auth zzc
 * @date 2017/12/4
 * @desc ${desc}
 */

public class ToastView implements IToast {
    private Toast mToast;

    @Override
    public void showShortToast(Context context, CharSequence msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    @Override
    public void showLongToast(Context context, CharSequence msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }

    private void showToast(Context context, CharSequence msg, int duration) {
        if (Looper.myLooper() == null) return;
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, msg, duration);
        mToast.show();
    }

    @Override
    public void hideToast() {
        if (mToast != null) mToast.cancel();
    }
}
