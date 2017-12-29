package com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class IRSRecordViewHolder extends BaseViewHolder {

    private TextView tvItem;
    private ProgressBar mPb;
    private View vDotted;
    private ImageView ivStatusIcon;


    public IRSRecordViewHolder(View itemView) {
        super(itemView);
        mPb = (ProgressBar) getView(R.id.mPb);
        tvItem = (TextView) getView(R.id.tvItem);
        vDotted = (View) getView(R.id.vDotted);
        ivStatusIcon = (ImageView) getView(R.id.ivStatusIcon);
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
        LogUtils.d(finalPosition+"");

        final IRS_RecordItem bean = (IRS_RecordItem) data;
//        Glide.with(ivStatusIcon.getContext()).load(R.drawable.irs_gray).asBitmap().into(ivStatusIcon);

        tvItem.setText(bean.getCourseNo());

        mPb.setProgress(0);
        int min = mPb.getProgress();
        int max = bean.getAverage();
        int duration = bean.getAverage() * 12;
        final  int rid = bean.getStatusDexRid();
        ObjectAnimator progressAnimator;
        if (min == 0) {
            progressAnimator = ObjectAnimator.ofInt(mPb, "progress", min, max);
            progressAnimator.setDuration(duration);
            progressAnimator.setInterpolator(new LinearInterpolator());
            progressAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    setImage(ivStatusIcon,rid);
                }
            });
            progressAnimator.start();
        } else if (min < max) {
            progressAnimator = ObjectAnimator.ofInt(mPb, "progress", min, max);
            progressAnimator.setDuration(duration);
            progressAnimator.setInterpolator(new LinearInterpolator());
            progressAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    setImage(ivStatusIcon,rid);
                }
            });
            progressAnimator.start();
        } else {
            //null
            setImage(ivStatusIcon,rid);
        }
        if (rid == -1) {
            LogUtils.d(bean.toString());
        }

        if(itemPosition == finalPosition)
            vDotted.setVisibility(View.INVISIBLE);
        else
            vDotted.setVisibility(View.VISIBLE);

    }

    public void setImage(ImageView img, int Rid){
        //
        try {
            Glide.with(img.getContext()).load(Rid).asBitmap().error(R.drawable.irs_gray).into(img);
        }catch (Exception e){
            LogUtils.e(e.getMessage());
        }
    }


}
