package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/7.
 */

public class SNSCallbackBean implements Serializable {
    private String status;
    private int status_code;
    private SNSCommonBean data;

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

    public SNSCommonBean getData() {
        return data;
    }

    public void setData(SNSCommonBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SNSCallbackBean{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                '}';
    }
}
