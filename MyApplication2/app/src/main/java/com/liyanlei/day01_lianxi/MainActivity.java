package com.liyanlei.day01_lianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.liyanlei.day01_lianxi.adapter.MyAdapter;
import com.liyanlei.day01_lianxi.bean.RootBean;
import com.liyanlei.day01_lianxi.model.MyModelImpl;
import com.liyanlei.day01_lianxi.presenter.MyPresenterImpl;
import com.liyanlei.day01_lianxi.view.MyView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyView {

    private RecyclerView mRv;
    private ArrayList<RootBean.DataBean.BrandListBean> list;
    private MyAdapter myAdapter;
    private MyPresenterImpl myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initDate() {
        myPresenter = new MyPresenterImpl(new MyModelImpl(), this);
        myPresenter.getDate();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mRv.setAdapter(myAdapter);
        mRv.setLayoutManager(new GridLayoutManager(this,2));

        //设置item之间的间距
        mRv.addItemDecoration(new SpacesItemDecoration(2));

    }

    @Override
    public void onSuccess(final RootBean rootBean) {
        list.addAll(rootBean.getData().getBrandList());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onField(final String msg) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }
}
