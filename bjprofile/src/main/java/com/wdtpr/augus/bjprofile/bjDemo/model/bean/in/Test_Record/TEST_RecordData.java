package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/25.
 */

public class TEST_RecordData implements Serializable {
    /*
    [
    {
        "BookNo": "BJ01",
        "records_list": [
            {
                "title": "Big Jump1 Unit1 Lesson1 Quiz",
                "score": 60,
                "average": 60,
                "highest": 60,
                "Position": "none",
                "courseNo": "BJ01U1L1",
                "status": null
            },
            {
                "title": "Big Jump1 FinalTest",
                "score": 88,
                "average": 88,
                "highest": 88,
                "Position": "none",
                "courseNo": "BJ01",
                "status": null
            },
            {
                "title": "Big Jump1 Unit1 UnitQuiz",
                "score": 45,
                "average": 45,
                "highest": 45,
                "Position": "none",
                "courseNo": "BJ01U1",
                "status": null
            },
            {
                "title": "Big Jump1 Unit1 Lesson2 Quiz",
                "score": 68,
                "average": 68,
                "highest": 68,
                "Position": "none",
                "courseNo": "BJ01U1L2",
                "status": null
            },
            {
                "title": "Big Jump1 Unit1 Lesson3 Quiz",
                "score": 88,
                "average": 88,
                "highest": 88,
                "Position": "none",
                "courseNo": "BJ01U1L3",
                "status": null
            },
            {
                "title": "Big Jump1 Unit2 UnitQuiz",
                "score": 98,
                "average": 98,
                "highest": 98,
                "Position": "none",
                "courseNo": "BJ01U2",
                "status": null
            },
            {
                "title": "Big Jump1 Unit2 Lesson1 Quiz",
                "score": 78,
                "average": 78,
                "highest": 78,
                "Position": "none",
                "courseNo": "BJ01U2L1",
                "status": null
            },
            {
                "title": "Big Jump1 Unit3 Lesson2 Quiz",
                "score": 78,
                "average": 78,
                "highest": 78,
                "Position": "none",
                "courseNo": "BJ01U3L2",
                "status": null
            },
            {
                "title": "Big Jump1 Unit3 Lesson3 Quiz",
                "score": 78,
                "average": 78,
                "highest": 78,
                "Position": "none",
                "courseNo": "BJ01U3L3",
                "status": null
            },
            {
                "title": "Big Jump1 Unit2 Lesson2 Quiz",
                "score": 85,
                "average": 85,
                "highest": 85,
                "Position": "none",
                "courseNo": "BJ01U2L2",
                "status": null
            },
            {
                "title": "Big Jump1 Unit3 Lesson1 Quiz",
                "score": 98,
                "average": 98,
                "highest": 98,
                "Position": "none",
                "courseNo": "BJ01U3L1",
                "status": null
            },
            {
                "title": "Big Jump1 Unit3 UnitQuiz",
                "score": 98,
                "average": 98,
                "highest": 98,
                "Position": "none",
                "courseNo": "BJ01U3",
                "status": null
            },
            {
                "title": "Big Jump1 Unit2 Lesson3 Quiz",
                "score": 68,
                "average": 68,
                "highest": 68,
                "Position": "none",
                "courseNo": "BJ01U2L3",
                "status": null
            }
        ]
    },
    {
        "BookNo": "BJ02",
        "records_list": [
            {
                "title": "Big Jump2 Unit1 Lesson1 Quiz",
                "score": 96,
                "average": 96,
                "highest": 96,
                "Position": "none",
                "courseNo": "BJ02U1L1",
                "status": null
            },
            {
                "title": "Big Jump2 Unit1 Lesson2 Quiz",
                "score": 85,
                "average": 85,
                "highest": 85,
                "Position": "none",
                "courseNo": "BJ02U1L2",
                "status": null
            },
            {
                "title": "Big Jump2 Unit1 Lesson3 Quiz",
                "score": 68,
                "average": 68,
                "highest": 68,
                "Position": "none",
                "courseNo": "BJ02U1L3",
                "status": null
            },
            {
                "title": "Big Jump2 Unit1 UnitQuiz",
                "score": 85,
                "average": 85,
                "highest": 85,
                "Position": "none",
                "courseNo": "BJ02U1",
                "status": null
            },
            {
                "title": "Big Jump2 FinalTest",
                "score": 86,
                "average": 86,
                "highest": 86,
                "Position": "none",
                "courseNo": "BJ02",
                "status": null
            },
            {
                "title": "Big Jump2 Unit2 UnitQuiz",
                "score": 38,
                "average": 38,
                "highest": 38,
                "Position": "none",
                "courseNo": "BJ02U2",
                "status": null
            },
            {
                "title": "Big Jump2 Unit2 Lesson1 Quiz",
                "score": 83,
                "average": 83,
                "highest": 83,
                "Position": "none",
                "courseNo": "BJ02U2L1",
                "status": null
            },
            {
                "title": "Big Jump2 Unit2 Lesson2 Quiz",
                "score": 58,
                "average": 58,
                "highest": 58,
                "Position": "none",
                "courseNo": "BJ02U2L2",
                "status": null
            },
            {
                "title": "Big Jump2 Unit2 Lesson3 Quiz",
                "score": 85,
                "average": 85,
                "highest": 85,
                "Position": "none",
                "courseNo": "BJ02U2L3",
                "status": null
            },
            {
                "title": "Big Jump2 Unit3 UnitQuiz",
                "score": 86,
                "average": 86,
                "highest": 86,
                "Position": "none",
                "courseNo": "BJ02U3",
                "status": null
            },
            {
                "title": "Big Jump2 Unit3 Lesson1 Quiz",
                "score": 96,
                "average": 96,
                "highest": 96,
                "Position": "none",
                "courseNo": "BJ02U3L1",
                "status": null
            },
            {
                "title": "Big Jump2 Unit3 Lesson2 Quiz",
                "score": 100,
                "average": 100,
                "highest": 100,
                "Position": "none",
                "courseNo": "BJ02U3L2",
                "status": null
            },
            {
                "title": "Big Jump2 Unit3 Lesson3 Quiz",
                "score": 86,
                "average": 86,
                "highest": 86,
                "Position": "none",
                "courseNo": "BJ02U3L3",
                "status": null
            }
        ]
    }
]
  */
    private String BookNo;
    private List<TEST_RecordItem> records_list;

    @Override
    public String toString() {
        return "TEST_Record{" +
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

    public List<TEST_RecordItem> getRecords_list() {
        return records_list;
    }

    public void setRecords_list(List<TEST_RecordItem> records_list) {
        this.records_list = records_list;
    }
}
