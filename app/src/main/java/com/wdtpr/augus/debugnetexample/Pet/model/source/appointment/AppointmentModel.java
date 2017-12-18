package com.wdtpr.augus.debugnetexample.Pet.model.source.appointment;

import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.debugnetexample.Pet.api.AppointmentAPI;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentListBean;
import com.wdtpr.augus.debugnetexample.Pet.network.RetrofitHelper_Pet;
import com.wdtpr.augus.debugnetexample.base.BaseModel;
import com.wdtpr.augus.debugnetexample.base.Utils.ErrorCodeUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.debugnetexample.base.Utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/10.
 */

public class AppointmentModel extends BaseModel implements IAppointmentModel {

    private IAppointmentModel.AppointmentStateListener appointmentStateListener;

    public AppointmentModel(AppointmentStateListener appointmentStateListener) {
        this.appointmentStateListener = appointmentStateListener;
    }

    public void unsubscribe(){
        disposableManager.clear();
        appointmentStateListener = null;
    }

    @Override
    public void GETAppointment(String Authorization, String start_time, String end_time, boolean paginator, int page) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).GETAppointment("Bearer " + Authorization, start_time, end_time,paginator,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AppointmentListBean>>() {
                    @Override
                    public void onNext(Result<AppointmentListBean> appointmentListBeanResult) {
                        //
                        final int responseCode = appointmentListBeanResult.response().code();
                        if(responseCode == 200){
                            AppointmentListBean bean = appointmentListBeanResult.response().body();
                            appointmentStateListener.GETAppointment(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void GETAppointmentWithId(String Authorization, int AppointmentId) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).GETAppointmentWithId("Bearer " + Authorization, AppointmentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AppointmentDetailBean>>() {
                    @Override
                    public void onNext(Result<AppointmentDetailBean> appointmentDetailBeanResult) {
                        //
                        final int responseCode = appointmentDetailBeanResult.response().code();
                        if(responseCode == 200){
                            AppointmentDetailBean bean = appointmentDetailBeanResult.response().body();
                            appointmentStateListener.GETAppointmentWithId(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void GETAppointmentWithStatus(String Authorization, String status, String start_time, String end_time, boolean paginator, int page) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
//
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).GETAppointmentWithStatus("Bearer " + Authorization, status, start_time, end_time, paginator, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AppointmentListBean>>() {
                    @Override
                    public void onNext(Result<AppointmentListBean> appointmentListBeanResult) {
                        //
                        final int responseCode = appointmentListBeanResult.response().code();
                        if(responseCode == 200){
                            AppointmentListBean bean = appointmentListBeanResult.response().body();
                            appointmentStateListener.GETAppointmentWithStatus(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void GETAppointmentWithStroe(String Authorization, int store_id, String start_time, String end_time, boolean paginator, int page) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).GETAppointmentWithStroe("Bearer " + Authorization, store_id, start_time, end_time, paginator, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AppointmentListBean>>() {
                    @Override
                    public void onNext(Result<AppointmentListBean> appointmentListBeanResult) {
                        //
                        final int responseCode = appointmentListBeanResult.response().code();
                        if(responseCode == 200){
                            AppointmentListBean bean = appointmentListBeanResult.response().body();
                            appointmentStateListener.GETAppointmentWithStroe(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void GETAppointmentWithStroeWithStatus(String Authorization, int store_id, String status, String start_time, String end_time, boolean paginator, int page) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).GETAppointmentWithStroeWithStatus("Bearer " + Authorization, store_id, status, start_time, end_time, paginator, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AppointmentListBean>>() {
                    @Override
                    public void onNext(Result<AppointmentListBean> appointmentListBeanResult) {
                        //
                        final int responseCode = appointmentListBeanResult.response().code();
                        if(responseCode == 200){
                            AppointmentListBean bean = appointmentListBeanResult.response().body();
                            appointmentStateListener.GETAppointmentWithStroeWithStatus(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void GETAppointmentWithCustomer(String Authorization, int customer_id, String start_time, String end_time, boolean paginator, int page) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).GETAppointmentWithCustomer("Bearer " + Authorization, customer_id, start_time, end_time, paginator, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AppointmentListBean>>() {
                    @Override
                    public void onNext(Result<AppointmentListBean> appointmentListBeanResult) {
                        //
                        final int responseCode = appointmentListBeanResult.response().code();
                        if(responseCode == 200){
                            AppointmentListBean bean = appointmentListBeanResult.response().body();
                            appointmentStateListener.GETAppointmentWithCustomer(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void GETAppointmentWithCustomerWithStatus(String Authorization, int customer_id, String status, String start_time, String end_time, boolean paginator, int page) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).GETAppointmentWithCustomerWithStatus("Bearer " + Authorization, customer_id, status, start_time, end_time, paginator, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<AppointmentListBean>>() {
                    @Override
                    public void onNext(Result<AppointmentListBean> appointmentListBeanResult) {
                        //
                        final int responseCode = appointmentListBeanResult.response().code();
                        if(responseCode == 200){
                            AppointmentListBean bean = appointmentListBeanResult.response().body();
                            appointmentStateListener.GETAppointmentWithCustomerWithStatus(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void POSTAppointment_Store(String Authorization, int store_id, int customer_id, int provider_id, int pet_id, String start_at, String end_at, boolean is_monthly, boolean with_lodging, String description) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).POSTAppointment_Store("Bearer " + Authorization, store_id, customer_id, provider_id, pet_id, start_at, end_at, is_monthly, with_lodging, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if(responseCode == 200){
                            Status bean = statusResult.response().body();
                            appointmentStateListener.POSTAppointment_Store(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));


    }

    @Override
    public void POSTAppointment_Customer(String Authorization, int store_id, int customer_id, int pet_id, String start_at, String end_at, boolean is_monthly, boolean with_lodging, String description) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).POSTAppointment_Customer("Bearer " + Authorization, store_id, customer_id, pet_id, start_at, end_at, is_monthly, with_lodging, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if(responseCode == 200){
                            Status bean = statusResult.response().body();
                            appointmentStateListener.POSTAppointment_Customer(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTAppointmentAccept(String Authorization, int appointmentId, int provider_id) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).POSTAppointmentAccept("Bearer " + Authorization, appointmentId, provider_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if(responseCode == 200){
                            Status bean = statusResult.response().body();
                            appointmentStateListener.POSTAppointmentAccept(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTAppointmentFinish(String Authorization, int appointmentId) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).POSTAppointmentFinish("Bearer " + Authorization, appointmentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if(responseCode == 200){
                            Status bean = statusResult.response().body();
                            appointmentStateListener.POSTAppointmentFinish(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTAppointmentDeny(String Authorization, int appointmentId) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).POSTAppointmentDeny("Bearer " + Authorization, appointmentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        //
                        final int responseCode = statusResult.response().code();
                        if(responseCode == 200){
                            Status bean = statusResult.response().body();
                            appointmentStateListener.POSTAppointmentDeny(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void POSTAppointmentCancel(String Authorization, int appointmentId) {
        if(appointmentStateListener == null) return;
        appointmentStateListener.onStart();
//
        disposableManager.add(RetrofitHelper_Pet.instance().create(AppointmentAPI.class).POSTAppointmentCancel("Bearer " + Authorization, appointmentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Status>>() {
                    @Override
                    public void onNext(Result<Status> statusResult) {
                        final int responseCode = statusResult.response().code();
                        if(responseCode == 200){
                            Status bean = statusResult.response().body();
                            appointmentStateListener.POSTAppointmentCancel(bean);
                        }else{
                            String errorStr = ErrorCodeUtils.getErrorCallBack(responseCode);
                            if (!StringUtils.isEmpty(errorStr))
                                appointmentStateListener.onUnknowError(errorStr);
                            else appointmentStateListener.AppointmentFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        appointmentStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appointmentStateListener.onComplete();
                    }
                }));
    }
}
