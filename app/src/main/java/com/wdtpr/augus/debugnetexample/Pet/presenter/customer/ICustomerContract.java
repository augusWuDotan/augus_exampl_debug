package com.wdtpr.augus.debugnetexample.Pet.presenter.customer;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Permission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.provider.ProviderListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.Store;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreAvatar;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreDetail;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outPermission;
import com.wdtpr.augus.debugnetexample.base.IBasePresenter;
import com.wdtpr.augus.debugnetexample.base.IBaseView;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/13.
 * User
 */

public interface ICustomerContract {

    interface CustomerView extends IBaseView {

        void customerFail();

        void GetCustomerListSuccess(CustomerListBean bean);

        void GETCustomerDetailSuccess(CustomerDetailBean bean);

        void PUTCustomerDetailSuccess(Status bean);

        void POSTCustomerAvatarSuccess(Status bean);

        void POSTCustomerBindStoreSuccess(Status bean);
    }

    interface Presnter extends IBasePresenter {

        void GETCustomerList(String Authorization);

        void GETCustomerDetail(String Authorization, int Customer_Id);

        void PUTCustomerDetail(String Authorization, int Customer_Id, int representative_pet_id, String address,
                               String customer_number, String phone, String mobile, String description);

        void POSTCustomerAvatar(String Authorization, int Customer_Id, MultipartBody.Part avatar);

        void POSTCustomerBindStore(String Authorization, int Customer_Id, String StoreMail);

    }
}
