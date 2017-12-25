package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.order;

import java.io.Serializable;

/**
 * Created by augus on 2017/11/20.
 */

public class OrderCallBack implements Serializable {
    /*
        "Order_ID": 19,
        "Order_Num": "O20171120005",
        "OrderPayType": "點數全額折抵
     */

    private int result;
    private String result_message;
    private ResultObjectBean result_object;


    public static class ResultObjectBean implements Serializable {
        private int Order_ID;
        private String Order_Num;
        private String OrderPayType;
        private int TotalCost;
        private int TotalPoint;

        public int getOrder_ID() {
            return Order_ID;
        }

        public void setOrder_ID(int order_ID) {
            Order_ID = order_ID;
        }

        public String getOrder_Num() {
            return Order_Num;
        }

        public void setOrder_Num(String order_Num) {
            Order_Num = order_Num;
        }

        public String getOrderPayType() {
            return OrderPayType;
        }

        public void setOrderPayType(String orderPayType) {
            OrderPayType = orderPayType;
        }

        public int getTotalCost() {
            return TotalCost;
        }

        public void setTotalCost(int totalCost) {
            TotalCost = totalCost;
        }

        @Override
        public String toString() {
            return "ResultObjectBean{" +
                    "Order_ID=" + Order_ID +
                    ", Order_Num='" + Order_Num + '\'' +
                    ", OrderPayType='" + OrderPayType + '\'' +
                    '}';
        }

        public int getTotalPoint() {
            return TotalPoint;
        }

        public void setTotalPoint(int totalPoint) {
            TotalPoint = totalPoint;
        }
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }

    public ResultObjectBean getResult_object() {
        return result_object;
    }

    public void setResult_object(ResultObjectBean result_object) {
        this.result_object = result_object;
    }

    @Override
    public String toString() {
        return "OrderCallBack{" +
                "result=" + result +
                ", result_message='" + result_message + '\'' +
                ", result_object=" + result_object +
                '}';
    }
}
