package com.wdtpr.augus.debugnetexample.Pet.model.source.user;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.UserInfo;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;

import java.util.List;

/**
 * Created by augus on 2017/12/3.
 */

public interface IUserModel {

    interface UserStateListener {
        void onStart();

        void onUnknowError(String errorStr);

        void onComplete();

        void registSuccess(registBackBean registBackBean);

        void registFail();

        void loginSuccess(UserInfo userInfo);

        void loginFail();
    }

    void POSTCustomerRegist(String email, String name, String password, String password_confirmation, String address,
                            String phone, String mobile, String birthday);

    void POSTLogin(String email, String password);
}
