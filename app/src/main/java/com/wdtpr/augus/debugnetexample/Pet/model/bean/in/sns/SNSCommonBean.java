package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/6.
 */

public class SNSCommonBean implements Serializable {

    private String EndpointArn;//callbackbean use
    private int count;//

    public String getEndpointArn() {
        return EndpointArn;
    }

    public void setEndpointArn(String endpointArn) {
        EndpointArn = endpointArn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SNSCommonBean{" +
                "EndpointArn='" + EndpointArn + '\'' +
                ", count=" + count +
                '}';
    }
}
