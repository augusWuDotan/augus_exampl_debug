package com.wdtpr.augus.debugnetexample.Pet.model.bean.in;

/**
 * Created by augus on 2017/12/3.
 */

public class Status<T> {
    private String status;
    private int status_code;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data='" + data + '\'' +
                '}';
    }
}
