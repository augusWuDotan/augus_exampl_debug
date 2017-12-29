package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/25.
 */

public class MovieData implements Serializable {
    /*
    {
        "BookNo": "BJ01",
        "records_list": [
            {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ01U1L1",
                "average": 90
            },
            {
                "title": "语法学习",
                "status": "green",
                "courseNo": "BJ01U1L1",
                "average": 90
            },
            {
                "title": "分组练习",
                "status": "green",
                "courseNo": "BJ01U1L1",
                "average": 90
            },
            {
                "title": "阅读练习",
                "status": "green",
                "courseNo": "BJ01U1L1",
                "average": 90
            },
            {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ01U1L2",
                "average": 98
            },
            {
                "title": "语法学习",
                "status": "green",
                "courseNo": "BJ01U1L2",
                "average": 98
            },
            {
                "title": "分组练习",
                "status": "green",
                "courseNo": "BJ01U1L2",
                "average": 98
            },
            {
                "title": "阅读练习",
                "status": "green",
                "courseNo": "BJ01U1L2",
                "average": 98
            },
            {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ01U1L3",
                "average": 81
            },
            {
                "title": "语法学习",
                "status": "green",
                "courseNo": "BJ01U1L3",
                "average": 81
            },
            {
                "title": "分组练习",
                "status": "green",
                "courseNo": "BJ01U1L3",
                "average": 81
            },
            {
                "title": "阅读练习",
                "status": "green",
                "courseNo": "BJ01U1L3",
                "average": 81
            },
            {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ01U2L1",
                "average": 100
            },
            {
                "title": "语法学习",
                "status": "green",
                "courseNo": "BJ01U2L1",
                "average": 100
            },
            {
                "title": "分组练习",
                "status": "green",
                "courseNo": "BJ01U2L1",
                "average": 100
            },
            {
                "title": "阅读练习",
                "status": "green",
                "courseNo": "BJ01U2L1",
                "average": 100
            },
            {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ01U2L2",
                "average": 96
            },
            {
                "title": "语法学习",
                "status": "green",
                "courseNo": "BJ01U2L2",
                "average": 96
            },
            {
                "title": "分组练习",
                "status": "green",
                "courseNo": "BJ01U2L2",
                "average": 96
            },
            {
                "title": "阅读练习",
                "status": "green",
                "courseNo": "BJ01U2L2",
                "average": 96
            },
            {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ01U2L3",
                "average": 92
            },
            {
                "title": "语法学习",
                "status": "green",
                "courseNo": "BJ01U2L3",
                "average": 92
            },
            {
                "title": "分组练习",
                "status": "green",
                "courseNo": "BJ01U2L3",
                "average": 92
            },
            {
                "title": "阅读练习",
                "status": "green",
                "courseNo": "BJ01U2L3",
                "average": 92
            },
            {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ01U3L1",
                "average": 100
            },
            {
                "title": "语法学习",
                "status": "green",
                "courseNo": "BJ01U3L1",
                "average": 100
            },
            {
                "title": "分组练习",
                "status": "green",
                "courseNo": "BJ01U3L1",
                "average": 100
            },
            {
                "title": "阅读练习",
                "status": "green",
                "courseNo": "BJ01U3L1",
                "average": 100
            },
            {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ01U3L2",
                "average": 100
            },
            {
                "title": "语法学习",
                "status": "green",
                "courseNo": "BJ01U3L2",
                "average": 100
            },
            {
                "title": "分组练习",
                "status": "green",
                "courseNo": "BJ01U3L2",
                "average": 100
            },
            {
                "title": "阅读练习",
                "status": "green",
                "courseNo": "BJ01U3L2",
                "average": 100
            },
            {
                "title": "单词学习",
                "status": "green",
                "courseNo": "BJ01U3L3",
                "average": 88
            },
            {
                "title": "语法学习",
                "status": "green",
                "courseNo": "BJ01U3L3",
                "average": 88
            },
            {
                "title": "分组练习",
                "status": "green",
                "courseNo": "BJ01U3L3",
                "average": 88
            },
            {
                "title": "阅读练习",
                "status": "green",
                "courseNo": "BJ01U3L3",
                "average": 88
            }
        ]
    }
     */
    private String BookNo;
    private List<MovieItem> records_list;

    @Override
    public String toString() {
        return "Movie{" +
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

    public List<MovieItem> getRecords_list() {
        return records_list;
    }

    public void setRecords_list(List<MovieItem> records_list) {
        this.records_list = records_list;
    }
}
