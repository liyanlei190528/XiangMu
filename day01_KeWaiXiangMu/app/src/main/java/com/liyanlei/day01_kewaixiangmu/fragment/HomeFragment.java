package com.liyanlei.day01_kewaixiangmu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liyanlei.day01_kewaixiangmu.R;
import com.liyanlei.day01_kewaixiangmu.adapter.HomeFragmentAdapter;
import com.liyanlei.day01_kewaixiangmu.bean.HomeBean;
import com.liyanlei.day01_kewaixiangmu.model.HomeModelImpl;
import com.liyanlei.day01_kewaixiangmu.presenter.HomePresenterImpl;
import com.liyanlei.day01_kewaixiangmu.view.HomeView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeView {


    private View view;
    private ImageView mImg;
    /**
     * title
     */
    private TextView mTitle;
    /**
     * name
     */
    private TextView mName;
    private RecyclerView mRv;
    private String id;
    private HomePresenterImpl homePresenter;
    private ArrayList<HomeBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;
    private HomeFragmentAdapter homeFragmentAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initDate() {
        homePresenter = new HomePresenterImpl(new HomeModelImpl(), this);
        homePresenter.getDate(id);
    }

    private void initView(View inflate) {
        mImg = (ImageView) inflate.findViewById(R.id.img);
        mTitle = (TextView) inflate.findViewById(R.id.title);
        mName = (TextView) inflate.findViewById(R.id.name);
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);

        Bundle bundle = getArguments();
        id = bundle.getString("Id", 0 + "");

        list = new ArrayList<>();

        homeFragmentAdapter = new HomeFragmentAdapter(getActivity(), list);
        mRv.setAdapter(homeFragmentAdapter);
        mRv.setLayoutManager(new GridLayoutManager(getActivity(),3));

    }

    @Override
    public void onSuccess(final HomeBean homeBean) {
        list.addAll(homeBean.getData().getCurrentCategory().getSubCategoryList());
        HomeBean.DataBean.CurrentCategoryBean currentCategory = homeBean.getData().getCurrentCategory();
        Glide.with(getActivity()).load(currentCategory.getWap_banner_url()).into(mImg);
        mTitle.setText(currentCategory.getFront_name());
        mName.setText("—"+currentCategory.getName()+"分类"+"—");
        homeFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void onField(final String msg) {

    }
}
