package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/3.
 */

public class PetHasMonthCardBean implements Serializable {
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
        return "PetHasMonthCardBean{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResultObject{
        private boolean has_monthly_card;

        public boolean isHas_monthly_card() {
            return has_monthly_card;
        }

        public void setHas_monthly_card(boolean has_monthly_card) {
            this.has_monthly_card = has_monthly_card;
        }

        @Override
        public String toString() {
            return "ResultObject{" +
                    "has_monthly_card=" + has_monthly_card +
                    '}';
        }
    }


}
