package com.zzc.basecore;

/**
 * Created : zzc
 * Time : 2017/4/27
 * Email : zzc1259@163.com
 * Description : ${desc}
 */
public interface IPresenter<V extends IView> {
    void attach(V view);

    void detach();

}
