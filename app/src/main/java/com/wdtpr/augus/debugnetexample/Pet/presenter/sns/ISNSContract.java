package com.wdtpr.augus.debugnetexample.Pet.presenter.sns;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.sns.SNSNotReadBean;
import com.wdtpr.augus.debugnetexample.base.IBasePresenter;
import com.wdtpr.augus.debugnetexample.base.IBaseView;

/**
 * Created by augus on 2017/12/17.
 */

public interface ISNSContract {

    interface SNSView extends IBaseView {

        void SNSFail();

        void DeleteSNSSuccess(SNSCallbackBean bean);

        void POSTSNSSuccess(SNSCallbackBean bean);

        void POSTSendAllSuccess(Status bean);

        void POSTSendOneSuccess(Status bean);

        void GETSNSSuccess(SNSListBean bean);

        void GETSNSNotReadCountSuccess(SNSNotReadBean bean);

        void GETSNSForIdSuccess(SNSDetailBean bean);

        void POSTChangeSNSReadStatusSuccess(Status bean);

    }

    interface Presenter extends IBasePresenter {

        void DeleteSNS(String Authorization);

        void POSTSNS(String Authorization,String token,String endpoint_device);

        void POSTSendAll(String Authorization,String message);

        void POSTSendOne(String Authorization,String customerId,String message);

        void GETSNS(String Authorization);

        void GETSNSNotReadCount(String Authorization);

        void GETSNSForId(String Authorization,int snsLogId);

        void POSTChangeSNSReadStatus(String Authorization,int snsLogId);
    }
}
