package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Paginator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class PetVariety implements Serializable {
    /*
    {
  "data": [
    {
      "id": 1,
      "en_name": "Abyssinian Sand Terrier",
      "zh_name": "阿比西尼亞沙梗"
    },
    {
      "id": 2,
      "en_name": "Affenpinscher",
      "zh_name": "猴面犬"
    },
    {
      "id": 3,
      "en_name": "Afghan Hound",
      "zh_name": "阿富汗獵犬"
    },
    {
      "id": 4,
      "en_name": "Airedale Terrier",
      "zh_name": "萬能梗"
    },
    {
      "id": 5,
      "en_name": "Akbash",
      "zh_name": "土耳其阿卡巴土犬"
    },
    {
      "id": 6,
      "en_name": "Akita Inu",
      "zh_name": "秋田犬"
    },
    {
      "id": 7,
      "en_name": "Alano Espanol",
      "zh_name": "西班牙牛頭犬"
    },
    {
      "id": 8,
      "en_name": "Alapaha Blue Blood Bulldog",
      "zh_name": "阿拉帕哈藍血鬥牛犬"
    },
    {
      "id": 9,
      "en_name": "Alaskan Husky",
      "zh_name": "亞拉斯加哈士奇"
    },
    {
      "id": 10,
      "en_name": "Alaskan Klee Kai",
      "zh_name": "迷你哈士奇"
    },
    {
      "id": 11,
      "en_name": "Alaskan Malamute",
      "zh_name": "阿拉斯加雪橇犬"
    },
    {
      "id": 12,
      "en_name": "Alpine Dachsbracke",
      "zh_name": "阿爾卑斯達切斯勃拉克犬"
    },
    {
      "id": 13,
      "en_name": "American Blue Gascon Hound",
      "zh_name": "美國藍加斯科獵犬"
    },
    {
      "id": 14,
      "en_name": "American Bulldog",
      "zh_name": "美國鬥牛犬"
    },
    {
      "id": 15,
      "en_name": "American Bullnese",
      "zh_name": "美國迷你鬥牛犬"
    }
  ],
  "status_code": 200,
  "status": "OK",
  "paginator": {
    "total": 441,
    "per_page": 15,
    "current_page": 1,
    "last_page": 30,
    "next_page_url": "https://momodi.com.tw/api/pet/variety?search_key=&page=2",
    "prev_page_url": null,
    "from": 1,
    "to": 15
  }
}
     */
    private int status_code;
    private String status;
    private List<Variety> data;
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

    public List<Variety> getData() {
        return data;
    }

    public void setData(List<Variety> data) {
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
        return "PetVariety{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                ", paginator=" + paginator +
                '}';
    }

    public static class  Variety{
        private int id;
        private String en_name;
        private String zh_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEn_name() {
            return en_name;
        }

        public void setEn_name(String en_name) {
            this.en_name = en_name;
        }

        public String getZh_name() {
            return zh_name;
        }

        public void setZh_name(String zh_name) {
            this.zh_name = zh_name;
        }

        @Override
        public String toString() {
            return "Variety{" +
                    "id=" + id +
                    ", en_name='" + en_name + '\'' +
                    ", zh_name='" + zh_name + '\'' +
                    '}';
        }
    }
}
