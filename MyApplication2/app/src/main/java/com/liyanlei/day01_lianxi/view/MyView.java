package com.liyanlei.day01_lianxi.view;

import com.liyanlei.day01_lianxi.bean.RootBean;

public interface MyView {
    void onSuccess(RootBean rootBean);
    void onField(String msg);
}
