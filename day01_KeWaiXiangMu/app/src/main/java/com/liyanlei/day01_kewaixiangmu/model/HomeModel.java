package com.liyanlei.day01_kewaixiangmu.model;

import com.liyanlei.day01_kewaixiangmu.callback.HomeCallBack;


public interface HomeModel {
    void getDate(String id,HomeCallBack callBack);
}
