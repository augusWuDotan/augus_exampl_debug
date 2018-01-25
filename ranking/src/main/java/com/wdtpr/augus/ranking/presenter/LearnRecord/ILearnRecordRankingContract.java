package com.wdtpr.augus.ranking.presenter.LearnRecord;


import com.wdtpr.augus.ranking.IBasePresenter;
import com.wdtpr.augus.ranking.IBaseView;

/**
 * Created by augus on 2017/12/26.
 */

public interface ILearnRecordRankingContract {

    interface LearnRecordStateView extends IBaseView {

        void GETFail();//失敗

    }

    interface Presnter extends IBasePresenter {

    }
}
