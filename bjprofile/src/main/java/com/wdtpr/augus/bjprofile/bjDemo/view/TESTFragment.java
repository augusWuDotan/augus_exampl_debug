package com.wdtpr.augus.bjprofile.bjDemo.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.GoldRecord.GoldRecordItem;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Radar.RadarModelData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.SpellData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.pager.mPagerAdapter;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.ILearnRecordContract;
import com.wdtpr.augus.bjprofile.bjDemo.presenter.LearnRecord.LearnRecordPresenter;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;
import com.wdtpr.augus.bjprofile.bjDemo.utils.StringUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TESTFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TESTFragment extends Fragment implements ILearnRecordContract.LearnRecordIRSStateView {

    private static final String STUDENTID = "STUDENTID_TEST";
    private int StudentID;
    private MaterialDialog ProgressDialog;
    //
    private ViewPager mViewPager;
    private mPagerAdapter mAdapter;
    private LearnRecordPresenter learnRecordPresenter;

    //
    private List<TEST_RecordData> beanData;
    private int thisPosition;//現在的頁面
    private ImageView ivLeft,ivRight;
    private TextView tvSchedule;


    public TESTFragment() {
        // Required empty public constructor
    }


    public static TESTFragment newInstance(int studentId) {
        TESTFragment fragment = new TESTFragment();
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
        //fragment_test
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        //
        ProgressDialog = new MaterialDialog.Builder(getActivity())
                .title("請稍等")
                .content("讀取中")
                .canceledOnTouchOutside(false)
                .autoDismiss(true)
                .progress(true, 0).show();
        //
        mViewPager = (ViewPager) view.findViewById(R.id.pager);
        learnRecordPresenter = new LearnRecordPresenter(this);
        learnRecordPresenter.GetTestRecord(StudentID,"");

        //
        ivLeft  = (ImageView) view.findViewById(R.id.ivLeft);
        ivRight  = (ImageView) view.findViewById(R.id.ivRight);
        tvSchedule  = (TextView) view.findViewById(R.id.tvSchedule);
        ivLeft.setOnClickListener(onClickListener);
        ivRight.setOnClickListener(onClickListener);
        mViewPager.addOnPageChangeListener(pageChangeListener);
    }

    public ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //
            thisPosition = position;
            //選到哪一個page
            if(StringUtils.isEmpty(beanData.get(position).getBookNo())) return;
            tvSchedule.setText(beanData.get(position).getBookNo());
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = v.getId();
            //
            if (i == R.id.ivLeft) {
                int position = thisPosition -1 ;
                thisPosition = position;
                mViewPager.setCurrentItem(position);
            }
            //
            if (i == R.id.ivRight) {
                int position = thisPosition + 1 ;
                thisPosition = position;
                mViewPager.setCurrentItem(position);
            }
        }
    };


    @Override
    public void showLoading() {
        //load 自行取代
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
        //
        beanData = bean;
        //this data
        mAdapter = new mPagerAdapter(getChildFragmentManager(), bean, Profile_Key.TEST.name());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(0);
        tvSchedule.setText(beanData.get(0).getBookNo());
    }

    @Override
    public void GetRadarSucess(RadarModelData bean) {
        //null
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
