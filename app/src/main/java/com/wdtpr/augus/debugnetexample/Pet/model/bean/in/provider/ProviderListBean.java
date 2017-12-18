package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.provider;

import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class ProviderListBean {
    /*
    {
      "status": "OK",
      "status_code": 200,
      "data": [
        {
          "id": 2,
          "store_id": null,
          "name": "hhh",
          "role": "Store",
          "email": "popo124117@gmail.com"
        },
        {
          "id": 5,
          "store_id": 2,
          "name": "測試美容師",
          "role": "Provider",
          "email": "testProvider@gmail.com"
        }
      ]
    }
     */
    private int status_code;
    private String status;
    private List<Provider> data;

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

    public List<Provider> getData() {
        return data;
    }

    public void setData(List<Provider> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ProviderListBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
