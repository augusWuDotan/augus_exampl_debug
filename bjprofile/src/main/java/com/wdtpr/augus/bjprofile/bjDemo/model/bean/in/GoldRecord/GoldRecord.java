package com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord;

import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/25.
 */

public class GoldRecord implements Serializable {
    /*
   {
    "result_status": true,
    "result_message": null,
    "result_content": [
        {
            "goldRecordCount": 6,
            "goldRecordReason": "完成Spell\n金幣(3)*倍率(2)",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-23\n02:49:00"
        },
        {
            "goldRecordCount": 2,
            "goldRecordReason": "完成Spell\n金幣(1)*倍率(2)",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-22\n07:12:00"
        },
        {
            "goldRecordCount": 42,
            "goldRecordReason": "Golds : (BaseGold)14*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n09:34:00"
        },
        {
            "goldRecordCount": 7,
            "goldRecordReason": "Golds : (BaseGold)7*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n09:24:00"
        },
        {
            "goldRecordCount": 14,
            "goldRecordReason": "Golds : (BaseGold)7*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n09:06:00"
        },
        {
            "goldRecordCount": 7,
            "goldRecordReason": "Golds : (BaseGold)7*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n08:51:00"
        },
        {
            "goldRecordCount": 8,
            "goldRecordReason": "Golds : (BaseGold)4*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n07:00:00"
        },
        {
            "goldRecordCount": 9,
            "goldRecordReason": "Golds : (BaseGold)9*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n06:49:00"
        },
        {
            "goldRecordCount": 9,
            "goldRecordReason": "Golds : (BaseGold)9*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n06:45:00"
        },
        {
            "goldRecordCount": 27,
            "goldRecordReason": "Golds : (BaseGold)9*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n06:44:00"
        },
        {
            "goldRecordCount": 9,
            "goldRecordReason": "Golds : (BaseGold)9*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n06:30:00"
        },
        {
            "goldRecordCount": 9,
            "goldRecordReason": "Golds : (BaseGold)9*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n06:28:00"
        },
        {
            "goldRecordCount": 6,
            "goldRecordReason": "Golds : (BaseGold)6*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n06:21:00"
        },
        {
            "goldRecordCount": 30,
            "goldRecordReason": "Golds : (BaseGold)6*(Award)5",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n06:19:00"
        },
        {
            "goldRecordCount": 12,
            "goldRecordReason": "Golds : (BaseGold)6*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n05:59:00"
        },
        {
            "goldRecordCount": 6,
            "goldRecordReason": "Golds : (BaseGold)6*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n05:57:00"
        },
        {
            "goldRecordCount": 18,
            "goldRecordReason": "Golds : (BaseGold)6*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n05:43:00"
        },
        {
            "goldRecordCount": 3,
            "goldRecordReason": "Golds : (BaseGold)3*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n05:34:00"
        },
        {
            "goldRecordCount": 3,
            "goldRecordReason": "Golds : (BaseGold)3*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n05:32:00"
        },
        {
            "goldRecordCount": 9,
            "goldRecordReason": "Golds : (BaseGold)3*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n05:30:00"
        },
        {
            "goldRecordCount": 8,
            "goldRecordReason": "Golds : (BaseGold)4*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n03:41:00"
        },
        {
            "goldRecordCount": 4,
            "goldRecordReason": "Golds : (BaseGold)4*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n03:39:00"
        },
        {
            "goldRecordCount": 4,
            "goldRecordReason": "Golds : (BaseGold)4*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n03:35:00"
        },
        {
            "goldRecordCount": 9,
            "goldRecordReason": "Golds : (BaseGold)3*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n03:04:00"
        },
        {
            "goldRecordCount": 6,
            "goldRecordReason": "Golds : (BaseGold)3*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n03:02:00"
        },
        {
            "goldRecordCount": 6,
            "goldRecordReason": "Golds : (BaseGold)3*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n03:00:00"
        },
        {
            "goldRecordCount": 15,
            "goldRecordReason": "Golds : (BaseGold)3*(Award)5",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-11\n02:53:00"
        },
        {
            "goldRecordCount": 2,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n09:42:00"
        },
        {
            "goldRecordCount": 1,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n09:32:00"
        },
        {
            "goldRecordCount": 1,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n09:25:00"
        },
        {
            "goldRecordCount": 1,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n09:23:00"
        },
        {
            "goldRecordCount": 1,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n09:22:00"
        },
        {
            "goldRecordCount": 2,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n09:13:00"
        },
        {
            "goldRecordCount": 1,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n08:56:00"
        },
        {
            "goldRecordCount": 1,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n08:49:00"
        },
        {
            "goldRecordCount": 5,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)5",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n08:23:00"
        },
        {
            "goldRecordCount": 1,
            "goldRecordReason": "Golds : (BaseGold)1*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-10\n08:17:00"
        },
        {
            "goldRecordCount": 90,
            "goldRecordReason": "Golds : (BaseGold)30*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-09\n07:01:00"
        },
        {
            "goldRecordCount": 90,
            "goldRecordReason": "Golds : (BaseGold)30*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n06:01:00"
        },
        {
            "goldRecordCount": 90,
            "goldRecordReason": "Golds : (BaseGold)30*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:58:00"
        },
        {
            "goldRecordCount": 60,
            "goldRecordReason": "Golds : (BaseGold)30*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:54:00"
        },
        {
            "goldRecordCount": 90,
            "goldRecordReason": "Golds : (BaseGold)30*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:51:00"
        },
        {
            "goldRecordCount": 60,
            "goldRecordReason": "Golds : (BaseGold)30*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:46:00"
        },
        {
            "goldRecordCount": 60,
            "goldRecordReason": "Golds : (BaseGold)20*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:37:00"
        },
        {
            "goldRecordCount": 20,
            "goldRecordReason": "Golds : (BaseGold)20*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:36:00"
        },
        {
            "goldRecordCount": 20,
            "goldRecordReason": "Golds : (BaseGold)20*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:33:00"
        },
        {
            "goldRecordCount": 20,
            "goldRecordReason": "Golds : (BaseGold)20*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:28:00"
        },
        {
            "goldRecordCount": 20,
            "goldRecordReason": "Golds : (BaseGold)20*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:26:00"
        },
        {
            "goldRecordCount": 60,
            "goldRecordReason": "Golds : (BaseGold)20*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:22:00"
        },
        {
            "goldRecordCount": 40,
            "goldRecordReason": "Golds : (BaseGold)20*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:14:00"
        },
        {
            "goldRecordCount": 40,
            "goldRecordReason": "Golds : (BaseGold)20*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:10:00"
        },
        {
            "goldRecordCount": 20,
            "goldRecordReason": "Golds : (BaseGold)20*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n05:06:00"
        },
        {
            "goldRecordCount": 20,
            "goldRecordReason": "Golds : (BaseGold)10*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n04:55:00"
        },
        {
            "goldRecordCount": 30,
            "goldRecordReason": "Golds : (BaseGold)10*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n04:51:00"
        },
        {
            "goldRecordCount": 50,
            "goldRecordReason": "Golds : (BaseGold)10*(Award)5",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n04:48:00"
        },
        {
            "goldRecordCount": 10,
            "goldRecordReason": "Golds : (BaseGold)10*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n04:40:00"
        },
        {
            "goldRecordCount": 10,
            "goldRecordReason": "Golds : (BaseGold)10*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n03:56:00"
        },
        {
            "goldRecordCount": 10,
            "goldRecordReason": "Golds : (BaseGold)10*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n03:42:00"
        },
        {
            "goldRecordCount": 10,
            "goldRecordReason": "Golds : (BaseGold)10*(Award)1",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n03:36:00"
        },
        {
            "goldRecordCount": 30,
            "goldRecordReason": "Golds : (BaseGold)10*(Award)3",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n03:35:00"
        },
        {
            "goldRecordCount": 20,
            "goldRecordReason": "Golds : (BaseGold)10*(Award)2",
            "isMonsterCoin": false,
            "goldRecordTime": "2018-01-08\n03:28:00"
        }
    ]
}
     */
    private Boolean result_status;
    private String result_message;
    private List<GoldRecordItem> result_content;

    @Override
    public String toString() {
        return "GoldRecord{" +
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

    public List<GoldRecordItem> getResult_content() {
        return result_content;
    }

    public void setResult_content(List<GoldRecordItem> result_content) {
        this.result_content = result_content;
    }
}
