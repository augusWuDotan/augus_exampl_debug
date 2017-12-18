package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.common_type;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/11.
 */

public class Content implements Serializable {
    /*
    //
            {
              "url": "storage/components/mask/2/yDkCWKFZZmWGVVzGW33d20171006181455.png",
              "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/0/content/0"
            }

     */
    private String text;
    private String url;
    private String update_url;

    @Override
    public String toString() {
        return "Content{" +
                "text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", update_url='" + update_url + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUpdate_url() {
        return update_url;
    }

    public void setUpdate_url(String update_url) {
        this.update_url = update_url;
    }
}
