package com.wdtpr.augus.debugnetexample.camplay.model.bean.source.dynamic;

import android.util.Log;

import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.ServerToken;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.bloger.Bloger;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.GraffitiDynamic_;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.dynamic.GraffitiDynamic_ob;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.order.OrderCallBack;
import com.wdtpr.augus.debugnetexample.camplay.model.bean.in.order.ProductOrderBean;
import com.wdtpr.augus.debugnetexample.camplay.network.RetrofitHelper;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/5.
 */

public class DynamicModel extends BaseModel implements IDynamicModel {

    @Override
    public void GetActiveMessage(String token, String accountToken, int Member_ID, int PageNum) {
        //
        disposableManager.add(RetrofitHelper.instance().create().GetActiveMessage1(token, accountToken, Member_ID, PageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<GraffitiDynamic_>() {

                    @Override
                    public void onNext(GraffitiDynamic_ graffitiDynamic_) {
                        Log.d("GetActiveMessage b", graffitiDynamic_.toString());
                        Log.d("GetActiveMessage b", graffitiDynamic_.getResult_object().size()+"");
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        Log.d("GetActiveMessage e", t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
    }

    @Override
    public void GetActiveMessageByBloger(String token, String accountToken, int Member_ID, int PageNum, int Bloger_ID) {

        disposableManager.add(RetrofitHelper.instance().create().GetActiveMessageByBloger(token, accountToken, Member_ID, PageNum,Bloger_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<GraffitiDynamic_>() {

                    @Override
                    public void onNext(GraffitiDynamic_ graffitiDynamic_) {
                        Log.d("GAMbloger b", graffitiDynamic_.toString());
                        Log.d("GAMbloger b", graffitiDynamic_.getResult_object().size()+"");
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        Log.d("GAMbloger e", t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
    }

    @Override
    public void GetActiveMessageByActiveID(String token, String accountToken, int Member_ID, int Active_ID) {
        //
        disposableManager.add(RetrofitHelper.instance().create().GetActiveMessageByActiveID(token, accountToken, Member_ID, Active_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<GraffitiDynamic_ob>() {

                    @Override
                    public void onNext(GraffitiDynamic_ob graffitiDynamic_) {
                        Log.d("gamByActiveID b", graffitiDynamic_.toString());
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        Log.d("gamByActiveID e", t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
    }

    @Override
    public void AddOrder(String token,String AccessToken, ProductOrderBean bean) {
        //
        disposableManager.add(RetrofitHelper.instance().create().AddOrder(token, AccessToken, bean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<OrderCallBack>() {

                    @Override
                    public void onNext(OrderCallBack orderCallBack) {
                        Log.d("OrderCallBack b", orderCallBack.toString());
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        Log.d("gamByActiveID e", t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
    }

    @Override
    public void getDynamicAndBloger(String token, String accountToken, int PageNum, int Member_ID) {
        disposableManager.add(Flowable.zip(DynamicFlowable(token,accountToken, PageNum, Member_ID), BlogerFlowable(token,accountToken, Member_ID),
                new BiFunction<GraffitiDynamic_, Bloger, List<Object>>() {
                    @Override
                    public List<Object> apply(@NonNull GraffitiDynamic_ graffitiDynamic_, @NonNull Bloger bloger) throws Exception {

                        List<Object> list = new ArrayList<>(2);
                        list.add(graffitiDynamic_);
//                        list.add(bloger);
//                        //
                        Bloger mbloger = new Bloger();
                        mbloger.setResult(bloger.getResult());
                        mbloger.setResult_message(bloger.getResult_message());
                        List<Bloger.ResultObjectBean> beans = new ArrayList<Bloger.ResultObjectBean>();
                        for (Bloger.ResultObjectBean bean : bloger.getResult_object()) {
                            if (bean.isIsTrace()) {
                                beans.add(bean);
                            }
                        }
                        mbloger.setResult_object(beans);
                        list.add(mbloger);
                        return list;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<List<Object>>() {
                    @Override
                    public void onNext(List<Object> list) {
//                        boolean isCanLoad = ((GraffitiDynamic_) list.get(0)).getResult() == ((GraffitiDynamic_) list.get(0)).getResult_object().size();
                        if (list.size() > 0) {
                            Log.d("GraffitiDynamic_",((GraffitiDynamic_) list.get(0)).getResult_object().size()+"");
                            Log.d("bloger",((Bloger) list.get(1)).getResult_object().size()+"");

                        } else {

                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));

    }

    //動態
    private Flowable<GraffitiDynamic_> DynamicFlowable(final String token,final String AccessToken, final int PageNum, final int Member_ID) {
        //
        return RetrofitHelper.instance().create().GetActiveMessage(token, AccessToken, Member_ID, PageNum).subscribeOn(Schedulers.io());

    }

    //部落客
    private Flowable<Bloger> BlogerFlowable(final String token,final String AccessToken, final int Member_ID) {

        return RetrofitHelper.instance().create().getAllBloger(token, AccessToken, Member_ID).subscribeOn(Schedulers.io());
    }

}
