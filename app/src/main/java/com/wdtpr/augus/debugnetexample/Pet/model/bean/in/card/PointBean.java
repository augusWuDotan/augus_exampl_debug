package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/10.
 */

public class PointBean implements Serializable {
    /*
    {
          "id": 16,
          "service": "大修",
          "use_date": "2017-10-02 23:17:59"
        }
     */

    private int id ;
    private String service;
    private String use_date;

    @Override
    public String toString() {
        return "PointBean{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", use_date='" + use_date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getUse_date() {
        return use_date;
    }

    public void setUse_date(String use_date) {
        this.use_date = use_date;
    }
}
