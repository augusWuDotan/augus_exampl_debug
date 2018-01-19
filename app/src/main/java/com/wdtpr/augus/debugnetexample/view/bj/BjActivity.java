package com.wdtpr.augus.debugnetexample.view.bj;

import android.content.Intent;
import android.os.Bundle;
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
import com.wdtpr.augus.spellkeyboard.model.listener.SpellKeyBoardListener;
import com.wdtpr.augus.spellkeyboard.widget.SpellKeyBoard;

import java.util.List;


public class BjActivity extends AppCompatActivity implements SpellKeyBoardListener  {


    private LearnRecordPresenter learnRecordPresenter;

    SpellKeyBoard mSpellKeyBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bj_main);



        //init
        mSpellKeyBoard = (SpellKeyBoard) findViewById(R.id.mSpellKeyBoard);
        //set anwser
        mSpellKeyBoard.setAnswer("test");
        /**
         * set 按鍵數
         * [count]<24 && [count]>=12 (需要3的倍數) ex 12,15,18,21
         * [count]<=40 && [count]>=23(需要4的倍數) ex 24,28,32,36,40
         */
        mSpellKeyBoard.setKeyBoardNum(24);
        /**
         * 設定版型
         */
        mSpellKeyBoard.setmType(1);// 1:答案格藍底 2:答案格黃底
        /**
         * 設定callback
         */
        mSpellKeyBoard.listener = this;

        /**
         * 更新方式
         */
//        mSpellKeyBoard.setAnswer("test");
//        mSpellKeyBoard.setKeyBoardNum(24);
//        mSpellKeyBoard.setmType(1);// 1:答案格藍底 2:答案格黃底
//        mSpellKeyBoard.updateKeyword();//呼叫重繪







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


    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("onDestroy");
        /**
         * 自主回收
         */
//        mSpellKeyBoard.unsubscribe();
//        mSpellKeyBoard1.unsubscribe();
    }






    @Override
    public void answerError(String ErrorStr) {
        LogUtils.d("錯誤答案為："+ErrorStr);
    }

    @Override
    public void answerCorrect(String CorrectStr) {
        LogUtils.d("正確答案為："+CorrectStr);
//                mSpellKeyBoard.setAnswer("money");//設定答案
//                mSpellKeyBoard.setKeyBoardNum(24);//設定鍵盤數[size]
//                mSpellKeyBoard.updateKeyword();//更新
    }

    @Override
    public void alreadyEstablished() {
        LogUtils.d("成功建立");
    }

    @Override
    public void update() {
        LogUtils.d("更新中");
    }

    @Override
    public void updateError() {
        LogUtils.d("更新錯誤");
    }

    @Override
    public void alreadyBack() {
        LogUtils.d("成功刪除");
    }

    @Override
    public void alreadyAdd() {
        LogUtils.d("成功新增");
    }

    @Override
    public void answerCorrectAnimFinish() {
        LogUtils.d("答題成功 刪除動畫執行結束");
        mSpellKeyBoard.setAnswer("how");
        mSpellKeyBoard.setKeyBoardNum(24);
        mSpellKeyBoard.setmType(1);// 1:答案格藍底 2:答案格黃底
        mSpellKeyBoard.updateKeyword();//呼叫重繪
    }
}
