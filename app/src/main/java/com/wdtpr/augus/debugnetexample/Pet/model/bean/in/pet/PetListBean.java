package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.Customer;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class PetListBean implements Serializable {
    /*
    {
  "status": "OK",
  "status_code": 200,
  "data": [
    {
      "id": 5,
      "name": "粗怯怯",
      "age": "5",
      "en_variety": "Afghan Hound",
      "zh_variety": "阿富汗獵犬",
      "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
    },
    {
      "id": 49,
      "name": "小芯",
      "age": "2",
      "en_variety": "Afghan Hound",
      "zh_variety": "阿富汗獵犬",
      "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg"
    },
    {
      "id": 50,
      "name": "波斯菊",
      "age": "2",
      "en_variety": "Airedale Terrier",
      "zh_variety": "萬能梗",
      "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
    },
    {
      "id": 54,
      "name": "次武餓俄",
      "age": "555",
      "en_variety": "American Staffordshire Bullterrier",
      "zh_variety": "美國斯塔福郡鬥牛犬",
      "thumbnail": "/pet_avatars/thumb/missing.png"
    },
    {
      "id": 62,
      "name": "無我",
      "age": "25",
      "en_variety": "Akbash",
      "zh_variety": "土耳其阿卡巴土犬",
      "thumbnail": "/pet_avatars/thumb/missing.png"
    },
    {
      "id": 64,
      "name": "thhh",
      "age": "5",
      "en_variety": "Afghan Hound",
      "zh_variety": "阿富汗獵犬",
      "thumbnail": "/pet_avatars/thumb/missing.png"
    },
    {
      "id": 65,
      "name": "yes",
      "age": "5",
      "en_variety": "Afghan Hound",
      "zh_variety": "阿富汗獵犬",
      "thumbnail": "/pet_avatars/thumb/missing.png"
    },
    {
      "id": 66,
      "name": "test",
      "age": "12",
      "en_variety": "test",
      "zh_variety": "test",
      "thumbnail": "/pet_avatars/thumb/missing.png"
    },
    {
      "id": 67,
      "name": "h",
      "age": "5",
      "en_variety": "Afghan Hound",
      "zh_variety": "阿富汗獵犬",
      "thumbnail": "/pet_avatars/thumb/missing.png"
    },
    {
      "id": 68,
      "name": "jjj",
      "age": "5",
      "en_variety": "Afghan Hound",
      "zh_variety": "阿富汗獵犬",
      "thumbnail": "/pet_avatars/thumb/missing.png"
    }
  ]
}
     */
    private int status_code;
    private String status;
    private List<Pet> data;

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

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PetListBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
