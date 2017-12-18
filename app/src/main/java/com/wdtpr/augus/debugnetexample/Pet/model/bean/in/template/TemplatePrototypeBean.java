package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/11.
 */

public class TemplatePrototypeBean implements Serializable {
    /*
    {
      "id": "59ae9d8c2867e169e94cba81",
      "type": "store",
      "theme": "store-A001",
      "theme_group": "store-A"
    }
     */
    private String id;
    private String type;
    private String theme;
    private String theme_group;

    @Override
    public String toString() {
        return "TemplatePrototypeBean{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", theme='" + theme + '\'' +
                ", theme_group='" + theme_group + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
