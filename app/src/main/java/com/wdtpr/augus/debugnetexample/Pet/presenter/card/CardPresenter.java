package com.wdtpr.augus.debugnetexample.Pet.presenter.card;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.CardListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.card.PointCreateCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.card.CardModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.card.ICardModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

/**
 * Created by augus on 2017/12/17.
 */

public class CardPresenter extends BasePresenter implements ICardContract.Presnter {

    private ICardContract.CardStateView cardStateView;
    private CardModel cardModel;

    public CardPresenter(ICardContract.CardStateView cardStateView) {
        this.cardStateView = cardStateView;
        cardModel = new CardModel(cardStateListener);
    }

    public ICardModel.CardStateListener cardStateListener = new ICardModel.CardStateListener() {
        @Override
        public void onStart() {
            cardStateView.showLoading();
        }

        @Override
        public void onComplete() {
            cardStateView.hideLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            cardStateView.showUnknowError(errorStr);
        }

        @Override
        public void CardFail() {
            cardStateView.CardFail();
        }

        @Override
        public void GETCustomerPetCardList(CardListBean bean) {
            cardStateView.GETCustomerPetCardList(bean);
        }

        @Override
        public void GETPetCardDetail(CardDetailBean bean) {
            cardStateView.GETPetCardDetail(bean);
        }

        @Override
        public void POSTPetCard(CardCreateCallbackBean bean) {
            cardStateView.POSTPetCard(bean);
        }

        @Override
        public void PUTPetCard(Status bean) {
            cardStateView.PUTPetCard(bean);
        }

        @Override
        public void PUTCardBindAccount(Status bean) {
            cardStateView.PUTCardBindAccount(bean);
        }

        @Override
        public void POSTCardPoint(PointCreateCallbackBean bean) {
            cardStateView.POSTCardPoint(bean);
        }

        @Override
        public void DeleteCardPoint(Status bean) {
            cardStateView.DeleteCardPoint(bean);
        }
    };

    @Override
    public void unsubscribe() {
        cardModel.unsubscribe();
        cardModel = null;
        cardStateView = null;
    }

    @Override
    public void GETCustomerPetCardList(String Authorization, int customer_id, int store_id) {
        cardModel.GETCustomerPetCardList(Authorization,customer_id,store_id);
    }

    @Override
    public void GETPetCardDetail(String Authorization, int pet_id, int store_id) {
        cardModel.GETPetCardDetail(Authorization,pet_id,store_id);
    }

    @Override
    public void POSTPetCard(String Authorization, int pet_id, int store_id, String title, int cost, int point_count) {
        cardModel.POSTPetCard(Authorization,pet_id,store_id,title,cost,point_count);
    }

    @Override
    public void PUTPetCard(String Authorization, int card_id, String title, int cost) {
        cardModel.PUTPetCard(Authorization,card_id,title,cost);
    }

    @Override
    public void PUTCardBindAccount(String Authorization, int card_id, int account_id) {
        cardModel.PUTCardBindAccount(Authorization,card_id,account_id);
    }

    @Override
    public void POSTCardPoint(String Authorization, int card_id, String service) {
        cardModel.POSTCardPoint(Authorization,card_id,service);
    }

    @Override
    public void DeleteCardPoint(String Authorization, int Point_Id) {
        cardModel.DeleteCardPoint(Authorization,Point_Id);
    }
}
