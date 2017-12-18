package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.Store;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class CustomerDetailBean implements Serializable {
    /*
    {
  "status": "OK",
  "status_code": 200,
  "data": {
    "id": 17,
    "name": "小屋",
    "customer_number": "null",
    "birthday": null,
    "address": "高雄市",
    "phone": "889888",
    "mobile": "0985622333",
    "description": "null",
    "thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/avatar.jpg",
    "representative_pet_id": 5,
    "pets": [
      {
        "id": 5,
        "name": "粗怯怯",
        "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
      },
      {
        "id": 49,
        "name": "小芯",
        "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg"
      },
      {
        "id": 50,
        "name": "波斯菊",
        "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
      },
      {
        "id": 54,
        "name": "次武餓俄",
        "thumbnail": "/pet_avatars/thumb/missing.png"
      },
      {
        "id": 62,
        "name": "無我",
        "thumbnail": "/pet_avatars/thumb/missing.png"
      },
      {
        "id": 64,
        "name": "thhh",
        "thumbnail": "/pet_avatars/thumb/missing.png"
      },
      {
        "id": 65,
        "name": "yes",
        "thumbnail": "/pet_avatars/thumb/missing.png"
      },
      {
        "id": 66,
        "name": "test",
        "thumbnail": "/pet_avatars/thumb/missing.png"
      },
      {
        "id": 67,
        "name": "h",
        "thumbnail": "/pet_avatars/thumb/missing.png"
      },
      {
        "id": 68,
        "name": "jjj",
        "thumbnail": "/pet_avatars/thumb/missing.png"
      }
    ]
  }
}
     */

    private int status_code;
    private String status;
    private Customer data;

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

    public Customer getData() {
        return data;
    }

    public void setData(Customer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CustomerDetailBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
