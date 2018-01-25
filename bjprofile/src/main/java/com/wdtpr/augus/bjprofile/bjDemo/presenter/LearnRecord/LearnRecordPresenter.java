package com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord;


import com.wdtpr.augus.bjprofile.bjDemo.BasePresenter;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarModelData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.SpellData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.source.LearnRecord.ILearnRecordModel;
import com.wdtpr.augus.bjprofile.bjDemo.model.source.LearnRecord.LearnRecordModel;

import java.util.List;

/**
 * Created by augus on 2017/12/26.
 */

public class LearnRecordPresenter extends BasePresenter implements ILearnRecordContract.Presnter {


    private ILearnRecordContract.LearnRecordIRSStateView learnRecordIRSStateView;
    private LearnRecordModel learnRecordModel;

    public LearnRecordPresenter(ILearnRecordContract.LearnRecordIRSStateView learnRecordIRSStateView) {
        this.learnRecordIRSStateView = learnRecordIRSStateView;
        learnRecordModel = new LearnRecordModel(learnRecordStateListener);
    }

    public ILearnRecordModel.LearnRecordStateListener learnRecordStateListener = new ILearnRecordModel.LearnRecordStateListener() {
        @Override
        public void onStart() {
            learnRecordIRSStateView.showLoading();
        }

        @Override
        public void onComplete() {
            learnRecordIRSStateView.hideLoading();
        }

        @Override
        public void onUnknowError(String errorStr) {
            learnRecordIRSStateView.showUnknowError(errorStr);
        }

        @Override
        public void GETFail() {
            learnRecordIRSStateView.GETFail();
        }

        @Override
        public void GETIRSListSucess(List<IRS_RecordData> bean) {
            learnRecordIRSStateView.GETIRSListSucess(bean);
        }

        @Override
        public void GetMovieRecordSucess(List<MovieData> bean) {
            learnRecordIRSStateView.GetMovieRecordSucess(bean);
        }

        @Override
        public void GetTestRecordSucess(List<TEST_RecordData> bean) {
            learnRecordIRSStateView.GetTestRecordSucess(bean);
        }

        @Override
        public void GetRadarSuccess(RadarModelData bean) {
            learnRecordIRSStateView.GetRadarSucess(bean);
        }

        @Override
        public void GetSpeakTestRecordByIDSucess(List<SpeakData> bean) {
            learnRecordIRSStateView.GetSpeakTestRecordByIDSucess(bean);
        }

        @Override
        public void GetGoldRecord(List<GoldRecordItem> bean) {
            learnRecordIRSStateView.GetGoldRecord(bean);
        }

        @Override
        public void GetSpellSucess(List<SpellData> bean) {
            learnRecordIRSStateView.GetSpellSucess(bean);
        }
    };


    @Override
    public void unsubscribe() {
        learnRecordModel.unsubscribe();
        learnRecordModel = null;
        learnRecordIRSStateView = null;
    }

    @Override
    public void GETIRSList(int studentID, String courseNo) {
        learnRecordModel.GETIRSList(studentID, courseNo);
    }

    @Override
    public void GetMovieRecord(int studentID, String courseNo) {
        learnRecordModel.GetMovieRecord(studentID, courseNo);
    }

    @Override
    public void GetTestRecord(int studentID, String bookNo) {
        learnRecordModel.GetTestRecord(studentID, bookNo);
    }

    @Override
    public void GetRadar(int studentID) {
        learnRecordModel.GetRadar(studentID);
    }

    @Override
    public void GetSpeakTestRecordByID(int StudentId) {
        learnRecordModel.GetSpeakTestRecordByID(StudentId);
    }

    @Override
    public void GetGoldRecord(int StudentId) {
        learnRecordModel.GetGoldRecord(StudentId);
    }

    @Override
    public void GetSpellTestRecord(int StudentId) {
        learnRecordModel.GetSpell(StudentId);
    }
}
