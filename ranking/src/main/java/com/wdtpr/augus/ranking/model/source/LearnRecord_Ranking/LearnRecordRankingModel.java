package com.wdtpr.augus.ranking.model.source.LearnRecord_Ranking;


import com.wdtpr.augus.ranking.BaseModel;
import com.wdtpr.augus.ranking.network.RetrofitHelper_bj;

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


}
