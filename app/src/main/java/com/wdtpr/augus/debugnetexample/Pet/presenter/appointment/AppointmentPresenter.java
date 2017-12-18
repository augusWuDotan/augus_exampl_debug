package com.wdtpr.augus.debugnetexample.Pet.presenter.appointment;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.source.appointment.AppointmentModel;
import com.wdtpr.augus.debugnetexample.Pet.model.source.appointment.IAppointmentModel;
import com.wdtpr.augus.debugnetexample.base.BasePresenter;

/**
 * Created by augus on 2017/12/17.
 */

public class AppointmentPresenter extends BasePresenter implements IAppointmentContract.Presnter {

    private IAppointmentContract.AppointmentStateView appointmentStateView;
    private AppointmentModel appointmentModel;

    public AppointmentPresenter(IAppointmentContract.AppointmentStateView appointmentStateView) {
        this.appointmentStateView = appointmentStateView;
        appointmentModel = new AppointmentModel(appointmentStateListener);
    }

    public IAppointmentModel.AppointmentStateListener appointmentStateListener = new IAppointmentModel.AppointmentStateListener() {
        @Override
        public void onStart() {
            appointmentStateView.showLoading();
        }

        @Override
        public void onComplete() {
            appointmentStateView.hideLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            appointmentStateView.showUnknowError(errorStr);
        }

        @Override
        public void AppointmentFail() {
            appointmentStateView.AppointmentFail();
        }

        @Override
        public void GETAppointment(AppointmentListBean bean) {
            appointmentStateView.GETAppointment(bean);
        }

        @Override
        public void GETAppointmentWithId(AppointmentDetailBean bean) {
            appointmentStateView.GETAppointmentWithId(bean);
        }

        @Override
        public void GETAppointmentWithStatus(AppointmentListBean bean) {
            appointmentStateView.GETAppointmentWithStatus(bean);
        }

        @Override
        public void GETAppointmentWithStroe(AppointmentListBean bean) {
            appointmentStateView.GETAppointmentWithStroe(bean);
        }

        @Override
        public void GETAppointmentWithStroeWithStatus(AppointmentListBean bean) {
            appointmentStateView.GETAppointmentWithStroeWithStatus(bean);
        }

        @Override
        public void GETAppointmentWithCustomer(AppointmentListBean bean) {
            appointmentStateView.GETAppointmentWithCustomer(bean);
        }

        @Override
        public void GETAppointmentWithCustomerWithStatus(AppointmentListBean bean) {
            appointmentStateView.GETAppointmentWithCustomerWithStatus(bean);
        }

        @Override
        public void POSTAppointment_Store(Status bean) {
            appointmentStateView.POSTAppointment_Store(bean);
        }

        @Override
        public void POSTAppointment_Customer(Status bean) {
            appointmentStateView.POSTAppointment_Customer(bean);
        }

        @Override
        public void POSTAppointmentAccept(Status bean) {
            appointmentStateView.POSTAppointmentAccept(bean);
        }

        @Override
        public void POSTAppointmentFinish(Status bean) {
            appointmentStateView.POSTAppointmentFinish(bean);
        }

        @Override
        public void POSTAppointmentDeny(Status bean) {
            appointmentStateView.POSTAppointmentDeny(bean);
        }

        @Override
        public void POSTAppointmentCancel(Status bean) {
            appointmentStateView.POSTAppointmentCancel(bean);
        }
    };

    @Override
    public void unsubscribe() {
        appointmentModel.unsubscribe();
        appointmentModel = null;
        appointmentStateView= null;
    }

    @Override
    public void GETAppointment(String Authorization, String start_time, String end_time, boolean paginator, int page) {
        appointmentModel.GETAppointment(Authorization,start_time,end_time,paginator,page);
    }

    @Override
    public void GETAppointmentWithId(String Authorization, int AppointmentId) {
        appointmentModel.GETAppointmentWithId(Authorization,AppointmentId);
    }

    @Override
    public void GETAppointmentWithStatus(String Authorization, String status, String start_time, String end_time, boolean paginator, int page) {
        appointmentModel.GETAppointmentWithStatus(Authorization,status,start_time,end_time,paginator,page);
    }

    @Override
    public void GETAppointmentWithStroe(String Authorization, int store_id, String start_time, String end_time, boolean paginator, int page) {
        appointmentModel.GETAppointmentWithStroe(Authorization,store_id,start_time,end_time,paginator,page);
    }

    @Override
    public void GETAppointmentWithStroeWithStatus(String Authorization, int store_id, String status, String start_time, String end_time, boolean paginator, int page) {
        appointmentModel.GETAppointmentWithStroeWithStatus(Authorization,store_id,status,start_time,end_time,paginator,page);
    }

    @Override
    public void GETAppointmentWithCustomer(String Authorization, int customer_id, String start_time, String end_time, boolean paginator, int page) {
        appointmentModel.GETAppointmentWithCustomer(Authorization,customer_id,start_time,end_time,paginator,page);
    }

    @Override
    public void GETAppointmentWithCustomerWithStatus(String Authorization, int customer_id, String status, String start_time, String end_time, boolean paginator, int page) {
        appointmentModel.GETAppointmentWithCustomerWithStatus(Authorization,customer_id,status,start_time,end_time,paginator,page);
    }

    @Override
    public void POSTAppointment_Store(String Authorization, int store_id, int customer_id, int provider_id, int pet_id, String start_at, String end_at, boolean is_monthly, boolean with_lodging, String description) {
        appointmentModel.POSTAppointment_Store(Authorization,store_id,customer_id,provider_id,pet_id,start_at,end_at,is_monthly,with_lodging,description);
    }

    @Override
    public void POSTAppointment_Customer(String Authorization, int store_id, int customer_id, int pet_id, String start_at, String end_at, boolean is_monthly, boolean with_lodging, String description) {
        appointmentModel.POSTAppointment_Customer(Authorization,store_id,customer_id,pet_id,start_at,end_at,is_monthly,with_lodging,description);
    }

    @Override
    public void POSTAppointmentAccept(String Authorization, int appointmentId, int provider_id) {
        appointmentModel.POSTAppointmentAccept(Authorization,appointmentId,provider_id);
    }

    @Override
    public void POSTAppointmentFinish(String Authorization, int appointmentId) {
        appointmentModel.POSTAppointmentFinish(Authorization,appointmentId);
    }

    @Override
    public void POSTAppointmentDeny(String Authorization, int appointmentId) {
        appointmentModel.POSTAppointmentDeny(Authorization,appointmentId);
    }

    @Override
    public void POSTAppointmentCancel(String Authorization, int appointmentId) {
        appointmentModel.POSTAppointmentCancel(Authorization,appointmentId);
    }
}
