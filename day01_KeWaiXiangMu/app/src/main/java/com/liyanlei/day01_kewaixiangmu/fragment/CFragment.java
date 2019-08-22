package com.liyanlei.day01_kewaixiangmu.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liyanlei.day01_kewaixiangmu.R;
import com.liyanlei.day01_kewaixiangmu.adapter.HomeAdapter;
import com.liyanlei.day01_kewaixiangmu.bean.TabBean;
import com.liyanlei.day01_kewaixiangmu.model.TabModelImpl;
import com.liyanlei.day01_kewaixiangmu.presenter.TabPresenterImpl;
import com.liyanlei.day01_kewaixiangmu.view.TabView;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.QTabView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment implements TabView {


    private View view;
    private VerticalTabLayout mTab;
    private ViewPager mVp;
    private ArrayList<TabBean.DataBean.CategoryListBean> list;
    private ArrayList<Fragment> fragments;
    private TabPresenterImpl tabPresenter;
    private HomeAdapter homeAdapter;

    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_c, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {
        tabPresenter = new TabPresenterImpl(new TabModelImpl(), this);
        tabPresenter.getDate();
    }

    private void initView(View inflate) {
        mTab = (VerticalTabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);

        list = new ArrayList<>();

        fragments = new ArrayList<>();

        homeAdapter = new HomeAdapter(getChildFragmentManager(), fragments, list);
        mVp.setAdapter(homeAdapter);
        mTab.setupWithViewPager(mVp);

    }

    @Override
    public void onSuccess(final TabBean tabBean) {
        List<TabBean.DataBean.CategoryListBean> categoryList = tabBean.getData().getCategoryList();
        for (int i = 0; i < categoryList.size(); i++) {
            list.addAll(categoryList);
            HomeFragment homeFragment = new HomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Id",categoryList.get(i).getId()+"");
            homeFragment.setArguments(bundle);
            fragments.add(homeFragment);
        }

        homeAdapter.notifyDataSetChanged();

    }

    @Override
    public void onField(final String msg) {

    }
}
