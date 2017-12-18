package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class StoreAvatar implements Serializable {
    /*
    {
      "status": "OK",
      "status_code": 200,
      "data": {
        "avatar": "/stapler/App/Models/User/StoreDetail/avatars/000/000/001/thumb/avatar.jpg"
      }
    }
     */
    private int status_code;
    private String status;
    private ResultObject data;

    public static class ResultObject {
        private String avatar;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        @Override
        public String toString() {
            return "ResultObject{" +
                    "avatar='" + avatar + '\'' +
                    '}';
        }
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

    public ResultObject getData() {
        return data;
    }

    public void setData(ResultObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StoreAvatar{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
