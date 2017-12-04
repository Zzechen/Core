package com.zzc.core.biz.custom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zzc.core.R;
import com.zzc.core.base.BaseBizActivity;

/**
 * @auth zzc
 * @date 2017/12/4
 * @desc ${desc}
 */

public class CustomActivity extends BaseBizActivity {
    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Toolbar tb = (Toolbar) findViewById(R.id.tb_common);
        setToolBar(tb, "");
        setToolBack(tb);
        tb.setBackgroundColor(Color.GRAY);
        TextView tv = (TextView) findViewById(R.id.tv_common_title);
        tv.setText("Custom");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_custom;
    }

    @Override
    protected String setTitle() {
        return null;
    }
}
