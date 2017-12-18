package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/5.
 */

public class SourceMember implements Serializable {
       /*
              {
          "Member_ID": 14,
          "Member_Name": "邱馬克",
          "Member_HeadImg": "https://campimages.blob.core.windows.net/images/member/20171003120546053.jpg",
          "Member_Action": "標註",
          "Comment": null,
          "CommentTime": "0001-01-01T00:00:00"
        },
             */

    private String Member_ID;
    private String Member_Name;
    private String Member_HeadImg; //img avatar url
    private String Member_Action;//附加狀態 「留言 > 推薦 > 標註」
    private String Comment; //留言狀態的 「內容」
    private String CommentTime; //此狀態的啟動時間

    public String getMember_ID() {
        return Member_ID;
    }

    public void setMember_ID(String member_ID) {
        Member_ID = member_ID;
    }

    public String getMember_Name() {
        return Member_Name;
    }

    public void setMember_Name(String member_Name) {
        Member_Name = member_Name;
    }

    public String getMember_HeadImg() {
        return Member_HeadImg;
    }

    public void setMember_HeadImg(String member_HeadImg) {
        Member_HeadImg = member_HeadImg;
    }

    public String getMember_Action() {
        return Member_Action;
    }

    public void setMember_Action(String member_Action) {
        Member_Action = member_Action;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getCommentTime() {
        return CommentTime;
    }

    public void setCommentTime(String commentTime) {
        CommentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Source_members{" +
                "Member_ID='" + Member_ID + '\'' +
                ", Member_Name='" + Member_Name + '\'' +
                ", Member_HeadImg='" + Member_HeadImg + '\'' +
                ", Member_Action='" + Member_Action + '\'' +
                ", Comment='" + Comment + '\'' +
                ", CommentTime='" + CommentTime + '\'' +
                '}';
    }
}
