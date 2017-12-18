package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.Pet;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class Customer implements Serializable {
    /*
    //detail
    {
      {
        "id": 17,
        "name": "小屋",
        "customer_number": "null",
        "birthday": null,
        "address": "高雄市",
        "phone": "889888",
        "mobile": "0985622333",
        "description": "null",
        "thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/avatar.jpg",
        "representative_pet_id": 5,
        "pets": [
          {
            "id": 5,
            "name": "粗怯怯",
            "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
          },
          {
            "id": 49,
            "name": "小芯",
            "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg"
          },
          {
            "id": 50,
            "name": "波斯菊",
            "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
          },
          {
            "id": 54,
            "name": "次武餓俄",
            "thumbnail": "/pet_avatars/thumb/missing.png"
          },
          {
            "id": 62,
            "name": "無我",
            "thumbnail": "/pet_avatars/thumb/missing.png"
          },
          {
            "id": 64,
            "name": "thhh",
            "thumbnail": "/pet_avatars/thumb/missing.png"
          },
          {
            "id": 65,
            "name": "yes",
            "thumbnail": "/pet_avatars/thumb/missing.png"
          },
          {
            "id": 66,
            "name": "test",
            "thumbnail": "/pet_avatars/thumb/missing.png"
          },
          {
            "id": 67,
            "name": "h",
            "thumbnail": "/pet_avatars/thumb/missing.png"
          },
          {
            "id": 68,
            "name": "jjj",
            "thumbnail": "/pet_avatars/thumb/missing.png"
          }
        ]
      }
    }
    //list
    {
      "id": 17,
      "name": "小屋",
      "customer_number": "null",
      "birthday": null,
      "thumbnail": "/stapler/App/Models/User/CustomerDetail/avatars/000/000/003/thumb/avatar.jpg",
      "pets": [
        {
          "name": "粗怯怯",
          "variety": null,
          "blood_type": "O",
          "weight": "5",
          "description": "test",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg"
        },
        {
          "name": "小芯",
          "variety": null,
          "blood_type": "",
          "weight": "25",
          "description": "",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/049/thumb/cropped-1525964166.jpg"
        },
        {
          "name": "波斯菊",
          "variety": null,
          "blood_type": "O",
          "weight": "3",
          "description": "貪吃",
          "thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/050/thumb/pet_avatar.jpg"
        },
        {
          "name": "次武餓俄",
          "variety": null,
          "blood_type": "O",
          "weight": "558",
          "description": "Giuliani",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "無我",
          "variety": null,
          "blood_type": "",
          "weight": "25",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "thhh",
          "variety": null,
          "blood_type": "",
          "weight": "5",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "yes",
          "variety": null,
          "blood_type": "",
          "weight": "5",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "test",
          "variety": null,
          "blood_type": "0",
          "weight": "2",
          "description": "222",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "h",
          "variety": null,
          "blood_type": "",
          "weight": "5",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        },
        {
          "name": "jjj",
          "variety": null,
          "blood_type": "",
          "weight": "5",
          "description": "",
          "thumbnail": "/pet_avatars/thumb/missing.png"
        }
      ]
    }
     */

    private int id;
    private String name;
    private String customer_number;
    private String birthday;
    private String address;
    private String phone;
    private String mobile;
    private String description;
    private String thumbnail;
    private int representative_pet_id;
    private List<Pet> pets;

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

    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getRepresentative_pet_id() {
        return representative_pet_id;
    }

    public void setRepresentative_pet_id(int representative_pet_id) {
        this.representative_pet_id = representative_pet_id;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customer_number='" + customer_number + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", representative_pet_id=" + representative_pet_id +
                ", pets=" + pets +
                '}';
    }
}
