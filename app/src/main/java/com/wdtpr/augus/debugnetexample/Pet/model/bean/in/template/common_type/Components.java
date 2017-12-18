package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.common_type;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by augus on 2017/12/11.
 */

public class Components implements Serializable {
    /*
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
        }
        //
        {
          "type": "textarea",
          "content": {
            "text": "測試",
            "update_url": "https://momodi.com.tw/api/store-template-id/59c5f1732867e1205a21c928/component/2/content/"
          }
        }
     */

    private String type;
    private Content content;
    private List<Content> contentArray;

    @Override
    public String toString() {
        return "Components{" +
                "type='" + type + '\'' +
                ", content=" + content +
                ", contentArray=" + contentArray +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Content getContent() {
        return content;
    }

    public List<Content> getContentArray() {
        return contentArray;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setContentArray(List<Content> contentArray) {
        this.contentArray = contentArray;
    }

    public static class ComponentsDeserializer implements JsonDeserializer<Components>
    {
        @Override
        public Components deserialize(JsonElement json, Type typeOfT,
                                      JsonDeserializationContext context) throws JsonParseException {
            Components components = new Components();
            if(json.isJsonObject()){
                Set<Map.Entry<String, JsonElement>> entries = json.getAsJsonObject().entrySet();
                for(Map.Entry<String, JsonElement> entry : entries){
                    switch (entry.getKey()){
                        case "type":
                            components.setType(entry.getValue().getAsString());
                            break;
                        case "content":
                            if(entry.getValue().isJsonObject()){//jsonObject
                                components.setContent(new Gson().fromJson(entry.getValue(), Content.class));
                            }else{//JsonArray
                                JsonArray array = entry.getValue().getAsJsonArray();
                                List<Content> list = new ArrayList<>();
                                for(JsonElement je1 :array){
                                    list.add(new Gson().fromJson(je1, Content.class));
                                }
                                components.setContentArray(list);
                            }
                            break;
                    }
                }
                return components;
            }else{
                return null;
            }
        }
    }
}
