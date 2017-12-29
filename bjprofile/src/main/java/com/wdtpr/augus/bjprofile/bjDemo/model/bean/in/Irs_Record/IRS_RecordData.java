package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/25.
 */

public class IRS_RecordData implements Serializable {
    /*
    {
        "BookNo": "BJ01",
        "records_list": [
            {
                "courseNo": "BJ01U1L1",
                "average": 63,
                "status": "yellow"
            },
            {
                "courseNo": "BJ01U1L2",
                "average": 78,
                "status": "yellow"
            },
            {
                "courseNo": "BJ01U1L3",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ01U2L1",
                "average": 0,
                "status": ""
            },
            {
                "courseNo": "BJ01U2L2",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ01U2L3",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ01U3L1",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ01U3L2",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ01U3L3",
                "average": 0,
                "status": "gray"
            }
        ]
    },
    {
        "BookNo": "BJ02",
        "records_list": [
            {
                "courseNo": "BJ02U1L1",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ02U1L2",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ02U1L3",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ02U2L1",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ02U2L2",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ02U2L3",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ02U3L1",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ02U3L2",
                "average": 0,
                "status": "gray"
            },
            {
                "courseNo": "BJ02U3L3",
                "average": 0,
                "status": "gray"
            }
        ]
    }
     */
    private String BookNo;
    private List<IRS_RecordItem> records_list;

    @Override
    public String toString() {
        return "IRS_Record{" +
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

    public List<IRS_RecordItem> getRecords_list() {
        return records_list;
    }

    public void setRecords_list(List<IRS_RecordItem> records_list) {
        this.records_list = records_list;
    }
}
