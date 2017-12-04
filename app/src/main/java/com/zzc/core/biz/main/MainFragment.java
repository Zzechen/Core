package com.zzc.core.biz.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zzc.core.R;
import com.zzc.core.base.BaseBizFragment;

/**
 * @auth zzc
 * @date 2017/12/4
 * @desc ${desc}
 */

public class MainFragment extends BaseBizFragment<MainPresenter> implements MainContract.View {

    private Button btn;

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void loadData() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.custom();
            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        btn = view.findViewById(R.id.btn_main);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }
}
