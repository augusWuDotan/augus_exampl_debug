package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class CardCreateCallbackBean implements Serializable {
    private int status_code;
    private String status;
    private ResultObject data;

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

    public ResultObject getData() {
        return data;
    }

    public void setData(ResultObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CardCreateCallbackBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResultObject{
        private int card_id;
        private int store_id;

        @Override
        public String toString() {
            return "ResultObject{" +
                    "card_id=" + card_id +
                    ", store_id=" + store_id +
                    '}';
        }

        public int getCard_id() {
            return card_id;
        }

        public void setCard_id(int card_id) {
            this.card_id = card_id;
        }

        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }
    }
}
