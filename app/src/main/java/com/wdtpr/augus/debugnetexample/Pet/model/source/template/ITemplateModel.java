package com.wdtpr.augus.debugnetexample.Pet.model.source.template;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.PointCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateAmountBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateGroupBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplatePrototypeListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.template.TemplateUpdateCallbackBean;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/11.
 */

public interface ITemplateModel {

    interface TemplateStateListener  {

        void onStart();

        void onComplete();

        void onUnknowError(String errorStr);

        void TemplateFail();

        void GETTemplateList(TemplateListBean bean);

        void GETTemplateBoardGroupList(TemplateGroupBean bean);

        void GETTemplatePrototypeList(TemplatePrototypeListBean bean);

        void GETTemplateBoardCount(TemplateAmountBean bean);

        void POSTTemplate(TemplateCreateCallbackBean bean);

        void GETTemplateBoard(TemplateDetailBean bean);

        void DeleteTemplateBoard(Status bean);

        void POSTUpdateTemplateText(TemplateUpdateCallbackBean bean);

        void POSTUpdateTemplateImage(TemplateUpdateCallbackBean bean);
    }

    //
    void GETTemplateList(String Authorization, int store_id,String type);

    void GETTemplateBoardGroupList(String Authorization,String theme);

    void GETTemplatePrototypeList(String Authorization,String theme_group);

    void GETTemplateBoardCount(String Authorization, int store_id,String theme);

    void POSTTemplate(String Authorization, int store_id,String template_prototype_id);

    void GETTemplateBoard(String Authorization, String store_template_id);

    void DeleteTemplateBoard(String Authorization, String store_template_id);

    void POSTUpdateTemplateText(String url ,String Authorization, String text);

    void POSTUpdateTemplateImage(String url ,String Authorization, MultipartBody.Part avatar);


}
