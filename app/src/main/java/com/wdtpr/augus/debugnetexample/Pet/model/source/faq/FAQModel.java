package com.wdtpr.augus.debugnetexample.Pet.model.source.faq;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.FaqAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQListBean;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/4.
 */

public class FAQModel extends BaseModel implements IFAQModel {

    private IFAQModel.FAQStateListener faqStateListener;

    public FAQModel(FAQStateListener faqStateListener) {
        this.faqStateListener = faqStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        faqStateListener = null;
    }

    @Override
    public void GETFAQList(String Authorization, int Store_Id, int page) {
        if (faqStateListener == null) return;
        faqStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(FaqAPI.class).GETFAQList("Bearer " + Authorization, Store_Id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<FAQListBean>>() {
                    @Override
                    public void onNext(Result<FAQListBean> faqListBeanResult) {
                        //
                        final int responseCode = faqListBeanResult.response().code();
                        if (responseCode == 200) {
                            FAQListBean bean = faqListBeanResult.response().body();
                            faqStateListener.GETFAQListSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                faqStateListener.onUnknowError(errorStr);
                            else faqStateListener.FAQFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        faqStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        faqStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTFAQ(String Authorization, int Store_Id, String question, String anwser) {
        if (faqStateListener == null) return;
        faqStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(FaqAPI.class).POSTFAQ("Bearer " + Authorization, Store_Id, question, anwser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<FAQCallbackBean>>() {
                    @Override
                    public void onNext(Result<FAQCallbackBean> faqCallbackBeanResult) {
                        //
                        final int responseCode = faqCallbackBeanResult.response().code();
                        if (responseCode == 200) {
                            FAQCallbackBean bean = faqCallbackBeanResult.response().body();
                            faqStateListener.POSTFAQSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                faqStateListener.onUnknowError(errorStr);
                            else faqStateListener.FAQFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        faqStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        faqStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void PUTFAQ(String Authorization, int FAQ_id, String question, String anwser) {
        if (faqStateListener == null) return;
        faqStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(FaqAPI.class).PUTFAQ("Bearer " + Authorization, FAQ_id, question, anwser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            faqStateListener.PUTFAQSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                faqStateListener.onUnknowError(errorStr);
                            else faqStateListener.FAQFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        faqStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        faqStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void DeleteFAQ(String Authorization, int Faq_Id) {
        if (faqStateListener == null) return;
        faqStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(FaqAPI.class).DeleteFAQ("Bearer " + Authorization, Faq_Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            faqStateListener.DeleteFAQSuccess(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                faqStateListener.onUnknowError(errorStr);
                            else faqStateListener.FAQFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        faqStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        faqStateListener.onComplete();
                    }
                }));
    }
}
