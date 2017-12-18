package com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/15.
 * 圖片格式 data
 */

public class FbPictureData implements Serializable {
    /*
    "picture": {
          "data": {
            "url": "https://scontent.xx.fbcdn.net/v/t1.0-1/c0.0.320.320/p320x320/24232154_105045606948563_6745031319954407502_n.jpg?oh=648f67b2ea63253d3a55b94994121c5b&oe=5ABBE317",
          }
        }
     */

    private String url;

    @Override
    public String toString() {
        return "FbPictureData{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
