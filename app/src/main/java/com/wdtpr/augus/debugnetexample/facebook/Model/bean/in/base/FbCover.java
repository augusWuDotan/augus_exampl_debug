package com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base;

import java.io.Serializable;


/**
 * Created by augus on 2017/12/15.
 * 屏幕圖示
 */

public class FbCover implements Serializable {
    private String id;
    private int offset_x;
    private int offset_y;
    private String source;

    @Override
    public String toString() {
        return "FbCover{" +
                "id='" + id + '\'' +
                ", offset_x=" + offset_x +
                ", offset_y=" + offset_y +
                ", source='" + source + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOffset_x() {
        return offset_x;
    }

    public void setOffset_x(int offset_x) {
        this.offset_x = offset_x;
    }

    public int getOffset_y() {
        return offset_y;
    }

    public void setOffset_y(int offset_y) {
        this.offset_y = offset_y;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
