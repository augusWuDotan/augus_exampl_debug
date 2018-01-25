package com.wdtpr.augus.bjprofile.bjDemo.view;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import com.github.mikephil.charting.utils.Utils;
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
import com.wdtpr.augus.bjprofile.bjDemo.model.pager.mPagerAdapter;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.ILearnRecordContract;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.LearnRecordPresenter;
import com.wdtpr.augus.bjprofile.bjDemo.utils.ListUtils;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RadarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RadarFragment extends Fragment implements ILearnRecordContract.LearnRecordIRSStateView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String STUDENTID = "STUDENTID_RADAR";
    private int StudentID;
    private MaterialDialog ProgressDialog;
    private RadarChart mChart;
    private LearnRecordPresenter learnRecordPresenter;

    protected Typeface mTfLight;//使用字型
    private String lineColor = "#7e2401";//雷達圖 線 顏色
    private int lineWidth = 2;//雷達圖 線 寬度
    private int mChartAlpha = 255;//雷達圖 背景透明度
    private float mChartLeftSpace = 10;//雷達圖 左邊距離
    private float mChartTopSpace = 70;//雷達圖 上邊距離
    private float mChartRightSpace = 10;//雷達圖 右邊距離
    private float mChartBottomSpace = 70;//雷達圖 下邊距離
    private float xAxisTextSize = 16;//Ｘ軸文字大小
    private int startAnimTime = 1200;//起始展開動畫使用時間
    private int yAxisMin;//從資料內挑出最小值
    private int yAxisAverage;//從資料內計算差值平均


    public RadarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RadarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RadarFragment newInstance(int studentId) {
        RadarFragment fragment = new RadarFragment();
        Bundle args = new Bundle();
        args.putInt(STUDENTID, studentId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            StudentID = getArguments().getInt(STUDENTID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_radar, container, false);
        mTfLight = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf");
        initView(view);
        return view;
    }

    private void initView(View view) {
        //
        mChart = (RadarChart) view.findViewById(R.id.radarChart);
        //read
        learnRecordPresenter = new LearnRecordPresenter(this);
        learnRecordPresenter.GetRadar(StudentID);
    }

    //資料呈現設定
    private void setData(final RadarModelData bean) {
        /**
         * 設定基本參數
         */
        mChart.setDrawWeb(true);//
        mChart.getDescription().setEnabled(false);//備註不顯示
        mChart.setWebColor(Color.parseColor(lineColor));//雷達圖 縱線 顏色
        mChart.setWebColorInner(Color.parseColor(lineColor));//雷達圖 縱線 顏色
        mChart.setWebAlpha(mChartAlpha);//縱線 橫線 透明度
        mChart.setExtraOffsets(mChartLeftSpace, mChartTopSpace, mChartRightSpace, mChartBottomSpace);//上下左右 space
//        mChart.setSkipWebLineCount(0);//要被跳過的網路格數 y軸 [不使用]

        /**
         * 點擊到座標點會顯示什麼[圖示、％數]
         */
        MarkerView mv = new RadarMarkerView(getActivity(), R.layout.radar_markerview);
        mv.setChartView(mChart); // For bounds control
        mChart.setMarker(mv); // Set the marker to the chart
        mChart.setMaxHighlightDistance(5);

        /**
         * 建立相關參數[雷達圖 (雷達圖所需資料配置)、(Y軸最小值)、]
         */
        if (bean == null) return;
        if (ListUtils.isEmpty(bean.getKey())) return;
        //預設空值
        List<ArrayList<RadarEntry>> entriesList = new ArrayList<>();//儲存繪製雷達圖資料
        List<Integer> ScoreSet = new ArrayList<>();//儲存雷達圖分數
        /**
         *確認有值 儲存相關參數
         */
        for (RadarKeyModel radar : bean.getKey()) {
            ArrayList<RadarEntry> radarEntries = new ArrayList<>();
            for (RadarLebel label : radar.getLabel()) {
                radarEntries.add(new RadarEntry(label.getScore()));
                ScoreSet.add(label.getScore());
            }
            LogUtils.d("radarEntries size :" + radarEntries.size());
            entriesList.add(radarEntries);
        }
        LogUtils.d("entriesList size :" + entriesList.size());
        LogUtils.d("ScoreSet :" + ScoreSet);

        /**
         * 取得Y軸最小值、差值平均
         */
        yAxisMin = Collections.min(ScoreSet);
        int max = Collections.max(ScoreSet);
        yAxisAverage = (max-yAxisMin)/ScoreSet.size();
        LogUtils.d("ScoreSet min value :" + yAxisMin);

        /**
         *
         */
        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        int index = 0;
        for (ArrayList<RadarEntry> entries : entriesList) {
            RadarDataSet set = new RadarDataSet(entries, bean.getKey().get(index).getKey_Title());
            set.setColor(Color.TRANSPARENT);//線條顏色[線條不用顏色]
            set.setFillColor(Color.parseColor(bean.getKey().get(index).getColor_Number()));//填滿顏色
            set.setDrawFilled(true);//是否填滿
            set.setFillAlpha(180);//設置透明度
            set.setLineWidth(2f);//設置線的寬度
            set.setDrawHighlightCircleEnabled(true);//未知
            set.setDrawHighlightIndicators(false);//未知
            set.setDrawValues(true);//是否顯示科度數值
            sets.add(set);
            index++;
        }
        /**
         * 資料集中 建制畫面
         */
        RadarData data = new RadarData(sets);
        data.setValueTypeface(mTfLight);//設置字型
        data.setValueTextSize(8f);//設置字體大小
        data.setDrawValues(false);//是否顯示資料上的數值
//        data.setValueTextColor(Color.WHITE);//設置字體顏色
        mChart.setData(data);
        mChart.invalidate();

        /**
         * 動畫設置
         */
        mChart.animateXY(
                startAnimTime, startAnimTime,
                Easing.EasingOption.EaseInOutQuad,
                Easing.EasingOption.EaseInOutQuad);


        /**
         * 建立x軸相關資訊
         * Utils.convertPixelsToDp(40)//內建方法
         */
        XAxis xAxis = mChart.getXAxis();
        xAxis.setTypeface(mTfLight);//文字字型
        xAxis.setTextSize(xAxisTextSize);//文字大小
//        xAxis.setLabelCount(5,true);//?
//        xAxis.setYOffset(0f);//?
//        xAxis.setXOffset(0f);//?
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                //取得相關的標題
                return bean.getKey().get(0).getLabel().get((int) value % bean.getKey().get(0).getLabel().size()).getLabel_Name();
            }
        });
        xAxis.setTextColor(Color.parseColor(lineColor));
        xAxis.setEnabled(true);
//        xAxis.setDrawLabels(false);//隱藏或是顯示 標題

        /**
         * 建立Y軸相關資訊
         */
        YAxis yAxis = mChart.getYAxis();
        yAxis.setTypeface(mTfLight);//文字字型
        yAxis.setLabelCount(5,true);//?
        yAxis.setTextSize(10f);//文字大小
//        yAxis.setGranularity(8f);
        yAxis.setAxisMinimum(yAxisMin-yAxisAverage);//最小值=數值最小值-[(數值最大值-數值最小值)/數值比對數量]
//        yAxis.setAxisMinimum(0f);
//        yAxis.setAxisMaximum(100f);//最大值
        yAxis.setTextColor(Color.parseColor(lineColor));
        yAxis.setDrawLabels(false);

        /**
         * 預設下方標題
         */
        Legend l = mChart.getLegend();
        l.setEnabled(false);
        l.setDrawInside(false); //
    }


    @Override
    public void showLoading() {
        //load 自行取代
        ProgressDialog = new MaterialDialog.Builder(getActivity())
                .title("請稍等")
                .content("讀取中")
                .canceledOnTouchOutside(false)
                .autoDismiss(true)
                .progress(true, 0).show();
    }

    @Override
    public void hideLoading() {
        //finish
        getActivity().runOnUiThread(new Runnable() {
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
    public void onDestroyView() {
        super.onDestroyView();
        learnRecordPresenter.unsubscribe();
    }
}
