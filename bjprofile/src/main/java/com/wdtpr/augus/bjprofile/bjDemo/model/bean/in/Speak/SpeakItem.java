package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak;

import android.support.annotation.DrawableRes;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.factory.IItemType;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Level;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/25.
 * IRS 課程單一項目
 */

public class SpeakItem implements Serializable, IItemType {
    public static final int SPEAK_ITEM = R.layout.adapter_speak_form_item;

    /*
                 {
                     "APP_TestRecord_ID": null,
                     "TestTime": null,
                     "Gold": 0,
                     "GoldType": false,
                     "courseNo": "BJ01U1L1",
                     "average": 0,
                     "status": "0" // 0: 還沒考 或是 還沒批改 ; 1: 已經批改還沒轉金幣 ; 2: 已經轉金幣
                 }
     */
    private String APP_TestRecord_ID;
    private String TestTime;
    private int Gold;
    private boolean GoldType;
    private String courseNo;
    private double average;
    private String status;

    @Override
    public String toString() {
        return "MovieItem{" +
                "APP_TestRecord_ID='" + APP_TestRecord_ID + '\'' +
                ", TestTime='" + TestTime + '\'' +
                ", Gold=" + Gold +
                ", GoldType=" + GoldType +
                ", courseNo='" + courseNo + '\'' +
                ", average=" + average +
                ", status=" + status +
                '}';
    }

    public String getAPP_TestRecord_ID() {
        return APP_TestRecord_ID;
    }

    public void setAPP_TestRecord_ID(String APP_TestRecord_ID) {
        this.APP_TestRecord_ID = APP_TestRecord_ID;
    }

    public String getTestTime() {
        return TestTime;
    }

    public void setTestTime(String testTime) {
        TestTime = testTime;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public boolean isGoldType() {
        return GoldType;
    }

    public void setGoldType(boolean goldType) {
        GoldType = goldType;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
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
        return SPEAK_ITEM;
    }
}
