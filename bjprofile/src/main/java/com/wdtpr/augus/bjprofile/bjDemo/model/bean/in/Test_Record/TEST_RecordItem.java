package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record;

import android.support.annotation.DrawableRes;


import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.factory.IItemType;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Level;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/25.
 *
 */

public class TEST_RecordItem implements Serializable,IItemType {
    public static final int TEST = R.layout.adapter_test_form_item;
    /*
            {
                "title": "Big Jump1 Unit1 Lesson1 Quiz",
                "score": 60,
                "average": 60,
                "highest": 60,
                "Position": "none",
                "courseNo": "BJ01U1L1",
                "status": null
            }
     */

    private String title;
    private int score;
    private int average;
    private int highest;
    private String Position;
    private String courseNo;
    private String status;
    private int itemType = 0;

    @Override
    public String toString() {
        return "TEST_RecordItem{" +
                "title='" + title + '\'' +
                ", score=" + score +
                ", average=" + average +
                ", highest=" + highest +
                ", Position='" + Position + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", status='" + status + '\'' +
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getHighest() {
        return highest;
    }

    public void setHighest(int highest) {
        this.highest = highest;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int itemType() {
        return TEST ;
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
