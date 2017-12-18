package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/11.
 */

public class TemplatePrototypeListBean implements Serializable {

    private String status;
    private int status_code;
    private List<TemplatePrototypeBean> data;

    @Override
    public String toString() {
        return "TemplatePrototypeListBean{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                '}';
    }

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

    public List<TemplatePrototypeBean> getData() {
        return data;
    }

    public void setData(List<TemplatePrototypeBean> data) {
        this.data = data;
    }
}
