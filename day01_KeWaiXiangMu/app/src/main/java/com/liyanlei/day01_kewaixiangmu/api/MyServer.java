package com.liyanlei.day01_kewaixiangmu.api;

import com.liyanlei.day01_kewaixiangmu.bean.HomeBean;
import com.liyanlei.day01_kewaixiangmu.bean.TabBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyServer {
    public String tabUrl = "https://cdwan.cn/api/";
    @GET("catalog/index")
    Observable<TabBean> getTabDate();

    public String homeUrl = "https://cdwan.cn/api/";

    @GET("catalog/current")
    Observable<HomeBean> getHomeDate(@Query("id") String id);
}
