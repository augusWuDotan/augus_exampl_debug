package com.wdtpr.augus.debugnetexample.Pet.model.source.account;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.AccountAPI;
import com.wdtpr.augus.debugnetexample.Pet.api.CalendarAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountListBean;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/10.
 */

public class AccountModel extends BaseModel implements IAccountModel {

    private IAccountModel.AccountStateListener accountStateListener;

    public AccountModel(AccountStateListener accountStateListener) {
        this.accountStateListener = accountStateListener;
    }

    public void unsubscribe(){
        disposableManager.clear();
        accountStateListener =null;
    }

    @Override
    public void GETAccount(String Authorization, int Store_id, String start_date, String end_date) {
        if(accountStateListener == null) return;
        accountStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AccountAPI.class).GETAccount("Bearer "+Authorization,Store_id,start_date,end_date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AccountListBean>>(){
                    @Override
                    public void onNext(Result<AccountListBean> accountListBeanResult) {
                        //
                        final int responseCode = accountListBeanResult.response().code();
                        if(responseCode == 200){
                            AccountListBean bean = accountListBeanResult.response().body();
                            accountStateListener.GETAccountSuccess(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                accountStateListener.onUnknowError(errorStr);
                            else accountStateListener.AccountFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        Log.d("AccountModel e",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));

    }

    @Override
    public void POSTAccount(String Authorization, int Store_id, int customer_id, String date, String title, String description, int cost) {
        if(accountStateListener == null) return;
        accountStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AccountAPI.class).
                POSTAccount("Bearer "+Authorization,Store_id,customer_id,date,title,description,cost)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AccountCallBackBean>>(){
                    @Override
                    public void onNext(Result<AccountCallBackBean> accountCallBackBeanResult) {
                        //
                        final int responseCode = accountCallBackBeanResult.response().code();
                        if(responseCode == 200){
                            AccountCallBackBean bean = accountCallBackBeanResult.response().body();
                            accountStateListener.POSTAccountSuccess(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                accountStateListener.onUnknowError(errorStr);
                            else accountStateListener.AccountFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        accountStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        accountStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void GETAccountCustomer(String Authorization, int customer_id, String start_date, String end_date) {
        if(accountStateListener == null) return;
        accountStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AccountAPI.class).GETAccountCustomer("Bearer "+Authorization,customer_id,start_date,end_date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AccountListBean>>(){
                    @Override
                    public void onNext(Result<AccountListBean> accountListBeanResult) {
                        //
                        final int responseCode = accountListBeanResult.response().code();
                        if(responseCode == 200){
                            AccountListBean bean = accountListBeanResult.response().body();
                            accountStateListener.GETAccountCustomerSuccess(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                accountStateListener.onUnknowError(errorStr);
                            else accountStateListener.AccountFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        accountStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        accountStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void PUTAccount(String Authorization, int account_id, int customer_id, String title, String description, int cost) {
        if(accountStateListener == null) return;
        accountStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AccountAPI.class).PUTAccount("Bearer "+Authorization,account_id,customer_id,title,description,cost)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>(){
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if(responseCode == 200){
                            Status bean = statusResult.response().body();
                            accountStateListener.PUTAccountSuccess(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                accountStateListener.onUnknowError(errorStr);
                            else accountStateListener.AccountFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        accountStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        accountStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void DeleteAccount(String Authorization, int account_id) {
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AccountAPI.class).DeleteAccount("Bearer "+Authorization,account_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>(){
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if(responseCode == 200){
                            Status bean = statusResult.response().body();
                            accountStateListener.DeleteAccountSuccess(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                accountStateListener.onUnknowError(errorStr);
                            else accountStateListener.AccountFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        accountStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        accountStateListener.onComplete();
                    }
                }));
    }
}
