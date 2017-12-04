package com.zzc.core.biz.main;

import android.os.Bundle;

import com.zzc.core.R;
import com.zzc.core.base.BaseBizActivity;
import com.zzc.utilscore.ActivityUtils;

public class MainActivity extends BaseBizActivity {

    @Override
    protected String setTitle() {
        return "Main";
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fl_content);
        if (fragment == null){
            fragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.fl_content);
        }
    }
}
