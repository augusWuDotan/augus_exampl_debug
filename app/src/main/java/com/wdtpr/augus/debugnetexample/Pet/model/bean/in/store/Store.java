package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class Store implements Serializable {
    /*
    //detail
    "id": 2, √
    "name": "測試店",√
    "open_time": "10:00 - 22:00",√
    "address": "高雄市鼓山區蓮海路70號",√
    "website": "https://www.google.com",√
    "instagram": "https://www.google.com",√
    "fanpage": "https://www.google.com",√
    "phone": "07 525 2000",√
    "mobile": "0912345678",
    "description": "我是帥哥",
    "thumbnail": "/stapler/App/Models/User/StoreDetail/avatars/000/000/001/thumb/avatar.jpg"√
    //list
       "id": 25,
      "name": "涅涅美容",
      "phone": "",
      "open_time": "",
      "address": "",
      "website": null,
      "instagram": null,
      "fanpage": null,
      "thumbnail": "/avatars/thumb/missing.png"
     */

    public Store() {
    }

    /**
     *
     * @param name
     * @param open_time
     * @param address
     * @param website
     * @param instagram
     * @param fanpage
     * @param phone
     * @param mobile
     * @param description
     */
    public Store( String name, String open_time, String address, String website,
                 String instagram, String fanpage, String phone, String mobile, String description) {
        this.name = name;
        this.open_time = open_time;
        this.address = address;
        this.website = website;
        this.instagram = instagram;
        this.fanpage = fanpage;
        this.phone = phone;
        this.mobile = mobile;
        this.description = description;
    }

    private int id;
    private String name;
    private String open_time;
    private String address;
    private String website;
    private String instagram;
    private String fanpage;
    private String phone;
    private String mobile; //list not
    private String description; //list not
    private String thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFanpage() {
        return fanpage;
    }

    public void setFanpage(String fanpage) {
        this.fanpage = fanpage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", open_time='" + open_time + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", instagram='" + instagram + '\'' +
                ", fanpage='" + fanpage + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
