package com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord;


import com.wdtpr.augus.bjprofile.bjDemo.IBasePresenter;
import com.wdtpr.augus.bjprofile.bjDemo.IBaseView;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarModelData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.SpellData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordData;

import java.util.List;

/**
 * Created by augus on 2017/12/26.
 */

public interface ILearnRecordContract {

    interface LearnRecordIRSStateView extends IBaseView {

        void GETFail();//失敗

        void GETIRSListSucess(List<IRS_RecordData> bean);

        void GetMovieRecordSucess(List<MovieData> bean);

        void GetTestRecordSucess(List<TEST_RecordData> bean);

        void GetRadarSucess(RadarModelData bean);

        void GetSpeakTestRecordByIDSucess(List<SpeakData> bean);

        void GetGoldRecord(List<GoldRecordItem> bean);

        void GetSpellSucess(List<SpellData> bean);
    }

    interface Presnter extends IBasePresenter {

        //irs
        void GETIRSList(int studentID, String courseNo);

        //movie
        void GetMovieRecord(int studentID, String courseNo);

        //test
        void GetTestRecord(int studentID, String bookNo);

        //radar
        void GetRadar(int studentID);

        //speak
        void GetSpeakTestRecordByID(int StudentId);

        //GoldRecord
        void GetGoldRecord(int StudentId);

        //GoldRecord
        void GetSpellTestRecord(int StudentId);
    }
}
