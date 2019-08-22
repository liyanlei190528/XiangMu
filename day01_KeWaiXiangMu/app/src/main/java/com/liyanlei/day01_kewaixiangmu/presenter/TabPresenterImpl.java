package com.liyanlei.day01_kewaixiangmu.presenter;

import com.liyanlei.day01_kewaixiangmu.bean.TabBean;
import com.liyanlei.day01_kewaixiangmu.callback.TabCallBack;
import com.liyanlei.day01_kewaixiangmu.model.TabModel;
import com.liyanlei.day01_kewaixiangmu.view.TabView;

public class TabPresenterImpl implements TabPresenter, TabCallBack {
    private TabModel tabModel;
    private TabView tabView;

    public TabPresenterImpl(final TabModel tabModel, final TabView tabView) {
        this.tabModel = tabModel;
        this.tabView = tabView;
    }

    @Override
    public void getDate() {
        if (tabModel!=null){
            tabModel.getDate(this);
        }
    }

    @Override
    public void onSuccess(final TabBean tabBean) {
        if (tabView!=null){
            tabView.onSuccess(tabBean);
        }
    }

    @Override
    public void onField(final String msg) {
        if (tabView!=null){
            tabView.onField(msg);
        }
    }
}
