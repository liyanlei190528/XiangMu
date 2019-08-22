package com.liyanlei.day01_lianxi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liyanlei.day01_lianxi.MainActivity;
import com.liyanlei.day01_lianxi.R;
import com.liyanlei.day01_lianxi.bean.RootBean;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final MainActivity mainActivity;
    private final ArrayList<RootBean.DataBean.BrandListBean> list;

    public MyAdapter(final MainActivity mainActivity, final ArrayList<RootBean.DataBean.BrandListBean> list) {

        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view = View.inflate(mainActivity,R.layout.layout_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        RootBean.DataBean.BrandListBean brandListBean = list.get(i);
        ViewHolder holder = viewHolder;
        holder.title.setText(brandListBean.getName());
        holder.pice.setText(brandListBean.getFloor_price());
        Glide.with(mainActivity)
                .load(brandListBean.getNew_pic_url())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title,pice;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            pice = itemView.findViewById(R.id.pice);
        }
    }
}
