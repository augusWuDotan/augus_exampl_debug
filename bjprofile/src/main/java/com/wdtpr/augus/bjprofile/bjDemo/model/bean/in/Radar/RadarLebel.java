package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/27.
 * 項目
 */

public class RadarLebel implements Serializable {
    /*
                {
                    "Label_Name": "阅读",
                    "Score": 90
                }
     */
    private String Label_Name;
    private int Score;

    @Override
    public String toString() {
        return "RadarLebel{" +
                "Label_Name='" + Label_Name + '\'' +
                ", Score=" + Score +
                '}';
    }

    public String getLabel_Name() {
        return Label_Name;
    }

    public void setLabel_Name(String label_Name) {
        Label_Name = label_Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
