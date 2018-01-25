package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/25.
 */

public class SpeakData implements Serializable {
    /*
    [
       {
            "BookNo": "BJ01",
            "records_list": [
                {
                    "courseNo": "BJ01U1L1",
                    "testRecordID": 414,
                    "testTime": "2018-01-04 10:57:00",
                    "average": 0,
                    "shareUrl": "http://mosaandnasa.com.cn/AppShare/Index/414",
                    "canLotteryDraw": false
                },
                {
                    "courseNo": "BJ01U1L2",
                    "testRecordID": null,
                    "testTime": null,
                    "average": 0,
                    "shareUrl": null,
                    "canLotteryDraw": false
                },
                {
                    "courseNo": "BJ01U1L3",
                    "testRecordID": null,
                    "testTime": null,
                    "average": 0,
                    "shareUrl": null,
                    "canLotteryDraw": false
                },
                {
                    "courseNo": "BJ01U2L1",
                    "testRecordID": null,
                    "testTime": null,
                    "average": 0,
                    "shareUrl": null,
                    "canLotteryDraw": false
                },
                {
                    "courseNo": "BJ01U2L2",
                    "testRecordID": null,
                    "testTime": null,
                    "average": 0,
                    "shareUrl": null,
                    "canLotteryDraw": false
                },
                {
                    "courseNo": "BJ01U2L3",
                    "testRecordID": null,
                    "testTime": null,
                    "average": 0,
                    "shareUrl": null,
                    "canLotteryDraw": false
                },
                {
                    "courseNo": "BJ01U3L1",
                    "testRecordID": null,
                    "testTime": null,
                    "average": 0,
                    "shareUrl": null,
                    "canLotteryDraw": false
                },
                {
                    "courseNo": "BJ01U3L2",
                    "testRecordID": null,
                    "testTime": null,
                    "average": 0,
                    "shareUrl": null,
                    "canLotteryDraw": false
                },
                {
                    "courseNo": "BJ01U3L3",
                    "testRecordID": null,
                    "testTime": null,
                    "average": 0,
                    "shareUrl": null,
                    "canLotteryDraw": false
                }
            ]
        }
    ]
     */
    private String BookNo;
    private List<SpeakItem> records_list;

    @Override
    public String toString() {
        return "SpeakData{" +
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

    public List<SpeakItem> getRecords_list() {
        return records_list;
    }

    public void setRecords_list(List<SpeakItem> records_list) {
        this.records_list = records_list;
    }
}
