package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Paginator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/4.
 */

public class FAQListBean implements Serializable {
    /*
    {
  "data": [
    {
      "id": 8,
      "question": "TQ1.1",
      "anwser": "TA1.1"
    },
    {
      "id": 6,
      "question": "Q1",
      "anwser": "A1"
    },
    {
      "id": 3,
      "question": "我有問題",
      "anwser": "咋hhbnn\n\n\n巍峨"
    }
  ],
  "status_code": 200,
  "status": "OK",
  "paginator": {
    "total": 3,
    "per_page": 15,
    "current_page": 1,
    "last_page": 1,
    "next_page_url": null,
    "prev_page_url": null,
    "from": 1,
    "to": 3
  }
}
     */
    private int status_code;
    private String status;
    private List<FAQ> data;
    private Paginator paginator;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FAQ> getData() {
        return data;
    }

    public void setData(List<FAQ> data) {
        this.data = data;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    @Override
    public String toString() {
        return "FAQListBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                ", paginator=" + paginator +
                '}';
    }
}
