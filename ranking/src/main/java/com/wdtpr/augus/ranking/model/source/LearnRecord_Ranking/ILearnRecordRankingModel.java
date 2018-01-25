package com.wdtpr.augus.ranking.model.source.LearnRecord_Ranking;


/**
 * Created by augus on 2017/12/10.
 */

public interface ILearnRecordRankingModel {

    interface LearnRecordStateListener {

        void onStart();

        void onComplete();

        void onUnknowError(String errorStr);

        void GETFail();//失敗


    }

}
