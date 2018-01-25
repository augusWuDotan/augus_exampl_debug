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
     new
                {
                    "courseNo": "BJ01U3L3",
                    "testRecordID": null,
                    "testTime": null,
                    "average": 0,
                    "shareUrl": null,
                    "canLotteryDraw": false
                }
      old
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

    private String courseNo;
    private int testRecordID;
    private String testTime;
    private double average;
    private String shareUrl;
    private boolean canLotteryDraw;

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public int getTestRecordID() {
        return testRecordID;
    }

    public void setTestRecordID(int testRecordID) {
        this.testRecordID = testRecordID;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public boolean isCanLotteryDraw() {
        return canLotteryDraw;
    }

    public void setCanLotteryDraw(boolean canLotteryDraw) {
        this.canLotteryDraw = canLotteryDraw;
    }

    @Override
    public int itemType() {
        return SPEAK_ITEM;
    }
}
