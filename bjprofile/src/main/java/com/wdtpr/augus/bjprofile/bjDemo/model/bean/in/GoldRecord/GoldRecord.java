package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord;

import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/25.
 */

public class GoldRecord implements Serializable {
    /*
    {
    "result_status": true,
    "result_message": null,
    "result_content": [
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-27T03:45:00"
        },
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-18T11:54:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-18T09:53:00"
        },
        {
            "APP_GoldRecord_Count": 3,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-18T09:53:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-18T09:52:00"
        },
        {
            "APP_GoldRecord_Count": 3,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-17T14:55:00"
        },
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-17T14:44:00"
        },
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-15T10:30:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-15T10:29:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-15T09:42:00"
        },
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-15T07:16:00"
        },
        {
            "APP_GoldRecord_Count": 5,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-15T07:02:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-15T06:41:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-15T06:41:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-15T06:41:00"
        },
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-14T10:21:00"
        },
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-14T09:44:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-14T09:40:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-14T09:24:00"
        },
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-14T05:57:00"
        },
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-13T05:47:00"
        },
        {
            "APP_GoldRecord_Count": 1,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-07T10:35:00"
        },
        {
            "APP_GoldRecord_Count": 2,
            "APP_GoldRecord_Reason": "完成Exam取得",
            "GoldType": false,
            "APP_GoldRecord_Time": "2017-12-07T10:23:00"
        }
    ]
}
     */
    private Boolean result_status;
    private String result_message;
    private List<GoldRecordItem> result_content;

    @Override
    public String toString() {
        return "GoldRecord{" +
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

    public List<GoldRecordItem> getResult_content() {
        return result_content;
    }

    public void setResult_content(List<GoldRecordItem> result_content) {
        this.result_content = result_content;
    }
}
