package com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/15.
 *
 */

public class FbPaging implements Serializable {
    private Cursors cursors;

    @Override
    public String toString() {
        return "FbPaging{" +
                "cursors=" + cursors +
                '}';
    }

    public Cursors getCursors() {
        return cursors;
    }

    public void setCursors(Cursors cursors) {
        this.cursors = cursors;
    }

    public static class Cursors implements Serializable {
        private String before;
        private String after;

        @Override
        public String toString() {
            return "Cursors{" +
                    "before='" + before + '\'' +
                    ", after='" + after + '\'' +
                    '}';
        }

        public String getBefore() {
            return before;
        }

        public void setBefore(String before) {
            this.before = before;
        }

        public String getAfter() {
            return after;
        }

        public void setAfter(String after) {
            this.after = after;
        }
    }
}
