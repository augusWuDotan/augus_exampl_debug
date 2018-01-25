package com.wdtpr.augus.bjprofile.bjDemo.view;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.afollestad.materialdialogs.MaterialDialog;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarKeyModel;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarLebel;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarModelData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.SpellData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.ILearnRecordContract;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.LearnRecordPresenter;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class RadarActivity extends AppCompatActivity implements ILearnRecordContract.LearnRecordIRSStateView {

    private RadarChart mChart;
    private LearnRecordPresenter learnRecordPresenter;
    protected Typeface mTfLight;
    private MaterialDialog ProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar);
        learnRecordPresenter = new LearnRecordPresenter(this);
//        learnRecordPresenter.GetRadar(16361);
        learnRecordPresenter.GetRadar(19);

        mTfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");
        mChart = (RadarChart) findViewById(R.id.radarChart);
    }

    private void setData(final RadarModelData bean) {
        mChart.setDrawWeb(true);//
        mChart.getDescription().setEnabled(false);//備註不顯示

//        mChart.setWebLineWidth(1f);//雷達圖 縱線 寬度
        mChart.setWebColor(Color.parseColor("#7e2401"));//雷達圖 縱線 顏色
//        mChart.setWebLineWidthInner(1f);//雷達圖 橫線 寬度
        mChart.setWebColorInner(Color.parseColor("#7e2401"));//雷達圖 橫線 顏色
        mChart.setWebAlpha(255);//縱線 橫線 透明度
        mChart.setExtraOffsets(0, 50f, 0, 50f);//上下左右 margin
        mChart.setSkipWebLineCount(0);//要被跳過的網路格數
//        mChart.setElevation(10);

        /**
         * 點擊到的項目顯示
         */
        MarkerView mv = new RadarMarkerView(this, R.layout.radar_markerview);
        mv.setChartView(mChart); // For bounds control
        mChart.setMarker(mv); // Set the marker to the chart

        /**
         * 動畫設置 動畫時間跟種類可以重新配置
         */
        mChart.animateXY(
                1400, 1400,
                Easing.EasingOption.EaseInOutQuad,
                Easing.EasingOption.EaseInOutQuad);
//
        /**
         * 資料設置
         */
        List<ArrayList<RadarEntry>> entriesList = new ArrayList<>();
        //
        for (RadarKeyModel radar : bean.getKey()) {
            ArrayList<RadarEntry> radarEntries = new ArrayList<>();
            for (RadarLebel label : radar.getLabel()) {
                RadarEntry radarEntry = new RadarEntry(label.getScore());
                float result = label.getScore()==100 ? ((float) label.getScore() - 1f) : label.getScore();
                LogUtils.d("result:"+result);
                radarEntries.add(new RadarEntry(label.getScore()));
//                radarEntries.add(new RadarEntry(result));
            }
            entriesList.add(radarEntries);
        }

        //
        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        int index = 0;
        for (ArrayList<RadarEntry> entries : entriesList) {
            RadarDataSet set = new RadarDataSet(entries, bean.getKey().get(index).getKey_Title());
            set.setColor(Color.TRANSPARENT);//線條顏色
            set.setFillColor(Color.parseColor(bean.getKey().get(index).getColor_Number()));//填滿顏色
            set.setDrawFilled(false);//是否填滿
            set.setFillAlpha(180);//設置透明度
//            set.setLineWidth(2f);//設置線的寬度
            set.setDrawHighlightCircleEnabled(true);//未知
            set.setDrawHighlightIndicators(false);//未知
            set.setDrawValues(true);//是否顯示科度數值
            sets.add(set);
            index++;
        }

        //最後打包
        RadarData data = new RadarData(sets);
        data.setValueTypeface(mTfLight);//設置字型
        data.setValueTextSize(8f);//設置字體大小
        data.setDrawValues(false);//是否顯示資料上的數值
        data.setValueTextColor(Color.WHITE);//設置字體顏色
        mChart.setData(data);



        XAxis xAxis = mChart.getXAxis();
        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(10f);
        xAxis.setLabelCount(5,true);
//        xAxis.setGridColor(Color.WHITE);//
//        xAxis.setYOffset(0f);
//        xAxis.setXOffset(0f);
//        xAxis.setAxisMinimum(90f);
//        xAxis.setAxisMaximum(100f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return bean.getKey().get(0).getLabel().get((int) value % bean.getKey().get(0).getLabel().size()).getLabel_Name();
            }
        });
        xAxis.setTextColor(Color.parseColor("#7e2401"));
        xAxis.setEnabled(true);
//        xAxis.setDrawLabels(false);//隱藏或是顯示 標題

        YAxis yAxis = mChart.getYAxis();

        yAxis.setTypeface(mTfLight);
//        yAxis.setGranularity(10f);
        yAxis.setLabelCount(5);
        yAxis.setTextSize(10f);
//        yAxis.resetAxisMinimum();
        yAxis.setAxisMinimum(88f);
        yAxis.setAxisMaximum(100f);
//        yAxis.calculate(0f,100f);
//        yAxis.setGranularityEnabled(true);
        yAxis.setTextColor(Color.parseColor("#7e2401"));
        yAxis.setDrawLabels(true);
        LogUtils.d("yAxis getAxisDependency: "+yAxis.getAxisDependency());
        LogUtils.d("yAxis getLongestLabel: "+yAxis.getLongestLabel());
        LogUtils.d("yAxis getLabelPosition: "+yAxis.getLabelPosition());
        LogUtils.d("yAxis getMaxWidth: "+yAxis.getMaxWidth());
        LogUtils.d("yAxis getMinWidth: "+yAxis.getMinWidth());
        LogUtils.d("yAxis getSpaceBottom: "+yAxis.getSpaceBottom());
        LogUtils.d("yAxis getSpaceTop: "+yAxis.getSpaceTop());
        LogUtils.d("yAxis getZeroLineColor: "+yAxis.getZeroLineColor());
        LogUtils.d("yAxis getZeroLineWidth: "+yAxis.getZeroLineWidth());
        LogUtils.d("yAxis getAxisMaximum: "+yAxis.getAxisMaximum());
        LogUtils.d("yAxis getAxisMinimum: "+yAxis.getAxisMinimum());
        LogUtils.d("yAxis getGranularity: "+yAxis.getGranularity());
        LogUtils.d("yAxis getLabelCount: "+yAxis.getLabelCount());
        LogUtils.d("yAxis getSpaceMin: "+yAxis.getSpaceMin());
        LogUtils.d("yAxis getSpaceMax: "+yAxis.getSpaceMax());
        LogUtils.d("yAxis getXOffset: "+yAxis.getXOffset());
        LogUtils.d("yAxis getYOffset: "+yAxis.getYOffset());
        LogUtils.d("yAxis getLongestLabel: "+yAxis.getLongestLabel());
        LogUtils.d("yAxis getLimitLines().size(): "+yAxis.getLimitLines().size());
        LogUtils.d("yAxis getAxisDependency().name(): "+yAxis.getAxisDependency().name());
        LogUtils.d("yAxis mAxisRange: "+yAxis.mAxisRange);
        LogUtils.d("yAxis mAxisMinimum: "+yAxis.mAxisMinimum);
        LogUtils.d("yAxis mAxisMaximum: "+yAxis.mAxisMaximum);


        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setEnabled(false);
        l.setDrawInside(false); //
        l.setTypeface(mTfLight);
        l.setXEntrySpace(0f);// 分類 左右間距 [HORIZONTAL]
        l.setYEntrySpace(0f);
        l.setTextColor(Color.TRANSPARENT);


        LogUtils.d("char getRadius: "+mChart.getRadius());
        LogUtils.d("char getSkipWebLineCount: "+mChart.getSkipWebLineCount());
        LogUtils.d("char getSliceAngle: "+mChart.getSliceAngle());
        LogUtils.d("char getWebAlpha: "+mChart.getWebAlpha());
        LogUtils.d("char getWebLineWidth: "+mChart.getWebLineWidth());
        LogUtils.d("char getYChartMin: "+mChart.getYChartMin());
        LogUtils.d("char getYChartMax: "+mChart.getYChartMax());
        LogUtils.d("char getYRange: "+mChart.getYRange());
//        LogUtils.d("char getYRange: "+mChart.get());

        mChart.invalidate();
    }


    private void setData() {
        mChart.setBackgroundColor(Color.parseColor("#30ffffff"));//雷達圖底色
        mChart.setDrawWeb(true);//

        mChart.getDescription().setEnabled(false);//背著不可觸碰

        mChart.setWebLineWidth(1f);//雷達圖 縱線 寬度
        mChart.setWebColor(Color.parseColor("#BB5500"));//雷達圖 縱線 顏色
        mChart.setWebLineWidthInner(1f);//雷達圖 橫線 寬度
        mChart.setWebColorInner(Color.parseColor("#BB5500"));//雷達圖 橫線 顏色
        mChart.setWebAlpha(255);//縱線 橫線 透明度


        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it
        MarkerView mv = new RadarMarkerView(this, R.layout.radar_markerview);
        mv.setChartView(mChart); // For bounds control
        mChart.setMarker(mv); // Set the marker to the chart

//
        ArrayList<RadarEntry> entries1 = new ArrayList<RadarEntry>();

        entries1.add(new RadarEntry(90));//寫入數值
        entries1.add(new RadarEntry(93));//寫入數值
        entries1.add(new RadarEntry(96));//寫入數值
        entries1.add(new RadarEntry(96));//寫入數值
        entries1.add(new RadarEntry(92));//寫入數值
        entries1.add(new RadarEntry(86));//寫入數值
        entries1.add(new RadarEntry(100));//寫入數值

        RadarDataSet set1 = new RadarDataSet(entries1, "所有学习范围");
        set1.setColor(Color.BLUE);
        set1.setFillColor(Color.BLUE);
        set1.setDrawFilled(true);
        set1.setFillAlpha(100);
        set1.setLineWidth(2f);
        set1.setDrawHighlightCircleEnabled(true);
        set1.setDrawHighlightIndicators(false);
//
        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        sets.add(set1);

        RadarData data = new RadarData(sets);
        data.setValueTypeface(mTfLight);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);
        mChart.invalidate();

        //一開始的動畫
        mChart.animateXY(
                1400, 1400,
                Easing.EasingOption.EaseInOutQuad,
                Easing.EasingOption.EaseInOutQuad);


        XAxis xAxis = mChart.getXAxis();
        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(12f);
//        xAxis.setGridColor(Color.WHITE);//
        xAxis.setYOffset(0f);
        xAxis.setXOffset(0f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] mActivities = new String[]{"阅读", "单词听力", "单词认读", "句型听力", "语法","拼字","语法句构"};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mActivities[(int) value % mActivities.length];
            }
        });
        xAxis.setTextColor(Color.WHITE);
        xAxis.setEnabled(true);
//        xAxis.setDrawLabels(false);//隱藏或是顯示 標題

        YAxis yAxis = mChart.getYAxis();
        yAxis.setTypeface(mTfLight);
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(12f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setDrawLabels(true);


        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setEnabled(false);
        l.setDrawInside(true); //

        l.setTypeface(mTfLight);
        l.setXEntrySpace(0f);// 分類 左右間距 [HORIZONTAL]
        l.setYEntrySpace(2f);
        l.setTextColor(Color.TRANSPARENT);
    }


    @Override
    public void showLoading() {
        //load 自行取代
        ProgressDialog = new MaterialDialog.Builder(this)
                .title("請稍等")
                .content("讀取中")
                .canceledOnTouchOutside(false)
                .autoDismiss(true)
                .progress(true, 0).show();
    }

    @Override
    public void hideLoading() {
        //finish
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ProgressDialog.dismiss();
            }
        });
    }

    @Override
    public void showUnknowError(String errorStr) {
        //
        LogUtils.d(errorStr);
    }

    @Override
    public void GETFail() {
        LogUtils.d("GETFail");
    }

    @Override
    public void GETIRSListSucess(List<IRS_RecordData> bean) {
        //null
    }

    @Override
    public void GetMovieRecordSucess(List<MovieData> bean) {
        //null
    }

    @Override
    public void GetTestRecordSucess(List<TEST_RecordData> bean) {
        //null
    }

    @Override
    public void GetRadarSucess(RadarModelData bean) {
        //this data
        LogUtils.d(bean.toString());
        setData(bean);
//        setData();
    }


    @Override
    public void GetSpeakTestRecordByIDSucess(List<SpeakData> bean) {
        //null
    }

    @Override
    public void GetGoldRecord(List<GoldRecordItem> bean) {
        //null
    }

    @Override
    public void GetSpellSucess(List<SpellData> bean) {
        //null
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        learnRecordPresenter.unsubscribe();
    }
}
