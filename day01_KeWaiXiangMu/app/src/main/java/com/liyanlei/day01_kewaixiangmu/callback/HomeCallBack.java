package com.liyanlei.day01_kewaixiangmu.callback;

import com.liyanlei.day01_kewaixiangmu.bean.HomeBean;


public interface HomeCallBack {
    void onSuccess(HomeBean homeBean);
    void onField(String msg);
}
