package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.schedule;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/8.
 */

public class ScheduleBean implements Serializable {
    /*
    //
    {
      "appointment_id": 231,
      "store_name": "測試店",
      "start": "16:00:00",
      "end": "17:00:00",
      "status": "pending",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
    }
    //
    {
        "start": "09:00:00",
        "end": "18:00:00",
        "status": "available"
      }
     */

    private int appointment_id;
    private String store_name;
    private String start;
    private String end;
    private String status;
    private String pet_name;
    private String pet_thumbnail;

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getPet_thumbnail() {
        return pet_thumbnail;
    }

    public void setPet_thumbnail(String pet_thumbnail) {
        this.pet_thumbnail = pet_thumbnail;
    }

    @Override
    public String toString() {
        return "ScheduleBean{" +
                "appointment_id=" + appointment_id +
                ", store_name='" + store_name + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", status='" + status + '\'' +
                ", pet_name='" + pet_name + '\'' +
                ", pet_thumbnail='" + pet_thumbnail + '\'' +
                '}';
    }
}

