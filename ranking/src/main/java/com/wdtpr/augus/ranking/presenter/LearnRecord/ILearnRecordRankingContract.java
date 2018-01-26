package com.wdtpr.augus.ranking.presenter.LearnRecord;


import com.wdtpr.augus.ranking.IBasePresenter;
import com.wdtpr.augus.ranking.IBaseView;
import com.wdtpr.augus.ranking.model.bean.in.ranking.RankingItem;

import java.util.List;

/**
 * Created by augus on 2017/12/26.
 */

public interface ILearnRecordRankingContract {

    interface LearnRecordStateView extends IBaseView {

        void GETFail();//失敗

        void GetStudentRankingSucess(List<RankingItem> bean );

        void GetSingleStudentRankingSucess(RankingItem bean );

    }

    interface Presnter extends IBasePresenter {
        void GetStudentRanking( String Type,  int studentID,int PageNum);

        void GetSingleStudentRanking( String Type,  int studentID);
    }
}
