package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/11.
 */

public class TemplateDetailBean implements Serializable {

    private String status;
    private int status_code;
    private TemplateBean data;

    @Override
    public String toString() {
        return "TemplateDetailBean{" +
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

    public TemplateBean getData() {
        return data;
    }

    public void setData(TemplateBean data) {
        this.data = data;
    }
}
