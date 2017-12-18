package com.wdtpr.augus.debugnetexample.Pet.presenter.appointment;

import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.Status;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountCallBackBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.account.AccountListBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentDetailBean;
import com.wdtpr.augus.debugnetexample.Pet.model.bean.in.appointment.AppointmentListBean;
import com.wdtpr.augus.debugnetexample.base.IBasePresenter;
import com.wdtpr.augus.debugnetexample.base.IBaseView;

/**
 * Created by augus on 2017/12/13.
 *
 */

public interface IAppointmentContract {

    interface AppointmentStateView extends IBaseView {

        void AppointmentFail();

        void GETAppointment(AppointmentListBean bean);

        void GETAppointmentWithId(AppointmentDetailBean bean);

        void GETAppointmentWithStatus(AppointmentListBean bean);

        void GETAppointmentWithStroe(AppointmentListBean bean);

        void GETAppointmentWithStroeWithStatus(AppointmentListBean bean);

        void GETAppointmentWithCustomer(AppointmentListBean bean);

        void GETAppointmentWithCustomerWithStatus(AppointmentListBean bean);

        void POSTAppointment_Store(Status bean);

        void POSTAppointment_Customer(Status bean);

        void POSTAppointmentAccept(Status bean);

        void POSTAppointmentFinish(Status bean);

        void POSTAppointmentDeny(Status bean);

        void POSTAppointmentCancel(Status bean);

    }

    interface Presnter extends IBasePresenter {

        //
        void GETAppointment(String Authorization, String start_time, String end_time, boolean paginator, int page);
        //
        void GETAppointmentWithId(String Authorization, int AppointmentId);
        //
        void GETAppointmentWithStatus(String Authorization, String status, String start_time, String end_time, boolean paginator, int page);
        //
        void GETAppointmentWithStroe(String Authorization, int store_id, String start_time, String end_time, boolean paginator, int page);
        //
        void GETAppointmentWithStroeWithStatus(String Authorization, int store_id, String status, String start_time, String end_time, boolean paginator, int page);
        //
        void GETAppointmentWithCustomer(String Authorization, int customer_id, String start_time, String end_time, boolean paginator, int page);
        //
        void GETAppointmentWithCustomerWithStatus(String Authorization, int customer_id, String status, String start_time, String end_time, boolean paginator, int page);
        //
        void POSTAppointment_Store(String Authorization, int store_id, int customer_id, int provider_id, int pet_id,
                                   String start_at, String end_at, boolean is_monthly, boolean with_lodging, String description);
        //
        void POSTAppointment_Customer(String Authorization, int store_id, int customer_id, int pet_id,
                                      String start_at, String end_at, boolean is_monthly, boolean with_lodging, String description);

        //
        void POSTAppointmentAccept(String Authorization, int appointmentId, int provider_id);

        //
        void POSTAppointmentFinish(String Authorization, int appointmentId);

        //
        void POSTAppointmentDeny(String Authorization, int appointmentId);

        //
        void POSTAppointmentCancel(String Authorization, int appointmentId);

    }
}
