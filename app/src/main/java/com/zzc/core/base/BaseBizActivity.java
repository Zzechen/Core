package com.zzc.core.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zzc.basecore.BaseActivity;
import com.zzc.core.R;

/**
 * @auth zzc
 * @date 2017/12/4
 * @desc ${desc}
 */

public abstract class BaseBizActivity extends BaseActivity {

    @Override
    protected void beforeInflate(Bundle savedInstanceState) {
    }

    @Override
    protected void afterInflate() {
        int layoutResId = getLayoutResId();
        if (R.layout.activity_common == layoutResId) {
            Toolbar tb = (Toolbar) findViewById(R.id.tb_common);
            tb.setTitle("");
            setSupportActionBar(tb);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            TextView tvTitle = (TextView) findViewById(R.id.tv_common_title);
            tb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            tvTitle.setText(getTitle());
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_common;
    }

    protected abstract String setTitle();
}
