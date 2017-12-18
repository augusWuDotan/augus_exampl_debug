package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Paginator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class StoreListBean implements Serializable {
    /*
    {
  "data": [
    {
      "id": 2,
      "name": "測試店",
      "phone": "07 525 2000",
      "open_time": "10:00 - 22:00",
      "address": "高雄市鼓山區蓮海路70號",
      "website": "https://www.google.com",
      "instagram": "https://www.google.com",
      "fanpage": "https://www.google.com",
      "thumbnail": "/stapler/App/Models/User/StoreDetail/avatars/000/000/001/thumb/avatar.jpg"
    },
    {
      "id": 7,
      "name": "黑貓寵物美容",
      "phone": "075867265",
      "open_time": "08:30am       09:00pm",
      "address": "東京都三鷹市吉卜力",
      "website": "momodi. com.tw",
      "instagram": "",
      "fanpage": "",
      "thumbnail": "/stapler/App/Models/User/StoreDetail/avatars/000/000/002/thumb/cropped-1547570627.jpg"
    },
    {
      "id": 22,
      "name": "狂夜家",
      "phone": "0411111111",
      "open_time": "8:30 - 21:00",
      "address": "OOOOO",
      "website": "",
      "instagram": "",
      "fanpage": "",
      "thumbnail": "/stapler/App/Models/User/StoreDetail/avatars/000/000/004/thumb/cropped1773236977.jpg"
    },
    {
      "id": 25,
      "name": "涅涅美容",
      "phone": "",
      "open_time": "",
      "address": "",
      "website": null,
      "instagram": null,
      "fanpage": null,
      "thumbnail": "/avatars/thumb/missing.png"
    }
  ],
  "status_code": 200,
  "status": "OK",
  "paginator": {
    "total": 4,
    "per_page": 15,
    "current_page": 1,
    "last_page": 1,
    "next_page_url": null,
    "prev_page_url": null,
    "from": 1,
    "to": 4
  }
}
     */

    private int status_code;
    private String status;
    private List<Store> data;
    private Paginator Paginator;

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

    public List<Store> getData() {
        return data;
    }

    public void setData(List<Store> data) {
        this.data = data;
    }

    public Paginator getPaginator() {
        return Paginator;
    }

    public void setPaginator(Paginator Paginator) {
        this.Paginator = Paginator;
    }

    @Override
    public String toString() {
        return "StoreListBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                ", paginator=" + Paginator +
                '}';
    }
}
