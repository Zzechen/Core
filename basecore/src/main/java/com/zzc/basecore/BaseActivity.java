package com.zzc.basecore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.AttrRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created : zzc
 * Time : 2017/4/27
 * Email : zzc1259@163.com
 * Description : ${desc}
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen(supportFullScreen());
        beforeInflate(savedInstanceState);
        setContentView(getLayoutResId());
        initView(savedInstanceState);
        initListener();
    }

    protected abstract void beforeInflate(Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void initView(Bundle savedInstanceState);

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setFullScreen(boolean fullScreen) {
        if (fullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    /**
     * 设置toolbar文字
     *
     * @param toolbar
     * @param title
     */
    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * 设置toolbar可返回
     *
     * @param toolbar
     */
    protected void setToolBack(Toolbar toolbar) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 根据主题设置toolbar背景色
     *
     * @param tbBar
     * @param resId
     */
    protected void setToolbarBackground(Toolbar tbBar, @AttrRes int resId) {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(resId, typedValue, true);
        tbBar.setBackgroundColor(typedValue.data);
    }

    /**
     * 重新加载当前Activity
     */
    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    /**
     * 是否支持全屏
     *
     * @return true：支持
     */
    protected boolean supportFullScreen() {
        return false;
    }

    /**
     * 设置contentView的布局id
     *
     * @return 布局id，R.Layout.xxx
     */
    protected abstract int getLayoutResId();

    /**
     * 是否支持侧滑关闭,默认不支持
     *
     * @return
     */
    protected boolean supportSwipe() {
        return false;
    }
}
