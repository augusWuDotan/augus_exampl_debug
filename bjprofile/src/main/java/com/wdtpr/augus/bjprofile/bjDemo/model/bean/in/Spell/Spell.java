package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell;

import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2018/1/24.
 */

public class Spell implements Serializable {
    /*
    {
    "result_status": true,
    "result_message": null,
    "result_content": [
        {
            "BookNo": "BJ01",
            "records_list": [
                {
                    "courseNo": "U1L1",
                    "lights": [
                        "red",
                        "green",
                        "green",
                        "green",
                        "green",
                        "green"
                    ]
                },
                {
                    "courseNo": "U1L2",
                    "lights": [
                        "green",
                        "green",
                        "green",
                        "green",
                        "green",
                        "green"
                    ]
                },
                {
                    "courseNo": "U1L3",
                    "lights": [
                        "green",
                        "green",
                        "green",
                        "red",
                        "green",
                        "green"
                    ]
                },
                {
                    "courseNo": "U2L1",
                    "lights": [
                        "green",
                        "green",
                        "green",
                        "green",
                        "green",
                        "green"
                    ]
                },
                {
                    "courseNo": "U2L2",
                    "lights": [
                        "green",
                        "green",
                        "green",
                        "green",
                        "green",
                        "green"
                    ]
                },
                {
                    "courseNo": "U2L3",
                    "lights": [
                        "green",
                        "green",
                        "green",
                        "green",
                        "green",
                        "green"
                    ]
                },
                {
                    "courseNo": "U3L1",
                    "lights": [
                        "green",
                        "red",
                        "green",
                        "green",
                        "green",
                        "green"
                    ]
                },
                {
                    "courseNo": "U3L2",
                    "lights": [
                        "gray",
                        "gray",
                        "gray",
                        "gray",
                        "gray",
                        "gray"
                    ]
                },
                {
                    "courseNo": "U3L3",
                    "lights": [
                        "green",
                        "green",
                        "green",
                        "green",
                        "green",
                        "green"
                    ]
                }
            ]
        },
        ...
    ]
}
     */

    private Boolean result_status;
    private String result_message;
    private List<SpellData> result_content;

    @Override
    public String toString() {
        return "Spell{" +
                "result_status=" + result_status +
                ", result_message='" + result_message + '\'' +
                ", result_content=" + result_content +
                '}';
    }

    public Boolean getResult_status() {
        return result_status;
    }

    public void setResult_status(Boolean result_status) {
        this.result_status = result_status;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }

    public List<SpellData> getResult_content() {
        return result_content;
    }

    public void setResult_content(List<SpellData> result_content) {
        this.result_content = result_content;
    }
}
