package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/25.
 */

public class IRS_Record implements Serializable {
    /*
    {
    "result_status": true,
    "result_message": null,
    "result_content": [
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
                    "status": "red"
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
        },
        {
            "BookNo": "BJ03",
            "records_list": [
                {
                    "courseNo": "BJ03U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ03U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ03U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ03U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ03U2L2",
                    "average": 100,
                    "status": "green"
                },
                {
                    "courseNo": "BJ03U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ03U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ03U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ03U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        },
        {
            "BookNo": "BJ04",
            "records_list": [
                {
                    "courseNo": "BJ04U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ04U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ04U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ04U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ04U2L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ04U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ04U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ04U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ04U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        },
        {
            "BookNo": "BJ05",
            "records_list": [
                {
                    "courseNo": "BJ05U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ05U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ05U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ05U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ05U2L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ05U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ05U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ05U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ05U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        },
        {
            "BookNo": "BJ06",
            "records_list": [
                {
                    "courseNo": "BJ06U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ06U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ06U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ06U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ06U2L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ06U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ06U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ06U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ06U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        },
        {
            "BookNo": "BJ07",
            "records_list": [
                {
                    "courseNo": "BJ07U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ07U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ07U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ07U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ07U2L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ07U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ07U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ07U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ07U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        },
        {
            "BookNo": "BJ08",
            "records_list": [
                {
                    "courseNo": "BJ08U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ08U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ08U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ08U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ08U2L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ08U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ08U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ08U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ08U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        },
        {
            "BookNo": "BJ09",
            "records_list": [
                {
                    "courseNo": "BJ09U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ09U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ09U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ09U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ09U2L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ09U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ09U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ09U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ09U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        },
        {
            "BookNo": "BJ10",
            "records_list": [
                {
                    "courseNo": "BJ10U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ10U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ10U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ10U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ10U2L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ10U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ10U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ10U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ10U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        },
        {
            "BookNo": "BJ11",
            "records_list": [
                {
                    "courseNo": "BJ11U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ11U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ11U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ11U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ11U2L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ11U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ11U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ11U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ11U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        },
        {
            "BookNo": "BJ12",
            "records_list": [
                {
                    "courseNo": "BJ12U1L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ12U1L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ12U1L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ12U2L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ12U2L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ12U2L3",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ12U3L1",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ12U3L2",
                    "average": 0,
                    "status": "gray"
                },
                {
                    "courseNo": "BJ12U3L3",
                    "average": 0,
                    "status": "gray"
                }
            ]
        }
    ]
}
     */
    private Boolean result_status;
    private String result_message;
    private List<IRS_RecordData> result_content;

    @Override
    public String toString() {
        return "IRS_Record{" +
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

    public List<IRS_RecordData> getResult_content() {
        return result_content;
    }

    public void setResult_content(List<IRS_RecordData> result_content) {
        this.result_content = result_content;
    }
}
