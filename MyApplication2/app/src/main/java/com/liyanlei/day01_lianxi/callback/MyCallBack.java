package com.liyanlei.day01_lianxi.callback;

import com.liyanlei.day01_lianxi.bean.RootBean;

public interface MyCallBack {
    void onSuccess(RootBean rootBean);
    void onField(String msg);
}
