package com.wdtpr.augus.ranking.model.bean.in.ranking;

import java.io.Serializable;

/**
 * Created by augus on 2018/1/25.
 */

public class Rank_single implements Serializable {
    /*
    {
    "result_status": true,
    "result_message": null,
    "result_content":
       {
            "Ranking": 4,
            "Student_Name": "徐英杰",
            "APP_PureGoldCount": 0,
            "Sub_School_Name": "金华市美华分校",
            "Class_Name": "Boston"
        }
}
     */

    private Boolean result_status;
    private String result_message;
    private RankingItem result_content;

    @Override
    public String toString() {
        return "rank_single{" +
                "result_status=" + result_status +
                ", result_message='" + result_message + '\'' +
                ", result_content=" + result_content +
                '}';
    }

    public Boolean getResult_status() {
        return result_status;
    }

    public void setResult_status(Boolean result_status) {
        this.result_status = result_status;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }

    public RankingItem getResult_content() {
        return result_content;
    }

    public void setResult_content(RankingItem result_content) {
        this.result_content = result_content;
    }
}
