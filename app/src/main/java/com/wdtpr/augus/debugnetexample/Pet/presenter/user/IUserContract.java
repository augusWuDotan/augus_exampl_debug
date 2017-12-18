package com.wdtpr.augus.debugnetexample.Pet.presenter.user;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.UserInfo;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;
import com.wdtpr.augus.debugnetexample.base.IBasePresenter;
import com.wdtpr.augus.debugnetexample.base.IBaseView;

import java.util.List;

/**
 * Created by augus on 2017/12/13.
 * User
 */

public interface IUserContract {

    interface UserView extends IBaseView {

        void registSuccess(registBackBean registBackBean);

        void registFail();

        void loginSuccess(UserInfo userInfo);

        void loginFail();
    }

    interface Presnter extends IBasePresenter {

        void POSTCustomerRegist(String email, String name, String password, String password_confirmation, String address,
                                String phone, String mobile, String birthday);

        void POSTLogin(String email, String password);
    }
}
