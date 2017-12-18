package com.wdtpr.augus.debugnetexample.Pet.model.source.card;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.CardAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.PointCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/10.
 */

public class CardModel extends BaseModel implements ICardModel {

    private ICardModel.CardStateListener cardStateListener;

    public CardModel(CardStateListener cardStateListener) {
        this.cardStateListener = cardStateListener;

    }

    public void unsubscribe() {
        disposableManager.clear();
        cardStateListener = null;
    }

    @Override
    public void GETCustomerPetCardList(String Authorization, int customer_id, int store_id) {
        if (cardStateListener == null) return;
        cardStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CardAPI.class).GETCustomerPetCardList("Bearer " + Authorization, customer_id, store_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<CardListBean>>() {
                    @Override
                    public void onNext(Result<CardListBean> cardListBeanResult) {
                        //
                        final int responseCode = cardListBeanResult.response().code();
                        if (responseCode == 200) {
                            CardListBean bean = cardListBeanResult.response().body();
                            cardStateListener.GETCustomerPetCardList(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                cardStateListener.onUnknowError(errorStr);
                            else cardStateListener.CardFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        cardStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        cardStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void GETPetCardDetail(String Authorization, int pet_id, int store_id) {
        if (cardStateListener == null) return;
        cardStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CardAPI.class).GETPetCardDetail("Bearer " + Authorization, pet_id, store_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<CardDetailBean>>() {
                    @Override
                    public void onNext(Result<CardDetailBean> cardDetailBeanResult) {
                        //
                        final int responseCode = cardDetailBeanResult.response().code();
                        if (responseCode == 200) {
                            CardDetailBean bean = cardDetailBeanResult.response().body();
                            cardStateListener.GETPetCardDetail(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                cardStateListener.onUnknowError(errorStr);
                            else cardStateListener.CardFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        cardStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        cardStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTPetCard(String Authorization, int pet_id, int store_id, String title, int cost, int point_count) {
        if (cardStateListener == null) return;
        cardStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CardAPI.class).POSTPetCard("Bearer " + Authorization, pet_id, store_id, title, cost, point_count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<CardCreateCallbackBean>>() {
                    @Override
                    public void onNext(Result<CardCreateCallbackBean> cardCreateCallbackBeanResult) {
                        //
                        final int responseCode = cardCreateCallbackBeanResult.response().code();
                        if (responseCode == 200) {
                            CardCreateCallbackBean bean = cardCreateCallbackBeanResult.response().body();
                            cardStateListener.POSTPetCard(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                cardStateListener.onUnknowError(errorStr);
                            else cardStateListener.CardFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        cardStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        cardStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void PUTPetCard(String Authorization, int card_id, String title, int cost) {
        if (cardStateListener == null) return;
        cardStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CardAPI.class).PUTPetCard("Bearer " + Authorization, card_id, title, cost)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            cardStateListener.PUTPetCard(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                cardStateListener.onUnknowError(errorStr);
                            else cardStateListener.CardFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        cardStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        cardStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void PUTCardBindAccount(String Authorization, int card_id, int account_id) {
        if (cardStateListener == null) return;
        cardStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CardAPI.class).PUTCardBindAccount("Bearer " + Authorization, card_id, account_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            cardStateListener.PUTCardBindAccount(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                cardStateListener.onUnknowError(errorStr);
                            else cardStateListener.CardFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        cardStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        cardStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTCardPoint(String Authorization, int card_id, String service) {
        if (cardStateListener == null) return;
        cardStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CardAPI.class).POSTCardPoint("Bearer " + Authorization, card_id, service)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<PointCreateCallbackBean>>() {
                    @Override
                    public void onNext(Result<PointCreateCallbackBean> pointCreateCallbackBeanResult) {
                        //
                        final int responseCode = pointCreateCallbackBeanResult.response().code();
                        if (responseCode == 200) {
                            PointCreateCallbackBean bean = pointCreateCallbackBeanResult.response().body();
                            cardStateListener.POSTCardPoint(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                cardStateListener.onUnknowError(errorStr);
                            else cardStateListener.CardFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        cardStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        cardStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void DeleteCardPoint(String Authorization, int Point_Id) {
        if (cardStateListener == null) return;
        cardStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(CardAPI.class).DeleteCardPoint("Bearer " + Authorization, Point_Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            cardStateListener.DeleteCardPoint(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                cardStateListener.onUnknowError(errorStr);
                            else cardStateListener.CardFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        cardStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        cardStateListener.onComplete();
                    }
                }));
    }
}
