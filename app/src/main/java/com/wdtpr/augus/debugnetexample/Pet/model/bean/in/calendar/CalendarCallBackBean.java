package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class CalendarCallBackBean implements Serializable {
    /*
    {
      "status": "OK",
      "status_code": 200,
      "data": {
        "time_calendar_id": 443
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
        return "CalendarCallBackBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResultObject implements Serializable{
        private int time_calendar_id;

        public int getTime_calendar_id() {
            return time_calendar_id;
        }

        public void setTime_calendar_id(int time_calendar_id) {
            this.time_calendar_id = time_calendar_id;
        }

        @Override
        public String toString() {
            return "ResultObject{" +
                    "time_calendar_id=" + time_calendar_id +
                    '}';
        }
    }
}
