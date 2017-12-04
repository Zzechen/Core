package com.zzc.basecore;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created : zzc
 * Time : 2017/4/27
 * Email : zzc1259@163.com
 * Description : ${desc}
 */

public abstract class BaseListViewAdapter<T> extends BaseAdapter {
    protected List<T> mList;
    protected Context mContext;

    public BaseListViewAdapter(List<T> list, Context context) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mList = list;
        this.mContext = context;
    }

    public BaseListViewAdapter(List<T> list, Activity context) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mList = list;
        this.mContext = context;
    }

    public BaseListViewAdapter(List<T> list, Fragment fragment) {
        this(list, fragment.getActivity());
    }

    public void addItems(Collection<? extends T> items) {
        mList.addAll(0, items);
    }

    public void addItem(T item) {
        mList.add(item);
    }

    public void addItem(int index, T item) {
        mList.add(index, item);
    }

    public boolean deleteItem(T item) {
        return mList.remove(item);
    }

    public void deleteItem(int index) {
        mList.remove(index);
    }

    public void deleteAll() {
        mList.clear();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder viewHolder = ListViewHolder.getHolder(mContext
                , convertView
                , parent
                , getLayoutResByType(position), position);
        adaptView(viewHolder, position);
        return viewHolder.getConvertView();
    }


    protected abstract void adaptView(ListViewHolder viewHolder, int position);

    protected abstract int getLayoutResByType(int position);
}
