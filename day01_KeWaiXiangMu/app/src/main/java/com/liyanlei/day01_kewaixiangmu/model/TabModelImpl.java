package com.liyanlei.day01_kewaixiangmu.model;

import com.liyanlei.day01_kewaixiangmu.api.MyServer;
import com.liyanlei.day01_kewaixiangmu.bean.TabBean;
import com.liyanlei.day01_kewaixiangmu.callback.TabCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TabModelImpl implements TabModel {
    @Override
    public void getDate(final TabCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.tabUrl)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<TabBean> tabDate = myServer.getTabDate();
        tabDate.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TabBean>() {
                    @Override
                    public void onSubscribe(final Disposable d) {

                    }

                    @Override
                    public void onNext(final TabBean tabBean) {

                        if (callBack!=null){
                            callBack.onSuccess(tabBean);
                        }
                    }

                    @Override
                    public void onError(final Throwable e) {

                        if (callBack!=null){
                            callBack.onField(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
