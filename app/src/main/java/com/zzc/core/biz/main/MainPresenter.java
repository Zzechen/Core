package com.zzc.core.biz.main;

import android.content.Intent;

import com.zzc.basecore.BasePresenter;
import com.zzc.core.biz.custom.CustomActivity;

/**
 * @auth zzc
 * @date 2017/12/4
 * @desc ${desc}
 */

public class MainPresenter extends BasePresenter<MainFragment> implements MainContract.Presenter {
    @Override
    public void custom() {
        mView.startActivity(new Intent(mContext, CustomActivity.class));
    }
}
