package com.wdtpr.augus.debugnetexample.Pet.model.source.card;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.PointCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemListBean;

/**
 * Created by augus on 2017/12/10.
 */

public interface ICardModel {

    interface CardStateListener  {

        void onStart();

        void onComplete();

        void onUnknowError(String errorStr);

        void CardFail();

        void GETCustomerPetCardList(CardListBean bean);

        void GETPetCardDetail(CardDetailBean bean);

        void POSTPetCard(CardCreateCallbackBean bean);

        void PUTPetCard(Status bean);

        void PUTCardBindAccount(Status bean);

        void POSTCardPoint(PointCreateCallbackBean bean);

        void DeleteCardPoint(Status bean);
    }

    void GETCustomerPetCardList(String Authorization, int customer_id, int store_id);

    void GETPetCardDetail(String Authorization, int pet_id, int store_id);

    void POSTPetCard(String Authorization, int pet_id, int store_id, String title, int cost, int point_count);

    void PUTPetCard(String Authorization, int card_id, String title, int cost);

    void PUTCardBindAccount(String Authorization, int card_id,int account_id);

    void POSTCardPoint(String Authorization, int card_id, String service);

    void DeleteCardPoint(String Authorization, int Point_Id);
}
