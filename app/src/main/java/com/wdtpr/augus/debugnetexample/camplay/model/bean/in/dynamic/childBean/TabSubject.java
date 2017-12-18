package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/5.
 */

public class TabSubject implements Serializable {

    private String TabSubject_ID;
    private String TabSubject_Name;
    private String TabSubject_Image;
    private String TabSubject_Sort;

    public String getTabSubject_ID() {
        return TabSubject_ID;
    }

    public void setTabSubject_ID(String tabSubject_ID) {
        TabSubject_ID = tabSubject_ID;
    }

    public String getTabSubject_Name() {
        return TabSubject_Name;
    }

    public void setTabSubject_Name(String tabSubject_Name) {
        TabSubject_Name = tabSubject_Name;
    }

    public String getTabSubject_Image() {
        return TabSubject_Image;
    }

    public void setTabSubject_Image(String tabSubject_Image) {
        TabSubject_Image = tabSubject_Image;
    }

    public String getTabSubject_Sort() {
        return TabSubject_Sort;
    }

    public void setTabSubject_Sort(String tabSubject_Sort) {
        TabSubject_Sort = tabSubject_Sort;
    }

    @Override
    public String toString() {
        return "TabSuject{" +
                "TabSubject_ID='" + TabSubject_ID + '\'' +
                ", TabSubject_Name='" + TabSubject_Name + '\'' +
                ", TabSubject_Image='" + TabSubject_Image + '\'' +
                ", TabSubject_Sort='" + TabSubject_Sort + '\'' +
                '}';
    }
}
