package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarCallBackBean;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/4.
 */

public class FAQCallbackBean implements Serializable {
    /*
    {
  "status": "OK",
  "status_code": 200,
  "data": {
    "FAQ_id": 9
  }
}
     */

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
        return "FAQCallbackBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResultObject implements Serializable{
        private int FAQ_id;

        public int getFAQ_id() {
            return FAQ_id;
        }

        public void setFAQ_id(int FAQ_id) {
            this.FAQ_id = FAQ_id;
        }

        @Override
        public String toString() {
            return "ResultObject{" +
                    "FAQ_id=" + FAQ_id +
                    '}';
        }
    }
}
