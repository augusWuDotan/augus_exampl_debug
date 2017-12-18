package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/10.
 */

public class CardBean implements Serializable {
    /*
    {
      "pet_id": 5,
      "pet_name": "粗怯怯",
      "pet_thumbnail": "/stapler/App/Models/Pet/Pet/pet_avatars/000/000/005/thumb/cropped-393098058.jpg",
      "account_id": 27,
      "card_id": 8,
      "store_id": 2,
      "card_date": "2017-10-02 23:02:32",
      "title": "測試",
      "cost": 5,
      "point_count": 10,
      "points": [
        {
          "id": 16,
          "service": "大修",
          "use_date": "2017-10-02 23:17:59"
        },
        {
          "id": 17,
          "service": "大修",
          "use_date": "2017-10-02 23:18:42"
        },
        {
          "id": 18,
          "service": "小修",
          "use_date": "2017-10-02 23:21:56"
        }
      ]
    }
     */

    private int pet_id;
    private String pet_name;
    private String pet_thumbnail;
    private int account_id;
    private int card_id;
    private int store_id;
    private String card_date;
    private String title;
    private int cost;
    private int point_count;
    private List<PointBean> points;

    @Override
    public String toString() {
        return "CardBean{" +
                "pet_id=" + pet_id +
                ", pet_name='" + pet_name + '\'' +
                ", pet_thumbnail='" + pet_thumbnail + '\'' +
                ", account_id=" + account_id +
                ", card_id=" + card_id +
                ", store_id=" + store_id +
                ", card_date='" + card_date + '\'' +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", point_count=" + point_count +
                ", points=" + points +
                '}';
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
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

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getCard_date() {
        return card_date;
    }

    public void setCard_date(String card_date) {
        this.card_date = card_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPoint_count() {
        return point_count;
    }

    public void setPoint_count(int point_count) {
        this.point_count = point_count;
    }

    public List<PointBean> getPoints() {
        return points;
    }

    public void setPoints(List<PointBean> points) {
        this.points = points;
    }
}
