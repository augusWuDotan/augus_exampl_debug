package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie;

import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/25.
 */

public class Movie implements Serializable {
    /*
   {
    "result_status": true,
    "result_message": null,
    "result_content": [
        {
            "BookNo": "BJ01",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ01U1L1",
                    "average": 93
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ01U1L1",
                    "average": 93
                },
                {
                    "title": "分组练习",
                    "status": "green",
                    "courseNo": "BJ01U1L1",
                    "average": 93
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ01U1L1",
                    "average": 93
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
                    "average": 82
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ01U1L3",
                    "average": 82
                },
                {
                    "title": "分组练习",
                    "status": "green",
                    "courseNo": "BJ01U1L3",
                    "average": 82
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ01U1L3",
                    "average": 82
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
        },
        {
            "BookNo": "BJ02",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ02U1L1",
                    "average": 96
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ02U1L1",
                    "average": 96
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ02U1L1",
                    "average": 96
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ02U1L2",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ02U1L2",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ02U1L2",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "red",
                    "courseNo": "BJ02U1L3",
                    "average": 55
                },
                {
                    "title": "语法学习",
                    "status": "red",
                    "courseNo": "BJ02U1L3",
                    "average": 55
                },
                {
                    "title": "阅读练习",
                    "status": "red",
                    "courseNo": "BJ02U1L3",
                    "average": 55
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ02U2L1",
                    "average": 98
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ02U2L1",
                    "average": 98
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ02U2L1",
                    "average": 98
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ02U2L2",
                    "average": 96
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ02U2L2",
                    "average": 96
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ02U2L2",
                    "average": 96
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ02U2L3",
                    "average": 96
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ02U2L3",
                    "average": 96
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ02U2L3",
                    "average": 96
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ02U3L1",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ02U3L1",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ02U3L1",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ02U3L2",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ02U3L2",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ02U3L2",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ02U3L3",
                    "average": 96
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ02U3L3",
                    "average": 96
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ02U3L3",
                    "average": 96
                }
            ]
        },
        {
            "BookNo": "BJ03",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ03U1L1",
                    "average": 91
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ03U1L1",
                    "average": 91
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ03U1L1",
                    "average": 91
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ03U1L2",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ03U1L2",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ03U1L2",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ03U1L3",
                    "average": 96
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ03U1L3",
                    "average": 96
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ03U1L3",
                    "average": 96
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ03U2L1",
                    "average": 91
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ03U2L1",
                    "average": 91
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ03U2L1",
                    "average": 91
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ03U2L2",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ03U2L2",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ03U2L2",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ03U2L3",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ03U2L3",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ03U2L3",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ03U3L1",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ03U3L1",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ03U3L1",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ03U3L2",
                    "average": 96
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ03U3L2",
                    "average": 96
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ03U3L2",
                    "average": 96
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ03U3L3",
                    "average": 98
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ03U3L3",
                    "average": 98
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ03U3L3",
                    "average": 98
                }
            ]
        },
        {
            "BookNo": "BJ04",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ04U1L1",
                    "average": 92
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ04U1L1",
                    "average": 92
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ04U1L1",
                    "average": 92
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ04U1L2",
                    "average": 96
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ04U1L2",
                    "average": 96
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ04U1L2",
                    "average": 96
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ04U1L3",
                    "average": 98
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ04U1L3",
                    "average": 98
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ04U1L3",
                    "average": 98
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ04U2L1",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ04U2L1",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ04U2L1",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ04U2L2",
                    "average": 97
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ04U2L2",
                    "average": 97
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ04U2L2",
                    "average": 97
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ04U2L3",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ04U2L3",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ04U2L3",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ04U3L1",
                    "average": 87
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ04U3L1",
                    "average": 87
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ04U3L1",
                    "average": 87
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ04U3L2",
                    "average": 98
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ04U3L2",
                    "average": 98
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ04U3L2",
                    "average": 98
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ04U3L3",
                    "average": 88
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ04U3L3",
                    "average": 88
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ04U3L3",
                    "average": 88
                }
            ]
        },
        {
            "BookNo": "BJ05",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ05U1L1",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ05U1L1",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ05U1L1",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ05U1L2",
                    "average": 94
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ05U1L2",
                    "average": 94
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ05U1L2",
                    "average": 94
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ05U1L3",
                    "average": 93
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ05U1L3",
                    "average": 93
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ05U1L3",
                    "average": 93
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ05U2L1",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ05U2L1",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ05U2L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ05U2L2",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ05U2L2",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ05U2L2",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ05U2L3",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ05U2L3",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ05U2L3",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ05U3L1",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ05U3L1",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ05U3L1",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ05U3L2",
                    "average": 97
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ05U3L2",
                    "average": 97
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ05U3L2",
                    "average": 97
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ05U3L3",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ05U3L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ05U3L3",
                    "average": 0
                }
            ]
        },
        {
            "BookNo": "BJ06",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ06U1L1",
                    "average": 96
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ06U1L1",
                    "average": 96
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ06U1L1",
                    "average": 96
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ06U1L2",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ06U1L2",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ06U1L2",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ06U1L3",
                    "average": 98
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ06U1L3",
                    "average": 98
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ06U1L3",
                    "average": 98
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ06U2L1",
                    "average": 98
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ06U2L1",
                    "average": 98
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ06U2L1",
                    "average": 98
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ06U2L2",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ06U2L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ06U2L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ06U2L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ06U2L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ06U2L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ06U3L1",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ06U3L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ06U3L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "yellow",
                    "courseNo": "BJ06U3L2",
                    "average": 77
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ06U3L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ06U3L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ06U3L3",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ06U3L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ06U3L3",
                    "average": 0
                }
            ]
        },
        {
            "BookNo": "BJ07",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ07U1L1",
                    "average": 98
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ07U1L1",
                    "average": 98
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ07U1L1",
                    "average": 98
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ07U1L2",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ07U1L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ07U1L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ07U1L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ07U1L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ07U1L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "red",
                    "courseNo": "BJ07U2L1",
                    "average": 24
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ07U2L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ07U2L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ07U2L2",
                    "average": 83
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ07U2L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ07U2L2",
                    "average": 83
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ07U2L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ07U2L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "red",
                    "courseNo": "BJ07U2L3",
                    "average": 41
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ07U3L1",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ07U3L1",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ07U3L1",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ07U3L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ07U3L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ07U3L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ07U3L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ07U3L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ07U3L3",
                    "average": 91
                }
            ]
        },
        {
            "BookNo": "BJ08",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ08U1L1",
                    "average": 93
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ08U1L1",
                    "average": 93
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ08U1L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ08U1L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ08U1L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ08U1L2",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ08U1L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ08U1L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ08U1L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ08U2L1",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ08U2L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ08U2L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ08U2L2",
                    "average": 88
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ08U2L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ08U2L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ08U2L3",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ08U2L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ08U2L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ08U3L1",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ08U3L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ08U3L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ08U3L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ08U3L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ08U3L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ08U3L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ08U3L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ08U3L3",
                    "average": 100
                }
            ]
        },
        {
            "BookNo": "BJ09",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ09U1L1",
                    "average": 97
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ09U1L1",
                    "average": 97
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ09U1L1",
                    "average": 97
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ09U1L2",
                    "average": 97
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ09U1L2",
                    "average": 97
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ09U1L2",
                    "average": 97
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ09U1L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ09U1L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ09U1L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ09U2L1",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ09U2L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ09U2L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ09U2L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ09U2L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ09U2L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ09U2L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ09U2L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ09U2L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ09U3L1",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ09U3L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ09U3L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ09U3L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ09U3L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ09U3L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ09U3L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "green",
                    "courseNo": "BJ09U3L3",
                    "average": 100
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ09U3L3",
                    "average": 0
                }
            ]
        },
        {
            "BookNo": "BJ10",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "red",
                    "courseNo": "BJ10U1L1",
                    "average": 49
                },
                {
                    "title": "语法学习",
                    "status": "red",
                    "courseNo": "BJ10U1L1",
                    "average": 49
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ10U1L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ10U1L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ10U1L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "green",
                    "courseNo": "BJ10U1L2",
                    "average": 100
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ10U1L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ10U1L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ10U1L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "red",
                    "courseNo": "BJ10U2L1",
                    "average": 42
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ10U2L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ10U2L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ10U2L2",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ10U2L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ10U2L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ10U2L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ10U2L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ10U2L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ10U3L1",
                    "average": 84
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ10U3L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ10U3L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ10U3L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ10U3L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ10U3L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ10U3L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ10U3L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ10U3L3",
                    "average": 0
                }
            ]
        },
        {
            "BookNo": "BJ11",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ11U1L1",
                    "average": 100
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ11U1L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ11U1L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "green",
                    "courseNo": "BJ11U1L2",
                    "average": 86
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ11U1L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ11U1L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ11U1L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ11U1L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ11U1L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ11U2L1",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ11U2L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ11U2L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ11U2L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ11U2L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ11U2L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ11U2L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ11U2L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ11U2L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ11U3L1",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ11U3L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ11U3L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ11U3L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ11U3L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ11U3L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ11U3L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ11U3L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ11U3L3",
                    "average": 0
                }
            ]
        },
        {
            "BookNo": "BJ12",
            "records_list": [
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ12U1L1",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ12U1L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ12U1L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ12U1L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ12U1L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ12U1L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ12U1L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ12U1L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ12U1L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ12U2L1",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ12U2L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ12U2L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ12U2L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ12U2L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ12U2L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ12U2L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ12U2L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ12U2L3",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ12U3L1",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ12U3L1",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ12U3L1",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ12U3L2",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ12U3L2",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ12U3L2",
                    "average": 0
                },
                {
                    "title": "单词学习",
                    "status": "gray",
                    "courseNo": "BJ12U3L3",
                    "average": 0
                },
                {
                    "title": "语法学习",
                    "status": "gray",
                    "courseNo": "BJ12U3L3",
                    "average": 0
                },
                {
                    "title": "阅读练习",
                    "status": "gray",
                    "courseNo": "BJ12U3L3",
                    "average": 0
                }
            ]
        }
    ]
}
     */
    private Boolean result_status;
    private String result_message;
    private List<MovieData> result_content;

    @Override
    public String toString() {
        return "Movie{" +
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

    public List<MovieData> getResult_content() {
        return result_content;
    }

    public void setResult_content(List<MovieData> result_content) {
        this.result_content = result_content;
    }
}
