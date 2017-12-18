package com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.FBLoginProfile;

import com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base.FbCover;
import com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base.FbFriendLists;
import com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base.FbFriendsDetail;
import com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.base.FbPictureDetail;

import java.io.Serializable;
import java.util.List;

/**
 * Created by augus on 2017/12/15.
 */

public class LoginUser implements Serializable {

    private String id;
    private String name;
    private String email;
    private FbFriendLists friends ;
    private FbCover cover;
    private FbPictureDetail picture;

    @Override
    public String toString() {
        return "LoginUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", friends=" + friends +
                ", cover=" + cover +
                ", picture=" + picture +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FbFriendLists getFriends() {
        return friends;
    }

    public void setFriends(FbFriendLists friends) {
        this.friends = friends;
    }

    public FbCover getCover() {
        return cover;
    }

    public void setCover(FbCover cover) {
        this.cover = cover;
    }

    public FbPictureDetail getPicture() {
        return picture;
    }

    public void setPicture(FbPictureDetail picture) {
        this.picture = picture;
    }
}
