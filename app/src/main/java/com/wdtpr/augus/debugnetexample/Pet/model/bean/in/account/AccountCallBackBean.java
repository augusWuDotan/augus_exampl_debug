package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class AccountCallBackBean implements Serializable {
    /*
    {
      "status": "OK",
      "status_code": 200,
      "data": {
        "account_id": 85
      }
    }
     */
    private int status_code;
    private String status;
    private ResultObject data;

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

    public ResultObject getData() {
        return data;
    }

    public void setData(ResultObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AccountCallBackBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResultObject implements Serializable{
        private int account_id;

        public int getAccount_id() {
            return account_id;
        }

        public void setAccount_id(int account_id) {
            this.account_id = account_id;
        }

        @Override
        public String toString() {
            return "ResultObject{" +
                    "account_id=" + account_id +
                    '}';
        }
    }
}
