package com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns;

import java.io.Serializable;

/**
 * Created by augus on 2017/12/7.
 */

public class SNSBean implements Serializable {
    /*
    {
      "id": 372,
      "user_id": 17,
      "sns_category": "message",
      "is_read": 0,
      "title": "你有最新訊息",
      "content": "Hello World !!",
      "created_at": "2017-12-07 00:32:20"
    }
     */

    private int id;
    private int user_id;
    private String sns_category;
    private int is_read;
    private String title;
    private String content;
    private String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getSns_category() {
        return sns_category;
    }

    public void setSns_category(String sns_category) {
        this.sns_category = sns_category;
    }

    public int getIs_read() {
        return is_read;
    }

    public void setIs_read(int is_read) {
        this.is_read = is_read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "SNSBean{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", sns_category='" + sns_category + '\'' +
                ", is_read=" + is_read +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
