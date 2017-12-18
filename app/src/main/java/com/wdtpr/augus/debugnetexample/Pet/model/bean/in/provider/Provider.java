package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.provider;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class Provider implements Serializable {
    /*
     "id": 2,
      "store_id": null,
      "name": "hhh",
      "role": "Store",
      "email": "popo124117@gmail.com"
     */
    private int id;
    private int store_id;
    private String name;
    private String role;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", store_id=" + store_id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
