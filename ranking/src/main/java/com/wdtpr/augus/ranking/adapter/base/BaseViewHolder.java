package com.wdtpr.augus.ranking.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Ray on 2017/3/14.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        mViews = new SparseArray<>();
    }

    protected View getView(int redId) {
        View view = mViews.get(redId);
        if (view == null) {
            view = mItemView.findViewById(redId);
            mViews.put(redId, view);
        }
        return view;
    }

    /**
     * 實現view的點擊事件
     */
    public abstract View[] getClickViews();

    /**
     * 實現view的長按點擊事件
     */
    public abstract View[] getLongClickViews();

    /**
     * 綁定資料
     *
     * @param context
     * @param data
     */
    public abstract void bindViewData(Context context, T data, int itemPosition,int finalPosition);
}
