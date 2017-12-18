package com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/15.
 * 單一圖示 detail
 */

public class FbPictureDetail implements Serializable {

    private FbPictureData data;

    @Override
    public String toString() {
        return "Picture{" +
                "data=" + data +
                '}';
    }

    public FbPictureData getData() {
        return data;
    }

    public void setData(FbPictureData data) {
        this.data = data;
    }
}
