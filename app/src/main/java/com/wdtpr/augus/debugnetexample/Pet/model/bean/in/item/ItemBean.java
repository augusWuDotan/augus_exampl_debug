package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/6.
 */

public class ItemBean implements Serializable {
    /*
     {
      "id": 15,
      "title": "中大型犬",
      "cost": 0,
      "default_cost": 1
    }
     */
    private int id;
    private String title;
    private int cost;
    private int default_cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDefaults() {
        return default_cost;
    }

    public void setDefaults(int default_cost) {
        this.default_cost = default_cost;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", default_cost=" + default_cost +
                '}';
    }
}
