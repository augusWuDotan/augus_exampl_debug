package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class CalendarBean implements Serializable {
    /*
    {
      "id": 422,
      "appointment": true,
      "status": "pending",
      "datetime": "2017-12-30 15:00:00",
      "address": null,
      "description": "poop。\n住宿天數： 1 天",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
    }
     */
    private int id;
    private boolean appointment;
    private String status;
    private String datetime;
    private String address;
    private String description;
    private String customer_name;
    private String customer_thumbnail;
    private String pet_name;
    private String pet_thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAppointment() {
        return appointment;
    }

    public void setAppointment(boolean appointment) {
        this.appointment = appointment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_thumbnail() {
        return customer_thumbnail;
    }

    public void setCustomer_thumbnail(String customer_thumbnail) {
        this.customer_thumbnail = customer_thumbnail;
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
        return "CalendarBean{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", status='" + status + '\'' +
                ", datetime='" + datetime + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", customer_thumbnail='" + customer_thumbnail + '\'' +
                ", pet_name='" + pet_name + '\'' +
                ", pet_thumbnail='" + pet_thumbnail + '\'' +
                '}';
    }
}
