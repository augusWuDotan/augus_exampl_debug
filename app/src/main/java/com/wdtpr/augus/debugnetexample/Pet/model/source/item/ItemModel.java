package com.wdtpr.augus.debugnetexample.Pet.model.source.item;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.ItemAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemListBean;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/6.
 */

public class ItemModel extends BaseModel implements IItemModel {

    private IItemModel.ItemStateListener itemStateListener;

    public ItemModel(ItemStateListener itemStateListener) {
        this.itemStateListener = itemStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        itemStateListener = null;
    }


    @Override
    public void GETItemList(String Authorization) {
        if (itemStateListener == null) return;
        itemStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(ItemAPI.class)
                .GETItemList("Bearer " + Authorization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<ItemListBean>>() {
                    @Override
                    public void onNext(Result<ItemListBean> itemListBeanResult) {
                        //
                        final int responseCode = itemListBeanResult.response().code();
                        if (responseCode == 200) {
                            ItemListBean bean = itemListBeanResult.response().body();
                            itemStateListener.GETItemListSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                itemStateListener.onUnknowError(errorStr);
                            else itemStateListener.ItemFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        itemStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        itemStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTItem(String Authorization, int Store_Id, String title, int cost) {
        if (itemStateListener == null) return;
        itemStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(ItemAPI.class)
                .POSTItem("Bearer " + Authorization, Store_Id, title, cost)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<ItemCallbackBean>>() {
                    @Override
                    public void onNext(Result<ItemCallbackBean> itemCallbackBeanResult) {
                        //
                        final int responseCode = itemCallbackBeanResult.response().code();
                        if (responseCode == 200) {
                            ItemCallbackBean bean = itemCallbackBeanResult.response().body();
                            itemStateListener.POSTItemSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                itemStateListener.onUnknowError(errorStr);
                            else itemStateListener.ItemFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        itemStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        itemStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void PUTItem(String Authorization, int Item_Id, String title, int cost) {
        if (itemStateListener == null) return;
        itemStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(ItemAPI.class)
                .PUTItem("Bearer " + Authorization, Item_Id, title, cost)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            itemStateListener.PUTItemSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                itemStateListener.onUnknowError(errorStr);
                            else itemStateListener.ItemFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        itemStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        itemStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void DeleteItem(String Authorization, int Item_Id) {
        if (itemStateListener == null) return;
        itemStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(ItemAPI.class)
                .DeleteItem("Bearer " + Authorization, Item_Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            itemStateListener.DeleteItemSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                itemStateListener.onUnknowError(errorStr);
                            else itemStateListener.ItemFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        itemStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        itemStateListener.onComplete();
                    }
                }));
    }
}
