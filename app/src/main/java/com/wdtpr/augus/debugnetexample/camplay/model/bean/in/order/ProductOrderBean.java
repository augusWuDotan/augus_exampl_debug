package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.order;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/11/20.
 */

public class ProductOrderBean implements Serializable {
    /*
          {
              "Member_ID": 0,
              "Contact_Phone": "string",
              "Contact_Address": "string",
              "Contact_Name": "string",
              "detail": [
                {
                  "Product_ID": 0,
                  "Quantity": 0,
                  "OrderDetailPrice": 0,
                  "OrderDetailPoints": 0
                }
              ]
            }
     */

    private int Member_ID;
    private String Contact_Phone;
    private String Contact_Address;
    private String Contact_Name;
    private List<Detail> detail;

    public int getMember_ID() {
        return Member_ID;
    }

    public void setMember_ID(int member_ID) {
        Member_ID = member_ID;
    }

    public String getContact_Phone() {
        return Contact_Phone;
    }

    public void setContact_Phone(String contact_Phone) {
        Contact_Phone = contact_Phone;
    }

    public String getContact_Address() {
        return Contact_Address;
    }

    public void setContact_Address(String contact_Address) {
        Contact_Address = contact_Address;
    }

    public String getContact_Name() {
        return Contact_Name;
    }

    public void setContact_Name(String contact_Name) {
        Contact_Name = contact_Name;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ProductOrderBean{" +
                "Member_ID=" + Member_ID +
                ", Contact_Phone='" + Contact_Phone + '\'' +
                ", Contact_Address='" + Contact_Address + '\'' +
                ", Contact_Name='" + Contact_Name + '\'' +
                ", detail=" + detail +
                '}';
    }

    public static class Detail implements Serializable {
        private int Product_ID;//商品id
        private int Quantity;//數量
        private int OrderDetailPrice;//總使用金額
        private int OrderDetailPoints;//總使用露點

        public int getProduct_ID() {
            return Product_ID;
        }

        public void setProduct_ID(int product_ID) {
            Product_ID = product_ID;
        }

        public int getQuantity() {
            return Quantity;
        }

        public void setQuantity(int quantity) {
            Quantity = quantity;
        }

        public int getOrderDetailPrice() {
            return OrderDetailPrice;
        }

        public void setOrderDetailPrice(int orderDetailPrice) {
            OrderDetailPrice = orderDetailPrice;
        }

        public int getOrderDetailPoints() {
            return OrderDetailPoints;
        }

        public void setOrderDetailPoints(int orderDetailPoints) {
            OrderDetailPoints = orderDetailPoints;
        }


        @Override
        public String toString() {
            return "ProductOrderBean{" +
                    "Product_ID=" + Product_ID +
                    ", Quantity=" + Quantity +
                    ", OrderDetailPrice=" + OrderDetailPrice +
                    ", OrderDetailPoints=" + OrderDetailPoints +
                    '}';
        }
    }


}
