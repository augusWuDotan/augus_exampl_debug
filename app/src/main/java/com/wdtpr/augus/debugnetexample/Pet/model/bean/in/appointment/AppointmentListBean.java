package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Paginator;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class AppointmentListBean implements Serializable {
    /*
   {
  "data": [
    {
      "id": 260,
      "start_at": "2017-12-14 14:00:00",
      "end_at": "2017-12-14 15:00:00",
      "status": "accepted",
      "description": "",
      "pet_id": 50,
      "is_monthly": 0,
      "with_lodging": 0,
      "store_name": "測試店",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg",
      "provider_id": 5,
      "provider_name": "測試美容師"
    },
    {
      "id": 259,
      "start_at": "2017-12-30 15:00:00",
      "end_at": "2017-12-30 16:00:00",
      "status": "pending",
      "description": "",
      "pet_id": 49,
      "is_monthly": 0,
      "with_lodging": 0,
      "store_name": "測試店",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "小芯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg",
      "provider_id": "",
      "provider_name": ""
    },
    {
      "id": 255,
      "start_at": "2017-12-26 14:00:00",
      "end_at": "2017-12-26 15:00:00",
      "status": "accepted",
      "description": "high",
      "pet_id": 50,
      "is_monthly": 1,
      "with_lodging": 0,
      "store_name": "黑貓寵物美容",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg",
      "provider_id": 7,
      "provider_name": null
    },
    {
      "id": 248,
      "start_at": "2017-12-15 10:00:00",
      "end_at": "2017-12-15 11:00:00",
      "status": "accepted",
      "description": "guilty",
      "pet_id": 60,
      "is_monthly": 0,
      "with_lodging": 0,
      "store_name": "黑貓寵物美容",
      "customer_name": "王勝賢",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/010/thumb/cropped-395979931.jpg",
      "pet_name": "阿狸",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/060/thumb/cropped789940271.jpg",
      "provider_id": 7,
      "provider_name": null
    },
    {
      "id": 242,
      "start_at": "2017-12-26 14:00:00",
      "end_at": "2017-12-26 15:00:00",
      "status": "accepted",
      "description": "",
      "pet_id": 16,
      "is_monthly": 0,
      "with_lodging": 0,
      "store_name": "狂夜家",
      "customer_name": "王勝賢",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/010/thumb/cropped-395979931.jpg",
      "pet_name": "modi",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/016/thumb/cropped-1160598236.jpg",
      "provider_id": 24,
      "provider_name": "狂夜家第一位美容師"
    },
    {
      "id": 241,
      "start_at": "2017-12-27 16:00:00",
      "end_at": "2017-12-27 17:00:00",
      "status": "accepted",
      "description": "",
      "pet_id": 31,
      "is_monthly": 0,
      "with_lodging": 0,
      "store_name": "狂夜家",
      "customer_name": "王勝賢",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/010/thumb/cropped-395979931.jpg",
      "pet_name": "馬鹿野郎",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/031/thumb/cropped61216590.jpg",
      "provider_id": 24,
      "provider_name": "狂夜家第一位美容師"
    },
    {
      "id": 240,
      "start_at": "2017-12-27 13:00:00",
      "end_at": "2017-12-27 14:00:00",
      "status": "canceled",
      "description": "住宿天數： 3 天",
      "pet_id": 16,
      "is_monthly": 1,
      "with_lodging": 1,
      "store_name": "狂夜家",
      "customer_name": "王勝賢",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/010/thumb/cropped-395979931.jpg",
      "pet_name": "modi",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/016/thumb/cropped-1160598236.jpg",
      "provider_id": 24,
      "provider_name": "狂夜家第一位美容師"
    },
    {
      "id": 239,
      "start_at": "2017-12-23 11:00:00",
      "end_at": "2017-12-23 12:00:00",
      "status": "canceled",
      "description": "住宿天數： 3 天",
      "pet_id": 16,
      "is_monthly": 1,
      "with_lodging": 1,
      "store_name": "黑貓寵物美容",
      "customer_name": "王勝賢",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/010/thumb/cropped-395979931.jpg",
      "pet_name": "modi",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/016/thumb/cropped-1160598236.jpg",
      "provider_id": 7,
      "provider_name": null
    },
    {
      "id": 230,
      "start_at": "2017-12-28 17:00:00",
      "end_at": "2017-12-28 18:00:00",
      "status": "pending",
      "description": "",
      "pet_id": 54,
      "is_monthly": 0,
      "with_lodging": 0,
      "store_name": "測試店",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "次武餓俄",
      "pet_thumbnail": "/pet_avatars/thumb/missing.png",
      "provider_id": "",
      "provider_name": ""
    },
    {
      "id": 229,
      "start_at": "2017-12-27 15:00:00",
      "end_at": "2017-12-27 16:00:00",
      "status": "pending",
      "description": "hmmm",
      "pet_id": 49,
      "is_monthly": 0,
      "with_lodging": 0,
      "store_name": "測試店",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "小芯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg",
      "provider_id": "",
      "provider_name": ""
    },
    {
      "id": 227,
      "start_at": "2017-12-22 15:00:00",
      "end_at": "2017-12-22 16:00:00",
      "status": "accepted",
      "description": "test。\n住宿天數： 25 天",
      "pet_id": 5,
      "is_monthly": 1,
      "with_lodging": 1,
      "store_name": "測試店",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "粗怯怯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg",
      "provider_id": 5,
      "provider_name": "測試美容師"
    },
    {
      "id": 226,
      "start_at": "2017-12-25 10:00:00",
      "end_at": "2017-12-25 11:00:00",
      "status": "accepted",
      "description": "poop。\n住宿天數： 2 天",
      "pet_id": 5,
      "is_monthly": 1,
      "with_lodging": 1,
      "store_name": "黑貓寵物美容",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "粗怯怯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg",
      "provider_id": 7,
      "provider_name": null
    },
    {
      "id": 225,
      "start_at": "2017-12-25 14:00:00",
      "end_at": "2017-12-25 15:00:00",
      "status": "pending",
      "description": "poop。\n住宿天數： 1 天",
      "pet_id": 54,
      "is_monthly": 0,
      "with_lodging": 1,
      "store_name": "狂夜家",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "次武餓俄",
      "pet_thumbnail": "/pet_avatars/thumb/missing.png",
      "provider_id": "",
      "provider_name": ""
    },
    {
      "id": 224,
      "start_at": "2017-12-27 16:00:00",
      "end_at": "2017-12-27 17:00:00",
      "status": "pending",
      "description": "poop。\n住宿天數： 1 天",
      "pet_id": 49,
      "is_monthly": 1,
      "with_lodging": 1,
      "store_name": "狂夜家",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "小芯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg",
      "provider_id": "",
      "provider_name": ""
    },
    {
      "id": 223,
      "start_at": "2017-12-30 15:00:00",
      "end_at": "2017-12-30 16:00:00",
      "status": "accepted",
      "description": "poop。\n住宿天數： 1 天",
      "pet_id": 50,
      "is_monthly": 0,
      "with_lodging": 1,
      "store_name": "黑貓寵物美容",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg",
      "provider_id": 7,
      "provider_name": null
    }
  ],
  "status_code": 200,
  "status": "OK",
  "paginator": {
    "total": 19,
    "per_page": 15,
    "current_page": 1,
    "last_page": 2,
    "next_page_url": "https://momodi.com.tw/api/appointment?start_time=2017-12-14+00%3A00&end_time=2017-12-30+23%3A59&page=2",
    "prev_page_url": null,
    "from": 1,
    "to": 15
  }
}
}
     */
    private int status_code;
    private String status;
    private List<AppoitmentBean> data;
    private Paginator paginator;

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

    public List<AppoitmentBean> getData() {
        return data;
    }

    public void setData(List<AppoitmentBean> data) {
        this.data = data;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    @Override
    public String toString() {
        return "AppointmentListBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                ", paginator=" + paginator +
                '}';
    }
}
