package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Paginator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class AppointmentDetailBean implements Serializable {
    /*
    {
  "status": "OK",
  "status_code": 200,
  "data": {
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
  }
}
     */
    private int status_code;
    private String status;
    private AppoitmentBean data;

    @Override
    public String toString() {
        return "AppointmentDetailBean{" +
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

    public AppoitmentBean getData() {
        return data;
    }

    public void setData(AppoitmentBean data) {
        this.data = data;
    }
}
