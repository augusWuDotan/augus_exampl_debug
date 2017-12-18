package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.Pet;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class CardDetailBean implements Serializable {
    /*
        {
  "status": "OK",
  "status_code": 200,
  "data": {
    "pet_id": 5,
    "pet_name": "粗怯怯",
    "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg",
    "account_id": 27,
    "card_id": 8,
    "store_id": 2,
    "card_date": "2017-10-02 23:02:32",
    "title": "測試",
    "cost": 5,
    "point_count": 10,
    "points": [
      {
        "id": 16,
        "service": "大修",
        "use_date": "2017-10-02 23:17:59"
      },
      {
        "id": 17,
        "service": "大修",
        "use_date": "2017-10-02 23:18:42"
      },
      {
        "id": 18,
        "service": "小修",
        "use_date": "2017-10-02 23:21:56"
      }
    ]
  }
}
     */

    private int status_code;
    private String status;
    private CardBean data;

    @Override
    public String toString() {
        return "CardDetailBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

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

    public CardBean getData() {
        return data;
    }

    public void setData(CardBean data) {
        this.data = data;
    }
}
