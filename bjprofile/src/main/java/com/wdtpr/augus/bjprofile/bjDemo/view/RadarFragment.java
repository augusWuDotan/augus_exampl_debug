package com.wdtpr.augus.bjprofile.bjDemo.view;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarModelData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.pager.mPagerAdapter;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.ILearnRecordContract;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.LearnRecordPresenter;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;

import java.util.ArrayList;
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
    private TextView tvTitle;
    //
    private ViewPager mViewPager;
    private mPagerAdapter mAdapter;
    private LearnRecordPresenter learnRecordPresenter;
    String[] labels;
    protected Typeface mTfLight;


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
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        //
        mChart = (RadarChart) view.findViewById(R.id.radarChart);
//        mChart.setBackgroundColor(Color.parseColor("#30ffffff"));//雷達圖底色 白色透明

        //read
        learnRecordPresenter = new LearnRecordPresenter(this);
        learnRecordPresenter.GetRadar(StudentID);
    }

    //資料呈現設定
    private void setData(final RadarModelData bean) {

//        // create a custom MarkerView (extend MarkerView) and specify the layout
//        // to use for it
//        MarkerView mv = new RadarMarkerView(getActivity(), R.layout.radar_markerview);
//        mv.setChartView(mChart); // For bounds control
//        mChart.setMarker(mv); // Set the marker to the chart
//        tvTitle.setText(bean.getTitle());
//
//
//        //data start
//        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();//總資料
//        for(RadarKeyModel keyModel : bean.getKey()){
//            //單元分類開始---
//
//            //取得並設定各項目分數
//            ArrayList<RadarEntry> KeyModeEntries = new ArrayList<RadarEntry>();
//            for(RadarLebel lebel : keyModel.getLabel()){
//                KeyModeEntries.add(new RadarEntry((float) lebel.getScore()));
//            }
//            RadarDataSet set1 = new RadarDataSet(KeyModeEntries, keyModel.getKey_Title());
//            set1.setColor(Color.BLUE);
//            set1.setFillColor(Color.BLUE);
//            set1.setDrawFilled(true);
//            set1.setFillAlpha(180);
//            set1.setLineWidth(2f);
//            set1.setDrawHighlightCircleEnabled(true);
//            set1.setDrawHighlightIndicators(false);
//            set1.setDrawValues(true);
//            //
//            sets.add(set1);//集中資料
//        }
//        //建立 分數文字
//        RadarData data = new RadarData(sets);
//        data.setValueTextSize(8f);
//        data.setDrawValues(false);//建制不顯示
//        data.setValueTextColor(Color.WHITE);
//        //
//        mChart.setData(data);//設定
//        mChart.invalidate();//刷新
//        //data end
//
//        //一開始的動畫
//        mChart.animateXY(
//                1400, 1400,
//                Easing.EasingOption.EaseInOutQuad,
//                Easing.EasingOption.EaseInOutQuad);
//
//        labels = new String[bean.getKey().get(0).getLabel().size()];
//        int i = 0;
//        for(RadarLebel label : bean.getKey().get(0).getLabel()){
//            labels[i] = label.getLabel_Name();
//            i++;
//        }
//
//        XAxis xAxis = mChart.getXAxis();
//        xAxis.setTextSize(12f);
//        xAxis.setGridColor(Color.GREEN);//
//        xAxis.setYOffset(0f);
//        xAxis.setXOffset(0f);
//        xAxis.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                return labels[(int) value % labels.length];
//            }
//        });
//        xAxis.setTextColor(Color.WHITE);
//
//        YAxis yAxis = mChart.getYAxis();
//        yAxis.setLabelCount(5, false);
//        yAxis.setTextSize(12f);
//        yAxis.setAxisMinimum(0f);
//        yAxis.setAxisMaximum(80f);
//        yAxis.setTextColor(Color.WHITE);
//        yAxis.setDrawLabels(false);
//
//        Legend l = mChart.getLegend();
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
//        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
//        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//        l.setDrawInside(true);
//        l.setXEntrySpace(10f);
//        l.setYEntrySpace(5f);
//        l.setTextColor(Color.WHITE);

//        mChart.setBackgroundColor(Color.rgb(60, 65, 82));
        mChart.setBackgroundColor(Color.parseColor("#30ffffff"));//雷達圖底色
        mChart.setDrawWeb(true);//

        mChart.getDescription().setEnabled(false);//背著不可觸碰

        mChart.setWebLineWidth(1f);//雷達圖 縱線 寬度
        mChart.setWebColor(Color.LTGRAY);//雷達圖 縱線 顏色
        mChart.setWebLineWidthInner(1f);//雷達圖 橫線 寬度
        mChart.setWebColorInner(Color.LTGRAY);//雷達圖 橫線 顏色
        mChart.setWebAlpha(100);//縱線 橫線 透明度
//        mChart.setTouchEnabled(false);//禁止觸碰//沒辦法在旋轉


        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it
        MarkerView mv = new RadarMarkerView(getActivity(), R.layout.radar_markerview);
        mv.setChartView(mChart); // For bounds control
        mChart.setMarker(mv); // Set the marker to the chart

        //建置資料
        setData();

        //一開始的動畫
        mChart.animateXY(
                1400, 1400,
                Easing.EasingOption.EaseInOutQuad,
                Easing.EasingOption.EaseInOutQuad);


        XAxis xAxis = mChart.getXAxis();
        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(12f);
        xAxis.setGridColor(Color.WHITE);//
        xAxis.setYOffset(0f);
        xAxis.setXOffset(0f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] mActivities = new String[]{"阅读", "单词听力", "单词认读", "句型听力", "语法", "拼字", "语法句构"};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mActivities[(int) value % mActivities.length];
            }
        });
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawLabels(false);//隱藏或是顯示 標題

        YAxis yAxis = mChart.getYAxis();
        yAxis.setTypeface(mTfLight);
        yAxis.setLabelCount(5, true);
        yAxis.setTextSize(12f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setDrawLabels(false);


        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false); //
        l.setTypeface(mTfLight);
        l.setXEntrySpace(10f);// 分類 左右間距 [HORIZONTAL]
        l.setYEntrySpace(10f);
        l.setTextColor(Color.WHITE);

        mChart.invalidate();
    }

    public void setData() {

        float mult = 80;
        float min = 20;
        int cnt = 7;//幾邊型

        ArrayList<RadarEntry> entries1 = new ArrayList<RadarEntry>();
        ArrayList<RadarEntry> entries2 = new ArrayList<RadarEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < cnt; i++) {
            float val1 = (float) (Math.random() * mult) + min;
            entries1.add(new RadarEntry(val1));//寫入數值
            Log.d("TAG val1", String.valueOf(val1));
            float val2 = (float) (Math.random() * mult) + min;
            entries2.add(new RadarEntry(val2));
            Log.d("TAG val2", String.valueOf(val2));
        }

        RadarDataSet set1 = new RadarDataSet(entries1, "第一單元");
        set1.setColor(Color.BLUE);
        set1.setFillColor(Color.BLUE);
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightCircleEnabled(true);
        set1.setDrawHighlightIndicators(false);

        RadarDataSet set2 = new RadarDataSet(entries2, "第二單元");
        set2.setColor(Color.YELLOW);//線
        set2.setFillColor(Color.YELLOW);//填滿色
        set2.setDrawFilled(true);//是否設置填滿色澤
        set2.setFillAlpha(180);//設置填滿色澤的透明度 0 ~ 255
        set2.setLineWidth(1f);//繪製框線的寬度
        set2.setDrawHighlightCircleEnabled(true);//
        set2.setDrawHighlightIndicators(false);//
        set2.setDrawValues(true);//顯示科度數值

        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        sets.add(set1);
        sets.add(set2);

        RadarData data = new RadarData(sets);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);
        mChart.invalidate();
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
    public void onDestroyView() {
        super.onDestroyView();
        learnRecordPresenter.unsubscribe();
    }
}
