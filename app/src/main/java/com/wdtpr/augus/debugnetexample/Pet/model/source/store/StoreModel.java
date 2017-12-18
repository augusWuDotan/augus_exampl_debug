package com.wdtpr.augus.debugnetexample.Pet.model.source.store;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.StoreAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Permission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.provider.ProviderListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.Store;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreAvatar;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreDetail;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outPermission;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/2.
 */

public class StoreModel extends BaseModel implements IStoreModel {

    private IStoreModel.StoreStateListener storeStateListener;

    public StoreModel(StoreStateListener storeStateListener) {
        this.storeStateListener = storeStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        storeStateListener = null;
    }

    @Override
    public void GETStoreList(String Authorization) {
        if (storeStateListener == null) return;
        storeStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(StoreAPI.class).GETStoreList("Bearer " + Authorization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<StoreListBean>>() {
                    @Override
                    public void onNext(Result<StoreListBean> storeListBean) {
                        final int responseCode = storeListBean.response().code();
                        if (responseCode == 200) {
                            StoreListBean bean = storeListBean.response().body();
                            storeStateListener.GETStoreListSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) storeStateListener.onUnknowError(errorStr);
                            else storeStateListener.storeFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        storeStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        storeStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void GETStoreDetail(String Authorization, int Store_Id) {
        if (storeStateListener == null) return;
        storeStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(StoreAPI.class).GETStoreDetail("Bearer " + Authorization, Store_Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<StoreDetail>>() {
                    @Override
                    public void onNext(Result<StoreDetail> storeDetail) {
                        final int responseCode = storeDetail.response().code();
                        if (responseCode == 200) {
                            StoreDetail bean = storeDetail.response().body();
                            storeStateListener.GETStoreDetailSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) storeStateListener.onUnknowError(errorStr);
                            else storeStateListener.storeFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        storeStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        storeStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void PUTStoreDetail(String Authorization, int Store_Id, Store store) {
        if (storeStateListener == null) return;
        storeStateListener.onStart();
        //store
        disposableManager.add(RetrofitHelper_Pet.instance().create(StoreAPI.class).PUTStoreDetail("Bearer " + Authorization, Store_Id, store.getName(), store.getOpen_time()
                , store.getAddress(), store.getWebsite(), store.getInstagram(), store.getFanpage(), store.getPhone(), store.getMobile(), store.getDescription())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> status) {
                        final int responseCode = status.response().code();
                        if (responseCode == 200) {
                            Status bean = status.response().body();
                            storeStateListener.PUTStoreDetailSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) storeStateListener.onUnknowError(errorStr);
                            else storeStateListener.storeFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        storeStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        storeStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void GETStoreAvatar(String Authorization, int Store_Id) {
       if(storeStateListener == null) return;
       storeStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(StoreAPI.class).GETStoreAvatar("Bearer " + Authorization, Store_Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<StoreAvatar>>() {
                    @Override
                    public void onNext(Result<StoreAvatar> avatarResult) {
                        final int responseCode = avatarResult.response().code();
                        if (responseCode == 200) {
                            StoreAvatar bean = avatarResult.response().body();
                            storeStateListener.GETStoreAvatarSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) storeStateListener.onUnknowError(errorStr);
                            else storeStateListener.storeFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        storeStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        storeStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void POSTStoreAvatar(String Authorization, int Store_Id, MultipartBody.Part avatar) {
        if(storeStateListener == null) return;
        storeStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(StoreAPI.class).POSTStoreAvatar("Bearer " + Authorization, Store_Id, avatar)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> status) {
                        final int responseCode = status.response().code();
                        if (responseCode == 200) {
                            Status bean = status.response().body();
                            storeStateListener.POSTStoreAvatarSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) storeStateListener.onUnknowError(errorStr);
                            else storeStateListener.storeFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        storeStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        storeStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void GETStoreProvider(String Authorization, int Store_Id) {
        if(storeStateListener == null) return;
        storeStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(StoreAPI.class).GETStoreProvider("Bearer " + Authorization, Store_Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<ProviderListBean>>() {
                    @Override
                    public void onNext(Result<ProviderListBean> providerListBean) {
                        final int responseCode = providerListBean.response().code();
                        if (responseCode == 200) {
                            ProviderListBean bean = providerListBean.response().body();
                            storeStateListener.GETStoreProviderSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) storeStateListener.onUnknowError(errorStr);
                            else storeStateListener.storeFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        storeStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        storeStateListener.onComplete();
                    }
                })

        );

    }

    @Override
    public void GetPermission(String Authorization, int Store_Id) {
        if(storeStateListener == null) return;
        storeStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(StoreAPI.class).GETPermission("Bearer " + Authorization, Store_Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Permission>>() {
                    @Override
                    public void onNext(Result<Permission> permission) {
                        final int responseCode = permission.response().code();
                        if (responseCode == 200) {
                            Permission bean = permission.response().body();
                            storeStateListener.GETPermissionSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) storeStateListener.onUnknowError(errorStr);
                            else storeStateListener.storeFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        storeStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        storeStateListener.onComplete();
                    }
                })

        );

    }

    @Override
    public void PostPermission(String Authorization, int Store_Id, outPermission permission) {
        if(storeStateListener == null) return;
        storeStateListener.onStart();
        disposableManager.add(RetrofitHelper_Pet.instance().create(StoreAPI.class).POSTPermission("Bearer " + Authorization, Store_Id, permission)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> status) {
                        final int responseCode = status.response().code();
                        if (responseCode == 200) {
                            Status bean = status.response().body();
                            storeStateListener.POSTPermissionSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) storeStateListener.onUnknowError(errorStr);
                            else storeStateListener.storeFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        storeStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        storeStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void POSTStoreBindCustomer(String Authorization, int Store_Id, String CustomerMail) {
        if(storeStateListener == null) return;
        storeStateListener.onStart();
        disposableManager.add(RetrofitHelper_Pet.instance().create(StoreAPI.class).POSTStoreBindCustomer("Bearer " + Authorization, Store_Id, CustomerMail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> status) {
                        final int responseCode = status.response().code();
                        if (responseCode == 200) {
                            Status bean = status.response().body();
                            storeStateListener.POSTStoreBindCustomerSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) storeStateListener.onUnknowError(errorStr);
                            else storeStateListener.storeFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        storeStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        storeStateListener.onComplete();
                    }
                })

        );
    }
}
