package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/25.
 * token
 */

public class ServerBean implements Serializable {
    private boolean result_status;
    private String result_message;
    private String result_content;//token

    @Override
    public String toString() {
        return "ServerBean{" +
                "result_status=" + result_status +
                ", result_message='" + result_message + '\'' +
                ", result_content='" + result_content + '\'' +
                '}';
    }

    public boolean isResult_status() {
        return result_status;
    }

    public void setResult_status(boolean result_status) {
        this.result_status = result_status;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }

    public String getResult_content() {
        return result_content;
    }

    public void setResult_content(String result_content) {
        this.result_content = result_content;
    }
}
