package com.wdtpr.augus.debugnetexample.Pet.presenter.store;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Permission;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.provider.ProviderListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.Store;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreAvatar;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreDetail;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.store.StoreListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.UserInfo;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.user.registBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.out.outPermission;
import com.wdtpr.augus.debugnetexample.Pet.model.source.store.IStoreModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.store.StoreModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.user.IUserModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.user.UserModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/13.
 */

public class StorePresenter extends BasePresenter implements IStoreContract.Presnter {

    private IStoreContract.StoreView storeView;//對view互動
    private StoreModel storeModel;//對presenter互動

    public StorePresenter(IStoreContract.StoreView storeView) {
        this.storeView = storeView;
        storeModel = new StoreModel(storeStateListener);
    }

    public IStoreModel.StoreStateListener storeStateListener = new IStoreModel.StoreStateListener() {
        @Override
        public void onStart() {
            storeView.showLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            storeView.showUnknowError(errorStr);
        }

        @Override
        public void onComplete() {
            storeView.hideLoading();
        }

        @Override
        public void storeFail() {
            storeView.storeFail();
        }

        @Override
        public void GETStoreListSuccess(StoreListBean storeListBean) {
            storeView.GETStoreListSuccess(storeListBean);
        }

        @Override
        public void GETStoreDetailSuccess(StoreDetail storeDetail) {
            storeView.GETStoreDetailSuccess(storeDetail);
        }

        @Override
        public void GETStoreProviderSuccess(ProviderListBean providerListBean) {
            storeView.GETStoreProviderSuccess(providerListBean);
        }

        @Override
        public void PUTStoreDetailSuccess(Status status) {
            storeView.PUTStoreDetailSuccess(status);
        }

        @Override
        public void GETStoreAvatarSuccess(StoreAvatar storeAvatar) {
            storeView.GETStoreAvatarSuccess(storeAvatar);
        }

        @Override
        public void POSTStoreAvatarSuccess(Status status) {
            storeView.POSTStoreAvatarSuccess(status);
        }

        @Override
        public void GETPermissionSuccess(Permission permission) {
            storeView.GETPermissionSuccess(permission);
        }

        @Override
        public void POSTPermissionSuccess(Status status) {
            storeView.POSTPermissionSuccess(status);
        }

        @Override
        public void POSTStoreBindCustomerSuccess(Status status) {
            storeView.POSTStoreBindCustomerSuccess(status);
        }
    };

    @Override
    public void unsubscribe() {
        storeModel.unsubscribe();
        storeModel = null;
        storeView = null;
    }

    @Override
    public void GETStoreList(String Authorization) {
        storeModel.GETStoreList(Authorization);
    }

    @Override
    public void GETStoreDetail(String Authorization, int Store_Id) {
        storeModel.GETStoreDetail(Authorization,Store_Id);
    }

    @Override
    public void GETStoreProvider(String Authorization, int Store_Id) {
        storeModel.GETStoreProvider(Authorization,Store_Id);
    }

    @Override
    public void PUTStoreDetail(String Authorization, int Store_Id, Store store) {
        storeModel.PUTStoreDetail(Authorization,Store_Id,store);
    }

    @Override
    public void GETStoreAvatar(String Authorization, int Store_Id) {
        storeModel.GETStoreAvatar(Authorization,Store_Id);
    }

    @Override
    public void POSTStoreAvatar(String Authorization, int Store_Id, MultipartBody.Part avatar) {
        storeModel.POSTStoreAvatar(Authorization,Store_Id,avatar);
    }

    @Override
    public void GetPermission(String Authorization, int Store_Id) {
        storeModel.GetPermission(Authorization,Store_Id);
    }

    @Override
    public void PostPermission(String Authorization, int Store_Id, outPermission permission) {
        storeModel.PostPermission(Authorization,Store_Id,permission);
    }

    @Override
    public void POSTStoreBindCustomer(String Authorization, int Store_Id, String CustomerMail) {
        storeModel.POSTStoreBindCustomer(Authorization,Store_Id,CustomerMail);
    }
}
