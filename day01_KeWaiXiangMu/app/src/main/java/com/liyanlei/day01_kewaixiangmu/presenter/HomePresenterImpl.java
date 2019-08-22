package com.liyanlei.day01_kewaixiangmu.presenter;

import com.liyanlei.day01_kewaixiangmu.bean.HomeBean;
import com.liyanlei.day01_kewaixiangmu.callback.HomeCallBack;
import com.liyanlei.day01_kewaixiangmu.model.HomeModel;
import com.liyanlei.day01_kewaixiangmu.view.HomeView;

public class HomePresenterImpl implements HomePresenter, HomeCallBack {
    private HomeModel homeModel;
    private HomeView homeView;

    public HomePresenterImpl(final HomeModel homeModel, final HomeView homeView) {
        this.homeModel = homeModel;
        this.homeView = homeView;
    }

    @Override
    public void getDate(final String id) {
        if (homeModel!=null){
            homeModel.getDate(id,this);
        }
    }

    @Override
    public void onSuccess(final HomeBean homeBean) {
        if (homeView!=null){
            homeView.onSuccess(homeBean);
        }
    }

    @Override
    public void onField(final String msg) {
        if (homeView!=null){
            homeView.onField(msg);
        }
    }
}
