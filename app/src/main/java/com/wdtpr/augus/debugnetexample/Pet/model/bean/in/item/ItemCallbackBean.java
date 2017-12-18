package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/6.
 */

public class ItemCallbackBean implements Serializable {
    /*
    {
      "status": "OK",
      "status_code": 200,
      "data": {
        "item_id": 96
      }
    }
     */
    private String status;
    private int status_code;
    private ResultObject data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public ResultObject getData() {
        return data;
    }

    public void setData(ResultObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ItemCallbackBean{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                '}';
    }

    public static class ResultObject implements Serializable{
        private int item_id;

        public int getItem_id() {
            return item_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
        }

        @Override
        public String toString() {
            return "ResultObject{" +
                    "item_id=" + item_id +
                    '}';
        }
    }
}
