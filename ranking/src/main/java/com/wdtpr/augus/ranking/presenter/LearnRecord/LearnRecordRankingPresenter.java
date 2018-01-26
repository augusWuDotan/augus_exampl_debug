package com.wdtpr.augus.ranking.presenter.LearnRecord;


import com.wdtpr.augus.ranking.BasePresenter;
import com.wdtpr.augus.ranking.model.bean.in.ranking.RankingItem;
import com.wdtpr.augus.ranking.model.source.LearnRecord_Ranking.ILearnRecordRankingModel;
import com.wdtpr.augus.ranking.model.source.LearnRecord_Ranking.LearnRecordRankingModel;

import java.util.List;

/**
 * Created by augus on 2017/12/26.
 */

public class LearnRecordRankingPresenter extends BasePresenter implements ILearnRecordRankingContract.Presnter {


    private ILearnRecordRankingContract.LearnRecordStateView learnRecordStateView;
    private LearnRecordRankingModel learnRecordRankingModel;

    public LearnRecordRankingPresenter(ILearnRecordRankingContract.LearnRecordStateView learnRecordStateView) {
        this.learnRecordStateView = learnRecordStateView;
        learnRecordRankingModel = new LearnRecordRankingModel(learnRecordStateListener);
    }

    public ILearnRecordRankingModel.LearnRecordStateListener learnRecordStateListener = new ILearnRecordRankingModel.LearnRecordStateListener() {
        @Override
        public void onStart() {
            learnRecordStateView.showLoading();
        }

        @Override
        public void onComplete() {
            learnRecordStateView.hideLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            learnRecordStateView.showUnknowError(errorStr);
        }

        @Override
        public void GETFail() {
            learnRecordStateView.GETFail();
        }

        @Override
        public void GetStudentRankingSucess(List<RankingItem> bean) {
            learnRecordStateView.GetStudentRankingSucess(bean);
        }

        @Override
        public void GetSingleStudentRankingSucess(RankingItem bean) {
            learnRecordStateView.GetSingleStudentRankingSucess(bean);
        }
    };


    @Override
    public void unsubscribe() {
        learnRecordRankingModel.unsubscribe();
        learnRecordRankingModel = null;
        learnRecordStateView = null;
    }

    @Override
    public void GetStudentRanking(String Type, int studentID ,int pageNum) {
        learnRecordRankingModel.GetStudentRanking(Type, studentID,pageNum);
    }

    @Override
    public void GetSingleStudentRanking(String Type, int studentID) {
        learnRecordRankingModel.GetSingleStudentRanking(Type, studentID);
    }
}
