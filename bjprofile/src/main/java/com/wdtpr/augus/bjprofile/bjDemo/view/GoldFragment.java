package com.wdtpr.augus.bjprofile.bjDemo.view;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.UtilAdapter;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.itemdecoration.LinearSectionDecoration;
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
import com.wdtpr.augus.bjprofile.bjDemo.utils.ListUtils;
import com.wdtpr.augus.bjprofile.bjDemo.utils.LogUtils;

import java.util.List;

import static com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key.IRS;
import static com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key.MOVIE;
import static com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key.SPEAK;
import static com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key.TEST;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GoldFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoldFragment extends Fragment implements ILearnRecordContract.LearnRecordIRSStateView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String STUDENTID = "STUDENTID_IRS";
    private int StudentID;
    private MaterialDialog ProgressDialog;
    //
    private RecyclerView mRecyView;
    private RecyclerView.LayoutManager manager;
    private UtilAdapter adapter;
    private LearnRecordPresenter learnRecordPresenter;
    //
    private List<GoldRecordItem> goldRecordItems;


    public GoldFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param studentId studentId
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GoldFragment newInstance(int studentId) {
        GoldFragment fragment = new GoldFragment();
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
        View view = inflater.inflate(R.layout.fragment_gold, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyView = view.findViewById(R.id.mRecyView);
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyView.setLayoutManager(manager);
        mRecyView.addItemDecoration(new LinearSectionDecoration(0, Color.TRANSPARENT));
        mRecyView.setHasFixedSize(true);
        adapter = new UtilAdapter(getActivity(),null);
        mRecyView.setAdapter(adapter);


        learnRecordPresenter = new LearnRecordPresenter(this);
        learnRecordPresenter.GetGoldRecord(StudentID);
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
        //null
    }

    @Override
    public void GetSpeakTestRecordByIDSucess(List<SpeakData> bean) {
        //null
    }

    @Override
    public void GetGoldRecord(List<GoldRecordItem> bean) {
        //this data
        if(!ListUtils.isEmpty(bean)){
            adapter.resetDatas(bean);
        }
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
