package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/10.
 */

public class AppoitmentBean implements Serializable {
    /*
    //list
    {
      "id": 260,
      "start_at": "2017-12-14 14:00:00",
      "end_at": "2017-12-14 15:00:00",
      "status": "accepted",
      "description": "",
      "pet_id": 50,
      "is_monthly": 0,
      "with_lodging": 0,
      "store_name": "測試店",
      "customer_name": "小屋",
      "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
      "pet_name": "波斯菊",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg",
      "provider_id": 5,
      "provider_name": "測試美容師"
    }
    //detail
    {
        "id": 260,
        "start_at": "2017-12-14 14:00:00",
        "end_at": "2017-12-14 15:00:00",
        "status": "accepted",
        "description": "",
        "pet_id": 50,
        "is_monthly": 0,
        "with_lodging": 0,
        "store_name": "測試店",
        "customer_name": "小屋",
        "customer_thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/maxresdefault_1.jpg",
        "pet_name": "波斯菊",
        "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg",
        "provider_id": 5,
        "provider_name": "測試美容師"
      }

    }
     */
    private int id;
    private String start_at;
    private String end_at;
    private String status;
    private String description;
    private int pet_id;
    private int is_monthly;
    private int with_lodging;
    private String store_name;
    private String customer_name;
    private String customer_thumbnail;
    private String pet_name;
    private String pet_thumbnail;
    private String provider_id;
    private String provider_name;

    @Override
    public String toString() {
        return "AppoitmentBean{" +
                "id=" + id +
                ", start_at='" + start_at + '\'' +
                ", end_at='" + end_at + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", pet_id=" + pet_id +
                ", is_monthly=" + is_monthly +
                ", with_lodging=" + with_lodging +
                ", store_name='" + store_name + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", customer_thumbnail='" + customer_thumbnail + '\'' +
                ", pet_name='" + pet_name + '\'' +
                ", pet_thumbnail='" + pet_thumbnail + '\'' +
                ", provider_id=" + provider_id +
                ", provider_name='" + provider_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public int getIs_monthly() {
        return is_monthly;
    }

    public void setIs_monthly(int is_monthly) {
        this.is_monthly = is_monthly;
    }

    public int getWith_lodging() {
        return with_lodging;
    }

    public void setWith_lodging(int with_lodging) {
        this.with_lodging = with_lodging;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
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

    public String getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(String provider_id) {
        this.provider_id = provider_id;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }
}
