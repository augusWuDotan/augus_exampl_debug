package com.wdtpr.augus.ranking.presenter.LearnRecord;


import com.wdtpr.augus.ranking.BasePresenter;
import com.wdtpr.augus.ranking.model.source.LearnRecord_Ranking.ILearnRecordRankingModel;
import com.wdtpr.augus.ranking.model.source.LearnRecord_Ranking.LearnRecordRankingModel;

/**
 * Created by augus on 2017/12/26.
 */

public class LearnRecordPresenter extends BasePresenter implements ILearnRecordRankingContract.Presnter {


    private ILearnRecordRankingContract.LearnRecordStateView learnRecordStateView;
    private LearnRecordRankingModel learnRecordRankingModel;

    public LearnRecordPresenter(ILearnRecordRankingContract.LearnRecordStateView learnRecordStateView) {
        this.learnRecordStateView = learnRecordStateView;
        learnRecordRankingModel = new LearnRecordRankingModel(learnRecordStateListener);
    }

    public ILearnRecordRankingModel.LearnRecordStateListener learnRecordStateListener = new ILearnRecordRankingModel.LearnRecordStateListener() {
        @Override
        public void onStart() {

        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onUnknowError(String errorStr) {

        }

        @Override
        public void GETFail() {

        }
    };


    @Override
    public void unsubscribe() {
        learnRecordRankingModel.unsubscribe();
        learnRecordRankingModel = null;
        learnRecordStateView = null;
    }

}
