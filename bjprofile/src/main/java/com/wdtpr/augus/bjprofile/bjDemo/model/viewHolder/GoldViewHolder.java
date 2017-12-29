package com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakItem;
import com.wdtpr.augus.bjprofile.bjDemo.utils.DateUtils;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;
import com.wdtpr.augus.bjprofile.bjDemo.utils.StringUtils;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class GoldViewHolder extends BaseViewHolder {

    private View vDotted;
    private ImageView ivCoinIcon;
    private TextView tvTime, tvReason,tvNum;


    public GoldViewHolder(View itemView) {
        super(itemView);
        tvTime = (TextView) getView(R.id.tvTime);
        tvReason = (TextView) getView(R.id.tvReason);
        tvNum = (TextView) getView(R.id.tvNum);
        ivCoinIcon = (ImageView) getView(R.id.ivCoinIcon);
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
    public void bindViewData(Context context, Object data, int itemPosition,int finalPosition) {
        final GoldRecordItem bean = (GoldRecordItem) data;
        //time
        String dateTime = DateUtils.getFormTimeStr(bean.getAPP_GoldRecord_Time(),"yyyy-MM-dd'T'HH:mm:ss","yyyy-MM-dd HH:mm");
        tvTime.setText(dateTime);
        //reason
        tvReason.setText(bean.getAPP_GoldRecord_Reason());
        //num
        tvNum.setText(bean.getAPP_GoldRecord_Count()+"");

        try {
            //icon
            if(bean.isGoldType()){
                Glide.with(ivCoinIcon.getContext()).load(R.drawable.monster_coin).asBitmap().error(R.drawable.irs_gray).into(ivCoinIcon);
            }else{
                Glide.with(ivCoinIcon.getContext()).load(R.drawable.coin).asBitmap().error(R.drawable.irs_gray).into(ivCoinIcon);
            }
        }catch (Exception e){
            LogUtils.e(e.getMessage());
        }

        if(itemPosition == finalPosition)
            vDotted.setVisibility(View.INVISIBLE);
        else
            vDotted.setVisibility(View.VISIBLE);
    }

}
