package com.wdtpr.augus.debugnetexample.camplay.model.bean.in;

/**
 * Created by Ray on 2017/8/15.
 * ServerToken
 */

public class ServerToken {

    private int result;
    private String result_message;
    private ResultObjectBean result_object;

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

    public static class ResultObjectBean {
        private String s_server_token;

        public String getS_server_token() {
            return s_server_token;
        }

        public void setS_server_token(String s_server_token) {
            this.s_server_token = s_server_token;
        }

        @Override
        public String toString() {
            return "ResultObjectBean{" +
                    "s_server_token='" + s_server_token + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ServerToken{" +
                "result=" + result +
                ", result_message='" + result_message + '\'' +
                ", result_object=" + result_object +
                '}';
    }
}
