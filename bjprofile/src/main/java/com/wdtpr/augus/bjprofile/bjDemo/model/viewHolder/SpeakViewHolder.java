package com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.glide.GlideApp;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakItem;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;
import com.wdtpr.augus.bjprofile.bjDemo.utils.StringUtils;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class SpeakViewHolder extends BaseViewHolder {

    private View vDotted;
    private ImageView ivStatusIcon, ivPlayIcon;
    private TextView tvTitle, tvTime, tvScore;


    public SpeakViewHolder(View itemView) {
        super(itemView);
        tvTime = (TextView) getView(R.id.tvTime);
        tvTitle = (TextView) getView(R.id.tvTitle);
        tvScore = (TextView) getView(R.id.tvScore);
        vDotted = (View) getView(R.id.vDotted);
        ivStatusIcon = (ImageView) getView(R.id.ivStatusIcon);
        ivPlayIcon = (ImageView) getView(R.id.ivPlayIcon);
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
        final SpeakItem bean = (SpeakItem) data;

        //title
        tvTitle.setText(bean.getCourseNo());
        //time
        tvTime.setText(bean.getTestTime());
        tvTime.setVisibility(StringUtils.isEmpty(bean.getTestTime()) ? View.GONE : View.VISIBLE);
        //score
        tvScore.setText(String.valueOf(bean.getAverage()));
        //ivPlayIcon
        /*
        R.drawable.nplay 不能播放
        R.drawable.common_play 播放 含 點擊觸發
        R.drawable.upload 上傳 含 點擊觸發
         */
        //ivStatusIcon
         /*
        R.drawable.status0 不能播放
        R.drawable.status1 播放 含 點擊觸發
        R.drawable.status2 上傳 含 點擊觸發
         */

        try {

            switch (bean.getStatus()) {
                case "0":
                    GlideApp.with(context).asBitmap().load(R.drawable.nplay).into(ivPlayIcon);
                    GlideApp.with(context).asBitmap().load(R.drawable.turntable_status0).into(ivStatusIcon);
                    break;
                case "1":
                    GlideApp.with(context).asBitmap().load(R.drawable.play_normal).into(ivPlayIcon);
                    GlideApp.with(context).asBitmap().load(R.drawable.turntable_status1).into(ivStatusIcon);
                    break;
                case "2":
                    GlideApp.with(context).asBitmap().load(R.drawable.play_normal).into(ivPlayIcon);
                    GlideApp.with(context).asBitmap().load(R.drawable.turntable_status2).into(ivStatusIcon);
                    break;
                default:
                    GlideApp.with(context).asBitmap().load(R.drawable.nplay).into(ivPlayIcon);
                    GlideApp.with(context).asBitmap().load(R.drawable.turntable_status0).into(ivStatusIcon);
                    break;
            }
        } catch (Exception e) {
            LogUtils.e(e.getMessage());
        }

        if (itemPosition == finalPosition)
            vDotted.setVisibility(View.INVISIBLE);
        else
            vDotted.setVisibility(View.VISIBLE);
    }

}
