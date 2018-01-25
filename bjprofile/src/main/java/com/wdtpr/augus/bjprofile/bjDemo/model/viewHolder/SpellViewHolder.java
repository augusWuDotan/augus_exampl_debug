package com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.UtilAdapter;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.itemdecoration.LinearSectionDecoration;
import com.wdtpr.augus.bjprofile.bjDemo.glide.GlideApp;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.DealItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.SpellData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.SpellDataItem;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class SpellViewHolder extends BaseViewHolder {
    private ConstraintLayout cl;
    private View vDotted;
    private TextView tvCourseNo;
    private RecyclerView mRecyView;
    private UtilAdapter adapter;
    float scaleH;


    public SpellViewHolder(View itemView) {
        super(itemView);
        cl = (ConstraintLayout) getView(R.id.cl);
        tvCourseNo = (TextView) getView(R.id.tvCourseNo);
        vDotted = (View) getView(R.id.vDotted);
        mRecyView = (RecyclerView) getView(R.id.mRecyView);

        //        LogUtils.d("總高：" + itemView.getResources().getDisplayMetrics().heightPixels);
        scaleH = new BigDecimal((itemView.getContext().getResources().getDisplayMetrics().heightPixels / 1920f) * 150).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
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
    public void bindViewData(final Context context, Object data, int itemPosition, int finalPosition) {
        final SpellDataItem bean = (SpellDataItem) data;
        //time
        tvCourseNo.setText(bean.getCourseNo());
        //


//        LogUtils.d("dealItemList.size() : "+dealItemList.size());
        mRecyView.post(new Runnable() {
            @Override
            public void run() {
//                LogUtils.d("mRecyView.getWidth():" + mRecyView.getWidth());
                float hw = new BigDecimal((float) mRecyView.getWidth() / 6).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();

                ViewGroup.LayoutParams lp = cl.getLayoutParams();
                int height = bean.getLights().size() < 7 ? (int) hw : bean.getLights().size() < 13 ? (int) (hw * 2) : (int) (hw * 3);
                lp.height = height > (int)scaleH ? height : (int)scaleH;
                cl.setLayoutParams(lp);

                List<DealItem> dealItemList = new ArrayList<>();
                for (String s : bean.getLights()) {
                    DealItem deal = new DealItem();
                    deal.setType(s);
                    deal.setHw(hw);
                    dealItemList.add(deal);
                }
                adapter = new UtilAdapter(context, dealItemList);
                mRecyView.setAdapter(adapter);
            }
        });
        mRecyView.setLayoutManager(new GridLayoutManager(context, 6));
        mRecyView.addItemDecoration(new LinearSectionDecoration(0, Color.TRANSPARENT));
        mRecyView.setHasFixedSize(true);


        if (itemPosition == finalPosition && itemPosition >= 8)
            vDotted.setVisibility(View.INVISIBLE);
        else
            vDotted.setVisibility(View.VISIBLE);
    }

}
