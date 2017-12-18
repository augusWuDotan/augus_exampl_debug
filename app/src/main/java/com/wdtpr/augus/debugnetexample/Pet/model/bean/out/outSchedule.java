package com.wdtpr.augus.debugnetexample.Pet.model.bean.out;

import com.wdtpr.augus.debugnetexample.base.Utils.ListUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/8.
 */

public class outSchedule implements Serializable {
    /*
    //
    {
        "start": "09:00:00",
        "end": "18:00:00",
        "status": "available"
      }
     */

    private String start;
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "outSchedule{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    public static JSONArray getJsonArray(List<outSchedule> dataList) {
        JSONArray array = null;
        try {
            array = new JSONArray();
            if (!ListUtils.isEmpty(dataList)) {
                for (outSchedule bean : dataList) {
                    JSONObject object = new JSONObject();
                    object.put("start", bean.getStart());
                    object.put("end", bean.getEnd());
                    array.put(object);
                }
                return array;
            } else {
                return new JSONArray();
            }
        } catch (JSONException e) {
            return new JSONArray();
        }
    }
}

