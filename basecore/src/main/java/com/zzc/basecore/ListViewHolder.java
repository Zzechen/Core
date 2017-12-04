package com.zzc.basecore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created : zzc
 * Time : 2017/4/27
 * Email : zzc1259@163.com
 * Description : ${desc}
 */
public class ListViewHolder {
    private SparseArray<View> views;
    private View mConvertView;
    private int mPosition;

    private ListViewHolder() {
    }

    public View getConvertView() {
        return mConvertView;
    }

    private ListViewHolder(ViewGroup parent, Context context, @LayoutRes int layoutId, int position) {
        this.views = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        //setTag
        mConvertView.setTag(this);
    }

    public static ListViewHolder getHolder(Context context, View convertView,
                                           ViewGroup parent, int layoutId, int position) {

        if (convertView == null) {
            return new ListViewHolder(parent, context, layoutId, position);
        }
        return (ListViewHolder) convertView.getTag();
    }

    public ListViewHolder setText(@IdRes int id, CharSequence text) {
        TextView tv = findView(id);
        tv.setText(text);
        return this;
    }

    public ListViewHolder setImgRes(@IdRes int id, int resId) {
        ImageView iv = findView(id);
        iv.setImageResource(resId);
        return this;
    }

    public ListViewHolder setImgDrawable(@IdRes int id, Drawable drawable) {
        ImageView iv = findView(id);
        iv.setImageDrawable(drawable);
        return this;
    }

    public ListViewHolder setImgBitmap(@IdRes int id, Bitmap bitmap) {
        ImageView iv = findView(id);
        iv.setImageBitmap(bitmap);
        return this;
    }

    public <T> T findView(int id) {
        View v = views.get(id);
        if (v == null) {
            v = mConvertView.findViewById(id);
            views.put(id, v);
        }
        return (T) v;
    }

}
