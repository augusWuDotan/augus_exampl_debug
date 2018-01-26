package com.wdtpr.augus.ranking.view;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;

import com.wdtpr.augus.ranking.R;
import com.wdtpr.augus.ranking.adapter.UtilAdapter;
import com.wdtpr.augus.ranking.adapter.itemdecoration.LinearSectionDecoration;
import com.wdtpr.augus.ranking.model.bean.in.ranking.RankingItem;
import com.wdtpr.augus.ranking.presenter.LearnRecord.ILearnRecordRankingContract;
import com.wdtpr.augus.ranking.presenter.LearnRecord.LearnRecordRankingPresenter;
import com.wdtpr.augus.ranking.utils.ListUtils;
import com.wdtpr.augus.ranking.utils.LogUtils;
import com.wdtpr.augus.ranking.utils.Utils;
import com.wdtpr.augus.ranking.widget.ASEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RankManagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RankManagerFragment extends Fragment implements ILearnRecordRankingContract.LearnRecordStateView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String STUDENTID = "STUDENTID";
    private int StudentID;
    private String type;
    private int pageNum = 0;
    private String keyword;

    private ImageView ivClass, ivSchool, ivNational;
    private ASEditText etSearch;

    private LearnRecordRankingPresenter learnRecordRankingPresenter;
    private MaterialDialog ProgressDialog;

    private RecyclerView mRecyView;
    private RecyclerView.LayoutManager manager;
    private UtilAdapter adapter;
    private List<RankingItem> beanList;

    private boolean isUpdate = true;

    public RankManagerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param studentId Parameter 1.
     * @return A new instance of fragment SpeakFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RankManagerFragment newInstance(int studentId) {
        RankManagerFragment fragment = new RankManagerFragment();
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
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank_manager, container, false);
        learnRecordRankingPresenter = new LearnRecordRankingPresenter(this);
        initView(view);
        return view;
    }


    private void initView(View view) {

        mRecyView = view.findViewById(R.id.mRecyView);
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyView.setLayoutManager(manager);
        mRecyView.addItemDecoration(new LinearSectionDecoration(5, Color.TRANSPARENT));
        mRecyView.setHasFixedSize(true);
        adapter = new UtilAdapter(getActivity(), null);
        mRecyView.setAdapter(adapter);

        ivClass = view.findViewById(R.id.ivClass);
        ivSchool = view.findViewById(R.id.ivSchool);
        ivNational = view.findViewById(R.id.ivNational);
        etSearch = view.findViewById(R.id.etSearch);

        //
        ivClass.setOnClickListener(onClickListener);
        ivSchool.setOnClickListener(onClickListener);
        ivNational.setOnClickListener(onClickListener);

        //
        etSearch.setDeleteDrawable(getResources().getDrawable(R.drawable.ic_action_cancel), 22);//解除查詢
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    Utils.showOrHideSoftKeyBoard(getActivity());
                    return true;
                }
                return false;
            }
        });
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                keyword = etSearch.getText().toString();
                LogUtils.d("keyword:" + keyword);
//                getBlogerData(keyword);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //預設class
        viewStatus(0);
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = v.getId();

            if (i == R.id.ivClass) {
                //
                viewStatus(0);
            }

            if (i == R.id.ivSchool) {
                //
                viewStatus(1);
            }

            if (i == R.id.ivNational) {
                //
                viewStatus(2);
            }
        }
    };


    //
    private void viewStatus(int status) {
        ProgressDialog = new MaterialDialog.Builder(getActivity())
                .title("請稍等")
                .content("讀取中")
                .canceledOnTouchOutside(false)
                .autoDismiss(true)
                .progress(true, 0).show();
        //
        switch (status) {
            case 0:
                ivClass.setImageResource(R.drawable.rank_title_class_select);
                ivSchool.setImageResource(R.drawable.rank_title_school_normal);
                ivNational.setImageResource(R.drawable.rank_title_national_normal);
                isUpdate = true;
                type = "class";
                learnRecordRankingPresenter.GetStudentRanking(type, StudentID, pageNum);

                break;
            case 1:
                ivClass.setImageResource(R.drawable.rank_title_class_normal);
                ivSchool.setImageResource(R.drawable.rank_title_school_select);
                ivNational.setImageResource(R.drawable.rank_title_national_normal);
                isUpdate = true;
                type = "school";
                learnRecordRankingPresenter.GetStudentRanking(type, StudentID, pageNum);
                break;
            case 2:
                ivClass.setImageResource(R.drawable.rank_title_class_normal);
                ivSchool.setImageResource(R.drawable.rank_title_school_normal);
                ivNational.setImageResource(R.drawable.rank_title_national_select);
                isUpdate = true;
                type = "nation";
                learnRecordRankingPresenter.GetStudentRanking(type, StudentID, pageNum);
                break;
        }
    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ProgressDialog.dismiss();
            }
        });
    }

    @Override
    public void showUnknowError(String errorStr) {

    }

    @Override
    public void GETFail() {

    }

    @Override
    public void GetStudentRankingSucess(List<RankingItem> bean) {
        LogUtils.d("bean:" + bean.toString());
        if (!ListUtils.isEmpty(bean)) {
            if (isUpdate) {
                beanList = new ArrayList<>();
                beanList = bean;
            } else {
                beanList.addAll(bean);
            }
        } else {
            beanList = new ArrayList<>();
        }

        //個人資料
        if (isUpdate) learnRecordRankingPresenter.GetSingleStudentRanking(type, StudentID);
    }

    @Override
    public void GetSingleStudentRankingSucess(RankingItem bean) {
        LogUtils.d("bean:" + bean.toString());
        if (bean == null) return;
        beanList.add(0, bean);//加入第一筆
        LogUtils.d("beanList:" + beanList.toString());
        adapter.resetDatas(beanList);

        isUpdate = false;//狀態非更新
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
