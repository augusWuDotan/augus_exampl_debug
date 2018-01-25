package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.factory.IItemType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2018/1/24.
 */

public class SpellData implements Serializable {

    /*
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
        }
     */

    private String BookNo;
    private List<SpellDataItem> records_list;

    @Override
    public String toString() {
        return "SpellData{" +
                "BookNo='" + BookNo + '\'' +
                ", records_list=" + records_list +
                '}';
    }

    public String getBookNo() {
        return BookNo;
    }

    public void setBookNo(String bookNo) {
        BookNo = bookNo;
    }

    public List<SpellDataItem> getRecords_list() {
        return records_list;
    }

    public void setRecords_list(List<SpellDataItem> records_list) {
        this.records_list = records_list;
    }

}
