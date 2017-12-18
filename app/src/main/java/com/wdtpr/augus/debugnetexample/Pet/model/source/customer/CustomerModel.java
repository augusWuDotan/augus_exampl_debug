package com.wdtpr.augus.debugnetexample.Pet.model.source.customer;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.CustomerAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreListBean;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/3.
 */

public class CustomerModel extends BaseModel implements ICustomerModel {

    private ICustomerModel.CustomerListener customerListener;

    public CustomerModel(CustomerListener customerListener) {
        this.customerListener = customerListener;
    }

    public void unsubscribe(){
        disposableManager.clear();
        customerListener = null;
    }

    @Override
    public void GETCustomerList(String Authorization) {
        if (customerListener == null) return;
        customerListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CustomerAPI.class).GETCustomerList("Bearer " + Authorization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<CustomerListBean>>() {
                    @Override
                    public void onNext(Result<CustomerListBean> customerListBeanResult) {
                        //
                        final int responseCode = customerListBeanResult.response().code();
                        if (responseCode == 200) {
                            CustomerListBean bean = customerListBeanResult.response().body();
                            customerListener.GetCustomerListSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (errorStr.equals("")) customerListener.onUnknowError(errorStr);
                            else customerListener.customerFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        customerListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        customerListener.onComplete();
                    }
                })

        );

    }

    @Override
    public void GETCustomerDetail(String Authorization, int Customer_Id) {
        if (customerListener == null) return;
        customerListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CustomerAPI.class).GETCustomerDetail("Bearer " + Authorization, Customer_Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<CustomerDetailBean>>() {
                    @Override
                    public void onNext(Result<CustomerDetailBean> customerDetailBeanResult) {
                        //
                        final int responseCode = customerDetailBeanResult.response().code();
                        if (responseCode == 200) {
                            CustomerDetailBean bean = customerDetailBeanResult.response().body();
                            customerListener.GETCustomerDetailSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (errorStr.equals("")) customerListener.onUnknowError(errorStr);
                            else customerListener.customerFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        customerListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        customerListener.onComplete();
                    }
                })

        );

    }

    @Override
    public void PUTCustomerDetail(String Authorization, int Customer_Id, int representative_pet_id, String address, String customer_number, String phone, String mobile, String description) {
        if (customerListener == null) return;
        customerListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CustomerAPI.class).PUTStoreDetail("Bearer " + Authorization, Customer_Id, representative_pet_id, address, customer_number, phone, mobile, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            customerListener.PUTCustomerDetailSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (errorStr.equals("")) customerListener.onUnknowError(errorStr);
                            else customerListener.customerFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        customerListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        customerListener.onComplete();
                    }
                })

        );

    }

    @Override
    public void POSTCustomerAvatar(String Authorization, int Customer_Id, MultipartBody.Part avatar) {
        if (customerListener == null) return;
        customerListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CustomerAPI.class).POSTCustomerAvatar("Bearer " + Authorization, Customer_Id, avatar)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            customerListener.POSTCustomerAvatarSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (errorStr.equals("")) customerListener.onUnknowError(errorStr);
                            else customerListener.customerFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        customerListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        customerListener.onComplete();
                    }
                })

        );


    }

    @Override
    public void POSTCustomerBindStore(String Authorization, int Customer_Id, String StoreMail) {
        if (customerListener == null) return;
        customerListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CustomerAPI.class).POSTCustomerBindStore("Bearer " + Authorization, Customer_Id, StoreMail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            customerListener.POSTCustomerBindStoreSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (errorStr.equals("")) customerListener.onUnknowError(errorStr);
                            else customerListener.customerFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        customerListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        customerListener.onComplete();
                    }
                })

        );
    }
}
