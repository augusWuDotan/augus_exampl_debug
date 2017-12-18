package com.wdtpr.augus.debugnetexample.Pet.model.source.sns;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.snsAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSNotReadBean;
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

public class SNSModel extends BaseModel implements ISNSModel {

    private ISNSModel.SNSStateListener snsStateListener;

    public SNSModel(SNSStateListener snsStateListener) {
        this.snsStateListener = snsStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        snsStateListener = null;
    }

    @Override
    public void DeleteSNS(String Authorization) {
        if (snsStateListener == null) return;
        snsStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(snsAPI.class).DeleteSNS("Bearer " + Authorization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<SNSCallbackBean>>() {
                    @Override
                    public void onNext(Result<SNSCallbackBean> snsCallbackBeanResult) {
                        //
                        final int responseCode = snsCallbackBeanResult.response().code();
                        if (responseCode == 200) {
                            SNSCallbackBean bean = snsCallbackBeanResult.response().body();
                            snsStateListener.DeleteSNSSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                snsStateListener.onUnknowError(errorStr);
                            else snsStateListener.SNSFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        snsStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        snsStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTSNS(String Authorization, String token, String endpoint_device) {
        if (snsStateListener == null) return;
        snsStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(snsAPI.class).POSTSNS("Bearer " + Authorization, token, endpoint_device)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<SNSCallbackBean>>() {
                    @Override
                    public void onNext(Result<SNSCallbackBean> snsCallbackBeanResult) {
                        //
                        final int responseCode = snsCallbackBeanResult.response().code();
                        if (responseCode == 200) {
                            SNSCallbackBean bean = snsCallbackBeanResult.response().body();
                            snsStateListener.POSTSNSSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                snsStateListener.onUnknowError(errorStr);
                            else snsStateListener.SNSFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        snsStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        snsStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTSendAll(String Authorization, String message) {
        if (snsStateListener == null) return;
        snsStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(snsAPI.class).POSTSendAll("Bearer " + Authorization, message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            snsStateListener.POSTSendAllSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                snsStateListener.onUnknowError(errorStr);
                            else snsStateListener.SNSFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        snsStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        snsStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTSendOne(String Authorization, String customerId, String message) {
        if (snsStateListener == null) return;
        snsStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(snsAPI.class).POSTSendOne("Bearer " + Authorization, customerId, message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            snsStateListener.POSTSendOneSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                snsStateListener.onUnknowError(errorStr);
                            else snsStateListener.SNSFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        snsStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        snsStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void GETSNS(String Authorization) {
        if (snsStateListener == null) return;
        snsStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(snsAPI.class).GETSNS("Bearer " + Authorization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<SNSListBean>>() {
                    @Override
                    public void onNext(Result<SNSListBean> snsListBeanResult) {
                        //
                        final int responseCode = snsListBeanResult.response().code();
                        if (responseCode == 200) {
                            SNSListBean bean = snsListBeanResult.response().body();
                            snsStateListener.GETSNSSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                snsStateListener.onUnknowError(errorStr);
                            else snsStateListener.SNSFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        snsStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        snsStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void GETSNSNotReadCount(String Authorization) {
        if (snsStateListener == null) return;
        snsStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(snsAPI.class).GETSNSNotReadCount("Bearer " + Authorization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<SNSNotReadBean>>() {
                    @Override
                    public void onNext(Result<SNSNotReadBean> snsNotReadBeanResult) {
                        //
                        final int responseCode = snsNotReadBeanResult.response().code();
                        if (responseCode == 200) {
                            SNSNotReadBean bean = snsNotReadBeanResult.response().body();
                            snsStateListener.GETSNSNotReadCountSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                snsStateListener.onUnknowError(errorStr);
                            else snsStateListener.SNSFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        snsStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        snsStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void GETSNSForId(String Authorization, int snsLogId) {
        if (snsStateListener == null) return;
        snsStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(snsAPI.class).GETSNSForId("Bearer " + Authorization, snsLogId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<SNSDetailBean>>() {
                    @Override
                    public void onNext(Result<SNSDetailBean> snsDetailBeanResult) {
                        //
                        final int responseCode = snsDetailBeanResult.response().code();
                        if (responseCode == 200) {
                            SNSDetailBean bean = snsDetailBeanResult.response().body();
                            snsStateListener.GETSNSForIdSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                snsStateListener.onUnknowError(errorStr);
                            else snsStateListener.SNSFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        snsStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        snsStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void POSTChangeSNSReadStatus(String Authorization, int snsLogId) {
        if (snsStateListener == null) return;
        snsStateListener.onStart();

        disposableManager.add(RetrofitHelper_Pet.instance().create(snsAPI.class).POSTChangeSNSReadStatus("Bearer " + Authorization, snsLogId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            snsStateListener.POSTChangeSNSReadStatusSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                snsStateListener.onUnknowError(errorStr);
                            else snsStateListener.SNSFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        snsStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        snsStateListener.onComplete();
                    }
                }));

    }

}
