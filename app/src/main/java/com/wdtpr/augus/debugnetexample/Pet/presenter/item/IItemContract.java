package com.wdtpr.augus.debugnetexample.Pet.presenter.item;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.faq.FAQListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemCallbackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.item.ItemListBean;
import com.wdtpr.augus.debugnetexample.base.IBasePresenter;
import com.wdtpr.augus.debugnetexample.base.IBaseView;

/**
 * Created by augus on 2017/12/17.
 */

public interface IItemContract {

    interface ItemView extends IBaseView {

        void ItemFail();

        void GETItemListSuccess(ItemListBean bean);

        void POSTItemSuccess(ItemCallbackBean bean);

        void PUTItemSuccess(Status bean);

        void DeleteItemSuccess(Status bean);
    }

    interface Presnter extends IBasePresenter {

        void GETItemList(String Authorization);

        void POSTItem(String Authorization, int Store_Id, String title, int cost);

        void PUTItem(String Authorization, int Item_Id, String title, int cost);

        void DeleteItem(String Authorization, int Item_Id);
    }
}
