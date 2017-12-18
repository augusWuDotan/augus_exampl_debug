package com.wdtpr.augus.debugnetexample.Pet.model.source.user;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.UserAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.UserInfo;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/3.
 */

public class UserModel extends BaseModel implements IUserModel {

    private IUserModel.UserStateListener userStateListener;

    public UserModel(UserStateListener userStateListener) {
        this.userStateListener = userStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        userStateListener = null;
    }

    @Override
    public void POSTCustomerRegist(String email, String name, String password, String password_confirmation, String address, String phone, String mobile, String birthday) {
        if (userStateListener == null) return;
        userStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(UserAPI.class).POSTCustomerRegist(email, name, password, password_confirmation, address, phone, mobile, birthday)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<registBackBean>>() {
                    @Override
                    public void onNext(Result<registBackBean> registBackBeanResult) {
                        final int responseCode = registBackBeanResult.response().code();
                        if (responseCode == 200) {
                            registBackBean bean = registBackBeanResult.response().body();
                            userStateListener.registSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) userStateListener.onUnknowError(errorStr);
                            else userStateListener.registFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        userStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        userStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTLogin(String email, String password) {
        if (userStateListener == null) return;
        userStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(UserAPI.class).POSTLogin(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<UserInfo>>() {
                    @Override
                    public void onNext(Result<UserInfo> userInfoResult) {

                        final int responseCode = userInfoResult.response().code();
                        if (responseCode == 200) {
                            UserInfo bean = userInfoResult.response().body();
                            userStateListener.loginSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) userStateListener.onUnknowError(errorStr);
                            else userStateListener.loginFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        Log.d("POSTLogin e", t.toString());
                        userStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        userStateListener.onComplete();
                    }
                }));
    }
}
