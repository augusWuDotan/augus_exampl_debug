package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/6.
 */

public class ItemListBean implements Serializable {
    /*
    {
  "status": "OK",
  "status_code": 200,
  "data": [
    {
      "id": 2,
      "title": "剪指甲",
      "cost": 500,
      "default": 1
    },
    {
      "id": 19,
      "title": "長毛貓",
      "cost": 0,
      "default": 1
    },
    {
      "id": 18,
      "title": "短毛貓",
      "cost": 0,
      "default": 1
    },
    {
      "id": 17,
      "title": "特大型犬",
      "cost": 0,
      "default": 1
    },
    {
      "id": 16,
      "title": "大型犬",
      "cost": 0,
      "default": 1
    },
    {
      "id": 15,
      "title": "中大型犬",
      "cost": 0,
      "default": 1
    },
    {
      "id": 14,
      "title": "中型犬",
      "cost": 0,
      "default": 1
    },
    {
      "id": 13,
      "title": "小型犬",
      "cost": 0,
      "default": 1
    },
    {
      "id": 12,
      "title": "除蚤",
      "cost": 0,
      "default": 1
    },
    {
      "id": 11,
      "title": "SPA按摩浴",
      "cost": 250,
      "default": 1
    },
    {
      "id": 10,
      "title": "藥浴",
      "cost": 500,
      "default": 1
    },
    {
      "id": 9,
      "title": "貴賓腳",
      "cost": 0,
      "default": 1
    },
    {
      "id": 8,
      "title": "全身造型修剪",
      "cost": 0,
      "default": 1
    },
    {
      "id": 7,
      "title": "眼部雜毛修剪",
      "cost": 0,
      "default": 1
    },
    {
      "id": 6,
      "title": "擠肛門腺",
      "cost": 0,
      "default": 1
    },
    {
      "id": 5,
      "title": "剃肛門毛",
      "cost": 555,
      "default": 1
    },
    {
      "id": 4,
      "title": "清除耳毛",
      "cost": 0,
      "default": 1
    },
    {
      "id": 3,
      "title": "剃腳底毛",
      "cost": 0,
      "default": 1
    },
    {
      "id": 1,
      "title": "洗澡",
      "cost": 0,
      "default": 1
    },
    {
      "id": 23,
      "title": "測試",
      "cost": 800,
      "default": 0
    },
    {
      "id": 71,
      "title": "",
      "cost": 0,
      "default": 0
    },
    {
      "id": 73,
      "title": "ccc",
      "cost": 20,
      "default": 0
    },
    {
      "id": 74,
      "title": "按摩",
      "cost": 300,
      "default": 0
    },
    {
      "id": 75,
      "title": "聽牠說話",
      "cost": 500,
      "default": 0
    },
    {
      "id": 76,
      "title": "住宿（天）",
      "cost": 600,
      "default": 0
    }
  ]
}
     */

    private String status;
    private int status_code;
    private List<ItemBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public List<ItemBean> getData() {
        return data;
    }

    public void setData(List<ItemBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ItemListBean{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                '}';
    }
}
