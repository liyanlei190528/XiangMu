package com.liyanlei.day01_lianxi.api;

import com.liyanlei.day01_lianxi.bean.RootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    public String url = "https://cdwan.cn/";
    @GET("index")
    Observable<RootBean> getDate();
}
