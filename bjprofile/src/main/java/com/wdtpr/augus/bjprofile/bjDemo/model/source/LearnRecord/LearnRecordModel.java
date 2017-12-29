package com.wdtpr.augus.bjprofile.bjDemo.model.source.LearnRecord;


import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.bjprofile.bjDemo.BaseModel;
import com.wdtpr.augus.bjprofile.bjDemo.api.API;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecord;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_Record;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.Movie;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarBean;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.ServerBean;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.Speak;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_Record;
import com.wdtpr.augus.bjprofile.bjDemo.network.RetrofitHelper_bj;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/10.
 */

public class LearnRecordModel extends BaseModel implements ILearnRecordModel {

    private ILearnRecordModel.LearnRecordStateListener learnRecordStateListener;

    public LearnRecordModel(ILearnRecordModel.LearnRecordStateListener learnRecordStateListener) {
        this.learnRecordStateListener = learnRecordStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        learnRecordStateListener = null;
    }

    @Override
    public void GETIRSList(final int studentID, final String courseNo) {
        if (learnRecordStateListener == null) return;
        learnRecordStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_bj.instance().create(API.class).GetServerToken("Melody", "Melody12345")
                .flatMap(new Function<ServerBean, Publisher<Result<IRS_Record>>>() {
                    @Override
                    public Publisher<Result<IRS_Record>> apply(ServerBean serverBean) throws Exception {
                        String token = serverBean.getResult_content();
                        return RetrofitHelper_bj.instance().create(API.class).GetIRSRecord(token, studentID, courseNo);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<IRS_Record>>() {
                    @Override
                    public void onNext(Result<IRS_Record> listResult) {

                        //
                        final int responseCode = listResult.response().code();
                        if (responseCode == 200) {
                            IRS_Record bean = listResult.response().body();
                            learnRecordStateListener.GETIRSListSucess(bean.getResult_content());
                        } else {
                            learnRecordStateListener.GETFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        learnRecordStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        learnRecordStateListener.onComplete();
                    }
                }));

    }


    @Override
    public void GetMovieRecord(final int studentID, final String courseNo) {
        if (learnRecordStateListener == null) return;
        learnRecordStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_bj.instance().create(API.class).GetServerToken("Melody", "Melody12345")
                .flatMap(new Function<ServerBean, Publisher<Result<Movie>>>() {
                    @Override
                    public Publisher<Result<Movie>> apply(ServerBean serverBean) throws Exception {
                        String token = serverBean.getResult_content();
                        return RetrofitHelper_bj.instance().create(API.class).GetMovieRecord(token, studentID, courseNo);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Movie>>() {
                    @Override
                    public void onNext(Result<Movie> listResult) {

                        //
                        final int responseCode = listResult.response().code();
                        if (responseCode == 200) {
                            Movie bean = listResult.response().body();
                            learnRecordStateListener.GetMovieRecordSucess(bean.getResult_content());
                        } else {
                            learnRecordStateListener.GETFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        learnRecordStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        learnRecordStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void GetTestRecord(final int studentID, final String bookNo) {
        if (learnRecordStateListener == null) return;
        learnRecordStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_bj.instance().create(API.class).GetServerToken("Melody", "Melody12345")
                .flatMap(new Function<ServerBean, Publisher<Result<TEST_Record>>>() {
                    @Override
                    public Publisher<Result<TEST_Record>> apply(ServerBean serverBean) throws Exception {
                        String token = serverBean.getResult_content();
                        return RetrofitHelper_bj.instance().create(API.class).GetTestRecord(token, studentID, bookNo);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<TEST_Record>>() {
                    @Override
                    public void onNext(Result<TEST_Record> listResult) {

                        //
                        final int responseCode = listResult.response().code();
                        if (responseCode == 200) {
                            TEST_Record bean = listResult.response().body();
                            learnRecordStateListener.GetTestRecordSucess(bean.getResult_content());
                        } else {
                            learnRecordStateListener.GETFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        learnRecordStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        learnRecordStateListener.onComplete();
                    }
                }));

    }

    @Override
    public void GetRadar(final int studentID) {
        if (learnRecordStateListener == null) return;
        learnRecordStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_bj.instance().create(API.class).GetServerToken("Melody", "Melody12345")
                .flatMap(new Function<ServerBean, Publisher<Result<RadarBean>>>() {
                    @Override
                    public Publisher<Result<RadarBean>> apply(ServerBean serverBean) throws Exception {
                        String token = serverBean.getResult_content();
                        return RetrofitHelper_bj.instance().create(API.class).GetRadar(token, studentID);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<RadarBean>>() {
                    @Override
                    public void onNext(Result<RadarBean> radarBeanResult) {

                        //
                        final int responseCode = radarBeanResult.response().code();
                        if (responseCode == 200) {
                            RadarBean bean = radarBeanResult.response().body();
                            learnRecordStateListener.GetRadarSuccess(bean.getResult_content());
                        } else {
                            learnRecordStateListener.GETFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        learnRecordStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        learnRecordStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void GetSpeakTestRecordByID(final int StudentId) {
        if (learnRecordStateListener == null) return;
        learnRecordStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_bj.instance().create(API.class).GetServerToken("Melody", "Melody12345")
                .flatMap(new Function<ServerBean, Publisher<Result<Speak>>>() {
                    @Override
                    public Publisher<Result<Speak>> apply(ServerBean serverBean) throws Exception {
                        String token = serverBean.getResult_content();
                        return RetrofitHelper_bj.instance().create(API.class).GetSpeakTestRecordByID(token, StudentId);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Speak>>() {
                    @Override
                    public void onNext(Result<Speak> radarBeanResult) {

                        //
                        final int responseCode = radarBeanResult.response().code();
                        if (responseCode == 200) {
                            Speak bean = radarBeanResult.response().body();
                            learnRecordStateListener.GetSpeakTestRecordByIDSucess(bean.getResult_content());
                        } else {
                            learnRecordStateListener.GETFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        learnRecordStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        learnRecordStateListener.onComplete();
                    }
                }));
    }

    @Override
    public void GetGoldRecord(final int StudentId) {
        if (learnRecordStateListener == null) return;
        learnRecordStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_bj.instance().create(API.class).GetServerToken("Melody", "Melody12345")
                .flatMap(new Function<ServerBean, Publisher<Result<GoldRecord>>>() {
                    @Override
                    public Publisher<Result<GoldRecord>> apply(ServerBean serverBean) throws Exception {
                        String token = serverBean.getResult_content();
                        return RetrofitHelper_bj.instance().create(API.class).GetGoldRecord(token, StudentId);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<GoldRecord>>() {
                    @Override
                    public void onNext(Result<GoldRecord> goldRecordResult) {

                        //
                        final int responseCode = goldRecordResult.response().code();
                        if (responseCode == 200) {
                            GoldRecord bean = goldRecordResult.response().body();
                            learnRecordStateListener.GetGoldRecord(bean.getResult_content());
                        } else {
                            learnRecordStateListener.GETFail();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        disposableManager.clear();
                        learnRecordStateListener.onUnknowError(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        learnRecordStateListener.onComplete();
                    }
                }));
    }
}
