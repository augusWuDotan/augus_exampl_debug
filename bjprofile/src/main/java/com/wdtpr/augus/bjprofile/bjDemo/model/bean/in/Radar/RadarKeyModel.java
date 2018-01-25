package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/27.
 * //每一次的評分
 */

public class RadarKeyModel implements Serializable {
    /*
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
     */
    private String Key_Title;
    private String Color_Number;
    private List<RadarLebel> label;

    @Override
    public String toString() {
        return "RadarKeyModel{" +
                "Key_Title='" + Key_Title + '\'' +
                ", Color_Number='" + Color_Number + '\'' +
                ", label=" + label +
                '}';
    }

    public String getKey_Title() {
        return Key_Title;
    }

    public void setKey_Title(String key_Title) {
        Key_Title = key_Title;
    }

    public List<RadarLebel> getLabel() {
        return label;
    }

    public void setLabel(List<RadarLebel> label) {
        this.label = label;
    }

    public String getColor_Number() {
        return Color_Number;
    }

    public void setColor_Number(String color_Number) {
        Color_Number = color_Number;
    }
}
