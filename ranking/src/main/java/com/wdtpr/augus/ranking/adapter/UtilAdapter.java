package com.wdtpr.augus.ranking.adapter;

import android.content.Context;

import com.wdtpr.augus.ranking.adapter.base.BaseAdapter;
import com.wdtpr.augus.ranking.adapter.factory.IItemType;

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
