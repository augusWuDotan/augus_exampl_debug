package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/27.
 *
 */

public class RadarModelData implements Serializable {
    /*
    {
    "result_status": true,
    "result_message": null,
    "result_content": {
        "title": "总学习雷达图",
        "key": [
            {
                "Key_Title": "所有学习范围",
                "Color_Number": "#ff000077",
                "label": [
                    {
                        "Label_Name": "句型听力",
                        "Score": 87
                    },
                    {
                        "Label_Name": "语法",
                        "Score": 90
                    },
                    {
                        "Label_Name": "阅读",
                        "Score": 78
                    },
                    {
                        "Label_Name": "单词听力",
                        "Score": 83
                    },
                    {
                        "Label_Name": "单词认读",
                        "Score": 89
                    },
                    {
                        "Label_Name": "拼字",
                        "Score": 77
                    },
                    {
                        "Label_Name": "单词听力",
                        "Score": 67
                    },
                    {
                        "Label_Name": "单词认读",
                        "Score": 42
                    },
                    {
                        "Label_Name": "阅读",
                        "Score": 22
                    },
                    {
                        "Label_Name": "句型听力",
                        "Score": 33
                    },
                    {
                        "Label_Name": "文法",
                        "Score": 42
                    }
                ]
            }
        ]
    }
}
     */

    private String title;
    private List<RadarKeyModel> key;

    @Override
    public String toString() {
        return "RadarData{" +
                "title='" + title + '\'' +
                ", key=" + key +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RadarKeyModel> getKey() {
        return key;
    }

    public void setKey(List<RadarKeyModel> key) {
        this.key = key;
    }
}
