package com.liyanlei.day01_kewaixiangmu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.liyanlei.day01_kewaixiangmu.adapter.FragmentAdapter;
import com.liyanlei.day01_kewaixiangmu.fragment.AFragment;
import com.liyanlei.day01_kewaixiangmu.fragment.BFragment;
import com.liyanlei.day01_kewaixiangmu.fragment.CFragment;
import com.liyanlei.day01_kewaixiangmu.fragment.DFragment;
import com.liyanlei.day01_kewaixiangmu.fragment.EFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());
        fragments.add(new EFragment());

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(fragmentAdapter);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setCustomView(R.layout.layout_fma);
        mTab.getTabAt(1).setCustomView(R.layout.layout_fmb);
        mTab.getTabAt(2).setCustomView(R.layout.layout_fmc);
        mTab.getTabAt(3).setCustomView(R.layout.layout_fmd);
        mTab.getTabAt(4).setCustomView(R.layout.layout_fme);
    }
}
