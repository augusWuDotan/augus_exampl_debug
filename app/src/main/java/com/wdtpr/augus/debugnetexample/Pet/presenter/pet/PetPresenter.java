package com.wdtpr.augus.debugnetexample.Pet.presenter.pet;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetCreateStatusBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetHasMonthCardBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetVariety;
import com.wdtpr.augus.debugnetexample.Pet.model.source.pet.IPetModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.pet.PetModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/16.
 */

public class PetPresenter extends BasePresenter implements IPetContract.Presnter {

    private IPetContract.PetView petView;
    private PetModel petModel;

    public PetPresenter(IPetContract.PetView petView) {
        this.petView = petView;
        petModel = new PetModel(petListener);
    }

    public IPetModel.PetListener petListener = new IPetModel.PetListener() {
        @Override
        public void onStart() {
            petView.showLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            petView.showUnknowError(errorStr);
        }

        @Override
        public void onComplete() {
            petView.hideLoading();
        }

        @Override
        public void PetFail() {
            petView.PetFail();
        }

        @Override
        public void GETPetList(PetListBean bean) {
            petView.GETPetList(bean);
        }

        @Override
        public void GETPetDetail(PetDetailBean bean) {
            petView.GETPetDetail(bean);
        }

        @Override
        public void POSTCreatePet(PetCreateStatusBean bean) {
            petView.POSTCreatePet(bean);
        }

        @Override
        public void PUTPetDetail(Status bean) {
            petView.PUTPetDetail(bean);
        }

        @Override
        public void POSTPetAvatar(Status bean) {
            petView.POSTPetAvatar(bean);
        }

        @Override
        public void DeletePet(Status bean) {
            petView.DeletePet(bean);
        }

        @Override
        public void GETPetMonthly(PetHasMonthCardBean bean) {
            petView.GETPetMonthly(bean);
        }

        @Override
        public void GETPetVariety(PetVariety bean) {
            petView.GETPetVariety(bean);
        }
    };

    @Override
    public void unsubscribe() {
        petModel.unsubscribe();
        petModel = null;
        petView = null;
    }

    @Override
    public void GETPetList(String Authorization) {
        petModel.GETPetList(Authorization);
    }

    @Override
    public void GETPetDetail(String Authorization, int PetId) {
        petModel.GETPetDetail(Authorization,PetId);
    }

    @Override
    public void POSTCreatePet(String Authorization, String name, String age, int variety_id, String zh_variety,
                              String en_variety, String blood_type, String weight, boolean chip, String description) {
        petModel.POSTCreatePet(Authorization,name,age,variety_id,zh_variety,en_variety,blood_type,weight,chip,description);
    }

    @Override
    public void PUTPetDetail(String Authorization, int PetId, String name, String age, int variety_id, String zh_variety, String en_variety, String blood_type, String weight, boolean chip, String description) {
        petModel.PUTPetDetail(Authorization,PetId,name,age,variety_id,zh_variety,en_variety,blood_type,weight,chip,description);
    }

    @Override
    public void POSTPetAvatar(String Authorization, int PetId, MultipartBody.Part avatar) {
        petModel.POSTPetAvatar(Authorization,PetId,avatar);
    }

    @Override
    public void DeletePet(String Authorization, int PetId) {
        petModel.DeletePet(Authorization,PetId);
    }

    @Override
    public void GETPetMonthly(String Authorization, int PetId, int StoreId) {
        petModel.GETPetMonthly(Authorization,PetId,StoreId);
    }

    @Override
    public void GETPetVariety(String Authorization, String search_key, int page) {
        petModel.GETPetVariety(Authorization,search_key,page);
    }
}
