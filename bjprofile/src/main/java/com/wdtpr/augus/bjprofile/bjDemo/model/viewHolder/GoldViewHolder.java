package com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.glide.GlideApp;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.utils.DateUtils;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;

import java.math.BigDecimal;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class GoldViewHolder extends BaseViewHolder {
    private ConstraintLayout cl;
    private View vDotted;
    private ImageView ivCoinIcon;
    private TextView tvTime, tvReason,tvNum;


    public GoldViewHolder(View itemView) {
        super(itemView);
        cl = (ConstraintLayout) getView(R.id.cl);
        tvTime = (TextView) getView(R.id.tvTime);
        tvReason = (TextView) getView(R.id.tvReason);
        tvNum = (TextView) getView(R.id.tvNum);
        ivCoinIcon = (ImageView) getView(R.id.ivCoinIcon);
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
    public void bindViewData(Context context, Object data, int itemPosition,int finalPosition) {
        final GoldRecordItem bean = (GoldRecordItem) data;
        //time
        tvTime.setText(bean.getGoldRecordTime());
        //reason
        if(bean.getGoldRecordReason().split("\\n").length==1){
            tvReason.setText(bean.getGoldRecordReason().split("\\n")[0]);
        }else{
            tvReason.setText(bean.getGoldRecordReason());
        }
        //num
        tvNum.setText(bean.getGoldRecordCount()+"");
//        tvNum.setText("10000");
        try {
            //icon
            if(bean.isMonsterCoin()){
//                ivCoinIcon.setImageResource(R.drawable.monster_coin);
                GlideApp.with(context).asBitmap().load(R.drawable.monster_coin).error(R.drawable.irs_gray).into(ivCoinIcon);
            }else{
//                ivCoinIcon.setImageResource(R.drawable.coin);
                GlideApp.with(context).asBitmap().load(R.drawable.coin).error(R.drawable.irs_gray).into(ivCoinIcon);
            }
        }catch (Exception e){
//            LogUtils.e(e.getMessage());
        }

        if(itemPosition == finalPosition && itemPosition>=8)
            vDotted.setVisibility(View.INVISIBLE);
        else
            vDotted.setVisibility(View.VISIBLE);
    }

}
