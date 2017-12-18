package com.wdtpr.augus.debugnetexample.Pet.model.source.pet;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.PetAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.customer.CustomerListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetCreateStatusBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetHasMonthCardBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.pet.PetVariety;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.MultipartBody;

/**
 * Created by augus on 2017/12/3.
 */

public class PetModel extends BaseModel implements IPetModel {

    private IPetModel.PetListener petListener;

    public PetModel(PetListener petListener) {
        this.petListener = petListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        petListener = null;
    }

    @Override
    public void GETPetList(String Authorization) {
        if (petListener == null) return;
        petListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(PetAPI.class).GETPetList("Bearer " + Authorization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<PetListBean>>() {
                    @Override
                    public void onNext(Result<PetListBean> petListBeanResult) {
                        //
                        final int responseCode = petListBeanResult.response().code();
                        if (responseCode == 200) {
                            PetListBean bean = petListBeanResult.response().body();
                            petListener.GETPetList(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) petListener.onUnknowError(errorStr);
                            else petListener.PetFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        petListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        petListener.onComplete();
                    }
                }));
    }

    @Override
    public void GETPetDetail(String Authorization, int PetId) {
        if (petListener == null) return;
        petListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(PetAPI.class).GETPetDetail("Bearer " + Authorization, PetId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<PetDetailBean>>() {
                    @Override
                    public void onNext(Result<PetDetailBean> petDetailBeanResult) {
                        //
                        final int responseCode = petDetailBeanResult.response().code();
                        if (responseCode == 200) {
                            PetDetailBean bean = petDetailBeanResult.response().body();
                            petListener.GETPetDetail(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) petListener.onUnknowError(errorStr);
                            else petListener.PetFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        petListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        petListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTCreatePet(String Authorization, String name, String age, int variety_id, String zh_variety, String en_variety,
                              String blood_type, String weight, boolean chip, String description) {
        if (petListener == null) return;
        petListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(PetAPI.class).POSTCreatePet("Bearer " + Authorization, name, age, variety_id, zh_variety, en_variety, blood_type, weight, chip, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<PetCreateStatusBean>>() {
                    @Override
                    public void onNext(Result<PetCreateStatusBean> petCreateStatusBeanResult) {
                        //
                        final int responseCode = petCreateStatusBeanResult.response().code();
                        if (responseCode == 200) {
                            PetCreateStatusBean bean = petCreateStatusBeanResult.response().body();
                            petListener.POSTCreatePet(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) petListener.onUnknowError(errorStr);
                            else petListener.PetFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        petListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        petListener.onComplete();
                    }
                }));
    }

    @Override
    public void PUTPetDetail(String Authorization, int PetId, String name, String age, int variety_id, String zh_variety, String en_variety,
                             String blood_type, String weight, boolean chip, String description) {
        if (petListener == null) return;
        petListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(PetAPI.class).PUTPetDetail("Bearer " + Authorization, PetId, name, age, variety_id, zh_variety, en_variety, blood_type, weight, chip, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            petListener.PUTPetDetail(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) petListener.onUnknowError(errorStr);
                            else petListener.PetFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        petListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        petListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTPetAvatar(String Authorization, int PetId, MultipartBody.Part avatar) {
        if (petListener == null) return;
        petListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(PetAPI.class).POSTPetAvatar("Bearer " + Authorization, PetId, avatar)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            petListener.POSTPetAvatar(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) petListener.onUnknowError(errorStr);
                            else petListener.PetFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        petListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        petListener.onComplete();
                    }
                }));
    }

    @Override
    public void DeletePet(String Authorization, int PetId) {
        if (petListener == null) return;
        petListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(PetAPI.class).DeletePet("Bearer " + Authorization, PetId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if (responseCode == 200) {
                            Status bean = statusResult.response().body();
                            petListener.DeletePet(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) petListener.onUnknowError(errorStr);
                            else petListener.PetFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        petListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        petListener.onComplete();
                    }
                }));
    }

    @Override
    public void GETPetMonthly(String Authorization, int PetId, int StoreId) {
        if (petListener == null) return;
        petListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(PetAPI.class).GETPetMonthly("Bearer " + Authorization, PetId, StoreId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<PetHasMonthCardBean>>() {
                    @Override
                    public void onNext(Result<PetHasMonthCardBean> petHasMonthCardBeanResult) {
                        //
                        final int responseCode = petHasMonthCardBeanResult.response().code();
                        if (responseCode == 200) {
                            PetHasMonthCardBean bean = petHasMonthCardBeanResult.response().body();
                            petListener.GETPetMonthly(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) petListener.onUnknowError(errorStr);
                            else petListener.PetFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        petListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        petListener.onComplete();
                    }
                }));
    }

    @Override
    public void GETPetVariety(String Authorization, String search_key, int page) {
        if (petListener == null) return;
        petListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(PetAPI.class).GETPetVariety("Bearer " + Authorization, search_key, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<PetVariety>>() {
                    @Override
                    public void onNext(Result<PetVariety> petVarietyResult) {
                        //
                        final int responseCode = petVarietyResult.response().code();
                        if (responseCode == 200) {
                            PetVariety bean = petVarietyResult.response().body();
                            petListener.GETPetVariety(bean);
                        } else {
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr)) petListener.onUnknowError(errorStr);
                            else petListener.PetFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        petListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        petListener.onComplete();
                    }
                }));
    }
}
