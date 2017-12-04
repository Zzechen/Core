package com.zzc.basecore;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created : zzc
 * Time : 2017/4/27
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public abstract class BasePresenter<V extends IView> implements IPresenter<V> {
    protected V mView;
    protected Context mContext;

    @Override
    public void attach(V view) {
        mView = view;
        if (view != null) {
            if (view instanceof Fragment) {
                mContext = ((Fragment) view).getContext();
            } else if (view instanceof Activity) {
                mContext = (Context) view;
            }
        }
    }

    @Override
    public void detach() {
        mView = null;
        mContext = null;
    }
}
