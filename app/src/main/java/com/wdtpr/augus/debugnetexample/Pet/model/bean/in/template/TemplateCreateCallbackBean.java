package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/11.
 */

public class TemplateCreateCallbackBean implements Serializable {

    private String status;
    private int status_code;
    private ResultObject data;

    @Override
    public String toString() {
        return "TemplateCreateCallbackBean{" +
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

    public ResultObject getData() {
        return data;
    }

    public void setData(ResultObject data) {
        this.data = data;
    }

    public static class ResultObject implements Serializable {
        private String id;

        @Override
        public String toString() {
            return "ResultObject{" +
                    "id='" + id + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

}
