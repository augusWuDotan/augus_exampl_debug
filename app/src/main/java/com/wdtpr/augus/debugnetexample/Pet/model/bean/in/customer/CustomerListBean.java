package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Paginator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class CustomerListBean implements Serializable {
    /*
    {
  "data": [
    {
      "id": 3,
      "name": "仁博",
      "customer_number": "null",
      "birthday": null,
      "thumbnail": "/avatars/thumb/missing.png",
      "pets": [
        {
          "name": "cat",
          "variety": null,
          "blood_type": "B",
          "weight": "5",
          "description": "test",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/014/thumb/cropped1261961816.jpg"
        }
      ]
    },
    {
      "id": 6,
      "name": "吳東承顧客1",
      "customer_number": null,
      "birthday": null,
      "thumbnail": "/avatars/thumb/missing.png",
      "pets": [
        {
          "name": "測試狗一號",
          "variety": null,
          "blood_type": "O",
          "weight": "12",
          "description": "測試狗狗備註",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/001/thumb/15337477_1251546478255866_8736500522219622510_n.jpg"
        },
        {
          "name": "測試狗一號",
          "variety": null,
          "blood_type": "O",
          "weight": "12",
          "description": "測試狗狗備註",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        }
      ]
    },
    {
      "id": 15,
      "name": "吳東承顧客4",
      "customer_number": "C001",
      "birthday": null,
      "thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/005/thumb/web5_006.png",
      "pets": [
        {
          "name": "asdsad",
          "variety": null,
          "blood_type": "AB",
          "weight": "12",
          "description": "asdasdasd",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "testName",
          "variety": null,
          "blood_type": "o",
          "weight": "12",
          "description": "123",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/010/thumb/15337477_1251546478255866_8736500522219622510_n.jpg"
        }
      ]
    },
    {
      "id": 17,
      "name": "小屋",
      "customer_number": "null",
      "birthday": null,
      "thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/avatar.jpg",
      "pets": [
        {
          "name": "粗怯怯",
          "variety": null,
          "blood_type": "O",
          "weight": "5",
          "description": "test",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
        },
        {
          "name": "小芯",
          "variety": null,
          "blood_type": "",
          "weight": "25",
          "description": "",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg"
        },
        {
          "name": "波斯菊",
          "variety": null,
          "blood_type": "O",
          "weight": "3",
          "description": "貪吃",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
        },
        {
          "name": "次武餓俄",
          "variety": null,
          "blood_type": "O",
          "weight": "558",
          "description": "Giuliani",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "無我",
          "variety": null,
          "blood_type": "",
          "weight": "25",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "thhh",
          "variety": null,
          "blood_type": "",
          "weight": "5",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "yes",
          "variety": null,
          "blood_type": "",
          "weight": "5",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "test",
          "variety": null,
          "blood_type": "0",
          "weight": "2",
          "description": "222",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "h",
          "variety": null,
          "blood_type": "",
          "weight": "5",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "jjj",
          "variety": null,
          "blood_type": "",
          "weight": "5",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        }
      ]
    },
    {
      "id": 21,
      "name": "王勝賢",
      "customer_number": "null",
      "birthday": null,
      "thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/010/thumb/cropped-395979931.jpg",
      "pets": [
        {
          "name": "modi",
          "variety": null,
          "blood_type": "o",
          "weight": "28",
          "description": "無",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/016/thumb/cropped-1160598236.jpg"
        },
        {
          "name": "やまた",
          "variety": null,
          "blood_type": "o",
          "weight": "23",
          "description": "很凶",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/030/thumb/cropped1430115663.jpg"
        },
        {
          "name": "馬鹿野郎",
          "variety": null,
          "blood_type": "o",
          "weight": "1",
          "description": "不詳",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/031/thumb/cropped61216590.jpg"
        },
        {
          "name": "噹噹",
          "variety": null,
          "blood_type": "O",
          "weight": "25",
          "description": "8666",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/058/thumb/cropped297827348.jpg"
        },
        {
          "name": "龍貓",
          "variety": null,
          "blood_type": "D",
          "weight": "5",
          "description": "123",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/059/thumb/cropped2123331378.jpg"
        },
        {
          "name": "阿狸",
          "variety": null,
          "blood_type": "KK",
          "weight": "8",
          "description": "不過是否則是否則",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/060/thumb/cropped789940271.jpg"
        },
        {
          "name": "妖怪",
          "variety": null,
          "blood_type": "O",
          "weight": "5",
          "description": "ahhh",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/061/thumb/cropped108570709.jpg"
        },
        {
          "name": "豬皮",
          "variety": null,
          "blood_type": "",
          "weight": "4",
          "description": "怕水",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        }
      ]
    },
    {
      "id": 51,
      "name": "alan lee",
      "customer_number": null,
      "birthday": null,
      "thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/013/thumb/cropped1534598160.jpg",
      "pets": [
        {
          "name": "小A",
          "variety": null,
          "blood_type": "O",
          "weight": "11",
          "description": "456",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/038/thumb/cropped1132188694.jpg"
        }
      ]
    },
    {
      "id": 55,
      "name": "吳外務吳",
      "customer_number": "null",
      "birthday": "1988-03-31",
      "thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/017/thumb/cropped-1618645120.jpg",
      "pets": [
        {
          "name": "測試狗",
          "variety": null,
          "blood_type": "O",
          "weight": "5",
          "description": "test",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/052/thumb/cropped698852424.jpg"
        },
        {
          "name": "我是一個人",
          "variety": null,
          "blood_type": "O",
          "weight": "5",
          "description": "Chihuahua",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/053/thumb/cropped-2024761811.jpg"
        }
      ]
    }
  ],
  "status_code": 200,
  "status": "OK",
  "paginator": {
    "total": 7,
    "per_page": 15,
    "current_page": 1,
    "last_page": 1,
    "next_page_url": null,
    "prev_page_url": null,
    "from": 1,
    "to": 7
  }
}
     */

    private int status_code;
    private String status;
    private List<Customer> data;
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

    public List<Customer> getData() {
        return data;
    }

    public void setData(List<Customer> data) {
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
        return "CustomerListBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                ", paginator=" + Paginator +
                '}';
    }
}
