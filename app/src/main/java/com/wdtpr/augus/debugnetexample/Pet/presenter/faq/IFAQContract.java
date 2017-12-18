package com.wdtpr.augus.debugnetexample.Pet.presenter.faq;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetCreateStatusBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetHasMonthCardBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetVariety;
import com.wdtpr.augus.debugnetexample.base.IBasePresenter;
import com.wdtpr.augus.debugnetexample.base.IBaseView;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/17.
 */

public interface IFAQContract {

    interface FAQView extends IBaseView {

        void FAQFail();

        void GETFAQListSuccess(FAQListBean bean);

        void POSTFAQSuccess(FAQCallbackBean bean);

        void PUTFAQSuccess(Status bean);

        void DeleteFAQSuccess(Status bean);

    }

    interface Presnter extends IBasePresenter {

        void GETFAQList(String Authorization, int Store_Id, int page);

        void POSTFAQ(String Authorization, int Store_Id, String question, String anwser);

        void PUTFAQ(String Authorization, int FAQ_id, String question, String anwser);

        void DeleteFAQ(String Authorization, int Faq_Id);

    }
}
