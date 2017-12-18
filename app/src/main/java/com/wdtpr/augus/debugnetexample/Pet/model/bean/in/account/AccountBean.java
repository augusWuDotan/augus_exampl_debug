package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/9.
 * 帳單
 */

public class AccountBean implements Serializable {
    /*
     {
      "id": 80,
      "date": "2017-11-19",
      "title": "會員包月",
      "description": "測試",
      "cost": 250,
      "target_user": {
        "id": 21,
        "name": "王勝賢"
      }
    }
     */
    private int id;
    private String date;
    private String title;
    private String description;
    private int cost;
    private TargetUser target_user;

    @Override
    public String toString() {
        return "AccountBean{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", target_user=" + target_user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public TargetUser getTarget_user() {
        return target_user;
    }

    public void setTarget_user(TargetUser target_user) {
        this.target_user = target_user;
    }

    public static class TargetUser implements Serializable{
        private int id;
        private String name;

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

        @Override
        public String toString() {
            return "TargetUser{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
