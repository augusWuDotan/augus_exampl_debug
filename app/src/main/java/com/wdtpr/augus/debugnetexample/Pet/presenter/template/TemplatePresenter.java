package com.wdtpr.augus.debugnetexample.Pet.presenter.template;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateAmountBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateGroupBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplatePrototypeListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateUpdateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.template.ITemplateModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.template.TemplateModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/18.
 */

public class TemplatePresenter extends BasePresenter implements ITemplateContract.Presnter {

    private ITemplateContract.TemplateView templateView;
    private TemplateModel templateModel;

    public TemplatePresenter(ITemplateContract.TemplateView templateView) {
        this.templateView = templateView;
        templateModel = new TemplateModel(templateStateListener);
    }

    public ITemplateModel.TemplateStateListener templateStateListener = new ITemplateModel.TemplateStateListener() {
        @Override
        public void onStart() {
            templateView.showLoading();
        }

        @Override
        public void onComplete() {
            templateView.hideLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            templateView.showUnknowError(errorStr);
        }

        @Override
        public void TemplateFail() {
            templateView.TemplateFail();
        }

        @Override
        public void GETTemplateList(TemplateListBean bean) {
            templateView.GETTemplateList(bean);
        }

        @Override
        public void GETTemplateBoardGroupList(TemplateGroupBean bean) {
            templateView.GETTemplateBoardGroupList(bean);
        }

        @Override
        public void GETTemplatePrototypeList(TemplatePrototypeListBean bean) {
            templateView.GETTemplatePrototypeList(bean);
        }

        @Override
        public void GETTemplateBoardCount(TemplateAmountBean bean) {
            templateView.GETTemplateBoardCount(bean);
        }

        @Override
        public void POSTTemplate(TemplateCreateCallbackBean bean) {
            templateView.POSTTemplate(bean);
        }

        @Override
        public void GETTemplateBoard(TemplateDetailBean bean) {
            templateView.GETTemplateBoard(bean);
        }

        @Override
        public void DeleteTemplateBoard(Status bean) {
            templateView.DeleteTemplateBoard(bean);
        }

        @Override
        public void POSTUpdateTemplateText(TemplateUpdateCallbackBean bean) {
            templateView.POSTUpdateTemplateText(bean);
        }

        @Override
        public void POSTUpdateTemplateImage(TemplateUpdateCallbackBean bean) {
            templateView.POSTUpdateTemplateImage(bean);
        }
    };

    @Override
    public void unsubscribe() {
        templateModel.unsubscribe();
        templateModel = null;
        templateView = null;
    }

    @Override
    public void GETTemplateList(String Authorization, int store_id, String type) {
        templateModel.GETTemplateList(Authorization,store_id,type);
    }

    @Override
    public void GETTemplateBoardGroupList(String Authorization, String theme) {
        templateModel.GETTemplateBoardGroupList(Authorization,theme);
    }

    @Override
    public void GETTemplatePrototypeList(String Authorization, String theme_group) {
        templateModel.GETTemplatePrototypeList(Authorization,theme_group);
    }

    @Override
    public void GETTemplateBoardCount(String Authorization, int store_id, String theme) {
        templateModel.GETTemplateBoardCount(Authorization,store_id,theme);
    }

    @Override
    public void POSTTemplate(String Authorization, int store_id, String template_prototype_id) {
        templateModel.POSTTemplate(Authorization,store_id,template_prototype_id);
    }

    @Override
    public void GETTemplateBoard(String Authorization, String store_template_id) {
        templateModel.GETTemplateBoard(Authorization,store_template_id);
    }

    @Override
    public void DeleteTemplateBoard(String Authorization, String store_template_id) {
        templateModel.DeleteTemplateBoard(Authorization,store_template_id);
    }

    @Override
    public void POSTUpdateTemplateText(String url, String Authorization, String text) {
        templateModel.POSTUpdateTemplateText(url,Authorization,text);
    }

    @Override
    public void POSTUpdateTemplateImage(String url, String Authorization, MultipartBody.Part avatar) {
        templateModel.POSTUpdateTemplateImage(url,Authorization,avatar);
    }
}
