package com.wdtpr.augus.debugnetexample.Pet.model.source.faq;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQListBean;

/**
 * Created by augus on 2017/12/4.
 */

public interface IFAQModel {

    interface FAQStateListener {

        void onStart();

        void onUnknowError(String errorStr);

        void onComplete();

        void FAQFail();

        void GETFAQListSuccess(FAQListBean bean);

        void POSTFAQSuccess(FAQCallbackBean bean);

        void PUTFAQSuccess(Status bean);

        void DeleteFAQSuccess(Status bean);

    }


    void GETFAQList(String Authorization, int Store_Id, int page);

    void POSTFAQ(String Authorization, int Store_Id, String question, String anwser);

    void PUTFAQ(String Authorization, int FAQ_id, String question, String anwser);

    void DeleteFAQ(String Authorization, int Faq_Id);
}
