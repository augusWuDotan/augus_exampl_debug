package com.wdtpr.augus.bjprofile.bjDemo.adapter.factory;

/**
 * Created by Ray on 2017/8/14.
 * 統一管理所有ViewHolder的佈局
 */


import android.view.View;

import com.wdtpr.augus.bjprofile.bjDemo.adapter.base.BaseViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder.GoldViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder.IRSRecordViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder.MovieViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder.SpeakViewHolder;
import com.wdtpr.augus.bjprofile.bjDemo.model.viewHolder.TestViewHolder;


public class ItemTypeFactory {

    private static final int IRSRECORD_ITEM = IRS_RecordItem.IRS;
    private static final int MOVIE_ITEM = MovieItem.MOVIE;
    private static final int TEST_ITEM = TEST_RecordItem.TEST;
    private static final int SPEAK_ITEM = SpeakItem.SPEAK_ITEM;
    private static final int GOLD_ITEM = GoldRecordItem.GOLDITEM;


    public BaseViewHolder createViewHolder(int type, View itemView) {
        if(type == IRSRECORD_ITEM){
            return new IRSRecordViewHolder(itemView);
        }else if(type == MOVIE_ITEM){
            return new MovieViewHolder(itemView);
        }else if(type == TEST_ITEM){
            return new TestViewHolder(itemView);
        }else if(type == SPEAK_ITEM){
            return new SpeakViewHolder(itemView);
        }else if(type == GOLD_ITEM){
            return new GoldViewHolder(itemView);
        }else{
            return null;
        }
    }
}