package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class PointCreateCallbackBean implements Serializable {
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
        return "CardCreateCallbackBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResultObject {
        private int id;


        @Override
        public String toString() {
            return "ResultObject{" +
                    "id=" + id +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
