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
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakItem;
import com.wdtpr.augus.bjprofile.bjDemo.utils.StringUtils;

import java.math.BigDecimal;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class SpeakViewHolder extends BaseViewHolder {
    private ConstraintLayout cl;
    private View vDotted;
    private ImageView ivStatusIcon, ivPlayIcon;
    private TextView tvTitle, tvTime, tvScore;


    public SpeakViewHolder(View itemView) {
        super(itemView);
        cl = (ConstraintLayout) getView(R.id.cl);
        tvTime = (TextView) getView(R.id.tvTime);
        tvTitle = (TextView) getView(R.id.tvTitle);
        tvScore = (TextView) getView(R.id.tvScore);
        vDotted = (View) getView(R.id.vDotted);
        ivStatusIcon = (ImageView) getView(R.id.ivStatusIcon);
        ivPlayIcon = (ImageView) getView(R.id.ivPlayIcon);
        //        LogUtils.d("總高：" + itemView.getResources().getDisplayMetrics().heightPixels);
        float scaleH = new BigDecimal((itemView.getContext().getResources().getDisplayMetrics().heightPixels / 1920f) * 150).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
//        LogUtils.d("scaleH：" + scaleH);
        ViewGroup.LayoutParams lp = cl.getLayoutParams();
        lp.height = (int) scaleH;
        cl.setLayoutParams(lp);
    }

    @Override
    public View[] getClickViews() {
        return new View[]{ivPlayIcon,ivStatusIcon};
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
        tvTime.setVisibility(StringUtils.isEmpty(bean.getTestTime()) ? View.GONE : View.VISIBLE);
//        if(!StringUtils.isEmpty(bean.getTestTime())){
//            StringBuffer buffer = new StringBuffer();
//            String [] t = bean.getTestTime().split(" ");
//            int index = 0;
//            for(String ts : t){
//                if(index != 0){
//                    buffer.append("\n"+ts);
//                }else{
//                    buffer.append(ts);
//                }
//                index ++;
//            }
//            tvTime.setText(buffer.toString());
//        }
        tvTime.setText(bean.getTestTime());
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
        R.drawable.status 0 不能播放
        R.drawable.status 1 播放 含 點擊觸發
        R.drawable.status 2 上傳 含 點擊觸發
         */
//        GlideApp.with(ivPlayIcon.getContext()).clear(ivPlayIcon);
//        GlideApp.with(ivStatusIcon.getContext()).clear(ivStatusIcon);
        if (!bean.isCanLotteryDraw()) {
            //未考試 + 尚未領取
            if (bean.getAverage() > 0) {
                //未領取
                ivPlayIcon.setImageResource(R.drawable.play_normal);
                ivStatusIcon.setImageResource(R.drawable.turntable_status1);
//                GlideApp.with(ivPlayIcon.getContext()).asBitmap().load(R.drawable.play_normal).into(ivPlayIcon);
//                GlideApp.with(ivStatusIcon.getContext()).asBitmap().load(R.drawable.turntable_status1).into(ivStatusIcon);
            } else {
                //尚未考試
                ivPlayIcon.setImageResource(R.drawable.nplay);
                ivStatusIcon.setImageResource(R.drawable.turntable_status0);
//                GlideApp.with(ivPlayIcon.getContext()).asBitmap().load(R.drawable.nplay).into(ivPlayIcon);
//                GlideApp.with(ivStatusIcon.getContext()).asBitmap().load(R.drawable.turntable_status0).into(ivStatusIcon);
            }
        } else {
            //已領取
            if (bean.getAverage() > 0) {
                //已經領取
                ivPlayIcon.setImageResource(R.drawable.play_normal);
                ivStatusIcon.setImageResource(R.drawable.turntable_status2);
//                GlideApp.with(ivPlayIcon.getContext()).asBitmap().load(R.drawable.play_normal).into(ivPlayIcon);
//                GlideApp.with(ivStatusIcon.getContext()).asBitmap().load(R.drawable.turntable_status2).into(ivStatusIcon);
            } else {
                //無此狀態
                ivPlayIcon.setImageResource(R.drawable.nplay);
                ivStatusIcon.setImageResource(R.drawable.turntable_status0);
//                GlideApp.with(ivPlayIcon.getContext()).asBitmap().load(R.drawable.nplay).into(ivPlayIcon);
//                GlideApp.with(ivStatusIcon.getContext()).asBitmap().load(R.drawable.turntable_status0).into(ivStatusIcon);
            }
        }

        if (itemPosition == finalPosition)
            vDotted.setVisibility(  View.INVISIBLE);
        else
            vDotted.setVisibility(View.VISIBLE);

    }
}
