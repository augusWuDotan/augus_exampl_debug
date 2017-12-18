package com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.childBean;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/5.
 * 評論
 */

public class Comment implements Serializable {
    //
    /*
            "COMMENTNUM": {
                    "CommentStars": 0,
                    "CommentContent": "test content",
                    "CommentImage": null,
                    "CommentTime": "2017-10-13T09:43:00"
                }
             */
    private String CommentStars;// 評比星星
    private String CommentContent;//評比內容
    private String CommentImage;//評論附帶的圖示「一張」
    private String CommentTime;//評論時間

    public String getCommentStars() {
        return CommentStars;
    }

    public void setCommentStars(String commentStars) {
        CommentStars = commentStars;
    }

    public String getCommentContent() {
        return CommentContent;
    }

    public void setCommentContent(String commentContent) {
        CommentContent = commentContent;
    }

    public String getCommentImage() {
        return CommentImage;
    }

    public void setCommentImage(String commentImage) {
        CommentImage = commentImage;
    }

    public String getCommentTime() {
        return CommentTime;
    }

    public void setCommentTime(String commentTime) {
        CommentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentStars='" + CommentStars + '\'' +
                ", CommentContent='" + CommentContent + '\'' +
                ", CommentImage='" + CommentImage + '\'' +
                ", CommentTime='" + CommentTime + '\'' +
                '}';
    }
}
