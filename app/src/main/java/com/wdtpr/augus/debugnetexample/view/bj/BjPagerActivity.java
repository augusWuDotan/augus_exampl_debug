package com.wdtpr.augus.debugnetexample.view.bj;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.wdtpr.augus.bjprofile.bjDemo.model.pager.mPagerAdapter;
import com.wdtpr.augus.bjprofile.bjDemo.view.GoldFragment;
import com.wdtpr.augus.bjprofile.bjDemo.view.IRSFragment;
import com.wdtpr.augus.bjprofile.bjDemo.view.MovieFragment;
import com.wdtpr.augus.bjprofile.bjDemo.view.RadarFragment;
import com.wdtpr.augus.bjprofile.bjDemo.view.SpeakFragment;
import com.wdtpr.augus.bjprofile.bjDemo.view.SpellFragment;
import com.wdtpr.augus.bjprofile.bjDemo.view.TESTFragment;
import com.wdtpr.augus.debugnetexample.R;

public class BjPagerActivity extends AppCompatActivity {
    //
    private FragmentManager manager;
    private IRSFragment irsFragment;
    private MovieFragment movieFragment;
    private TESTFragment testFragment;
    private RadarFragment radarFragment;
    private SpeakFragment speakFragment;
    private GoldFragment goldFragment;
    private SpellFragment spellFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bjpager_main);
        initView();
    }

    private void initView() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (getIntent().getStringExtra("TYPE")) {
            case "IRS":
                irs(transaction);
                break;
            case "MOVIE":
                movie(transaction);
                break;
            case "TEST":
                Test(transaction);
                break;
            case "RADAR":
                Radar(transaction);
                break;
            case "SPEAK":
                Speak(transaction);
                break;
            case "GOLD":
                Gold(transaction);
                break;
            case "SPELL":
                Spell(transaction);
                break;
        }


    }

    //建立 irs
    private void irs(FragmentTransaction transaction) {
        if (irsFragment == null) {
            irsFragment = IRSFragment.newInstance(19);
            transaction.add(R.id.contain, irsFragment, "IRS");
            transaction.commit();
        } else {
            transaction.show(irsFragment);
        }
    }

    //建立 Movie
    private void movie(FragmentTransaction transaction) {
        if (movieFragment == null) {
            movieFragment = MovieFragment.newInstance(19);
            transaction.add(R.id.contain, movieFragment, "movie");
            transaction.commit();
        } else {
            transaction.show(movieFragment);
        }
    }

    //建立 Test
    private void Test(FragmentTransaction transaction) {
        if (testFragment == null) {
            testFragment = TESTFragment.newInstance(19);
            transaction.add(R.id.contain, testFragment, "IRS");
            transaction.commit();
        } else {
            transaction.show(testFragment);
        }
    }

    //建立 Radar
    private void Radar(FragmentTransaction transaction) {
        if (radarFragment == null) {
            radarFragment = RadarFragment.newInstance(16361);
            transaction.add(R.id.contain, radarFragment, "Radar");
            transaction.commit();
        } else {
            transaction.show(radarFragment);
        }
    }

    //建立 Speak
    private void Speak(FragmentTransaction transaction) {
        if (speakFragment == null) {
            speakFragment = SpeakFragment.newInstance(19);
            transaction.add(R.id.contain, speakFragment, "Speak");
            transaction.commit();
        } else {
            transaction.show(speakFragment);
        }
    }

    //建立 Gold
    private void Gold(FragmentTransaction transaction) {
        if (goldFragment == null) {
            goldFragment = GoldFragment.newInstance(16361);
            transaction.add(R.id.contain, goldFragment, "gold");
            transaction.commit();
        } else {
            transaction.show(goldFragment);
        }
    }

    //建立 Spell
    private void Spell(FragmentTransaction transaction) {
        if (spellFragment == null) {
            spellFragment = SpellFragment.newInstance(16361);
            transaction.add(R.id.contain, spellFragment, "spell");
            transaction.commit();
        } else {
            transaction.show(spellFragment);
        }
    }


}
