package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public class UserInfo implements Serializable {

    /*
    {
  "status": "OK",
  "status_code": 200,
  "data": {
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHBzOlwvXC9tb21vZGkuY29tLnR3XC9hcGlcL3VzZXJcL2xvZ2luIiwiaWF0IjoxNTEyMzEyNzM5LCJleHAiOjE1MjAyMDE5NTksIm5iZiI6MTUxMjMxMjczOSwianRpIjoiZHE1OVNSeXlOTUVhVUhnSSJ9.OFjNkjowLOQj1ZPiz6vRrIqwb8zvE-YidiltxF3waUA",
    "id": 2,
    "role": "Store",
    "store_id": 2,
    "is_in_contract": true,
    "remaining_days": 15,
    "contract_detail": {
      "appointment_per_month": 999999,
      "member_sns_per_month": 999999,
      "group_sns_per_month": 999999,
      "homepage_theme": [
        "store-normal",
        "store-A"
      ],
      "announcement_theme": [
        "announcement-normal",
        "announcement-A"
      ],
      "advertisement_theme": [
        "advertisement-A"
      ],
      "member_limit": 999999,
      "card_per_member": 9999,
      "smart_checkout": true,
      "accounting_report": true,
      "price_management": true,
      "sms_message_per_month": 999
    }
  }
}
     */
    /*
{
  "status": "OK",
  "status_code": 200,
  "data": {
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjE3LCJpc3MiOiJodHRwczpcL1wvbW9tb2RpLmNvbS50d1wvYXBpXC91c2VyXC9sb2dpbiIsImlhdCI6MTUxMjMxMjgxMiwiZXhwIjoxNTIwMjAyMDMyLCJuYmYiOjE1MTIzMTI4MTIsImp0aSI6IlN3YW16V1ZjNTF6dGd1MjMifQ.v9a4xRBHbL16qzxrOewen-ajikbZTaCjKY9DNsuCJX4",
    "id": 17,
    "role": "Customer"
  }
}
     */
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
        return "UserInfo{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResultObject{
        private String token;
        private int id;
        private String role;
        private int store_id;
        private boolean is_in_contract;
        private int remaining_days;
        private Contract_detail contract_detail;


        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public boolean isIs_in_contract() {
            return is_in_contract;
        }

        public void setIs_in_contract(boolean is_in_contract) {
            this.is_in_contract = is_in_contract;
        }

        public int getRemaining_days() {
            return remaining_days;
        }

        public void setRemaining_days(int remaining_days) {
            this.remaining_days = remaining_days;
        }

        public Contract_detail getContract_detail() {
            return contract_detail;
        }

        public void setContract_detail(Contract_detail contract_detail) {
            this.contract_detail = contract_detail;
        }

        @Override
        public String toString() {
            return "ResultObject{" +
                    "token='" + token + '\'' +
                    ", id=" + id +
                    ", role='" + role + '\'' +
                    ", store_id=" + store_id +
                    ", is_in_contract=" + is_in_contract +
                    ", remaining_days=" + remaining_days +
                    ", contract_detail=" + contract_detail +
                    '}';
        }

        public static class Contract_detail implements Serializable{
            private long appointment_per_month;
            private long member_sns_per_month;
            private long group_sns_per_month;
            private List<String> homepage_theme;
            private List<String> announcement_theme;
            private List<String> advertisement_theme;
            private long member_limit;
            private long card_per_member;
            private boolean smart_checkout;
            private boolean accounting_report;
            private boolean price_management;
            private int sms_message_per_month;

            public long getAppointment_per_month() {
                return appointment_per_month;
            }

            public void setAppointment_per_month(long appointment_per_month) {
                this.appointment_per_month = appointment_per_month;
            }

            public long getMember_sns_per_month() {
                return member_sns_per_month;
            }

            public void setMember_sns_per_month(long member_sns_per_month) {
                this.member_sns_per_month = member_sns_per_month;
            }

            public long getGroup_sns_per_month() {
                return group_sns_per_month;
            }

            public void setGroup_sns_per_month(long group_sns_per_month) {
                this.group_sns_per_month = group_sns_per_month;
            }

            public List<String> getHomepage_theme() {
                return homepage_theme;
            }

            public void setHomepage_theme(List<String> homepage_theme) {
                this.homepage_theme = homepage_theme;
            }

            public List<String> getAnnouncement_theme() {
                return announcement_theme;
            }

            public void setAnnouncement_theme(List<String> announcement_theme) {
                this.announcement_theme = announcement_theme;
            }

            public List<String> getAdvertisement_theme() {
                return advertisement_theme;
            }

            public void setAdvertisement_theme(List<String> advertisement_theme) {
                this.advertisement_theme = advertisement_theme;
            }

            public long getMember_limit() {
                return member_limit;
            }

            public void setMember_limit(long member_limit) {
                this.member_limit = member_limit;
            }

            public long getCard_per_member() {
                return card_per_member;
            }

            public void setCard_per_member(long card_per_member) {
                this.card_per_member = card_per_member;
            }

            public boolean isSmart_checkout() {
                return smart_checkout;
            }

            public void setSmart_checkout(boolean smart_checkout) {
                this.smart_checkout = smart_checkout;
            }

            public boolean isAccounting_report() {
                return accounting_report;
            }

            public void setAccounting_report(boolean accounting_report) {
                this.accounting_report = accounting_report;
            }

            public boolean isPrice_management() {
                return price_management;
            }

            public void setPrice_management(boolean price_management) {
                this.price_management = price_management;
            }

            public int getSms_message_per_month() {
                return sms_message_per_month;
            }

            public void setSms_message_per_month(int sms_message_per_month) {
                this.sms_message_per_month = sms_message_per_month;
            }

            @Override
            public String toString() {

                return "Contract_detail{" +
                        "appointment_per_month=" + appointment_per_month +
                        ", member_sns_per_month=" + member_sns_per_month +
                        ", group_sns_per_month=" + group_sns_per_month +
                        ", homepage_theme=" + homepage_theme +
                        ", announcement_theme=" + announcement_theme +
                        ", advertisement_theme=" + advertisement_theme +
                        ", member_limit=" + member_limit +
                        ", card_per_member=" + card_per_member +
                        ", smart_checkout=" + smart_checkout +
                        ", accounting_report=" + accounting_report +
                        ", price_management=" + price_management +
                        ", sms_message_per_month=" + sms_message_per_month +
                        '}';
            }
        }
    }
}
