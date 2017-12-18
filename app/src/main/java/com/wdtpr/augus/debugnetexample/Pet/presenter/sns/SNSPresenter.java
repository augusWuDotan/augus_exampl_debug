package com.wdtpr.augus.debugnetexample.Pet.presenter.sns;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSNotReadBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.sns.ISNSModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.sns.SNSModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

/**
 * Created by augus on 2017/12/17.
 */

public class SNSPresenter extends BasePresenter implements ISNSContract.Presenter {

    private ISNSContract.SNSView snsView;
    private SNSModel snsModel;

    public SNSPresenter(ISNSContract.SNSView snsView) {
        this.snsView = snsView;
        snsModel = new SNSModel(snsStateListener);
    }

    public ISNSModel.SNSStateListener snsStateListener = new ISNSModel.SNSStateListener() {
        @Override
        public void onStart() {
            snsView.showLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            snsView.showUnknowError(errorStr);
        }

        @Override
        public void onComplete() {
            snsView.hideLoading();
        }

        @Override
        public void SNSFail() {
            snsView.SNSFail();
        }

        @Override
        public void DeleteSNSSuccess(SNSCallbackBean bean) {
            snsView.DeleteSNSSuccess(bean);
        }

        @Override
        public void POSTSNSSuccess(SNSCallbackBean bean) {
            snsView.POSTSNSSuccess(bean);
        }

        @Override
        public void POSTSendAllSuccess(Status bean) {
            snsView.POSTSendAllSuccess(bean);
        }

        @Override
        public void POSTSendOneSuccess(Status bean) {
            snsView.POSTSendOneSuccess(bean);
        }

        @Override
        public void GETSNSSuccess(SNSListBean bean) {
            snsView.GETSNSSuccess(bean);
        }

        @Override
        public void GETSNSNotReadCountSuccess(SNSNotReadBean bean) {
            snsView.GETSNSNotReadCountSuccess(bean);
        }

        @Override
        public void GETSNSForIdSuccess(SNSDetailBean bean) {
            snsView.GETSNSForIdSuccess(bean);
        }

        @Override
        public void POSTChangeSNSReadStatusSuccess(Status bean) {
            snsView.POSTChangeSNSReadStatusSuccess(bean);
        }
    };

    @Override
    public void unsubscribe() {
        snsModel.unsubscribe();
        snsModel = null;
        snsView = null;
    }

    @Override
    public void DeleteSNS(String Authorization) {
        snsModel.DeleteSNS(Authorization);
    }

    @Override
    public void POSTSNS(String Authorization, String token, String endpoint_device) {
        snsModel.POSTSNS(Authorization,token,endpoint_device);
    }

    @Override
    public void POSTSendAll(String Authorization, String message) {
        snsModel.POSTSendAll(Authorization,message);
    }

    @Override
    public void POSTSendOne(String Authorization, String customerId, String message) {
        snsModel.POSTSendOne(Authorization,customerId,message);
    }

    @Override
    public void GETSNS(String Authorization) {
        snsModel.GETSNS(Authorization);
    }

    @Override
    public void GETSNSNotReadCount(String Authorization) {
        snsModel.GETSNSNotReadCount(Authorization);
    }

    @Override
    public void GETSNSForId(String Authorization, int snsLogId) {
        snsModel.GETSNSForId(Authorization,snsLogId);
    }

    @Override
    public void POSTChangeSNSReadStatus(String Authorization, int snsLogId) {
        snsModel.POSTChangeSNSReadStatus(Authorization,snsLogId);
    }
}
