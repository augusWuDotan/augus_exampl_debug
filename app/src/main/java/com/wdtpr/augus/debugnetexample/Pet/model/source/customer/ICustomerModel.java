package com.wdtpr.augus.debugnetexample.Pet.model.source.customer;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerListBean;

import okhttp3.MultipartBody;
import retrofit2.http.Field;

/**
 * Created by augus on 2017/12/3.
 */

public interface ICustomerModel {

    interface CustomerListener {

        void onStart();

        void onUnknowError(String errorStr);

        void onComplete();

        void customerFail();

        void GetCustomerListSuccess(CustomerListBean bean);

        void GETCustomerDetailSuccess(CustomerDetailBean bean);

        void PUTCustomerDetailSuccess(Status bean);

        void POSTCustomerAvatarSuccess(Status bean);

        void POSTCustomerBindStoreSuccess(Status bean);
    }


    void GETCustomerList(String Authorization);

    void GETCustomerDetail(String Authorization, int Customer_Id);

    void PUTCustomerDetail(String Authorization, int Customer_Id, int representative_pet_id, String address,
                           String customer_number, String phone, String mobile, String description);

    void POSTCustomerAvatar(String Authorization, int Customer_Id, MultipartBody.Part avatar);

    void POSTCustomerBindStore(String Authorization, int Customer_Id, String StoreMail);
}
