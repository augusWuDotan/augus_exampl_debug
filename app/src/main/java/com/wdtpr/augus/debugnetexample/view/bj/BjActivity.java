package com.wdtpr.augus.debugnetexample.view.bj;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarModelData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.ILearnRecordContract;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.LearnRecordPresenter;
import com.wdtpr.augus.debugnetexample.R;
import com.wdtpr.augus.debugnetexample.base.Utils.LogUtils;
import com.wdtpr.augus.spellkeyboard.widget.SpellKeyBoard;

import java.util.List;


public class BjActivity extends AppCompatActivity {

    private LearnRecordPresenter learnRecordPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bj_main);
        //
        final SpellKeyBoard mSpellKeyBoard = (SpellKeyBoard) findViewById(R.id.mSpellKeyBoard);
        mSpellKeyBoard.setAnswer("I'm joe");
        mSpellKeyBoard.setKeyBoardNum(18);

        final SpellKeyBoard mSpellKeyBoard1 = (SpellKeyBoard) findViewById(R.id.mSpellKeyBoard1);
        mSpellKeyBoard1.setAnswer("TEST");
        mSpellKeyBoard1.setKeyBoardNum(12);

        //mSpellKeyBoard1.setAnswer("money"); 設定答案
        //mSpellKeyBoard1.setKeyBoardNum(12); 設定鍵盤數[size]
        //mSpellKeyBoard1.updateKeyword(); 更新

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSpellKeyBoard1.setAnswer("money");//設定答案
                mSpellKeyBoard1.setKeyBoardNum(12);//設定鍵盤數[size]
                mSpellKeyBoard1.updateKeyword();//更新
            }
        }, 3000);


        //
        learnRecordPresenter = new LearnRecordPresenter(new ILearnRecordContract.LearnRecordIRSStateView() {
            @Override
            public void GETFail() {

            }

            @Override
            public void GETIRSListSucess(List<IRS_RecordData> bean) {

            }

            @Override
            public void GetMovieRecordSucess(List<MovieData> bean) {

            }

            @Override
            public void GetTestRecordSucess(List<TEST_RecordData> bean) {

            }

            @Override
            public void GetRadarSucess(RadarModelData bean) {
                LogUtils.d(bean.toString());
            }

            @Override
            public void showLoading() {

            }

            @Override
            public void hideLoading() {

            }

            @Override
            public void showUnknowError(String errorStr) {

            }

            @Override
            public void GetSpeakTestRecordByIDSucess(List<SpeakData> bean) {

            }

            @Override
            public void GetGoldRecord(List<GoldRecordItem> bean) {
                //null
                LogUtils.d(bean.toString());
            }
        });

//        learnRecordPresenter.GetGoldRecord(18);
    }

    public void IRS(View view) {
        startActivity(new Intent(this, BjPagerActivity.class).putExtra("TYPE", "IRS"));
    }

    public void MOVIE(View view) {
        startActivity(new Intent(this, BjPagerActivity.class).putExtra("TYPE", "MOVIE"));
    }

    public void TEST(View view) {
        startActivity(new Intent(this, BjPagerActivity.class).putExtra("TYPE", "TEST"));
    }

    public void RADAR(View view) {
        startActivity(new Intent(this, BjPagerActivity.class).putExtra("TYPE", "RADAR"));
    }

    public void SPEAK(View view) {
        startActivity(new Intent(this, BjPagerActivity.class).putExtra("TYPE", "SPEAK"));
    }

    public void GOLD(View view) {
        startActivity(new Intent(this, BjPagerActivity.class).putExtra("TYPE", "GOLD"));
    }


}
