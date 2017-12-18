package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Paginator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/7.
 */

public class SNSDetailBean implements Serializable {
    private String status;
    private int status_code;
    private SNSBean data;

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

    public SNSBean getData() {
        return data;
    }

    public void setData(SNSBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SNSDetailBean{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                '}';
    }
}
