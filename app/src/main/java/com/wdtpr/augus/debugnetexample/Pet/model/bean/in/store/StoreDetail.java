package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class StoreDetail implements Serializable {
    /*
    {
  "status": "OK",
  "status_code": 200,
  "data": {
    "id": 2,
    "name": "測試店",
    "open_time": "10:00 - 22:00",
    "address": "高雄市鼓山區蓮海路70號",
    "website": "https://www.google.com",
    "instagram": "https://www.google.com",
    "fanpage": "https://www.google.com",
    "phone": "07 525 2000",
    "mobile": "0912345678",
    "description": "我是帥哥",
    "thumbnail": "/stapler/App/Models/User/StoreDetail/avatars/000/000/001/thumb/avatar.jpg"
  }
}
     */


    private int status_code;
    private String status;
    private Store data;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Store getData() {
        return data;
    }

    public void setData(Store data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StoreDetail{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
