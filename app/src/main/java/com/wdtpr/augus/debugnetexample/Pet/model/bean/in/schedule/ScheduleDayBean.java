package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/8.
 */

public class ScheduleDayBean implements Serializable {
    private String status;
    private int status_code;
    private List<ScheduleBean> data;

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

    public List<ScheduleBean> getData() {
        return data;
    }

    public void setData(List<ScheduleBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ScheduleDayBean{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                '}';
    }
}
