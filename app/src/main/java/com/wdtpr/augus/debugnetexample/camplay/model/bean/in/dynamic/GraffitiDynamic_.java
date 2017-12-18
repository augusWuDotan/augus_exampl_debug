package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic;



import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean.ResultObjectBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/11/1.
 */

public class GraffitiDynamic_ implements Serializable {


    /*
    {
      "result": 1,
      "result_message": "20",
      "result_object": []
      }
     */
    private int result;
    private String result_message;
    private List<ResultObjectBean> result_object;


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }

    public List<ResultObjectBean> getResult_object() {
        return result_object;
    }

    public void setResult_object(List<ResultObjectBean> result_object) {
        this.result_object = result_object;
    }

    @Override
    public String toString() {
        return "GraffitiDynamic_{" +
                "result=" + result +
                ", result_message='" + result_message + '\'' +
                ", result_object=" + result_object +
                '}';
    }
}
