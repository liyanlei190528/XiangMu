package com.liyanlei.day01_lianxi.model;

import com.liyanlei.day01_lianxi.api.MyServer;
import com.liyanlei.day01_lianxi.bean.RootBean;
import com.liyanlei.day01_lianxi.callback.MyCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModelImpl implements MyModel {
    @Override
    public void getDate(final MyCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyServer.url)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<RootBean> date = myServer.getDate();
        date.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RootBean>() {
                    @Override
                    public void onSubscribe(final Disposable d) {

                    }

                    @Override
                    public void onNext(final RootBean rootBean) {
                            if (callBack!=null){
                                callBack.onSuccess(rootBean);
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
