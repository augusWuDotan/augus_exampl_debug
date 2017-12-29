package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record;

import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/25.
 */

public class TEST_Record implements Serializable {
    /*
   {
    "result_status": true,
    "result_message": null,
    "result_content": [
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
        }
    ]
}
     */
    private Boolean result_status;
    private String result_message;
    private List<TEST_RecordData> result_content;

    @Override
    public String toString() {
        return "TEST_Record{" +
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

    public List<TEST_RecordData> getResult_content() {
        return result_content;
    }

    public void setResult_content(List<TEST_RecordData> result_content) {
        this.result_content = result_content;
    }
}
