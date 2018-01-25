package com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.glide.GlideApp;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieItem;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;

import java.math.BigDecimal;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class MovieViewHolder extends BaseViewHolder {

    private ConstraintLayout cl;
    private ProgressBar mPb;
    private View vDotted;
    private ImageView ivStatusIcon;
    private TextView tvSchedule, tvTitle;


    public MovieViewHolder(View itemView) {
        super(itemView);
        cl = (ConstraintLayout)getView(R.id.cl);
        mPb = (ProgressBar) getView(R.id.mPb);
        tvSchedule = (TextView) getView(R.id.tvSchedule);
        tvTitle = (TextView) getView(R.id.tvTitle);
        vDotted = (View) getView(R.id.vDotted);

        ivStatusIcon = (ImageView) getView(R.id.ivStatusIcon);
        LogUtils.d("總高：" + itemView.getResources().getDisplayMetrics().heightPixels);
        float scaleH = new BigDecimal((itemView.getContext().getResources().getDisplayMetrics().heightPixels / 1920f) * 150).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        LogUtils.d("scaleH：" + scaleH);
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
        final MovieItem bean = (MovieItem) data;

        GlideApp.with(ivStatusIcon.getContext()).asBitmap().load(R.drawable.irs_gray).into(ivStatusIcon);
        tvSchedule.setText(bean.getCourseNo());
        tvTitle.setText(bean.getTitle());

        mPb.setProgress(0);
        int min = mPb.getProgress();
        int max = bean.getAverage();
        int duration = bean.getAverage() * 12;
        final int rid = bean.getStatusDexRid();
        ObjectAnimator progressAnimator;
        if (min == 0) {
            progressAnimator = ObjectAnimator.ofInt(mPb, "progress", min, max);
            progressAnimator.setDuration(duration);
            progressAnimator.setInterpolator(new LinearInterpolator());
            progressAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    animation.cancel();
                    setImage(ivStatusIcon, rid);
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
                    animation.cancel();
                    setImage(ivStatusIcon, rid);
                }
            });
            progressAnimator.start();
        } else {
            //null
            setImage(ivStatusIcon, rid);
        }
        if (rid == -1) {
            LogUtils.d(bean.toString());
        }

        if(itemPosition == finalPosition)
            vDotted.setVisibility(View.INVISIBLE);
        else
            vDotted.setVisibility(View.VISIBLE);
    }

    public void setImage(ImageView img, int Rid) {
        //
        try {
            if (img.getContext() != null)
                GlideApp.with(img.getContext()).asBitmap().load(Rid).error(R.drawable.irs_gray).into(img);
        }catch (Exception e){
            LogUtils.e(e.getMessage());
        }
    }

}
