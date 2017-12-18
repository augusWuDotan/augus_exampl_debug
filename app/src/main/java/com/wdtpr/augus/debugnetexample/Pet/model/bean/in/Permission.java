package com.wdtpr.augus.debugnetexample.Pet.model.bean.in;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/2.
 */

public class Permission implements Serializable {
    /*
    {
  "status": "OK",
  "status_code": 200,
  "data": {
    "id": 1,
    "store_id": 2,
    "provider_permission": "
    {\"APP_QUESTION_ANSWER\":false,
    \"APP_GO_FEEDBACK\":false,
    \"MEMBER_ACTION_CHECKOUT\":false,
    \"CARD_ACTION_DEDUCTION_POINT\":false,
    \"SNS_ACTION_CARDPUSH\":false}",
    "assistant_permission": "
    {\"CARD_ACTION_OPEN\":false,
    \"SNS_ACTION_MEMBERPUSH\":false,
    \"SNS_ACTION_MEMBERSPUSH\":false,
    \"BOARD_ACTION_SET_STORE\":true,
    \"BOARD_ACTION_SET_ADV\":true,
    \"BOARD_ACTION_SET_ANN\":true,
    \"APP_UPDATE_BUSSINESS_INFO\":true,
    \"APP_SET_STORE_SCHEDULE_TIME\":true,
    \"APP_PRICE_LIST\":false,
    \"APP_QUESTION_ANSWER\":false,
    \"APP_GO_FEEDBACK\":false}",
    "created_at": "2017-11-18 14:41:34",
    "updated_at": "2017-11-18 20:28:33"
  }
}
     */

    private String status;
    private int status_code;
    private ResultObject data;

    public static class ResultObject implements Serializable {
        private int id;
        private int store_id;
        private ProviderPermission provider_permission;
        private AssistantPermission assistant_permission;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public ProviderPermission getProvider_permission() {
            return provider_permission;
        }

        public void setProvider_permission(ProviderPermission provider_permission) {
            this.provider_permission = provider_permission;
        }

        public AssistantPermission getAssistant_permission() {
            return assistant_permission;
        }

        public void setAssistant_permission(AssistantPermission assistant_permission) {
            this.assistant_permission = assistant_permission;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public static class ProviderPermission implements Serializable {
            /*
            {\"APP_QUESTION_ANSWER\":false,
            \"APP_GO_FEEDBACK\":false,
            \"MEMBER_ACTION_CHECKOUT\":false,
            \"CARD_ACTION_DEDUCTION_POINT\":false,
            \"SNS_ACTION_CARDPUSH\":false}"
             */
            private boolean APP_QUESTION_ANSWER;
            private boolean APP_GO_FEEDBACK;
            private boolean MEMBER_ACTION_CHECKOUT;
            private boolean CARD_ACTION_DEDUCTION_POINT;
            private boolean SNS_ACTION_CARDPUSH;

            public boolean isAPP_QUESTION_ANSWER() {
                return APP_QUESTION_ANSWER;
            }

            public void setAPP_QUESTION_ANSWER(boolean APP_QUESTION_ANSWER) {
                this.APP_QUESTION_ANSWER = APP_QUESTION_ANSWER;
            }

            public boolean isAPP_GO_FEEDBACK() {
                return APP_GO_FEEDBACK;
            }

            public void setAPP_GO_FEEDBACK(boolean APP_GO_FEEDBACK) {
                this.APP_GO_FEEDBACK = APP_GO_FEEDBACK;
            }

            public boolean isMEMBER_ACTION_CHECKOUT() {
                return MEMBER_ACTION_CHECKOUT;
            }

            public void setMEMBER_ACTION_CHECKOUT(boolean MEMBER_ACTION_CHECKOUT) {
                this.MEMBER_ACTION_CHECKOUT = MEMBER_ACTION_CHECKOUT;
            }

            public boolean isCARD_ACTION_DEDUCTION_POINT() {
                return CARD_ACTION_DEDUCTION_POINT;
            }

            public void setCARD_ACTION_DEDUCTION_POINT(boolean CARD_ACTION_DEDUCTION_POINT) {
                this.CARD_ACTION_DEDUCTION_POINT = CARD_ACTION_DEDUCTION_POINT;
            }

            public boolean isSNS_ACTION_CARDPUSH() {
                return SNS_ACTION_CARDPUSH;
            }

            public void setSNS_ACTION_CARDPUSH(boolean SNS_ACTION_CARDPUSH) {
                this.SNS_ACTION_CARDPUSH = SNS_ACTION_CARDPUSH;
            }

            @Override
            public String toString() {
                return "ProviderPermission{" +
                        "APP_QUESTION_ANSWER=" + APP_QUESTION_ANSWER +
                        ", APP_GO_FEEDBACK=" + APP_GO_FEEDBACK +
                        ", MEMBER_ACTION_CHECKOUT=" + MEMBER_ACTION_CHECKOUT +
                        ", CARD_ACTION_DEDUCTION_POINT=" + CARD_ACTION_DEDUCTION_POINT +
                        ", SNS_ACTION_CARDPUSH=" + SNS_ACTION_CARDPUSH +
                        '}';
            }
        }

        public static class AssistantPermission implements Serializable {
            /*
             {\"CARD_ACTION_OPEN\":false,
            \"SNS_ACTION_MEMBERPUSH\":false,
            \"SNS_ACTION_MEMBERSPUSH\":false,
            \"BOARD_ACTION_SET_STORE\":true,
            \"BOARD_ACTION_SET_ADV\":true,
            \"BOARD_ACTION_SET_ANN\":true,
            \"APP_UPDATE_BUSSINESS_INFO\":true,
            \"APP_SET_STORE_SCHEDULE_TIME\":true,
            \"APP_PRICE_LIST\":false,
            \"APP_QUESTION_ANSWER\":false,
            \"APP_GO_FEEDBACK\":false}
             */
            private boolean CARD_ACTION_OPEN;
            private boolean SNS_ACTION_MEMBERPUSH;
            private boolean SNS_ACTION_MEMBERSPUSH;
            private boolean BOARD_ACTION_SET_STORE;
            private boolean BOARD_ACTION_SET_ADV;

            private boolean BOARD_ACTION_SET_ANN;
            private boolean APP_UPDATE_BUSSINESS_INFO;
            private boolean APP_SET_STORE_SCHEDULE_TIME;
            private boolean APP_PRICE_LIST;
            private boolean APP_QUESTION_ANSWER;
            private boolean APP_GO_FEEDBACK;

            public boolean isCARD_ACTION_OPEN() {
                return CARD_ACTION_OPEN;
            }

            public void setCARD_ACTION_OPEN(boolean CARD_ACTION_OPEN) {
                this.CARD_ACTION_OPEN = CARD_ACTION_OPEN;
            }

            public boolean isSNS_ACTION_MEMBERPUSH() {
                return SNS_ACTION_MEMBERPUSH;
            }

            public void setSNS_ACTION_MEMBERPUSH(boolean SNS_ACTION_MEMBERPUSH) {
                this.SNS_ACTION_MEMBERPUSH = SNS_ACTION_MEMBERPUSH;
            }

            public boolean isSNS_ACTION_MEMBERSPUSH() {
                return SNS_ACTION_MEMBERSPUSH;
            }

            public void setSNS_ACTION_MEMBERSPUSH(boolean SNS_ACTION_MEMBERSPUSH) {
                this.SNS_ACTION_MEMBERSPUSH = SNS_ACTION_MEMBERSPUSH;
            }

            public boolean isBOARD_ACTION_SET_STORE() {
                return BOARD_ACTION_SET_STORE;
            }

            public void setBOARD_ACTION_SET_STORE(boolean BOARD_ACTION_SET_STORE) {
                this.BOARD_ACTION_SET_STORE = BOARD_ACTION_SET_STORE;
            }

            public boolean isBOARD_ACTION_SET_ADV() {
                return BOARD_ACTION_SET_ADV;
            }

            public void setBOARD_ACTION_SET_ADV(boolean BOARD_ACTION_SET_ADV) {
                this.BOARD_ACTION_SET_ADV = BOARD_ACTION_SET_ADV;
            }

            public boolean isBOARD_ACTION_SET_ANN() {
                return BOARD_ACTION_SET_ANN;
            }

            public void setBOARD_ACTION_SET_ANN(boolean BOARD_ACTION_SET_ANN) {
                this.BOARD_ACTION_SET_ANN = BOARD_ACTION_SET_ANN;
            }

            public boolean isAPP_UPDATE_BUSSINESS_INFO() {
                return APP_UPDATE_BUSSINESS_INFO;
            }

            public void setAPP_UPDATE_BUSSINESS_INFO(boolean APP_UPDATE_BUSSINESS_INFO) {
                this.APP_UPDATE_BUSSINESS_INFO = APP_UPDATE_BUSSINESS_INFO;
            }

            public boolean isAPP_SET_STORE_SCHEDULE_TIME() {
                return APP_SET_STORE_SCHEDULE_TIME;
            }

            public void setAPP_SET_STORE_SCHEDULE_TIME(boolean APP_SET_STORE_SCHEDULE_TIME) {
                this.APP_SET_STORE_SCHEDULE_TIME = APP_SET_STORE_SCHEDULE_TIME;
            }

            public boolean isAPP_PRICE_LIST() {
                return APP_PRICE_LIST;
            }

            public void setAPP_PRICE_LIST(boolean APP_PRICE_LIST) {
                this.APP_PRICE_LIST = APP_PRICE_LIST;
            }

            public boolean isAPP_QUESTION_ANSWER() {
                return APP_QUESTION_ANSWER;
            }

            public void setAPP_QUESTION_ANSWER(boolean APP_QUESTION_ANSWER) {
                this.APP_QUESTION_ANSWER = APP_QUESTION_ANSWER;
            }

            public boolean isAPP_GO_FEEDBACK() {
                return APP_GO_FEEDBACK;
            }

            public void setAPP_GO_FEEDBACK(boolean APP_GO_FEEDBACK) {
                this.APP_GO_FEEDBACK = APP_GO_FEEDBACK;
            }

            @Override
            public String toString() {
                return "AssistantPermission{" +
                        "CARD_ACTION_OPEN=" + CARD_ACTION_OPEN +
                        ", SNS_ACTION_MEMBERPUSH=" + SNS_ACTION_MEMBERPUSH +
                        ", SNS_ACTION_MEMBERSPUSH=" + SNS_ACTION_MEMBERSPUSH +
                        ", BOARD_ACTION_SET_STORE=" + BOARD_ACTION_SET_STORE +
                        ", BOARD_ACTION_SET_ADV=" + BOARD_ACTION_SET_ADV +
                        ", BOARD_ACTION_SET_ANN=" + BOARD_ACTION_SET_ANN +
                        ", APP_UPDATE_BUSSINESS_INFO=" + APP_UPDATE_BUSSINESS_INFO +
                        ", APP_SET_STORE_SCHEDULE_TIME=" + APP_SET_STORE_SCHEDULE_TIME +
                        ", APP_PRICE_LIST=" + APP_PRICE_LIST +
                        ", APP_QUESTION_ANSWER=" + APP_QUESTION_ANSWER +
                        ", APP_GO_FEEDBACK=" + APP_GO_FEEDBACK +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ResultObject{" +
                    "id=" + id +
                    ", store_id=" + store_id +
                    ", provider_permission='" + provider_permission + '\'' +
                    ", assistant_permission='" + assistant_permission + '\'' +
                    ", created_at='" + created_at + '\'' +
                    ", updated_at='" + updated_at + '\'' +
                    '}';
        }


    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public ResultObject getData() {
        return data;
    }

    public void setData(ResultObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "status='" + status + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                '}';
    }
}
