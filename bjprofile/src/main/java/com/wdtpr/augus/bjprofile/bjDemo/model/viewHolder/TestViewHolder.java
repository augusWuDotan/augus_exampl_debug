package com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordItem;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class TestViewHolder extends BaseViewHolder {

    private TextView tv1, tvScore, tvAverage, tvMax;
    private View vDotted;

    public TestViewHolder(View itemView) {
        super(itemView);
        tv1 = (TextView) getView(R.id.tv1);
        tvScore = (TextView) getView(R.id.tvScore);
        tvAverage = (TextView) getView(R.id.tvAverage);
        tvMax = (TextView) getView(R.id.tvMax);
        vDotted = (View) getView(R.id.vDotted);
    }

    @Override
    public View[] getClickViews() {
        return new View[0];
    }

    @Override
    public View[] getLongClickViews() {
        return new View[0];
    }

    @Override
    public void bindViewData(Context context, Object data, int itemPosition, int finalPosition) {
        TEST_RecordItem bean = (TEST_RecordItem) data;

        tv1.setText(bean.getTitle());
        if (bean.getTitle().contains("FinalTest")) {
            //final test to bold
            tv1.setTypeface(null, Typeface.BOLD);
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18); // 設定sp
            tv1.setTextColor(Color.parseColor("#1B5E20"));
        } else {
            tv1.setTypeface(null, Typeface.NORMAL);
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12); // 設定sp
            tv1.setTextColor(Color.parseColor("#000000"));
        }


        tvScore.setText(bean.getScore() + "");
        tvScore.setTextColor(bean.getScore() > 59 ? Color.BLACK : Color.RED);
        tvAverage.setText(bean.getAverage() + "");
        tvMax.setText(bean.getHighest() + "");

        if (itemPosition == finalPosition)
            vDotted.setVisibility(View.INVISIBLE);
        else
            vDotted.setVisibility(View.VISIBLE);
    }

}
