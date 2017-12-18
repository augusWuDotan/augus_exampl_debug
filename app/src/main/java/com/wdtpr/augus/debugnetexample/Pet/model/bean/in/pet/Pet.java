package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class Pet implements Serializable {
    /*
    //list 1
     {
          "name": "粗怯怯",
          "variety": null,
          "blood_type": "O",
          "weight": "5",
          "description": "test",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
        }
     //list 2
     {
            "id": 68,
            "name": "jjj",
            "thumbnail": "/pet_avatars/thumb/missing.png"
          }
     //detail
     "id": 5,
    "name": "粗怯怯",
    "age": "5",
    "variety_id": 3,
    "en_variety": "Afghan Hound",
    "zh_variety": "阿富汗獵犬",
    "blood_type": "O",
    "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg",
    "image": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/medium/cropped-393098058.jpg",
    "weight": "5",
    "chip": 0,
    "description": "test",
    "customer_name": "小屋",
    "customer_email": "poop124113@gmail.com",
    "customer_mobile": "0985622333",
    "customer_phone": "889888"
     */
    private int id;
    private String name;
    private String age;
    private String variety;
    private int variety_id;
    private String en_variety;
    private String zh_variety;
    private String blood_type;
    private String thumbnail;
    private String image;
    private String weight;
    private int chip;
    private String description;
    private String customer_name;
    private String customer_email;
    private String customer_mobile;
    private String customer_phone;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getVariety_id() {
        return variety_id;
    }

    public void setVariety_id(int variety_id) {
        this.variety_id = variety_id;
    }

    public String getEn_variety() {
        return en_variety;
    }

    public void setEn_variety(String en_variety) {
        this.en_variety = en_variety;
    }

    public String getZh_variety() {
        return zh_variety;
    }

    public void setZh_variety(String zh_variety) {
        this.zh_variety = zh_variety;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
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

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_mobile() {
        return customer_mobile;
    }

    public void setCustomer_mobile(String customer_mobile) {
        this.customer_mobile = customer_mobile;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", variety='" + variety + '\'' +
                ", variety_id=" + variety_id +
                ", en_variety='" + en_variety + '\'' +
                ", zh_variety='" + zh_variety + '\'' +
                ", blood_type='" + blood_type + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", image='" + image + '\'' +
                ", weight='" + weight + '\'' +
                ", chip=" + chip +
                ", description='" + description + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", customer_mobile='" + customer_mobile + '\'' +
                ", customer_phone='" + customer_phone + '\'' +
                '}';
    }
}
