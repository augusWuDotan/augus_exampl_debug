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
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ01U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ01U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ01U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ01U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ01U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ01U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ01U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ01U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ01U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ02",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ02U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ02U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ02U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ02U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ02U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ02U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ02U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ02U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ02U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ03",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ03U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ03U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ03U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ03U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ03U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ03U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ03U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ03U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ03U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ04",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ04U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ04U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ04U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ04U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ04U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ04U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ04U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ04U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ04U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ05",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ05U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ05U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ05U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ05U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ05U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ05U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ05U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ05U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ05U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ06",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ06U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ06U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ06U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ06U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ06U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ06U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ06U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ06U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ06U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ07",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ07U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ07U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ07U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ07U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ07U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ07U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ07U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ07U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ07U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ08",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ08U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ08U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ08U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ08U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ08U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ08U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ08U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ08U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ08U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ09",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ09U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ09U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ09U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ09U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ09U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ09U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ09U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ09U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ09U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ10",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ10U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ10U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ10U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ10U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ10U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ10U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ10U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ10U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ10U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ11",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ11U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ11U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ11U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ11U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ11U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ11U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ11U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ11U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ11U3L3",
                    "average": 0,
                    "status": "0"
                }
            ]
        },
        {
            "BookNo": "BJ12",
            "records_list": [
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ12U1L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ12U1L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ12U1L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ12U2L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ12U2L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ12U2L3",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ12U3L1",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ12U3L2",
                    "average": 0,
                    "status": "0"
                },
                {
                    "APP_TestRecord_ID": null,
                    "TestTime": null,
                    "Gold": 0,
                    "GoldType": false,
                    "courseNo": "BJ12U3L3",
                    "average": 0,
                    "status": "0"
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
