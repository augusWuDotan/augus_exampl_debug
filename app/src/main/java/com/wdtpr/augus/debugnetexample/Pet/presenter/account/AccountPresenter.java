package com.wdtpr.augus.debugnetexample.Pet.presenter.account;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.account.AccountModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.account.IAccountModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

/**
 * Created by augus on 2017/12/17.
 */

public class AccountPresenter extends BasePresenter implements IAccountContract.Presnter {

    private IAccountContract.AccountStateView accountStateView;
    private AccountModel accountModel;

    public AccountPresenter(IAccountContract.AccountStateView accountStateView) {
        this.accountStateView = accountStateView;
        accountModel = new AccountModel(accountStateListener);
    }

    public IAccountModel.AccountStateListener accountStateListener = new IAccountModel.AccountStateListener() {
        @Override
        public void onStart() {
            accountStateView.showLoading();
        }

        @Override
        public void onComplete() {
            accountStateView.hideLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            accountStateView.showUnknowError(errorStr);
        }

        @Override
        public void AccountFail() {
            accountStateView.AccountFail();
        }

        @Override
        public void GETAccountSuccess(AccountListBean bean) {
            accountStateView.GETAccountSuccess(bean);
        }

        @Override
        public void POSTAccountSuccess(AccountCallBackBean bean) {
            accountStateView.POSTAccountSuccess(bean);
        }

        @Override
        public void GETAccountCustomerSuccess(AccountListBean bean) {
            accountStateView.GETAccountCustomerSuccess(bean);
        }

        @Override
        public void PUTAccountSuccess(Status bean) {
            accountStateView.PUTAccountSuccess(bean);
        }

        @Override
        public void DeleteAccountSuccess(Status bean) {
            accountStateView.DeleteAccountSuccess(bean);
        }
    };


    @Override
    public void unsubscribe() {
        accountModel.unsubscribe();
        accountModel = null;
        accountStateView = null;
    }

    @Override
    public void GETAccount(String Authorization, int Store_id, String start_date, String end_date) {
        accountModel.GETAccount(Authorization,Store_id,start_date,end_date);
    }

    @Override
    public void POSTAccount(String Authorization, int Store_id, int customer_id, String date, String title, String description, int cost) {
        accountModel.POSTAccount(Authorization,Store_id,customer_id,date,title,description,cost);
    }

    @Override
    public void GETAccountCustomer(String Authorization, int customer_id, String start_date, String end_date) {
        accountModel.GETAccountCustomer(Authorization,customer_id,start_date,end_date);
    }

    @Override
    public void PUTAccount(String Authorization, int account_id, int customer_id, String title, String description, int cost) {
        accountModel.PUTAccount(Authorization,account_id,customer_id,title,description,cost);
    }

    @Override
    public void DeleteAccount(String Authorization, int account_id) {
        accountModel.DeleteAccount(Authorization,account_id);
    }
}
