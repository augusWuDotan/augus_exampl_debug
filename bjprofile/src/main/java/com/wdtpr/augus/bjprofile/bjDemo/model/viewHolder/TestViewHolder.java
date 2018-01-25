package com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;

import java.math.BigDecimal;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class TestViewHolder extends BaseViewHolder {
    private ConstraintLayout cl;
    private TextView tv1, tvScore, tvAverage, tvMax;
    private View vDotted;

    public TestViewHolder(View itemView) {
        super(itemView);
        cl = (ConstraintLayout) getView(R.id.cl);
        tv1 = (TextView) getView(R.id.tv1);
        tvScore = (TextView) getView(R.id.tvScore);
        tvAverage = (TextView) getView(R.id.tvAverage);
        tvMax = (TextView) getView(R.id.tvMax);
        vDotted = (View) getView(R.id.vDotted);
//        LogUtils.d("總高：" + itemView.getResources().getDisplayMetrics().heightPixels);
        float scaleH = new BigDecimal((itemView.getContext().getResources().getDisplayMetrics().heightPixels / 1920f) * 150).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
//        LogUtils.d("scaleH：" + scaleH);
        ViewGroup.LayoutParams lp = cl.getLayoutParams();
        lp.height = (int) scaleH;
        cl.setLayoutParams(lp);
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
