package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.common_type.Components;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/11.
 */

public class TemplateBean implements Serializable {
    /*
    //adv|ann|store|lose
     {
      "id": "59c5f1732867e1205a21c928",
      "store_id": "2",
      "type": "advertisement",
      "theme": "advertisement-A001",
      "theme_group": "advertisement-A",
      "components": [
        {
          "type": "mask",
          "content": [
            {
              "url": "storage/components/mask/2/yDkCWKFZZmWGVVzGW33d20171006181455.png",
              "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/0/content/0"
            },
            {
              "url": "storage/components/mask/2/eAqKEzHJhF6sHQ8xISFg20170923164910.png",
              "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/0/content/1"
            },
            {
              "url": "storage/components/mask/2/wRXtyxn8FpcnUObbbgn320170923172350.png",
              "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/0/content/2"
            }
          ]
        },
        {
          "type": "slider",
          "content": [
            {
              "url": "storage/components/mask/2/ExnNMMQg6mzqaiHDIv9b20171007215935.png",
              "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/1/content/0"
            },
            {
              "url": "storage/components/mask/2/E5nvCehCu9FO63mfcaPP20170923055050.png",
              "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/1/content/1"
            },
            {
              "url": "storage/components/mask/2/xxSWcq6BhWftHMp4Yqht20170923055109.png",
              "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/1/content/2"
            }
          ]
        },
        {
          "type": "textarea",
          "content": {
            "text": "測試",
            "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/2/content/"
          }
        },
        {
          "type": "textlist",
          "content": {
            "text": "[\"次為啥\",\"測試2\",\"我問問\",\"吳\\n餓餓\"]",
            "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/3/content/"
          }
        }
      ]
    }
     */

    private String id;
    private int store_id;
    private String type;
    private String theme;
    private String theme_group;
    private List<Components> components;

    @Override
    public String toString() {
        return "TemplateBean{" +
                "id='" + id + '\'' +
                ", store_id=" + store_id +
                ", type='" + type + '\'' +
                ", theme='" + theme + '\'' +
                ", theme_group='" + theme_group + '\'' +
                ", components=" + components +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTheme_group() {
        return theme_group;
    }

    public void setTheme_group(String theme_group) {
        this.theme_group = theme_group;
    }

    public List<Components> getComponents() {
        return components;
    }

    public void setComponents(List<Components> components) {
        this.components = components;
    }
}
