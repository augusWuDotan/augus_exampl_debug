package com.wdtpr.augus.debugnetexample.Pet.presenter.customer;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.customer.CustomerModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.customer.ICustomerModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/16.
 */

public class CustomerPresenter extends BasePresenter implements ICustomerContract.Presnter {

    private ICustomerContract.CustomerView customerView;
    private CustomerModel customerModel;

    public CustomerPresenter(ICustomerContract.CustomerView customerView) {
        this.customerView = customerView;
        customerModel = new CustomerModel(customerListener);

    }

    private ICustomerModel.CustomerListener customerListener = new ICustomerModel.CustomerListener() {
        @Override
        public void onStart() {
            customerView.showLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            customerView.showUnknowError(errorStr);
        }

        @Override
        public void onComplete() {
            customerView.hideLoading();
        }

        @Override
        public void customerFail() {
            customerView.customerFail();
        }

        @Override
        public void GetCustomerListSuccess(CustomerListBean bean) {
            customerView.GetCustomerListSuccess(bean);
        }

        @Override
        public void GETCustomerDetailSuccess(CustomerDetailBean bean) {
            customerView.GETCustomerDetailSuccess(bean);
        }

        @Override
        public void PUTCustomerDetailSuccess(Status bean) {
            customerView.PUTCustomerDetailSuccess(bean);
        }

        @Override
        public void POSTCustomerAvatarSuccess(Status bean) {
            customerView.POSTCustomerAvatarSuccess(bean);
        }

        @Override
        public void POSTCustomerBindStoreSuccess(Status bean) {
            customerView.POSTCustomerBindStoreSuccess(bean);
        }
    };

    @Override
    public void unsubscribe() {
        customerModel.unsubscribe();
        customerModel = null;
        customerView = null;
    }

    @Override
    public void GETCustomerList(String Authorization) {
        customerModel.GETCustomerList(Authorization);
    }

    @Override
    public void GETCustomerDetail(String Authorization, int Customer_Id) {
        customerModel.GETCustomerDetail(Authorization,Customer_Id);
    }

    @Override
    public void PUTCustomerDetail(String Authorization, int Customer_Id, int representative_pet_id, String address, String customer_number, String phone, String mobile, String description) {
        customerModel.PUTCustomerDetail(Authorization,Customer_Id,representative_pet_id,address,customer_number,phone,mobile,description);
    }

    @Override
    public void POSTCustomerAvatar(String Authorization, int Customer_Id, MultipartBody.Part avatar) {
        customerModel.POSTCustomerAvatar(Authorization,Customer_Id,avatar);
    }

    @Override
    public void POSTCustomerBindStore(String Authorization, int Customer_Id, String StoreMail) {
        customerModel.POSTCustomerBindStore(Authorization,Customer_Id,StoreMail);
    }
}
