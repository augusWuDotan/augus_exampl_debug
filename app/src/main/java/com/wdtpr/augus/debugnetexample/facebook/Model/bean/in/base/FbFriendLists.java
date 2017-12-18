package com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/15.
 * friend list
 */

public class FbFriendLists implements Serializable {
    /*
    "friends": {
    "data": [
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
      },
      {
        "name": "Tien Ma",
        "picture": {
          "data": {
            "height": 320,
            "is_silhouette": false,
            "url": "https://scontent.xx.fbcdn.net/v/t1.0-1/p320x320/14725750_123291268137935_7641120615955239807_n.jpg?oh=7df067c35e88a0e37afd68b8c45a1294&oe=5AD28A81",
            "width": 320
          }
        },
        "id": "324570774676649"
      },
      {
        "name": "Je Wang",
        "picture": {
          "data": {
            "height": 320,
            "is_silhouette": false,
            "url": "https://scontent.xx.fbcdn.net/v/t1.0-1/c0.0.320.320/p320x320/24232154_105045606948563_6745031319954407502_n.jpg?oh=648f67b2ea63253d3a55b94994121c5b&oe=5ABBE317",
            "width": 320
          }
        },
        "id": "105047410281716"
      }
    ],
    "paging": {
      "cursors": {
        "before": "QVFIUkt0V0cycXFpYXUtcGhpZAHUwNnktZAlZAqSEhEYTNNU2U2TnBDZAHZAHQmZAldEJ5d0VIdy1razNKaEZAJRlRxNUdiWkJGbHpLbEtBTUZARZA2dGNEJuM0VlTFhR",
        "after": "QVFIUkswZA2FMZADdPeHYzOXo2eEo0emtiN2NueElWaU1USnB4ZADNQNXN0eXZAJVnRHTFFpTEZALek9DMDFFTlFFSFJGX0RaNExLLXMwS016Mk1vLUtDb0Rib3l3"
      }
    },
    "summary": {
      "total_count": 1085
    }
  }
     */
    private List<FbFriendsDetail> data;
    private FbPaging paging;
    private Summary summary;

    @Override
    public String toString() {
        return "FbFriends{" +
                "data=" + data +
                ", paging=" + paging +
                ", summary=" + summary +
                '}';
    }

    public List<FbFriendsDetail> getData() {
        return data;
    }

    public void setData(List<FbFriendsDetail> data) {
        this.data = data;
    }

    public FbPaging getPaging() {
        return paging;
    }

    public void setPaging(FbPaging paging) {
        this.paging = paging;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    //總朋友人數
    public static class Summary implements Serializable{

        private int total_count;

        @Override
        public String toString() {
            return "summary{" +
                    "total_count=" + total_count +
                    '}';
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }
    }
}
