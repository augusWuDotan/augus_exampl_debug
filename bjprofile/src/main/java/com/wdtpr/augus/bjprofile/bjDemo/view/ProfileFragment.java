package com.wdtpr.augus.bjprofile.bjDemo.view;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wdtpr.augus.bjprofile.R;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.UtilAdapter;
import com.wdtpr.augus.bjprofile.bjDemo.adapter.itemdecoration.LinearSectionDecoration;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.utils.ListUtils;

import static com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key.IRS;
import static com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key.MOVIE;
import static com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key.SPEAK;
import static com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key.TEST;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    public static final String KEY = "KEY";
    public static final String IRS_DATA = "IRS_DATA";
    public static final String MOVIE_DATA = "MOVIE_DATA";
    public static final String TEST_DATA = "TEST_DATA";
    public static final String SPEAK_DATA = "SPEAK_DATA";

    private String key;
    private IRS_RecordData irs_recordData;
    private TEST_RecordData test_recordData;
    private MovieData movieData;
    private SpeakData speakData;

    private RecyclerView mRecyView;
    private RecyclerView.LayoutManager manager;
    private UtilAdapter adapter;
    private Profile_Key profile_key;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment addIRSNewInstance(String key, IRS_RecordData irs_recordData) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(KEY, key);
        args.putSerializable(IRS_DATA, irs_recordData);
        fragment.setArguments(args);
        return fragment;
    }

    public static ProfileFragment addMovieNewInstance(String key, MovieData movieData) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(KEY, key);
        args.putSerializable(MOVIE_DATA, movieData);
        fragment.setArguments(args);
        return fragment;
    }

    public static ProfileFragment addTESTNewInstance(String key, TEST_RecordData test_recordData) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(KEY, key);
        args.putSerializable(TEST_DATA, test_recordData);
        fragment.setArguments(args);
        return fragment;
    }

    //addSpeakNewInstance
    public static ProfileFragment addSpeakNewInstance(String key, SpeakData speakData) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(KEY, key);
        args.putSerializable(SPEAK_DATA, speakData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            key = getArguments().getString(KEY);
            profile_key = Profile_Key.valueOf(key);
            switch (profile_key) {
                case IRS:
                    irs_recordData = (IRS_RecordData) getArguments().getSerializable(IRS_DATA);
                    break;
                case MOVIE:
                    movieData = (MovieData) getArguments().getSerializable(MOVIE_DATA);
                    break;
                case TEST:
                    test_recordData = (TEST_RecordData) getArguments().getSerializable(TEST_DATA);
                    break;
                case SPEAK:
                    speakData = (SpeakData) getArguments().getSerializable(SPEAK_DATA);
                    break;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        //
        mRecyView = view.findViewById(R.id.mRecyView);
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyView.setLayoutManager(manager);
        mRecyView.addItemDecoration(new LinearSectionDecoration(0, Color.TRANSPARENT));
        mRecyView.setHasFixedSize(true);
        if (checkData()) {//檢查空值處理
            adapter = new UtilAdapter(getActivity(), profile_key == IRS ? irs_recordData.getRecords_list() :
                    profile_key == MOVIE ? movieData.getRecords_list() :
                            profile_key == TEST ? test_recordData.getRecords_list() :
                                    profile_key == SPEAK ? speakData.getRecords_list() :null);
            mRecyView.setAdapter(adapter);
        }
    }

    private boolean checkData() {
        switch (profile_key) {
            case IRS:
                return !ListUtils.isEmpty(irs_recordData.getRecords_list());
            case MOVIE:
                return !ListUtils.isEmpty(movieData.getRecords_list());
            case TEST:
                return !ListUtils.isEmpty(test_recordData.getRecords_list());
            case SPEAK:
                return !ListUtils.isEmpty(speakData.getRecords_list());
            default:
                return false;
        }
    }

}
