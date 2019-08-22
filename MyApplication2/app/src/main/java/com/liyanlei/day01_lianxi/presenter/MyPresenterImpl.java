package com.liyanlei.day01_lianxi.presenter;

import com.liyanlei.day01_lianxi.bean.RootBean;
import com.liyanlei.day01_lianxi.callback.MyCallBack;
import com.liyanlei.day01_lianxi.model.MyModel;
import com.liyanlei.day01_lianxi.view.MyView;

public class MyPresenterImpl implements MyPresenter, MyCallBack {
    private MyModel myModel;
    private MyView myView;

    public MyPresenterImpl(final MyModel myModel, final MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void getDate() {
        if (myModel!=null){
            myModel.getDate(this);
        }
    }

    @Override
    public void onSuccess(final RootBean rootBean) {
        if (myView!=null){
            myView.onSuccess(rootBean);
        }
    }

    @Override
    public void onField(final String msg) {
        if (myView!=null){
            myView.onField(msg);
        }
    }
}
