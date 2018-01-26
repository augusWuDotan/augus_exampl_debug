package com.wdtpr.augus.ranking.adapter.factory;

/**
 * Created by Ray on 2017/8/14.
 * 統一管理所有ViewHolder的佈局
 */


import android.view.View;

import com.wdtpr.augus.ranking.adapter.base.BaseViewHolder;
import com.wdtpr.augus.ranking.model.bean.in.ranking.RankingItem;
import com.wdtpr.augus.ranking.model.viewHolder.RankLevelViewHolder;
import com.wdtpr.augus.ranking.model.viewHolder.RankUserViewHolder;

public class ItemTypeFactory {

    private static final int RANK_USER = RankingItem.RANK_USER;
    private static final int RANK_LEVEL = RankingItem.RANK_LEVEL;

    public BaseViewHolder createViewHolder(int type, View itemView) {
        if(type == RANK_USER){
            return new RankUserViewHolder(itemView);
        }else if(type == RANK_LEVEL){
            return new RankLevelViewHolder(itemView);
        }else{
            return null;
        }
    }
}