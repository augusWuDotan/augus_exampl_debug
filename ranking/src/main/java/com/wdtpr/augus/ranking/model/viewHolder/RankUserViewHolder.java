package com.wdtpr.augus.ranking.model.viewHolder;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wdtpr.augus.ranking.R;
import com.wdtpr.augus.ranking.adapter.base.BaseViewHolder;
import com.wdtpr.augus.ranking.model.bean.in.ranking.RankingItem;

import java.math.BigDecimal;


/**
 * Created by Ray on 2017/8/22.
 * ArticleProfileViewHolder
 */

public class RankUserViewHolder extends BaseViewHolder {
    private ConstraintLayout cl;
    private ImageView ivCup;
    private TextView tvScore, tvName, tvSchoolName,tvRank;


    public RankUserViewHolder(View itemView) {
        super(itemView);
        cl = (ConstraintLayout) getView(R.id.cl);
        tvName = (TextView) getView(R.id.tvName);
        tvSchoolName = (TextView) getView(R.id.tvSchoolName);
        tvScore = (TextView) getView(R.id.tvScore);
        tvRank= (TextView) getView(R.id.tvRank);
        ivCup = (ImageView) getView(R.id.ivCup);
        //        LogUtils.d("總高：" + itemView.getResources().getDisplayMetrics().heightPixels);
        float scaleH = new BigDecimal((itemView.getContext().getResources().getDisplayMetrics().heightPixels / 1920f) * 195).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
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
        final RankingItem bean = (RankingItem) data;

        //
        StringBuffer bf = new StringBuffer();
        tvName.setVisibility(View.VISIBLE);
        tvSchoolName.setVisibility(View.GONE);
        bf.append(bean.getStudent_Name());
        tvName.setText(bf.toString());


        //
        switch (bean.getRanking()) {
            case 1://第一名
                tvRank.setVisibility(View.GONE);
                Glide.with(context).asBitmap().load(R.drawable.cup_no1).into(ivCup);
                break;
            case 2://第二名
                tvRank.setVisibility(View.GONE);
                Glide.with(context).asBitmap().load(R.drawable.cup_no2).into(ivCup);
                break;
            case 3://第三名
                tvRank.setVisibility(View.GONE);
                Glide.with(context).asBitmap().load(R.drawable.cup_no3).into(ivCup);
                break;
            default://其他
                tvRank.setVisibility(View.VISIBLE);
                tvRank.setText(bean.getRanking());
                Glide.with(context).asBitmap().load(R.drawable.cup_normal).into(ivCup);
                break;
        }

        //
        tvScore.setText(bean.getAPP_PureGoldCount()+"");
    }

}
