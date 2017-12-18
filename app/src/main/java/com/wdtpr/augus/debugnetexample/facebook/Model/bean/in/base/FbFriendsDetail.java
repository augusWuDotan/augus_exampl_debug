package com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/15.
 * friend datail
 */

public class FbFriendsDetail implements Serializable {
    /*
     {
        "name": "王冠綸",
        "picture": {
          "data": {
            "height": 320,
            "is_silhouette": false,
            "url": "https://scontent.xx.fbcdn.net/v/t1.0-1/p320x320/13102793_128054790931399_8224177133593769118_n.jpg?oh=b15aea52006c42856475a3f830e6b245&oe=5A8928F2",
            "width": 320
          }
        },
        "id": "293816591021884"
      }
     */
    private String name;
    private String id;
    private FbPictureDetail picture;

    @Override
    public String toString() {
        return "FbFriendsDetail{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", picture=" + picture +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FbPictureDetail getPicture() {
        return picture;
    }

    public void setPicture(FbPictureDetail picture) {
        this.picture = picture;
    }
}
