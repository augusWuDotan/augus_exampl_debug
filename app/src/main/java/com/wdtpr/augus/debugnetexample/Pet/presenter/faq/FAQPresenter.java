package com.wdtpr.augus.debugnetexample.Pet.presenter.faq;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.faq.FAQModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.faq.IFAQModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

/**
 * Created by augus on 2017/12/17.
 */

public class FAQPresenter extends BasePresenter implements IFAQContract.Presnter {

    private IFAQContract.FAQView faqView;
    private FAQModel faqModel;

    public FAQPresenter(IFAQContract.FAQView faqView) {
        this.faqView = faqView;
        faqModel = new FAQModel(faqStateListener);
    }

    public IFAQModel.FAQStateListener faqStateListener = new IFAQModel.FAQStateListener() {
        @Override
        public void onStart() {
            faqView.showLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            faqView.showUnknowError(errorStr);
        }

        @Override
        public void onComplete() {
            faqView.hideLoading();
        }

        @Override
        public void FAQFail() {
            faqView.FAQFail();
        }

        @Override
        public void GETFAQListSuccess(FAQListBean bean) {
            faqView.GETFAQListSuccess(bean);
        }

        @Override
        public void POSTFAQSuccess(FAQCallbackBean bean) {
            faqView.POSTFAQSuccess(bean);
        }

        @Override
        public void PUTFAQSuccess(Status bean) {
            faqView.PUTFAQSuccess(bean);
        }

        @Override
        public void DeleteFAQSuccess(Status bean) {
            faqView.DeleteFAQSuccess(bean);
        }
    };

    @Override
    public void unsubscribe() {
        faqModel.unsubscribe();
        faqModel = null;
        faqView = null;
    }

    @Override
    public void GETFAQList(String Authorization, int Store_Id, int page) {
        faqModel.GETFAQList(Authorization,Store_Id,page);
    }

    @Override
    public void POSTFAQ(String Authorization, int Store_Id, String question, String anwser) {
        faqModel.POSTFAQ(Authorization,Store_Id,question,anwser);
    }

    @Override
    public void PUTFAQ(String Authorization, int FAQ_id, String question, String anwser) {
        faqModel.PUTFAQ(Authorization,FAQ_id,question,anwser);
    }

    @Override
    public void DeleteFAQ(String Authorization, int Faq_Id) {
        faqModel.DeleteFAQ(Authorization,Faq_Id);
    }
}
