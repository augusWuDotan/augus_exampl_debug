package com.wdtpr.augus.debugnetexample.facebook.Model.source.login;

import android.os.Bundle;

import com.wdtpr.augus.debugnetexample.facebook.Model.bean.in.FBLoginProfile.LoginUser;

/**
 * Created by augus on 2017/12/15.
 */

public interface IFbLoginModel {

    interface LoginListener{

        void onStart();

        void LoginSucess(LoginUser loginUser);

        void onUnknowError(String errorStr);

        void onComplete();
    }

    void FaceBooklogin(Bundle bundle);

}
