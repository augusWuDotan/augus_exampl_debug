package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Paginator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/7.
 */

public class SNSListBean implements Serializable {
    private String status;
    private int status_code;
    private List<SNSBean> data;
    private Paginator paginator;

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

    public List<SNSBean> getData() {
        return data;
    }

    public void setData(List<SNSBean> data) {
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
        return "SNSListBean{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                ", paginator=" + paginator +
                '}';
    }
}
