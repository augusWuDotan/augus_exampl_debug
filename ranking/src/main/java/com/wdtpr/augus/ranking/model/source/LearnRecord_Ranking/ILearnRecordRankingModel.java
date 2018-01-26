package com.wdtpr.augus.ranking.model.source.LearnRecord_Ranking;


import com.wdtpr.augus.ranking.model.bean.in.ranking.RankingItem;

import java.util.List;

import retrofit2.http.Field;

/**
 * Created by augus on 2017/12/10.
 */

public interface ILearnRecordRankingModel {

    interface LearnRecordStateListener {

        void onStart();

        void onComplete();

        void onUnknowError(String errorStr);

        void GETFail();//失敗

        void GetStudentRankingSucess(List<RankingItem> bean );

        void GetSingleStudentRankingSucess(RankingItem bean );
    }

    void GetStudentRanking( String Type,  int studentID,int pageNum);

    void GetSingleStudentRanking( String Type,  int studentID);
}
