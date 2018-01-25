package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.factory.IItemType;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/28.
 */

public class GoldRecordItem implements Serializable, IItemType {
    public static final int GOLDITEM = R.layout.adapter_gold_form_item;
    /*
        {
            "goldRecordCount": 6,
            "goldRecordReason": "完成Spell\n金幣(3)*倍率(2)",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-23\n02:49:00"
        }
        {
            "goldRecordCount": 2,
            "goldRecordReason": "完成Exam取得",
            "isMonsterCoin": false,
            "goldRecordTime": "2017-12-27T03:45:00"
        }
     */
    private int goldRecordCount;
    private String goldRecordReason;
    private boolean isMonsterCoin;
    private String goldRecordTime;

    @Override
    public int itemType() {
        return GOLDITEM;
    }

    @Override
    public String toString() {
        return "GoldRecordItem{" +
                "goldRecordCount=" + goldRecordCount +
                ", goldRecordReason='" + goldRecordReason + '\'' +
                ", isMonsterCoin=" + isMonsterCoin +
                ", goldRecordTime='" + goldRecordTime + '\'' +
                '}';
    }

    public int getGoldRecordCount() {
        return goldRecordCount;
    }

    public void setGoldRecordCount(int goldRecordCount) {
        this.goldRecordCount = goldRecordCount;
    }

    public String getGoldRecordReason() {
        return goldRecordReason;
    }

    public void setGoldRecordReason(String goldRecordReason) {
        this.goldRecordReason = goldRecordReason;
    }

    public boolean isMonsterCoin() {
        return isMonsterCoin;
    }

    public void setMonsterCoin(boolean monsterCoin) {
        isMonsterCoin = monsterCoin;
    }

    public String getGoldRecordTime() {
        return goldRecordTime;
    }

    public void setGoldRecordTime(String goldRecordTime) {
        this.goldRecordTime = goldRecordTime;
    }
}
