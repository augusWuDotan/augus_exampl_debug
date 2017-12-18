package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Paginator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class CalendarListBean implements Serializable {
    /*
    {
  "data": [
    {
      "id": 422,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-30 15:00:00",
      "address": null,
      "description": "poop。\n住宿天數： 1 天",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
    },
    {
      "id": 430,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-28 17:00:00",
      "address": null,
      "description": "",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "次武餓俄",
      "pet_thumbnail": "/pet_avatars/thumb/missing.png"
    },
    {
      "id": 423,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-27 16:00:00",
      "address": null,
      "description": "poop。\n住宿天數： 1 天",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "小芯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg"
    },
    {
      "id": 429,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-27 15:00:00",
      "address": null,
      "description": "hmmm",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "小芯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg"
    },
    {
      "id": 424,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-25 14:00:00",
      "address": null,
      "description": "poop。\n住宿天數： 1 天",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "次武餓俄",
      "pet_thumbnail": "/pet_avatars/thumb/missing.png"
    },
    {
      "id": 420,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-25 13:00:00",
      "address": null,
      "description": "high。\n住宿天數： 1 天",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
    },
    {
      "id": 425,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-25 10:00:00",
      "address": null,
      "description": "poop。\n住宿天數： 2 天",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "粗怯怯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
    },
    {
      "id": 426,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-22 15:00:00",
      "address": null,
      "description": "test。\n住宿天數： 25 天",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "粗怯怯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
    },
    {
      "id": 428,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-06 15:00:00",
      "address": null,
      "description": "junk",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "粗怯怯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
    },
    {
      "id": 431,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-01 16:00:00",
      "address": null,
      "description": "junk",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
    },
    {
      "id": 437,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-01 13:00:00",
      "address": null,
      "description": "",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "小芯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg"
    },
    {
      "id": 369,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-11-30 20:00:00",
      "address": null,
      "description": "Xmw",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
    },
    {
      "id": 368,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-11-30 16:00:00",
      "address": null,
      "description": "Lo",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
    },
    {
      "id": 328,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-11-30 15:00:00",
      "address": null,
      "description": "醋舞",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "粗怯怯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
    },
    {
      "id": 436,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-11-30 12:00:00",
      "address": null,
      "description": "",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
    }
  ],
  "status_code": 200,
  "status": "OK",
  "paginator": {
    "total": 60,
    "per_page": 15,
    "current_page": 1,
    "last_page": 4,
    "next_page_url": "https://momodi.com.tw/api/user/17/time-calendar?start_date=2017-01-01+00%3A00&end_date=2017-12-31+23%3A59&page=2",
    "prev_page_url": null,
    "from": 1,
    "to": 15
  }
}
     */
    private int status_code;
    private String status;
    private List<CalendarBean> data;
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

    public List<CalendarBean> getData() {
        return data;
    }

    public void setData(List<CalendarBean> data) {
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
        return "CalendarListBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                ", paginator=" + paginator +
                '}';
    }
}
