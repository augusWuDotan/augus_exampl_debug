package com.wdtpr.augus.bjprofile.bjDemo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by augus on 2018/1/24.
 */

public class mRecycleView extends RecyclerView {

    public mRecycleView(Context context) {
        super(context);
    }

    public mRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
    }
}
