package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/8.
 */

public class ScheduleWeekBean implements Serializable {
    private String status;
    private int status_code;
    private weekBean data;

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

    public weekBean getData() {
        return data;
    }

    public void setData(weekBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ScheduleWeekBean{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                '}';
    }

    public static class weekBean implements Serializable{
        private List<ScheduleBean> monday;
        private List<ScheduleBean> tuesday;
        private List<ScheduleBean> wednesday;
        private List<ScheduleBean> thursday;
        private List<ScheduleBean> friday;
        private List<ScheduleBean> saturday;
        private List<ScheduleBean> sunday;

        public List<ScheduleBean> getMonday() {
            return monday;
        }

        public void setMonday(List<ScheduleBean> monday) {
            this.monday = monday;
        }

        public List<ScheduleBean> getTuesday() {
            return tuesday;
        }

        public void setTuesday(List<ScheduleBean> tuesday) {
            this.tuesday = tuesday;
        }

        public List<ScheduleBean> getWednesday() {
            return wednesday;
        }

        public void setWednesday(List<ScheduleBean> wednesday) {
            this.wednesday = wednesday;
        }

        public List<ScheduleBean> getThursday() {
            return thursday;
        }

        public void setThursday(List<ScheduleBean> thursday) {
            this.thursday = thursday;
        }

        public List<ScheduleBean> getFriday() {
            return friday;
        }

        public void setFriday(List<ScheduleBean> friday) {
            this.friday = friday;
        }

        public List<ScheduleBean> getSaturday() {
            return saturday;
        }

        public void setSaturday(List<ScheduleBean> saturday) {
            this.saturday = saturday;
        }

        public List<ScheduleBean> getSunday() {
            return sunday;
        }

        public void setSunday(List<ScheduleBean> sunday) {
            this.sunday = sunday;
        }

        @Override
        public String toString() {
            return "weekBean{" +
                    "monday=" + monday +
                    ", tuesday=" + tuesday +
                    ", wednesday=" + wednesday +
                    ", thursday=" + thursday +
                    ", friday=" + friday +
                    ", saturday=" + saturday +
                    ", sunday=" + sunday +
                    '}';
        }
    }


}
