package com.wdtpr.augus.debugnetexample.Pet.presenter.card;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.calendar.CalendarListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.PointCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.base.IBasePresenter;
import com.wdtpr.augus.debugnetexample.base.IBaseView;

/**
 * Created by augus on 2017/12/13.
 *
 */

public interface ICardContract {

    interface CardStateView extends IBaseView {

        void CardFail();

        void GETCustomerPetCardList(CardListBean bean);

        void GETPetCardDetail(CardDetailBean bean);

        void POSTPetCard(CardCreateCallbackBean bean);

        void PUTPetCard(Status bean);

        void PUTCardBindAccount(Status bean);

        void POSTCardPoint(PointCreateCallbackBean bean);

        void DeleteCardPoint(Status bean);
    }

    interface Presnter extends IBasePresenter {

        void GETCustomerPetCardList(String Authorization, int customer_id, int store_id);

        void GETPetCardDetail(String Authorization, int pet_id, int store_id);

        void POSTPetCard(String Authorization, int pet_id, int store_id, String title, int cost, int point_count);

        void PUTPetCard(String Authorization, int card_id, String title, int cost);

        void PUTCardBindAccount(String Authorization, int card_id,int account_id);

        void POSTCardPoint(String Authorization, int card_id, String service);

        void DeleteCardPoint(String Authorization, int Point_Id);

    }
}
