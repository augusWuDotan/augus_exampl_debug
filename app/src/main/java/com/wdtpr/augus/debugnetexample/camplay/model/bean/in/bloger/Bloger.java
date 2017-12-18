package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.bloger;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Ray on 2017/8/18.
 * Bloger
 */

public class Bloger {
    private int result;
    private String result_message;
    private List<ResultObjectBean> result_object;

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

    public List<ResultObjectBean> getResult_object() {
        return result_object;
    }

    public void setResult_object(List<ResultObjectBean> result_object) {
        this.result_object = result_object;
    }

    public static class ResultObjectBean implements Parcelable {
        /**
         * Bloger_ID : 1
         * Member_ID : 3753
         * Bloger_Name : 我是劉太太。寫露營寫生活
         * Bloger_HeadImg : https://campimages.blob.core.windows.net/images/Bloger/20170414070812739.png
         * isTrace : false
         * ArticleCount : 186
         */

        private int Bloger_ID;
        private int Member_ID;
        private String Bloger_Name;
        private String Bloger_HeadImg;
        private boolean isTrace;
        private int ArticleCount;

        public ResultObjectBean(int bloger_ID, int member_ID, String bloger_Name, String bloger_HeadImg, boolean isTrace, int articleCount) {
            Bloger_ID = bloger_ID;
            Member_ID = member_ID;
            Bloger_Name = bloger_Name;
            Bloger_HeadImg = bloger_HeadImg;
            this.isTrace = isTrace;
            ArticleCount = articleCount;
        }

        protected ResultObjectBean(Parcel in) {
            Bloger_ID = in.readInt();
            Member_ID = in.readInt();
            Bloger_Name = in.readString();
            Bloger_HeadImg = in.readString();
            isTrace = in.readByte() != 0;
            ArticleCount = in.readInt();
        }

        public static final Creator<ResultObjectBean> CREATOR = new Creator<ResultObjectBean>() {
            @Override
            public ResultObjectBean createFromParcel(Parcel in) {
                return new ResultObjectBean(in);
            }

            @Override
            public ResultObjectBean[] newArray(int size) {
                return new ResultObjectBean[size];
            }
        };

        public int getBloger_ID() {
            return Bloger_ID;
        }

        public void setBloger_ID(int Bloger_ID) {
            this.Bloger_ID = Bloger_ID;
        }

        public int getMember_ID() {
            return Member_ID;
        }

        public void setMember_ID(int Member_ID) {
            this.Member_ID = Member_ID;
        }

        public String getBloger_Name() {
            return Bloger_Name;
        }

        public void setBloger_Name(String Bloger_Name) {
            this.Bloger_Name = Bloger_Name;
        }

        public String getBloger_HeadImg() {
            return Bloger_HeadImg;
        }

        public void setBloger_HeadImg(String Bloger_HeadImg) {
            this.Bloger_HeadImg = Bloger_HeadImg;
        }

        public boolean isIsTrace() {
            return isTrace;
        }

        public void setIsTrace(boolean isTrace) {
            this.isTrace = isTrace;
        }

        public int getArticleCount() {
            return ArticleCount;
        }

        public void setArticleCount(int ArticleCount) {
            this.ArticleCount = ArticleCount;
        }

        @Override
        public String toString() {
            return "ResultObjectBean{" +
                    "Bloger_ID=" + Bloger_ID +
                    ", Member_ID=" + Member_ID +
                    ", Bloger_Name='" + Bloger_Name + '\'' +
                    ", Bloger_HeadImg='" + Bloger_HeadImg + '\'' +
                    ", isTrace=" + isTrace +
                    ", ArticleCount=" + ArticleCount +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(Bloger_ID);
            parcel.writeInt(Member_ID);
            parcel.writeString(Bloger_Name);
            parcel.writeString(Bloger_HeadImg);
            parcel.writeByte((byte) (isTrace ? 1 : 0));
            parcel.writeInt(ArticleCount);
        }
    }

    @Override
    public String toString() {
        return "Bloger{" +
                "result=" + result +
                ", result_message='" + result_message + '\'' +
                ", result_object=" + result_object +
                '}';
    }
}
