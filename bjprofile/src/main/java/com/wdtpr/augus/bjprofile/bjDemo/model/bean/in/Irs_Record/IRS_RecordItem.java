package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;


import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.factory.IItemType;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Level;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/25.
 * IRS 課程單一項目
 */

public class IRS_RecordItem implements Serializable,IItemType {
    public static final int IRS = R.layout.adapter_irs_form_item;


    /*
    {
        "courseNo": "BJ03U1L1",
        "average": 0,
        "status": "gray"
    }
     */
    private String courseNo;
    private int average;
    private String status;
    private int itemType = 0;

    @Override
    public String toString() {
        return "IRS_RecordItem{" +
                "courseNo='" + courseNo + '\'' +
                ", average=" + average +
                ", status='" + status + '\'' +
                '}';
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
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
        return  IRS;
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
