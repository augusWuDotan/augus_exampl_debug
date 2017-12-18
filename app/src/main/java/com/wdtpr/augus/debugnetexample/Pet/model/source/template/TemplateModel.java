package com.wdtpr.augus.debugnetexample.Pet.model.source.template;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.TemplateAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateAmountBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateGroupBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplatePrototypeListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateUpdateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/11.
 */

public class TemplateModel extends BaseModel implements ITemplateModel {

    private ITemplateModel.TemplateStateListener templateStateListener;

    public TemplateModel(TemplateStateListener templateStateListener) {
        this.templateStateListener = templateStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        templateStateListener = null;
    }


    @Override
    public void GETTemplateList(String Authorization, int store_id, String type) {
        if (templateStateListener == null) return;
        templateStateListener.onStart();
       //
        disposableManager.add(RetrofitHelper_Pet.instance().create(TemplateAPI.class).GETTemplateList("Bearer " + Authorization,store_id,type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<TemplateListBean>>() {
                    @Override
                    public void onNext(Result<TemplateListBean> textListComponentsResult) {
                        //
                        final int responseCode = textListComponentsResult.response().code();
                        if (responseCode == 200) {
                            TemplateListBean bean = textListComponentsResult.response().body();
                            templateStateListener.GETTemplateList(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                templateStateListener.onUnknowError(errorStr);
                            else templateStateListener.TemplateFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        templateStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        templateStateListener.onComplete();
                    }
                })

        );
    }


    @Override
    public void GETTemplateBoardGroupList(String Authorization, String theme) {
        if (templateStateListener == null) return;
        templateStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(TemplateAPI.class).GETTemplateBoardGroupList("Bearer " + Authorization,theme)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<TemplateGroupBean>>() {
                    @Override
                    public void onNext(Result<TemplateGroupBean> templateGroupBeanResult) {
                        //
                        final int responseCode = templateGroupBeanResult.response().code();
                        if (responseCode == 200) {
                            TemplateGroupBean bean = templateGroupBeanResult.response().body();
                            templateStateListener.GETTemplateBoardGroupList(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                templateStateListener.onUnknowError(errorStr);
                            else templateStateListener.TemplateFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        templateStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        templateStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void GETTemplatePrototypeList(String Authorization, String theme_group) {
        if (templateStateListener == null) return;
        templateStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(TemplateAPI.class).GETTemplatePrototypeList("Bearer " + Authorization,theme_group)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<TemplatePrototypeListBean>>() {
                    @Override
                    public void onNext(Result<TemplatePrototypeListBean> templatePrototypeListBeanResult) {
                        //
                        final int responseCode = templatePrototypeListBeanResult.response().code();
                        if (responseCode == 200) {
                            TemplatePrototypeListBean bean = templatePrototypeListBeanResult.response().body();
                            templateStateListener.GETTemplatePrototypeList(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                templateStateListener.onUnknowError(errorStr);
                            else templateStateListener.TemplateFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        templateStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        templateStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void GETTemplateBoardCount(String Authorization, int store_id,String theme) {
        if (templateStateListener == null) return;
        templateStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(TemplateAPI.class).GETTemplateBoardCount("Bearer " + Authorization,store_id,theme)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<TemplateAmountBean>>() {
                    @Override
                    public void onNext(Result<TemplateAmountBean> templateAmountBeanResult) {
                        //
                        final int responseCode = templateAmountBeanResult.response().code();
                        if (responseCode == 200) {
                            TemplateAmountBean bean = templateAmountBeanResult.response().body();
                            templateStateListener.GETTemplateBoardCount(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                templateStateListener.onUnknowError(errorStr);
                            else templateStateListener.TemplateFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        templateStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        templateStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void POSTTemplate(String Authorization, int store_id, String template_prototype_id) {
        if (templateStateListener == null) return;
        templateStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(TemplateAPI.class).POSTTemplate("Bearer " + Authorization,store_id,template_prototype_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<TemplateCreateCallbackBean>>() {
                    @Override
                    public void onNext(Result<TemplateCreateCallbackBean> templateCreateCallbackBeanResult) {
                        //
                        final int responseCode = templateCreateCallbackBeanResult.response().code();
                        if (responseCode == 200) {
                            TemplateCreateCallbackBean bean = templateCreateCallbackBeanResult.response().body();
                            templateStateListener.POSTTemplate(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                templateStateListener.onUnknowError(errorStr);
                            else templateStateListener.TemplateFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        templateStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        templateStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void GETTemplateBoard(String Authorization, String store_template_id) {
        if (templateStateListener == null) return;
        templateStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(TemplateAPI.class).GETTemplateBoard("Bearer " + Authorization,store_template_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<TemplateDetailBean>>() {
                    @Override
                    public void onNext(Result<TemplateDetailBean> templateDetailBeanResult) {
                        //
                        final int responseCode = templateDetailBeanResult.response().code();
                        if (responseCode == 200) {
                            TemplateDetailBean bean = templateDetailBeanResult.response().body();
                            templateStateListener.GETTemplateBoard(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                templateStateListener.onUnknowError(errorStr);
                            else templateStateListener.TemplateFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        templateStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        templateStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void DeleteTemplateBoard(String Authorization, String store_template_id) {
        if (templateStateListener == null) return;
        templateStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(TemplateAPI.class).DeleteTemplateBoard("Bearer " + Authorization,store_template_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            templateStateListener.DeleteTemplateBoard(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                templateStateListener.onUnknowError(errorStr);
                            else templateStateListener.TemplateFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        templateStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        templateStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void POSTUpdateTemplateText(String url, String Authorization, String text) {
        if (templateStateListener == null) return;
        templateStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(TemplateAPI.class).POSTUpdateTemplateText(url,"Bearer " + Authorization,text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<TemplateUpdateCallbackBean>>() {
                    @Override
                    public void onNext(Result<TemplateUpdateCallbackBean> templateUpdateCallbackBeanResult) {
                        //
                        final int responseCode = templateUpdateCallbackBeanResult.response().code();
                        if (responseCode == 200) {
                            TemplateUpdateCallbackBean bean = templateUpdateCallbackBeanResult.response().body();
                            templateStateListener.POSTUpdateTemplateText(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                templateStateListener.onUnknowError(errorStr);
                            else templateStateListener.TemplateFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        templateStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        templateStateListener.onComplete();
                    }
                })

        );
    }

    @Override
    public void POSTUpdateTemplateImage(String url, String Authorization, MultipartBody.Part avatar) {
        if (templateStateListener == null) return;
        templateStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(TemplateAPI.class).POSTUpdateTemplateImage(url,"Bearer " + Authorization,avatar)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<TemplateUpdateCallbackBean>>() {
                    @Override
                    public void onNext(Result<TemplateUpdateCallbackBean> templateUpdateCallbackBeanResult) {
                        //
                        final int responseCode = templateUpdateCallbackBeanResult.response().code();
                        if (responseCode == 200) {
                            TemplateUpdateCallbackBean bean = templateUpdateCallbackBeanResult.response().body();
                            templateStateListener.POSTUpdateTemplateImage(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                templateStateListener.onUnknowError(errorStr);
                            else templateStateListener.TemplateFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        templateStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        templateStateListener.onComplete();
                    }
                })

        );

    }
}
