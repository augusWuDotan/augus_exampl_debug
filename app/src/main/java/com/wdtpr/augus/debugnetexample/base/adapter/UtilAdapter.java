package com.wdtpr.augus.debugnetexample.base.adapter;

import android.content.Context;


import com.wdtpr.augus.debugnetexample.base.adapter.base.BaseAdapter;
import com.wdtpr.augus.debugnetexample.base.adapter.factory.IItemType;

import java.util.List;

/**
 * 通用RecycleView Adapter
 */

public class UtilAdapter extends BaseAdapter {

    public UtilAdapter(Context mContext, List<? extends IItemType> mData) {
        super(mContext, mData);
    }

    @Override
    public int itemHeadViewType() {
        return 0;
    }

    @Override
    public int itemFootViewType() {
        return 0;
    }
}
