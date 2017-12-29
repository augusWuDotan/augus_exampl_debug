package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.factory.IItemType;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/28.
 */

public class GoldRecordItem implements Serializable,IItemType {
    public static final int GOLDITEM = R.layout.adapter_gold_form_item;
    /*
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-27T03:45:00"
        }
     */
    private int APP_GoldRecord_Count;
    private String APP_GoldRecord_Reason;
    private boolean GoldType;
    private String APP_GoldRecord_Time;

    @Override
    public int itemType() {
        return GOLDITEM;
    }

    @Override
    public String toString() {
        return "GoldRecordItem{" +
                "APP_GoldRecord_Count=" + APP_GoldRecord_Count +
                ", APP_GoldRecord_Reason='" + APP_GoldRecord_Reason + '\'' +
                ", GoldType=" + GoldType +
                ", APP_GoldRecord_Time='" + APP_GoldRecord_Time + '\'' +
                '}';
    }

    public int getAPP_GoldRecord_Count() {
        return APP_GoldRecord_Count;
    }

    public void setAPP_GoldRecord_Count(int APP_GoldRecord_Count) {
        this.APP_GoldRecord_Count = APP_GoldRecord_Count;
    }

    public String getAPP_GoldRecord_Reason() {
        return APP_GoldRecord_Reason;
    }

    public void setAPP_GoldRecord_Reason(String APP_GoldRecord_Reason) {
        this.APP_GoldRecord_Reason = APP_GoldRecord_Reason;
    }

    public boolean isGoldType() {
        return GoldType;
    }

    public void setGoldType(boolean goldType) {
        GoldType = goldType;
    }

    public String getAPP_GoldRecord_Time() {
        return APP_GoldRecord_Time;
    }

    public void setAPP_GoldRecord_Time(String APP_GoldRecord_Time) {
        this.APP_GoldRecord_Time = APP_GoldRecord_Time;
    }
}
