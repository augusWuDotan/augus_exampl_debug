package com.wdtpr.augus.debugnetexample.Pet.model.source.account;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountListBean;

/**
 * Created by augus on 2017/12/10.
 */

public interface IAccountModel {

    interface AccountStateListener  {

        void onStart();

        void onComplete();

        void onUnknowError(String errorStr);

        void AccountFail();

        void GETAccountSuccess(AccountListBean bean);

        void POSTAccountSuccess(AccountCallBackBean bean);

        void GETAccountCustomerSuccess(AccountListBean bean);

        void PUTAccountSuccess(Status bean);

        void DeleteAccountSuccess(Status bean);
    }


    void GETAccount(String Authorization, int Store_id, String start_date, String end_date);

    void POSTAccount(String Authorization, int Store_id, int customer_id, String date, String title, String description, int cost);

    void GETAccountCustomer(String Authorization, int customer_id, String start_date, String end_date);

    void PUTAccount(String Authorization, int account_id, int customer_id, String title, String description, int cost);

    void DeleteAccount(String Authorization, int account_id);

}
