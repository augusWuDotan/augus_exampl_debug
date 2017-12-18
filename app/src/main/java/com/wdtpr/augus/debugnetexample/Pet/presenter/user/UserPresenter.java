package com.wdtpr.augus.debugnetexample.Pet.presenter.user;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.UserInfo;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.user.IUserModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.user.UserModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

/**
 * Created by augus on 2017/12/13.
 */

public class UserPresenter extends BasePresenter implements IUserContract.Presnter {

    private IUserContract.UserView userView;//對view互動
    private UserModel userModel;//對presenter互動

    public UserPresenter(IUserContract.UserView userView) {
        this.userView = userView;
        userModel = new UserModel(userStateListener);
    }

    public  IUserModel.UserStateListener userStateListener = new IUserModel.UserStateListener() {
        @Override
        public void onStart() {
            userView.showLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            userView.showUnknowError(errorStr);
        }

        @Override
        public void onComplete() {
            userView.hideLoading();
        }

        @Override
        public void registSuccess(registBackBean registBackBean) {
            userView.registSuccess(registBackBean);
        }

        @Override
        public void registFail() {
            userView.registFail();
        }

        @Override
        public void loginSuccess(UserInfo userInfo) {
            userView.loginSuccess(userInfo);
        }

        @Override
        public void loginFail() {
            userView.loginFail();
        }
    };

    @Override
    public void unsubscribe() {
        userModel.unsubscribe();
        userModel = null;
        userView = null;
    }

    @Override
    public void POSTCustomerRegist(String email, String name, String password, String password_confirmation,
                                   String address, String phone, String mobile, String birthday) {
        userModel.POSTCustomerRegist(email,name,password,password_confirmation,address,phone,mobile,birthday);
    }

    @Override
    public void POSTLogin(String email, String password) {
        userModel.POSTLogin(email,password);
    }
}
