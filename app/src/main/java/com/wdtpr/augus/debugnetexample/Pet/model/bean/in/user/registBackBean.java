package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetHasMonthCardBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.common_type.Components;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.common_type.Content;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by augus on 2017/12/3.
 */

public class registBackBean implements Serializable {
    /*
    {
      "status": "OK",
      "status_code": 200,
      "data": {
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjU5LCJpc3MiOiJodHRwczpcL1wvbW9tb2RpLmNvbS50d1wvYXBpXC91c2VyXC9jdXN0b21lclwvcmVnaXN0ZXIiLCJpYXQiOjE1MTIzMTA3ODYsImV4cCI6MTUyMDIwMDAwNiwibmJmIjoxNTEyMzEwNzg2LCJqdGkiOiJLdlQwU1Z4Z2FZZHZCQUxBIn0.xzTjig_WeWC0_VNos8PP1desaGLXNAUKwzF70r3y6Ps",
        "id": 59,
        "role": "Customer"
      }
}
     */
    private int status_code;
    private String status;
    private ResultObject data;
    private String errorString;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultObject getData() {
        return data;
    }

    public void setData(ResultObject data) {
        this.data = data;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }

    @Override
    public String toString() {
        return "registBackBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                ", errorString='" + errorString + '\'' +
                '}';
    }

    public static class ResultObject implements Serializable{
        private String token;
        private int id;
        private String role;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "ResultObject{" +
                    "token='" + token + '\'' +
                    ", id=" + id +
                    ", role='" + role + '\'' +
                    '}';
        }
    }


//    public static class registBackBeanDeserializer implements JsonDeserializer<registBackBean> {
//        @Override
//        public registBackBean deserialize(JsonElement json, Type typeOfT,
//                                          JsonDeserializationContext context) throws JsonParseException {
//            LogUtils.d(json.toString());
//            registBackBean registBackBean = new registBackBean();
//            if (json.isJsonObject()) {
//                LogUtils.d("text");
//                Set<Map.Entry<String, JsonElement>> entries = json.getAsJsonObject().entrySet();
//                for (Map.Entry<String, JsonElement> entry : entries) {
//                    switch (entry.getKey()) {
//                        case "status":
//                            registBackBean.setStatus(entry.getValue().getAsString());
//                            break;
//                        case "status_code":
//                            registBackBean.setStatus_code(entry.getValue().getAsInt());
//                            break;
//                        case "data":
//                            if (entry.getValue().isJsonObject()) {//jsonObject
//                                registBackBean.setData(new Gson().fromJson(entry.getValue(), registBackBean.ResultObject.class));
//                                registBackBean.setErrorString("");
//                            } else {//Stirng
//                                registBackBean.setData(null);
//                                registBackBean.setErrorString(entry.getValue().getAsString());
//                            }
//                            break;
//                    }
//                }
//                return registBackBean;
//            } else {
//                LogUtils.d("text1");
//                return null;
//            }
//        }
//    }


}
