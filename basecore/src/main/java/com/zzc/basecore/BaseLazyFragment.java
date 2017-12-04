package com.zzc.basecore;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created : zzc
 * Time : 2017/4/27
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public abstract class BaseLazyFragment<P extends IPresenter> extends BaseFragment<P> {
    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    @Override
    public void loadData() {

    }

    public abstract void fetchData();

    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }

    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            if (!refreshVisible()) {
                isDataInitiated = true;
            }
            return true;
        }
        return false;
    }

    /**
     * 每次可见时刷新界面数据
     *
     * @return true is to refresh every time visible,or once
     */
    protected abstract boolean refreshVisible();
}
