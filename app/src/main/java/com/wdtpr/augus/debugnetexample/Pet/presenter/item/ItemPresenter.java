package com.wdtpr.augus.debugnetexample.Pet.presenter.item;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.item.IItemModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.item.ItemModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

/**
 * Created by augus on 2017/12/17.
 */

public class ItemPresenter extends BasePresenter implements IItemContract.Presnter {

    private IItemContract.ItemView itemView;
    private ItemModel itemModel;

    public ItemPresenter(IItemContract.ItemView itemView) {
        this.itemView = itemView;
        itemModel = new ItemModel(itemStateListener);
    }

    public IItemModel.ItemStateListener itemStateListener = new IItemModel.ItemStateListener() {
        @Override
        public void onStart() {
            itemView.showLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            itemView.showUnknowError(errorStr);
        }

        @Override
        public void onComplete() {
            itemView.hideLoading();
        }

        @Override
        public void ItemFail() {
            itemView.ItemFail();
        }

        @Override
        public void GETItemListSuccess(ItemListBean bean) {
            itemView.GETItemListSuccess(bean);
        }

        @Override
        public void POSTItemSuccess(ItemCallbackBean bean) {
            itemView.POSTItemSuccess(bean);
        }

        @Override
        public void PUTItemSuccess(Status bean) {
            itemView.PUTItemSuccess(bean);
        }

        @Override
        public void DeleteItemSuccess(Status bean) {
            itemView.DeleteItemSuccess(bean);
        }
    };

    @Override
    public void unsubscribe() {
        itemModel.unsubscribe();
        itemModel = null;
        itemView = null;
    }

    @Override
    public void GETItemList(String Authorization) {
        itemModel.GETItemList(Authorization);
    }

    @Override
    public void POSTItem(String Authorization, int Store_Id, String title, int cost) {
        itemModel.POSTItem(Authorization,Store_Id,title,cost);
    }

    @Override
    public void PUTItem(String Authorization, int Item_Id, String title, int cost) {
        itemModel.PUTItem(Authorization,Item_Id,title,cost);
    }

    @Override
    public void DeleteItem(String Authorization, int Item_Id) {
        itemModel.DeleteItem(Authorization,Item_Id);
    }
}
