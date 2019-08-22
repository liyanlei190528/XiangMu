package com.liyanlei.day01_kewaixiangmu.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liyanlei.day01_kewaixiangmu.R;
import com.liyanlei.day01_kewaixiangmu.bean.HomeBean;
import com.liyanlei.day01_kewaixiangmu.bean.TabBean;

import java.util.ArrayList;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder> {
    private final FragmentActivity activity;
    private final ArrayList<HomeBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;

    public HomeFragmentAdapter(final FragmentActivity activity, final ArrayList<HomeBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view = View.inflate(activity,R.layout.layout_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        HomeBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean = list.get(i);
        ViewHolder holder = viewHolder;
        holder.name.setText(subCategoryListBean.getName());
        Glide.with(activity)
                .load(subCategoryListBean.getWap_banner_url())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }
}
