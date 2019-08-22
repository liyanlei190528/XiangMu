package com.liyanlei.day01_kewaixiangmu.callback;

import com.liyanlei.day01_kewaixiangmu.bean.TabBean;

public interface TabCallBack {
    void onSuccess(TabBean tabBean);
    void onField(String msg);
}
