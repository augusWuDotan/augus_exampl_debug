package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/9.
 * 帳單列表
 */

public class AccountListBean implements Serializable {

    private int status_code;
    private String status;
    private List<AccountBean> data;

    @Override
    public String toString() {
        return "AccountListBean{" +
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

    public List<AccountBean> getData() {
        return data;
    }

    public void setData(List<AccountBean> data) {
        this.data = data;
    }
}
