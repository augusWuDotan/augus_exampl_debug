package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/5.
 * //[官方推薦活動]
 */

public class Tab implements Serializable {
    //tab
        /*
         {
        "Tab_ID": 7,
        "Tab_Name": "1000M高海拔",
        "Tab_Sort": 1,
        "subjects": [
          {
            "TabSubject_ID": 9,
            "TabSubject_Name": "秘境之北",
            "TabSubject_Image": "https://campimages.blob.core.windows.net/images/TabSubject/20170710102749463.jpg",
            "TabSubject_Sort": 1
          },
          {
            "TabSubject_ID": 10,
            "TabSubject_Name": "山嵐之中",
            "TabSubject_Image": "https://campimages.blob.core.windows.net/images/TabSubject/20170710095639474.jpg",
            "TabSubject_Sort": 2
          },
          {
            "TabSubject_ID": 11,
            "TabSubject_Name": "國境之南",
            "TabSubject_Image": "https://campimages.blob.core.windows.net/images/TabSubject/20170710095654425.jpg",
            "TabSubject_Sort": 3
          }
        ]
      }
         */
    private String Tab_ID;
    private String Tab_Name;
    private String Tab_Sort;
    private List<TabSubject> subjects;

    public String getTab_ID() {
        return Tab_ID;
    }

    public void setTab_ID(String tab_ID) {
        Tab_ID = tab_ID;
    }

    public String getTab_Name() {
        return Tab_Name;
    }

    public void setTab_Name(String tab_Name) {
        Tab_Name = tab_Name;
    }

    public String getTab_Sort() {
        return Tab_Sort;
    }

    public void setTab_Sort(String tab_Sort) {
        Tab_Sort = tab_Sort;
    }

    public List<TabSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<TabSubject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Tab{" +
                "Tab_ID='" + Tab_ID + '\'' +
                ", Tab_Name='" + Tab_Name + '\'' +
                ", Tab_Sort='" + Tab_Sort + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
