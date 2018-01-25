package com.wdtpr.augus.bjprofile.bjDemo.model.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Irs_Record.IRS_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Movie.MovieData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Profile_Key;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Speak.SpeakData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Spell.SpellData;
import com.wdtpr.augus.bjprofile.bjDemo.model.bean.in.Test_Record.TEST_RecordData;
import com.wdtpr.augus.bjprofile.bjDemo.utils.ListUtils;
import com.wdtpr.augus.bjprofile.bjDemo.view.ProfileFragment;

import java.util.List;


/**
 * Created by augus on 2017/12/26.
 */

public class mPagerAdapter extends FragmentPagerAdapter {

    private Object data;
    private String key;

    private List<IRS_RecordData> irs_recordDataList;
    private List<MovieData> movieDataItemList;
    private List<TEST_RecordData> test_recordDataList;
    private List<SpeakData> speakDataList;
    private List<SpellData> spellDataList;

    public mPagerAdapter(FragmentManager fm, Object data, String key) {
        super(fm);
        this.data = data;
        this.key = key;
        Profile_Key whichView = Profile_Key.valueOf(key);
        if (data instanceof List) {
            switch (whichView) {
                case IRS:
                    irs_recordDataList = (List<IRS_RecordData>) data;
                    break;
                case MOVIE:
                    movieDataItemList = (List<MovieData>) data;
                    break;
                case TEST:
                    test_recordDataList = (List<TEST_RecordData>) data;
                    break;
                case SPEAK:
                    speakDataList = (List<SpeakData>) data;
                    break;
                case SPELL:
                    spellDataList = (List<SpellData>) data;
                    break;
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Profile_Key whichView = Profile_Key.valueOf(key);
        switch (whichView) {
            case IRS:
                if (!ListUtils.isEmpty(irs_recordDataList))
                    fragment = ProfileFragment.addIRSNewInstance(key, irs_recordDataList.get(position));
                return fragment;
            case MOVIE:
                if (!ListUtils.isEmpty(movieDataItemList))
                    fragment = ProfileFragment.addMovieNewInstance(key, movieDataItemList.get(position));
                return fragment;
            case TEST:
                if (!ListUtils.isEmpty(test_recordDataList))
                    fragment = ProfileFragment.addTESTNewInstance(key, test_recordDataList.get(position));
                return fragment;
            case SPEAK:
                if (!ListUtils.isEmpty(speakDataList))
                    fragment = ProfileFragment.addSpeakNewInstance(key, speakDataList.get(position));
                return fragment;
            case SPELL:
                if (!ListUtils.isEmpty(spellDataList))
                    fragment = ProfileFragment.addSpellNewInstance(key, spellDataList.get(position));
                return fragment;
        }
        return null;
    }

    @Override
    public int getCount() {

        Profile_Key whichView = Profile_Key.valueOf(key);
        if (data instanceof List) {
            switch (whichView) {
                case IRS:
                    if (ListUtils.isEmpty(irs_recordDataList)) return 0;
                    else return irs_recordDataList.size();
                case MOVIE:
                    if (ListUtils.isEmpty(movieDataItemList)) return 0;
                    else return movieDataItemList.size();
                case TEST:
                    if (ListUtils.isEmpty(test_recordDataList)) return 0;
                    else return test_recordDataList.size();
                case SPEAK:
                    if (ListUtils.isEmpty(speakDataList)) return 0;
                    else return speakDataList.size();
                case SPELL:
                    if (ListUtils.isEmpty(spellDataList)) return 0;
                    else return spellDataList.size();
                default:
                    return 0;
            }
        } else {
            return 0;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
