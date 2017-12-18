package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class PetDetailBean implements Serializable {
    /*
    {
  "status": "OK",
  "status_code": 200,
  "data": {
    "id": 5,
    "name": "粗怯怯",
    "age": "5",
    "variety_id": 3,
    "en_variety": "Afghan Hound",
    "zh_variety": "阿富汗獵犬",
    "blood_type": "O",
    "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg",
    "image": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/medium/cropped-393098058.jpg",
    "weight": "5",
    "chip": 0,
    "description": "test",
    "customer_name": "小屋",
    "customer_email": "poop124113@gmail.com",
    "customer_mobile": "0985622333",
    "customer_phone": "8898888888"
  }
}
     */

    private int status_code;
    private String status;
    private Pet data;

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

    public Pet getData() {
        return data;
    }

    public void setData(Pet data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PetDetailBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
