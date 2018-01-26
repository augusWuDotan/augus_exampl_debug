package com.wdtpr.augus.ranking.model.bean.in.ranking;

import com.wdtpr.augus.ranking.R;
import com.wdtpr.augus.ranking.adapter.factory.IItemType;

import java.io.Serializable;

/**
 * Created by augus on 2018/1/25.
 */

public class RankingItem implements Serializable, IItemType {

    public static final int RANK_USER = R.layout.adapter_rank_user_item;
    public static final int RANK_LEVEL = R.layout.adapter_rank_level_item;
    /*
       {
            "Ranking": 4,
            "Student_Name": "徐英杰",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Boston"
        }
     */

    private int Ranking;
    private String Student_Name;
    private int APP_PureGoldCount;
    private String Sub_School_Name;
    private String Class_Name;
    private int itemType = 1001;
    private String type;


    @Override
    public String toString() {
        return "RankingItem{" +
                "Ranking=" + Ranking +
                ", Student_Name='" + Student_Name + '\'' +
                ", APP_PureGoldCount=" + APP_PureGoldCount +
                ", Sub_School_Name='" + Sub_School_Name + '\'' +
                ", Class_Name='" + Class_Name + '\'' +
                ", itemType=" + itemType +
                ", type='" + type + '\'' +
                '}';
    }

    public int getRanking() {
        return Ranking;
    }

    public void setRanking(int ranking) {
        Ranking = ranking;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public int getAPP_PureGoldCount() {
        return APP_PureGoldCount;
    }

    public void setAPP_PureGoldCount(int APP_PureGoldCount) {
        this.APP_PureGoldCount = APP_PureGoldCount;
    }

    public String getSub_School_Name() {
        return Sub_School_Name;
    }

    public void setSub_School_Name(String sub_School_Name) {
        Sub_School_Name = sub_School_Name;
    }

    public String getClass_Name() {
        return Class_Name;
    }

    public void setClass_Name(String class_Name) {
        Class_Name = class_Name;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int itemType() {
        return itemType == 1001 ? RANK_LEVEL : itemType == 1002 ? RANK_USER : 0;
    }
}
