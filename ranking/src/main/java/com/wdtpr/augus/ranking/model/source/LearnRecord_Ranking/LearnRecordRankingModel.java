package com.wdtpr.augus.ranking.model.source.LearnRecord_Ranking;


import com.jakewharton.retrofit2.adapter.rxjava2.Result;
import com.wdtpr.augus.ranking.BaseModel;
import com.wdtpr.augus.ranking.api.API;
import com.wdtpr.augus.ranking.model.bean.in.ServerBean;
import com.wdtpr.augus.ranking.model.bean.in.ranking.Rank_all;
import com.wdtpr.augus.ranking.model.bean.in.ranking.Rank_single;
import com.wdtpr.augus.ranking.model.bean.in.ranking.RankingItem;
import com.wdtpr.augus.ranking.network.RetrofitHelper_bj;
import com.wdtpr.augus.ranking.utils.ListUtils;
import com.wdtpr.augus.ranking.utils.LogUtils;

import org.reactivestreams.Publisher;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by augus on 2017/12/10.
 */

public class LearnRecordRankingModel extends BaseModel implements ILearnRecordRankingModel {

    private ILearnRecordRankingModel.LearnRecordStateListener learnRecordStateListener;

    public LearnRecordRankingModel(ILearnRecordRankingModel.LearnRecordStateListener learnRecordStateListener) {
        this.learnRecordStateListener = learnRecordStateListener;
    }

    public void unsubscribe() {
        disposableManager.clear();
        learnRecordStateListener = null;
    }


    @Override
    public void GetStudentRanking(final String Type,final int studentID,final int pageNum) {
        LogUtils.d("Type:"+Type+",studentID:"+studentID+",pageNum:"+pageNum);
        if (learnRecordStateListener == null) return;
        learnRecordStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_bj.instance().create(API.class).GetServerToken("Melody", "Melody12345")
                .flatMap(new Function<ServerBean, Publisher<Result<Rank_all>>>() {
                    @Override
                    public Publisher<Result<Rank_all>> apply(ServerBean serverBean) throws Exception {
                        String token = serverBean.getResult_content();
                        return RetrofitHelper_bj.instance().create(API.class).GetStudentRanking(token, Type,studentID, pageNum);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Rank_all>>() {
                    @Override
                    public void onNext(Result<Rank_all> rank_allResult) {

                        //
                        final int responseCode = rank_allResult.response().code();
                        if (responseCode == 200) {
                            Rank_all bean = rank_allResult.response().body();
                            if(!ListUtils.isEmpty(bean.getResult_content())){
                                //加入type
                                for(RankingItem item : bean.getResult_content()) {
                                    item.setType(Type);
                                    item.setItemType(1001);
                                }
                            }
                            learnRecordStateListener.GetStudentRankingSucess(bean.getResult_content());

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
    public void GetSingleStudentRanking(final String Type, final int studentID) {
        LogUtils.d("Type:"+Type+",studentID:"+studentID);
        if (learnRecordStateListener == null) return;
        learnRecordStateListener.onStart();
        //
        disposableManager.add(RetrofitHelper_bj.instance().create(API.class).GetServerToken("Melody", "Melody12345")
                .flatMap(new Function<ServerBean, Publisher<Result<Rank_single>>>() {
                    @Override
                    public Publisher<Result<Rank_single>> apply(ServerBean serverBean) throws Exception {
                        String token = serverBean.getResult_content();
                        return RetrofitHelper_bj.instance().create(API.class).GetSingleStudentRanking(token, Type,studentID);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Result<Rank_single>>() {
                    @Override
                    public void onNext(Result<Rank_single> rank_singleResult) {

                        //
                        final int responseCode = rank_singleResult.response().code();
                        if (responseCode == 200) {
                            Rank_single bean = rank_singleResult.response().body();

                            if(bean.getResult_content() != null){
                                bean.getResult_content().setType(Type);
                                bean.getResult_content().setItemType(1002);
                            }

                            learnRecordStateListener.GetSingleStudentRankingSucess(bean.getResult_content());
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
