package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/26.
 */

public class RadarBean implements Serializable {
    /*
   {
    "result_status": true,
    "result_message": null,
    "result_content": {
        "title": "总学习雷达图",
        "key": [
            {
                "Key_Title": "所有学习范围",
                "label": [
                    {
                        "Label_Name": "阅读",
                        "Score": 90
                    },
                    {
                        "Label_Name": "单词听力",
                        "Score": 93
                    },
                    {
                        "Label_Name": "单词认读",
                        "Score": 96
                    },
                    {
                        "Label_Name": "句型听力",
                        "Score": 96
                    },
                    {
                        "Label_Name": "语法",
                        "Score": 92
                    },
                    {
                        "Label_Name": "拼字",
                        "Score": 86
                    },
                    {
                        "Label_Name": "语法句构",
                        "Score": 100
                    }
                ]
            }
        ]
    }
}
     */
    private boolean result_status;
    private String result_message;
    private RadarModelData result_content;

    @Override
    public String toString() {
        return "RadarBean{" +
                "result_status=" + result_status +
                ", result_message='" + result_message + '\'' +
                ", result_content=" + result_content +
                '}';
    }

    public boolean isResult_status() {
        return result_status;
    }

    public void setResult_status(boolean result_status) {
        this.result_status = result_status;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }

    public RadarModelData getResult_content() {
        return result_content;
    }

    public void setResult_content(RadarModelData result_content) {
        this.result_content = result_content;
    }
}
