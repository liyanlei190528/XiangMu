package com.liyanlei.day01_kewaixiangmu.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.liyanlei.day01_kewaixiangmu.bean.TabBean;

import java.util.ArrayList;

import q.rorbin.verticaltablayout.widget.QTabView;

public class HomeAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<TabBean.DataBean.CategoryListBean> list;

    public HomeAdapter(final FragmentManager fm) {
        super(fm);
    }

    public HomeAdapter(final FragmentManager childFragmentManager, final ArrayList<Fragment> fragments, final ArrayList<TabBean.DataBean.CategoryListBean> list) {
        super(childFragmentManager);
        this.fragments = fragments;
        this.list = list;
    }

    @Override
    public Fragment getItem(final int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


   
    @Nullable
    @Override
    public CharSequence getPageTitle(final int position) {
        return list.get(position).getName();
    }
}
