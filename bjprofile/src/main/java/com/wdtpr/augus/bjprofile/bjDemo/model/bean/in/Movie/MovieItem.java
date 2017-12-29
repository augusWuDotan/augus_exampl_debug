package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie;

import android.support.annotation.DrawableRes;


import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.factory.IItemType;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Level;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/25.
 * IRS 課程單一項目
 */

public class MovieItem implements Serializable,IItemType {
    public static final int MOVIE = R.layout.adapter_movie_form_item;

    /*
     {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ02U1L1",
                "average": 96
            }
     */

    private String title;
    private String status;
    private String courseNo;
    private int average;
    private int itemType = 0;

    @Override
    public String toString() {
        return "MovieItem{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", average=" + average +
                '}';
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public int itemType() {
        return MOVIE;
    }

    @DrawableRes
    public int getStatusDexRid(){
        switch (status){
            case Profile_Level.gray:
                return Profile_Level.grayRid;
            case Profile_Level.green:
                return Profile_Level.greenRid;
            case Profile_Level.red:
                return Profile_Level.redRid;
            case Profile_Level.yellow:
                return Profile_Level.yellowRid;
            default:
                return -1;
        }
    }
}
